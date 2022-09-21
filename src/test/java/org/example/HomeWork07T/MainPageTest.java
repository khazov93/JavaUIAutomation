package org.example.HomeWork07T;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.NoSuchElementException;

@Story("Различный функционал сайта ЖЖ")
public class MainPageTest extends AbstractTest {

    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Test
    @DisplayName("Переход на вкладку Медиа в ЖЖ")
    @Description("Показать возможность перехода на вкладку Медиа в ЖЖ")
    @Issue("https://docs.google.com/document/d/1Z9qeZsUsSMEwpPpilh_ZwDiqQIcyhUih/edit?usp=sharing&ouid=100274869532413984930&rtpof=true&sd=true")
    @Severity(SeverityLevel.NORMAL)
    void mainMenuTest1() throws IOException
    {
        MainMenu mainMenu = new MainMenu(getWebDriver());
        //скрин для того чтобы посмотреть как выглядит меню и какие кнопки на главном экране
        File file = Util.makeScreenshot(getWebDriver(),"MainPageTest-1" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        mainMenu
                .clickmediaJJ();
        Assertions.assertEquals("Медиа в ЖЖ — ЖЖ",webDriver.getTitle(),"Не та страница");

    }

    @Test
    @DisplayName("Переход на вкладку Новые лица")
    @Description("Показать возможность перехода на вкладку Новые лица")
    @Issue("https://docs.google.com/document/d/1Z9qeZsUsSMEwpPpilh_ZwDiqQIcyhUih/edit?usp=sharing&ouid=100274869532413984930&rtpof=true&sd=true")
    @Severity(SeverityLevel.NORMAL)
    void mainMenuTest2(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clicknovielica();

        Assertions.assertEquals("Новые лица — ЖЖ",webDriver.getTitle(),"Не та страница");
    }

    @Test
    @DisplayName("Переход на вкладку #живаяприрода")
    @Description("Показать возможность перехода на вкладку #живая природа")
    @Issue("https://docs.google.com/document/d/1Z9qeZsUsSMEwpPpilh_ZwDiqQIcyhUih/edit?usp=sharing&ouid=100274869532413984930&rtpof=true&sd=true")
    @Severity(SeverityLevel.NORMAL)
    void mainMenuTest3(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickjivayaprirodaJJ();

        Assertions.assertEquals("#живаяприрода — ЖЖ",webDriver.getTitle(),"Не та страница");
    }

    @Test
    @DisplayName("Смена языка сайта на английский")
    @Description("Показать возможность смены языка сайта на английский")
    @Issue("https://docs.google.com/document/d/1Z9qeZsUsSMEwpPpilh_ZwDiqQIcyhUih/edit?usp=sharing&ouid=100274869532413984930&rtpof=true&sd=true")
    @Severity(SeverityLevel.CRITICAL)
    void changeLanguage() throws IOException{
        MainMenu mainMenu = new MainMenu(getWebDriver());

        mainMenu
                .clickChangeLanguage();
        File file = Util.makeScreenshot(getWebDriver(),"MainMenu-language" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        Assertions.assertEquals(webDriver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[5]/a/span")),
                webDriver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[5]/a/span")),
                "Не тот язык выбран");
    }

    @Test
    @DisplayName("Тест логирования и выхода из аккаунта")
    @Description("Показать возможность залогиниться и выйти из профиля")
    @Issue("https://docs.google.com/document/d/1Z9qeZsUsSMEwpPpilh_ZwDiqQIcyhUih/edit?usp=sharing&ouid=100274869532413984930&rtpof=true&sd=true")
    @Severity(SeverityLevel.BLOCKER)
    void loginInTest() {
        LoginIn loginIn = new LoginIn(getWebDriver());
        loginIn
                .loginIn()
                .logOut();

        Assertions.assertEquals("Главное — ЖЖ",webDriver.getTitle(),"Не та страница");
    }

    @Test
    @DisplayName("Тест выбора в настройках опции <показывать день рождения> - только зарегистрированным пользователям")
    @Description("Показать возможность выбора в настройках опции <показывать день рождения> - только зарегистрированным пользователям")
    @Issue("https://docs.google.com/document/d/1Z9qeZsUsSMEwpPpilh_ZwDiqQIcyhUih/edit?usp=sharing&ouid=100274869532413984930&rtpof=true&sd=true")
    @Severity(SeverityLevel.MINOR)
    void changeOptionsTest(){
        LoginIn loginIn = new LoginIn(getWebDriver());
        loginIn
                .loginIn()
                .changeOptions();
        Assertions.assertEquals("khazov71 - Профиль",webDriver.getTitle(),"Не та страница");
    }



}
