package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import utils.DriverManager;
import java.util.concurrent.TimeUnit;
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
    void testDropdownContent() throws InterruptedException {

        // Открываем первый элемент
        WebElement firstTargetElement = driver.findElement(MainPage.FIRST_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", firstTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstTargetElement);
        String firstContent = page.getFirstDropdownText();
        assertEquals("", firstContent.trim()); // Проверяем текст первого элемента

        // Пауза на 1 секунды
        TimeUnit.SECONDS.sleep(1); // Задержка между действиями

        // Открываем второй элемент
        WebElement secondTargetElement = driver.findElement(MainPage.SECOND_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", secondTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", secondTargetElement);
        String secondContent = page.getSecondDropdownText();
        assertEquals("", secondContent.trim()); // Проверяем текст второго элемента


    }
}