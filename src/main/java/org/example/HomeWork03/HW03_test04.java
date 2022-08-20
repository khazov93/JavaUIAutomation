package org.example.HomeWork03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HW03_test04 {

    public static void main(String [] args)
    {
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
        //открыть меню "настройки"
        Actions action = new Actions((driver));
        WebElement we = driver.findElement(By.cssSelector(".s-header-item--user"));
        action.moveToElement(we)
                .build()
                .perform();
        WebElement webElement6 = driver.findElement(By.cssSelector(".s-header-sub-list-item__link--settings"));
        webElement6.click();
        //редактировать профиль
        WebElement webElement7 = driver.findElement(By.xpath("//*[@id=\"settings_left\"]/div[1]/div/div/table/tbody/tr[1]/td[2]/span[2]/a"));
        webElement7.click();
        //открыть список
        WebElement webElement8 = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/div[3]/div[1]/div/form[2]/table[1]/tbody/tr[4]/td[2]/div[2]/select"));
        webElement8.click();
        //выбрать из списка "зарегистрированным пользователям"
        WebElement webElement9 = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/div[3]/div[1]/div/form[2]/table[1]/tbody/tr[4]/td[2]/div[2]/select/option[2]"));
        webElement9.click();
        //кнопка сохранить
        WebElement webElement10 = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/div[3]/div[1]/div/form[2]/footer/button"));
        webElement10.click();
        //driver.quit();
    }

}
