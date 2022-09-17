package org.example.HomeWork06T;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    static WebDriver webDriver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("1380x948");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void startSite(){
        Assertions.assertDoesNotThrow( ()-> webDriver.navigate().to("https://www.livejournal.com"),
                "Страница не доступна");}


    @AfterAll
    static void close(){
        webDriver.quit();
    }

    public WebDriver getWebDriver(){
        return this.webDriver;
    }

}
