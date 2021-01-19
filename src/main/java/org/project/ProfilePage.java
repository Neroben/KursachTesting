package org.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"profileInfoWrap\"]/div[2]/div[3]/p[1]")
    private WebElement userName;

    @FindBy(xpath = "//*[@id=\"kinopoisk-header-sticky-container\"]/header/div/div/div[3]/div/div/button")
    private WebElement buttonSupport;

    @FindBy(xpath = "//*[@id=\"kinopoisk-header-sticky-container\"]/header/div/div/div[3]/div/div/div/nav/ul[3]/li[4]/button")
    private WebElement logoutBtn;

    public String getUsername() {
        return userName.getText();
    }

    public void logoutUser() {
        buttonSupport.click();
        logoutBtn.click();
    }

}
