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
        driver.manage().window().maximize();
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

        // Пауза на 1 секунду
        TimeUnit.SECONDS.sleep(1);

        // Открываем второй элемент
        WebElement secondTargetElement = driver.findElement(MainPage.SECOND_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", secondTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", secondTargetElement);
        String secondContent = page.getSecondDropdownText();
        assertEquals("", secondContent.trim()); // Проверяем текст второго элемента

        // Пауза на 1 секунду
        TimeUnit.SECONDS.sleep(1);

        // Открываем третий элемент
        WebElement thirdTargetElement = driver.findElement(MainPage.THIRD_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", thirdTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", thirdTargetElement);
        String thirdContent = page.getThirdDropdownText();
        assertEquals("", thirdContent.trim()); // Проверяем текст третьего элемента

        // Пауза на 1 секунду
        TimeUnit.SECONDS.sleep(1);

        // Открываем четвёртый элемент
        WebElement fourthTargetElement = driver.findElement(MainPage.FOURTH_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", fourthTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fourthTargetElement);
        String fourthContent = page.getFourthDropdownText();
        assertEquals("", fourthContent.trim()); // Проверяем текст четвёртого элемента

        // Пауза на 1 секунду
        TimeUnit.SECONDS.sleep(1);

        // Открываем пятый элемент
        WebElement fifthTargetElement = driver.findElement(MainPage.FIFTH_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", fifthTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fifthTargetElement);
        String fifthContent = page.getFifthDropdownText();
        assertEquals("", fifthContent.trim()); // Проверяем текст пятого элемента

        // Пауза на 1 секунду
        TimeUnit.SECONDS.sleep(1);

        // Открываем шестой элемент
        WebElement sixthTargetElement = driver.findElement(MainPage.SIXTH_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", sixthTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sixthTargetElement);
        String sixthContent = page.getSixthDropdownText();
        assertEquals("", sixthContent.trim()); // Проверяем текст шестого элемента

        // Пауза на 1 секунду
        TimeUnit.SECONDS.sleep(1);

        // Открываем седьмой элемент
        WebElement seventhTargetElement = driver.findElement(MainPage.SEVENTH_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", seventhTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", seventhTargetElement);
        String seventhContent = page.getSeventhDropdownText();
        assertEquals("", seventhContent.trim()); // Проверяем текст седьмого элемента

        // Пауза на 1 секунду
        TimeUnit.SECONDS.sleep(1);

        // Открываем восьмой элемент
        WebElement eightTargetElement = driver.findElement(MainPage.EIGHT_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", eightTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eightTargetElement);
        String eightContent = page.getEightDropdownText();
        assertEquals("", eightContent.trim()); // Проверяем текст восьмого элемента

    }
}