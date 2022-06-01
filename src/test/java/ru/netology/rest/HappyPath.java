package ru.netology.rest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HappyPath {

private WebDriver driver;
    @BeforeAll
    static void setUp(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    @BeforeEach
    public void openPage() {
        driver = new ChromeDriver();

    }
    @AfterEach
    public void close(){
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldReturnValidValue() {
        open("http://localhost:7777/");
        $(".form-field_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Александр Исаев");
        $("[data-test-id=phone] input").setValue("+79012345678");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldReturnValidValueOneName() {
        $(".form-field_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Алексей");
        $("[data-test-id=phone] input").setValue("+79012345678");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldReturnValidValueDoubleName() {
        $(".form-field_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Алексей Александр Иванов");
        $("[data-test-id=phone] input").setValue("+79012345678");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}

