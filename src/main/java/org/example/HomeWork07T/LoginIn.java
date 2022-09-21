package org.example.HomeWork07T;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginIn extends AbstractPage {

    public LoginIn(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".s-header-item__link--login")
    private WebElement login;

    @FindBy(id = "user")
    private WebElement user;

    @FindBy(id = "lj_loginwidget_password")
    private WebElement password;

    @FindBy(css = ".b-loginform-checkbox__control")
    private WebElement checkBox;

    @FindBy(name = "action:login")
    private WebElement enter;

    @FindBy(css = ".s-header-item--user")
    private WebElement loginMenu;

    @FindBy(css = ".s-header-sub-list-item__link--logout")
    private WebElement logOut;

    @FindBy(css = ".s-header-item--user")
    private WebElement optionsMenu;

    @FindBy(css = ".s-header-sub-list-item__link--settings")
    private WebElement options;

    @FindBy(xpath = "//*[@id=\"settings_left\"]/div[1]/div/div/table/tbody/tr[1]/td[2]/span[2]/a")
    private WebElement changeProfile;

    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/div[3]/div[1]/div/form[2]/table[1]/tbody/tr[4]/td[2]/div[2]/select")
    private WebElement openList;

    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/div[3]/div[1]/div/form[2]/table[1]/tbody/tr[4]/td[2]/div[2]/select/option[2]")
    private WebElement changeFromList;

    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/div[3]/div[1]/div/form[2]/footer/button")
    private WebElement saveButton;

    public LoginIn loginIn()
    {
        login.click();
        user.click();
        user.sendKeys("Khazov71");
        password.click();
        password.sendKeys("Jj19931993");
        checkBox.click();
        enter.click();
        return this;
    }

    public LoginIn logOut(){

        Actions actions = new Actions(getDriver());
        actions.moveToElement(loginMenu).build().perform();
        logOut.click();
        return this;
    }

    public LoginIn changeOptions()
    {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(optionsMenu).build().perform();
        options.click();
        changeProfile.click();
        openList.click();
        changeFromList.click();
        saveButton.click();

        return this;
    }

}
