package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import utils.DriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DropdownTests {

    private WebDriver driver;
    private MainPage page;

    @BeforeEach
    void setUp() {
        driver = DriverManager.getFirefoxDriver(); // Только Firefox
        page = new MainPage(driver);
        page.open(); // Открываем страницу перед каждым тестом
    }

    @AfterEach
    void tearDown() {
        DriverManager.quitDriver(); // Завершаем работу браузера после каждого теста
    }

    @Test
    void testDropdownContent() {
        // Получаем ссылку на элемент
        WebElement targetElement = driver.findElement(By.id("accordion__heading-0"));

        // Программа приведет элемент в точку клика
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", targetElement);

        // Выполняем JavaScript-клик, чтобы обойти перекрытия
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", targetElement);

        // Получаем текст после открытия
        String content = page.getDropdownText();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", content.trim()); // Проверяем полученный текст
    }
}