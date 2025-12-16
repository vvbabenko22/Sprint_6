package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

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

    // Локаторы кнопок Заказать
    private final By UPPER_ORDER_BUTTON = By.xpath(".//*[@class='Button_Button__ra12g']");
    private final By LOWER_ORDER_BUTTON = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Локатор кнопки Принять куки
    private final By COOKIE_ACCEPT_BUTTON = By.xpath("//button[@id='rcc-confirm-button']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для открытия страницы
    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    // Метод для нажатия на верхнюю кнопку Заказать
    public void clickUpperOrderButton() {
        driver.findElement(UPPER_ORDER_BUTTON).click();
    }

    // Метод для нажатия на нижнюю кнопку Заказать
    public void clickLowerOrderButton() {
        driver.findElement(LOWER_ORDER_BUTTON).click();
    }

    // Метод для принятия cookie
    public void acceptCookies() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(COOKIE_ACCEPT_BUTTON))
                .click();
    }

    // Метод возвращения на главную страницу
    public void goBackToHomepage() {
        driver.get("https://qa-scooter.praktikum-services.ru");
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.urlContains("scooter")); // Ждём загрузки домашней страницы
    }
}