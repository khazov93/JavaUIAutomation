package org.example.HomeWork03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HW03_test01 {

    public static void main(String[] args){

        // автотест логирования и выхода из учётной записи
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("1380x948");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com");

        // вход в учётную запись и снятие чекбокса "запомни меня"
        WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();
        WebElement webElement2 = driver.findElement(By.id("user"));
        webElement2.sendKeys("Khazov71");
        WebElement webElement3 = driver.findElement(By.id("lj_loginwidget_password"));
        webElement3.sendKeys("Jj19931993");
        WebElement webElement4 = driver.findElement(By.cssSelector(".b-loginform-checkbox__control"));
        webElement4.click();
        WebElement webElement5 = driver.findElement(By.name("action:login"));
        webElement5.click();

        //наведение на логин с последующим выпадением скрытых опций и выбора "выход"
        Actions action = new Actions((driver));
        WebElement we = driver.findElement(By.cssSelector(".s-header-item--user"));
        action.moveToElement(we)
                //.moveToElement(driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout")))
                //.click(driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout")))
                //.moveToElement(driver.findElement(By.cssSelector(".s-header-sub-list-item__link")))
                //.click(driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout")))
                .build()
                .perform();
        WebElement webElement6 = driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout"));
        webElement6.click();

        //driver.quit();

    }
}
