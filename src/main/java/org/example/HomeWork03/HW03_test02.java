package org.example.HomeWork03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HW03_test02 {

    public static void main (String [] args){

        // автоматизация теста переходов по категория основного меню
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("1380x948");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com");

        //переход в "путешествия"
        WebElement webElement1 = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/div[4]/div[1]/div[1]/div/div/ul/li[2]/a"));
        webElement1.click();
        //переход в "медиа в ЖЖ"
        WebElement webElement2 = driver.findElement(By.xpath("//a[contains(text(),'Медиа в ЖЖ')]"));
        webElement2.click();
        //переход в "мода"
        WebElement webElement3 = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/div[4]/div[1]/div[1]/div/div/ul/li[3]/a"));
        webElement3.click();

        //driver.quit();

    }

}
