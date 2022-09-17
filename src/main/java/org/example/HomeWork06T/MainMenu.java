package org.example.HomeWork06T;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends AbstractPage
{
    public MainMenu(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/div[4]/div[1]/div[1]/div/div/ul/li[2]/a")
    private WebElement mediaJJ;

    @FindBy(xpath = "//html[@id='js']/body/div[2]/div[4]/div/div/div/div/ul/li/a")
    private WebElement novielicaJJ;

    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/div[4]/div[1]/div[1]/div/div/ul/li[5]/a")
    private WebElement jivayaprirodaJJ;

    @FindBy(css = ".s-drop-master")
    private WebElement changeLanguage;

    @FindBy(css = ".s-header-sub-list__item:nth-child(1) > .s-header-sub-list-item__link")
    private WebElement enLanguage;

    public MainMenu clickmediaJJ(){
        mediaJJ.click();
        return this;
    }

    public MainMenu clicknovielica(){
        novielicaJJ.click();
        return this;
    }

    public MainMenu clickjivayaprirodaJJ(){
        jivayaprirodaJJ.click();
        return this;
    }

    public MainMenu clickChangeLanguage(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(changeLanguage).build().perform();
        enLanguage.click();

        return this;
    }


}
