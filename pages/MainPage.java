package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;

    // Локаторы элементов
    public static final By FIRST_TARGET_ELEMENT = By.id("accordion__heading-0"); // Первый элемент
    public static final By SECOND_TARGET_ELEMENT = By.id("accordion__heading-1"); // Второй элемент

    // Локаторы текста
    public static final By DROPDOWN_TEXT_FIRST_LOCATOR = By.xpath("//div[@id='accordion__heading-0']/following::p[1]");
    public static final By DROPDOWN_TEXT_SECOND_LOCATOR = By.xpath("//div[@id='accordion__heading-1']/following::p[1]");

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
}