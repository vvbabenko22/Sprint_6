package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

public class SecondOrderPage {

    private final WebDriver driver;

    // Локаторы полей ввода
    public static final By DATE_FIELD = By.xpath(".//*[@placeholder='* Когда привезти самокат']");
    public static final By RENT_PERIOD_SELECT = By.xpath(".//*[@class='Dropdown-placeholder']");
    public static final By COLOR_RADIO_BUTTON = By.xpath(".//*[@class='Checkbox_Label__3wxSf']");
    public static final By COMMENT_FIELD = By.xpath(".//*[@placeholder='Комментарий для курьера']");
    public static final By PLACE_ORDER_BUTTON = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Локатор поля Про аренду для клика после выбора даты доставки самоката
    private final By ABOUT_RENT_LOCATOR = By.xpath(".//*[text()='Про аренду']");

    // Окончательное подтверждение заказа
    public static final By CONFIRM_ORDER_BUTTON = By.xpath(".//*[text()='Да']");

    // Сообщение успешного оформления заказа
    public static final By SUCCESS_MESSAGE = By.xpath(".//*[contains(text(),'Заказ оформлен')]");

    public SecondOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для прокрутки до элемента
    protected void scrollToElement(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    // Метод для выбора даты доставки
    public void setDeliveryDate(String deliveryDate) {
        scrollToElement(DATE_FIELD);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(DATE_FIELD).sendKeys(deliveryDate);
    }

    // Метод для клика на Про аренду после выбора даты доставки самоката
    public void clickAboutOfRentLocator() {
        driver.findElement(ABOUT_RENT_LOCATOR).click();
    }

    // Метод выбора срока аренды из выпадающего списка
    public void selectRentPeriod(String rentPeriod) {
        driver.findElement(RENT_PERIOD_SELECT).click();
        driver.findElement(By.xpath(".//*[@class='Dropdown-option'][1]")).click();
    }

    // Метод для выбора цвета самоката
    public void selectColor() {
        scrollToElement(COLOR_RADIO_BUTTON);
        driver.findElement(COLOR_RADIO_BUTTON).click();
    }

    // Метод для заполнения комментария
    public void addComment(String comment) {
        scrollToElement(COMMENT_FIELD);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(COMMENT_FIELD).sendKeys(comment);
    }

    // Метод для отправки заказа
    public void placeOrder() {
        scrollToElement(PLACE_ORDER_BUTTON);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(PLACE_ORDER_BUTTON).click();
    }

    // Метод для подтверждения заказа
    public void confirmOrder() {
        scrollToElement(CONFIRM_ORDER_BUTTON);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(CONFIRM_ORDER_BUTTON).click();
    }

    // Метод для проверки наличия сообщения об успешном заказе
    public boolean isSuccessMessageDisplayed() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Заполнение данными второй страницы заказа
    public void fillSecondPage(String deliveryDate, String rentPeriod, String comment) {
        setDeliveryDate(deliveryDate);
        clickAboutOfRentLocator();
        selectRentPeriod(rentPeriod);
        selectColor();
        addComment(comment);
        placeOrder();
        confirmOrder();
    }

}