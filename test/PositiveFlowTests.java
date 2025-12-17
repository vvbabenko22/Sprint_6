package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.FirstOrderPage;
import pages.SecondOrderPage;
import utils.DriverManager;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Гарантированно одноэкземплярный режим
class PositiveFlowTests {

    private WebDriver driver;
    private MainPage mainPage;
    private FirstOrderPage firstOrderPage;
    private SecondOrderPage secondOrderPage;

    @BeforeAll
    void setUp() {
        driver = DriverManager.getFirefoxDriver();
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

    // Тестируем позитивный сценарий через верхнюю кнопку "Заказать"
    @Test
    void testPositiveScenarioThroughUpperButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // Явное ожидание

        mainPage.clickUpperOrderButton();

        firstOrderPage.fillFirstPage(
                "Иван",
                "Иванов",
                "Москва ул. Ленина д.1",
                2, // Черкизовская
                "+79991234567"
        );

        secondOrderPage.setDeliveryDate("25 августа 2025");
        secondOrderPage.clickAboutOfRentLocator(); // Кликаем после выбора даты, чтобы закрыть календарь
        secondOrderPage.selectRentPeriod(1); // Срок аренды: сутки (позиция 1)
        secondOrderPage.addComment("привезти вечером");
        secondOrderPage.placeOrder(); // Нажимаем Заказать
        secondOrderPage.confirmOrder(); // Подтверждаем заказ

        wait.until(ExpectedConditions.visibilityOfElementLocated(SecondOrderPage.SUCCESS_MESSAGE)); // Ждём появления сообщения об успехе

        // Проверяем, что заказ оформлен
        String successText = driver.findElement(SecondOrderPage.SUCCESS_MESSAGE).getText();
        Assertions.assertTrue(successText.contains("Заказ оформлен"), "Сообщение об успешном оформлении заказа отсутствует!");
    }

    // Тестируем позитивный сценарий через нижнюю кнопку "Заказать"
    @Test
    void testPositiveScenarioThroughLowerButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1)); // Явное ожидание

        mainPage.clickLowerOrderButton();

        firstOrderPage.fillFirstPage(
                "Сергей",
                "Сергеев",
                "Санкт-Петербург ул. Невского д.10",
                4, // Сокольники
                "+79997654321"
        );

        secondOrderPage.setDeliveryDate("25 сентября 2025");
        secondOrderPage.clickAboutOfRentLocator(); // Кликаем после выбора даты, чтобы закрыть календарь
        secondOrderPage.selectRentPeriod(2); // Срок аренды: двое суток (позиция 2)
        secondOrderPage.addComment("оставьте у двери");
        secondOrderPage.placeOrder(); // Нажимаем Заказать
        secondOrderPage.confirmOrder(); // Подтверждаем заказ

        wait.until(ExpectedConditions.visibilityOfElementLocated(SecondOrderPage.SUCCESS_MESSAGE)); // Ждём появления сообщения об успехе

        // Проверяем, что заказ оформлен
        String successText = driver.findElement(SecondOrderPage.SUCCESS_MESSAGE).getText();
        Assertions.assertTrue(successText.contains("Заказ оформлен"), "Сообщение об успешном оформлении заказа отсутствует!");
    }
}