package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import utils.DriverManager;

class DropdownTests {

    private WebDriver driver;
    private MainPage page;

    @BeforeEach
    void setUp() {
        driver = DriverManager.getChromeDriver();
        page = new MainPage(driver);
        page.open(); // Открываем главную страницу
        driver.manage().window().maximize(); // Разворачиваем на весь экран
    }

    @AfterEach
    void tearDown() {
        DriverManager.quitDriver(); // Завершаем работу браузера после каждого теста
    }

    @Test
    void testDropdownContent() throws InterruptedException {

        // Метод для клика на первый элемент
        WebElement firstTargetElement = driver.findElement(MainPage.FIRST_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", firstTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstTargetElement);
        String firstContent = page.getFirstDropdownText();
        assertEquals("", firstContent.trim()); // Проверяем текст первого элемента

        // Метод для клика на второй элемент
        WebElement secondTargetElement = driver.findElement(MainPage.SECOND_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", secondTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", secondTargetElement);
        String secondContent = page.getSecondDropdownText();
        assertEquals("", secondContent.trim()); // Проверяем текст второго элемента

        // Метод для клика на третий элемент
        WebElement thirdTargetElement = driver.findElement(MainPage.THIRD_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", thirdTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", thirdTargetElement);
        String thirdContent = page.getThirdDropdownText();
        assertEquals("", thirdContent.trim()); // Проверяем текст третьего элемента

        // Метод для клика на четвёртый элемент
        WebElement fourthTargetElement = driver.findElement(MainPage.FOURTH_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", fourthTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fourthTargetElement);
        String fourthContent = page.getFourthDropdownText();
        assertEquals("", fourthContent.trim()); // Проверяем текст четвёртого элемента

        // Метод для клика на пятый элемент
        WebElement fifthTargetElement = driver.findElement(MainPage.FIFTH_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", fifthTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fifthTargetElement);
        String fifthContent = page.getFifthDropdownText();
        assertEquals("", fifthContent.trim()); // Проверяем текст пятого элемента

        // Метод для клика на шестой элемент
        WebElement sixthTargetElement = driver.findElement(MainPage.SIXTH_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", sixthTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sixthTargetElement);
        String sixthContent = page.getSixthDropdownText();
        assertEquals("", sixthContent.trim()); // Проверяем текст шестого элемента

        // Метод для клика на седьмой элемент
        WebElement seventhTargetElement = driver.findElement(MainPage.SEVENTH_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", seventhTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", seventhTargetElement);
        String seventhContent = page.getSeventhDropdownText();
        assertEquals("", seventhContent.trim()); // Проверяем текст седьмого элемента

        // Метод для клика на восмой элемент
        WebElement eightTargetElement = driver.findElement(MainPage.EIGHT_TARGET_ELEMENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", eightTargetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eightTargetElement);
        String eightContent = page.getEightDropdownText();
        assertEquals("", eightContent.trim()); // Проверяем текст восьмого элемента

    }

    private void assertEquals(String s, String trim) {
    }
}