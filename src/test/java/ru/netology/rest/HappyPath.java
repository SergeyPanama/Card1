package ru.netology.rest;

import com.codeborne.selenide.Condition;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HappyPath {


    @AfterEach
    public void close(){
        driver.quit();
        driver = null;
    }
    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
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
        open("http://localhost:7777/");
        $(".form-field_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Алексей");
        $("[data-test-id=phone] input").setValue("+79012345678");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldReturnValidValueDoubleName() {
        open("http://localhost:7777/");
        $(".form-field_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Алексей Александр Иванов");
        $("[data-test-id=phone] input").setValue("+79012345678");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}

