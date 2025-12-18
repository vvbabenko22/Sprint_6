package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import utils.DriverManager;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTests {

    private static WebDriver driver;
    private static MainPage page;

    @BeforeAll
    static void setupClass() {
        driver = DriverManager.getChromeDriver();
        page = new MainPage(driver);
        page.open(); // Открываем главную страницу
        driver.manage().window().maximize(); // Разворачиваем на весь экран
    }

    @AfterAll
    static void teardownClass() {
        DriverManager.quitDriver(); // Завершаем работу браузера после всех тестов
    }

    // Генерируем список аргументов для тестов
    public static List<Arguments> provideDropdownItems() {
        return Stream.of(
                Arguments.of(MainPage.FIRST_TARGET_ELEMENT, MainPage.DROPDOWN_TEXT_FIRST_LOCATOR, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."),
                Arguments.of(MainPage.SECOND_TARGET_ELEMENT, MainPage.DROPDOWN_TEXT_SECOND_LOCATOR, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."),
                Arguments.of(MainPage.THIRD_TARGET_ELEMENT, MainPage.DROPDOWN_TEXT_THIRD_LOCATOR, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
                Arguments.of(MainPage.FOURTH_TARGET_ELEMENT, MainPage.DROPDOWN_TEXT_FOURTH_LOCATOR, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."),
                Arguments.of(MainPage.FIFTH_TARGET_ELEMENT, MainPage.DROPDOWN_TEXT_FIFTH_LOCATOR, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."),
                Arguments.of(MainPage.SIXTH_TARGET_ELEMENT, MainPage.DROPDOWN_TEXT_SIXTH_LOCATOR, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."),
                Arguments.of(MainPage.SEVENTH_TARGET_ELEMENT, MainPage.DROPDOWN_TEXT_SEVENTH_LOCATOR, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."),
                Arguments.of(MainPage.EIGHT_TARGET_ELEMENT, MainPage.DROPDOWN_TEXT_EIGHT_LOCATOR, "Да, обязательно. Всем самокатов! И Москве, и Московской области.")
        ).collect(Collectors.toList());
    }

    // Параметризованный тест для проверки содержания раскрывающихся блоков
    @ParameterizedTest(name = "Проверяем тексты раскрывающихся элементов")
    @MethodSource("provideDropdownItems")
    void testDropdownContent(By targetElement, By textLocator, String expectedText) throws InterruptedException {

        // Клик на элемент
        WebElement element = driver.findElement(targetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        // Ждём появления текста после раскрытия элемента
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator));

        // Получаем текст и выводим его в консоль
        String actualContent = driver.findElement(textLocator).getText();
        System.out.println(actualContent.trim());

        // Проверяем соответствие текста
        assertEquals(expectedText, actualContent.trim(), "Ошибка: текст элемента не совпадает с ожидаемым");
    }
}