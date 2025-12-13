package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    // Локаторы элементов
    public static final By FIRST_TARGET_ELEMENT = By.id("accordion__heading-0"); // Первый элемент
    public static final By SECOND_TARGET_ELEMENT = By.id("accordion__heading-1"); // Второй элемент
    public static final By THIRD_TARGET_ELEMENT = By.id("accordion__heading-2"); // Третий элемент
    public static final By FOURTH_TARGET_ELEMENT = By.id("accordion__heading-3"); // Четвёртый элемент
    public static final By FIFTH_TARGET_ELEMENT = By.id("accordion__heading-4"); // Пятый элемент
    public static final By SIXTH_TARGET_ELEMENT = By.id("accordion__heading-5"); // Шестой элемент
    public static final By SEVENTH_TARGET_ELEMENT = By.id("accordion__heading-6"); // Седьмой элемент
    public static final By EIGHT_TARGET_ELEMENT = By.id("accordion__heading-7"); // Восьмой элемент

    // Локаторы текста
    public static final By DROPDOWN_TEXT_FIRST_LOCATOR = By.xpath("//div[@id='accordion__heading-0']/following::p[1]");
    public static final By DROPDOWN_TEXT_SECOND_LOCATOR = By.xpath("//div[@id='accordion__heading-1']/following::p[1]");
    public static final By DROPDOWN_TEXT_THIRD_LOCATOR = By.xpath("//div[@id='accordion__heading-2']/following::p[1]");
    public static final By DROPDOWN_TEXT_FOURTH_LOCATOR = By.xpath("//div[@id='accordion__heading-3']/following::p[1]");
    public static final By DROPDOWN_TEXT_FIFTH_LOCATOR = By.xpath("//div[@id='accordion__heading-4']/following::p[1]");
    public static final By DROPDOWN_TEXT_SIXTH_LOCATOR = By.xpath("//div[@id='accordion__heading-5']/following::p[1]");
    public static final By DROPDOWN_TEXT_SEVENTH_LOCATOR = By.xpath("//div[@id='accordion__heading-6']/following::p[1]");
    public static final By DROPDOWN_TEXT_EIGHT_LOCATOR = By.xpath("//div[@id='accordion__heading-7']/following::p[1]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для открытия страницы
    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    // Метод для получения текста первого элемента
    public String getFirstDropdownText() {
        return driver.findElement(DROPDOWN_TEXT_FIRST_LOCATOR).getText();
    }

    // Метод для получения текста второго элемента
    public String getSecondDropdownText() {
        return driver.findElement(DROPDOWN_TEXT_SECOND_LOCATOR).getText();
    }

    // Метод для получения текста третьего элемента
    public String getThirdDropdownText() {
        return driver.findElement(DROPDOWN_TEXT_THIRD_LOCATOR).getText();
    }

    // Метод для получения текста четвёртого элемента
    public String getFourthDropdownText() {
        return driver.findElement(DROPDOWN_TEXT_FOURTH_LOCATOR).getText();
    }

    // Метод для получения текста пятого элемента
    public String getFifthDropdownText() {
        return driver.findElement(DROPDOWN_TEXT_FIFTH_LOCATOR).getText();
    }

    // Метод для получения текста шестого элемента
    public String getSixthDropdownText() {
        return driver.findElement(DROPDOWN_TEXT_SIXTH_LOCATOR).getText();
    }

    // Метод для получения текста седьмого элемента
    public String getSeventhDropdownText() {
        return driver.findElement(DROPDOWN_TEXT_SEVENTH_LOCATOR).getText();
    }

    // Метод для получения текста восьмого элемента
    public String getEightDropdownText() {
        return driver.findElement(DROPDOWN_TEXT_EIGHT_LOCATOR).getText();
    }

}