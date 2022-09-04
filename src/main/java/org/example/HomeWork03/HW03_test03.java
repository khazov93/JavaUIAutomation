package org.example.HomeWork03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HW03_test03 {

    //автоматизация теста смены языка на en и с en на ru
    public static void main (String [] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("1380x948");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com");

        // смена на en
        Actions action = new Actions((driver));
        WebElement we = driver.findElement(By.cssSelector(".s-drop-master"));
        action.moveToElement(we)
                .build()
                .perform();

        WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-sub-list__item:nth-child(1) > .s-header-sub-list-item__link"));
        webElement1.click();
        Thread.sleep(1000);

        //смена на ru
        Actions action1 = new Actions((driver));
        WebElement we1 = driver.findElement(By.cssSelector(".s-drop-master"));
        action1.moveToElement(we1)
                .build()
                .perform();
        WebElement webElement2 = driver.findElement(By.cssSelector(".s-header-sub-list__item:nth-child(2) > .s-header-sub-list-item__link"));
        webElement2.click();

        //driver.quit();
    }
}
