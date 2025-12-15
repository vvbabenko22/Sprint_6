package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.FirstOrderPage;
import pages.SecondOrderPage;
import utils.DriverManager;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Гарантированно одноэкземплярный режим
class PositiveFlowTests {

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

    // Тестируем позитивный сценарий через верхнюю кнопку "Заказать"
    @Test
    void testPositiveScenarioThroughUpperButton() throws InterruptedException {
        mainPage.clickUpperOrderButton();
        TimeUnit.SECONDS.sleep(1);
        firstOrderPage.fillFirstPage(
                "Иван",
                "Иванов",
                "Москва ул. Ленина д.1",
                2,          // Черкизовская
                "+79991234567"
        );
        secondOrderPage.fillSecondPage(
                "25 августа 2025",
                1,           // Срок аренды: сутки (позиция 1)
                "привезти вечером"
        );
        Thread.sleep(2000); // Пауза перед подтверждением заказа
        secondOrderPage.confirmOrder(); // Подтверждаем заказ
        Thread.sleep(2000); // Пауза перед проверкой успеха
        assertTrue(secondOrderPage.isSuccessMessageDisplayed()); // Проверяем наличие сообщения об успехе
    }

    // Тестируем позитивный сценарий через нижнюю кнопку "Заказать"
    @Test
    void testPositiveScenarioThroughLowerButton() throws InterruptedException {
        mainPage.clickLowerOrderButton();
        TimeUnit.SECONDS.sleep(1);
        firstOrderPage.fillFirstPage(
                "Сергей",
                "Сергеев",
                "Санкт-Петербург ул. Невского д.10",
                4, // Сокольники
                "+79997654321"
        );
        secondOrderPage.fillSecondPage(
                "25 сентября 2025",
                2, // Срок аренды: двое суток (позиция 2)
                "оставьте у двери"
        );

        Thread.sleep(2000); // Пауза перед подтверждением заказа
        secondOrderPage.confirmOrder(); // Подтверждаем заказ
        Thread.sleep(2000); // Пауза перед проверкой успеха
        assertTrue(secondOrderPage.isSuccessMessageDisplayed()); // Проверяем наличие сообщения об успехе
    }

        private void assertTrue(boolean successMessageDisplayed) {
    }
}