package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class FirstOrderPage {

    private final WebDriver driver;

    // Локаторы полей ввода
    public static final By NAME_FIELD = By.xpath("//input[@placeholder='* Имя']");
    public static final By SURNAME_FIELD = By.xpath(".//*[@placeholder='* Фамилия']");
    public static final By ADDRESS_FIELD = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");
    public static final By METRO_STATION_FIELD = By.xpath(".//*[@placeholder='* Станция метро']");
    public static final By PHONE_FIELD = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");
    public static final By NEXT_STEP_BUTTON = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public FirstOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для прокрутки до элемента
    protected void scrollToElement(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    // Метод для заполнения поля имя
    public void enterName(String name) {
        scrollToElement(NAME_FIELD);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(NAME_FIELD).sendKeys(name);
    }

    // Метод для заполнения поля фамилия
    public void enterSurname(String surname) {
        scrollToElement(SURNAME_FIELD);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(SURNAME_FIELD).sendKeys(surname);
    }

    // Метод для заполнения поля адрес
    public void enterAddress(String address) {
        scrollToElement(ADDRESS_FIELD);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(ADDRESS_FIELD).sendKeys(address);
    }

    // Метод для выбора станции метро
    public void selectMetroStation(String station) {
        driver.findElement(METRO_STATION_FIELD).click();
        driver.findElement(By.xpath(".//*[@class='select-search__row'][2]")).click();
    }

    // Метод для заполнения поля номер телефона
    public void enterPhoneNumber(String phone) {
        scrollToElement(PHONE_FIELD);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(PHONE_FIELD).sendKeys(phone);
    }

    // Метод для перехода на второй этап заказа
    public void nextStep() {
        scrollToElement(NEXT_STEP_BUTTON);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(NEXT_STEP_BUTTON).click();
    }

    // Заполнение данными первой страницы заказа
    public void fillFirstPage(String name, String surname, String address, String station, String phone) {
        enterName(name);
        enterSurname(surname);
        enterAddress(address);
        selectMetroStation(station);
        enterPhoneNumber(phone);
        nextStep();
    }

}