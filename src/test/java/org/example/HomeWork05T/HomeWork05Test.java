package org.example.HomeWork05T;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HomeWork05Test {

    static WebDriver driver;
    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("1380x948");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void startSite(){Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.livejournal.com"),
            "Страница не доступна");}

    @Test
    void test1() {
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
                .build()
                .perform();
        WebElement webElement6 = driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout"));
        webElement6.click();
        //ассерт
        Assertions.assertEquals("Главное — ЖЖ",driver.getTitle(),"Не та страница");
    }

    @Test
    void test2() {
        //переход в "медиа в ЖЖ"
        WebElement webElement1 = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/div[4]/div[1]/div[1]/div/div/ul/li[2]/a"));
        webElement1.click();
        //ассерт
        Assertions.assertEquals("Медиа в ЖЖ — ЖЖ",driver.getTitle(),"Не та страница");
    }

    @Test
    void test3() {
        //переход в "новые лица"
        WebElement webElement2 = driver.findElement(By.xpath("//html[@id='js']/body/div[2]/div[4]/div/div/div/div/ul/li/a"));
        webElement2.click();
        //ассерт
        Assertions.assertEquals("Новые лица — ЖЖ",driver.getTitle(),"Не та страница");
    }

    @Test
    void test4()
    {
        //переход в "психология"
        WebElement webElement2 = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/div[4]/div[1]/div[1]/div/div/ul/li[5]/a"));
        webElement2.click();
        //ассерт
        Assertions.assertEquals("Статьи и блоги о психологии, психологические тесты — Живой Журнал — ЖЖ",driver.getTitle(),"Не та страница");
    }

    @Test
    void test5() throws InterruptedException {
        // смена на en
        Actions action = new Actions((driver));
        WebElement we = driver.findElement(By.cssSelector(".s-drop-master"));
        action.moveToElement(we)
                .build()
                .perform();
        WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-sub-list__item:nth-child(1) > .s-header-sub-list-item__link"));
        webElement1.click();
        Thread.sleep(1000);
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[5]/a/span")),
                driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[5]/a/span")),
                "Не тот язык выбран");

        //смена на ru
        Actions action1 = new Actions((driver));
        WebElement we1 = driver.findElement(By.cssSelector(".s-drop-master"));
        action1.moveToElement(we1)
                .build()
                .perform();
        WebElement webElement2 = driver.findElement(By.cssSelector(".s-header-sub-list__item:nth-child(2) > .s-header-sub-list-item__link"));
        webElement2.click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[5]/ul/li[2]/a")),
                driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[5]/ul/li[2]/a")),
                "Не тот язык выбран");


    }

    @Test
    void test6 ()
    {
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
        //ассерт
        Assertions.assertEquals("Настройки аккаунта",driver.getTitle(),"Не та страница");
        //редактировать профиль
        WebElement webElement7 = driver.findElement(By.xpath("//*[@id=\"settings_left\"]/div[1]/div/div/table/tbody/tr[1]/td[2]/span[2]/a"));
        webElement7.click();
        //ассерт
        Assertions.assertEquals("Редактор профиля",driver.getTitle(),"Не та страница");
        //открыть список
        WebElement webElement8 = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/div[3]/div[1]/div/form[2]/table[1]/tbody/tr[4]/td[2]/div[2]/select"));
        webElement8.click();
        //выбрать из списка "зарегистрированным пользователям"
        WebElement webElement9 = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/div[3]/div[1]/div/form[2]/table[1]/tbody/tr[4]/td[2]/div[2]/select/option[2]"));
        webElement9.click();
        //кнопка сохранить
        WebElement webElement10 = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/div[3]/div[1]/div/form[2]/footer/button"));
        webElement10.click();
        //ассерт
        Assertions.assertEquals("khazov71 - Профиль",driver.getTitle(),"Не та страница");
    }

    @AfterAll
    static void close(){
        driver.quit();
    }

}
