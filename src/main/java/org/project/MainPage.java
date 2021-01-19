package org.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "/html/body/div[1]/div/div[5]/header/div/div/div[3]/div/div")
    private WebElement userMenuSupport;
    /**
     * определение локатора меню пользователя
     */
    @FindBy(xpath = "/html/body/div[1]/div/div[5]/header/div/div/div[3]/div/div/div/nav/ul[1]/li/div/a/div[2]/span[2]")
    private WebElement userMenu;
    /**
     * метод для нажатия кнопки меню пользователя
     */
    public void entryMenu() {
        userMenuSupport.click();
        userMenu.click();
    }
}