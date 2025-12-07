package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы элементов
    By dropdownButtonLocator = By.id("accordion__heading-0"); // Уникальный элемент заголовка
    By dropdownTextLocator = By.cssSelector("div[data-accordion-component='AccordionItemPanel'] p"); // Текст аккордеона

    // Метод для открытия страницы
    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    // Метод для клика по выпадающему списку с ожиданием видимости элемента
    public void clickDropdown() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))          // Максимальное время ожидания
                .pollingEvery(Duration.ofMillis(500))        // Частота проверок
                .ignoring(NoSuchElementException.class)      // Игнорируем исключение, если элемент временно исчезнет
                .ignoring(StaleElementReferenceException.class);

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(dropdownButtonLocator)); // Ждем, пока элемент станет кликабельным
        button.click();
    }

    // Метод для получения текста выпадающего блока с ожиданием видимости
    public String getDropdownText() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownTextLocator)); // Ждем, пока элемент станет видимым
        return textElement.getText();
    }
}