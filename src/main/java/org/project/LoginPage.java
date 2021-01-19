package org.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/form/div[3]/button")
    private WebElement loginBtn1;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div[1]/form/div[3]/button")
    private WebElement loginBtn2;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn1() {
        loginBtn1.click();
    }

    public void clickLoginBtn2() {
        loginBtn2.click();
    }

}
