package org.example.HomeWork06T;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MainPageTest extends AbstractTest {

    @Test

    void mainMenuTest1(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickmediaJJ();

        Assertions.assertEquals("Медиа в ЖЖ — ЖЖ",webDriver.getTitle(),"Не та страница");
    }

    @Test
    void mainMenuTest2(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clicknovielica();

        Assertions.assertEquals("Новые лица — ЖЖ",webDriver.getTitle(),"Не та страница");
    }

    @Test
    void mainMenuTest3(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickjivayaprirodaJJ();

        Assertions.assertEquals("#живаяприрода — ЖЖ",webDriver.getTitle(),"Не та страница");
    }

    @Test
    void changeLanguage(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clickChangeLanguage();
        Assertions.assertEquals(webDriver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[5]/a/span")),
                webDriver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[5]/a/span")),
                "Не тот язык выбран");
    }

    @Test
    void loginInTest(){
        LoginIn loginIn = new LoginIn (getWebDriver());
        loginIn
                .loginIn()
                .logOut();

        Assertions.assertEquals("Главное — ЖЖ",webDriver.getTitle(),"Не та страница");
    }

    @Test
    void changeOptionsTest(){
        LoginIn loginIn = new LoginIn(getWebDriver());
        loginIn
                .loginIn()
                .changeOptions();
        Assertions.assertEquals("khazov71 - Профиль",webDriver.getTitle(),"Не та страница");
    }



}
