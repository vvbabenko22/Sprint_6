package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.FirstOrderPage;
import pages.SecondOrderPage;
import utils.DriverManager;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Гарантированно одноэкземплярный режим
class ParamTests {

    private WebDriver driver;
    private MainPage mainPage;
    private FirstOrderPage firstOrderPage;
    private SecondOrderPage secondOrderPage;

    @BeforeAll
    void setUp() {
        driver = DriverManager.getChromeDriver();
        mainPage = new MainPage(driver);
        firstOrderPage = new FirstOrderPage(driver);
        secondOrderPage = new SecondOrderPage(driver);
        mainPage.open(); // Загрузка главной страницы
        driver.manage().window().maximize(); // Разворачиваем на весь экран
        mainPage.acceptCookies(); // Принимаем куки
    }

    @AfterEach
    void afterEachTest() {
        mainPage.goBackToHomepage(); // Возвращаемся на главную страницу после каждого теста
    }

    @AfterAll
    void tearDown() {
        DriverManager.quitDriver(); // Завершаем работу браузера после всех тестов
    }

    // Генерируем наборы данных для тестов
    public static List<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("верхнюю", "Иван", "Иванов", "Москва ул. Ленина д.1", 2, "+79991234567", "25 августа 2025", 1, "привезти вечером"),
                Arguments.of("нижнюю", "Сергей", "Сергеев", "Санкт-Петербург ул. Невского д.10", 4, "+79997654321", "25 сентября 2025", 2, "оставьте у двери")
        ).collect(Collectors.toList());
    }

    // Параметризованный тест с выбором кнопки и соответствующих данных
    @ParameterizedTest(name = "Тестируем создание заказа через разные данные")
    @MethodSource("provideTestData")
    void testPositiveScenarioThroughButton(String buttonType,
                                           String name,
                                           String surname,
                                           String address,
                                           int metroStation,
                                           String phone,
                                           String deliveryDate,
                                           int rentPeriod,
                                           String comment) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1)); // Явное ожидание

        // Выбираем кнопку в зависимости от параметра
        if ("верхнюю".equals(buttonType)) {
            mainPage.clickUpperOrderButton();
        } else if ("нижнюю".equals(buttonType)) {
            mainPage.clickLowerOrderButton();
        }

        // Первая страница заказа
        firstOrderPage.fillFirstPage(name, surname, address, metroStation, phone);

        // Вторая страница заказа
        secondOrderPage.fillSecondPage(deliveryDate, rentPeriod, comment);

        // Ждём появления сообщения об успехе
        wait.until(ExpectedConditions.visibilityOfElementLocated(SecondOrderPage.SUCCESS_MESSAGE));

        // Проверяем успешность оформления заказа
        String successText = driver.findElement(SecondOrderPage.SUCCESS_MESSAGE).getText();
        assertTrue(successText.contains("Заказ оформлен"), "Сообщение об успешном оформлении заказа отсутствует!");
    }
}