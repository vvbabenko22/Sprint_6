package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.FirstOrderPage;
import pages.SecondOrderPage;
import utils.DriverManager;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void testPositiveScenarioThroughUpperButton() throws InterruptedException {
        mainPage.clickUpperOrderButton(); // Нажимаем на верхнюю кнопку "Заказать"
        TimeUnit.SECONDS.sleep(1); // Пауза на 1 секунду
        firstOrderPage.fillFirstPage("Иван", "Иванов", "Москва ул. Ленина д.1", "Черкизовская", "+79991234567");
        secondOrderPage.fillSecondPage("25 августа 2025", "сутки", "привезти вечером");
        assertTrue(secondOrderPage.isSuccessMessageDisplayed());
    }

    // Тестируем позитивный сценарий через нижнюю кнопку "Заказать"
    @Test
    void testPositiveScenarioThroughLowerButton() throws InterruptedException {
        mainPage.clickLowerOrderButton(); // Нажимаем на нижнюю кнопку "Заказать"
        TimeUnit.SECONDS.sleep(1); // Пауза на 1 секунду
        firstOrderPage.fillFirstPage("Сергей", "Сергеев", "Санкт-Петербург ул. Невского д.10", "Черкизовская", "+79997654321");
        secondOrderPage.fillSecondPage("25 сентября 2025", "сутки", "оставьте у двери");
        assertTrue(secondOrderPage.isSuccessMessageDisplayed());
    }
}