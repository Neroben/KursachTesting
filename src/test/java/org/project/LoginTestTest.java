package org.project;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTestTest {

    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @Before
    public void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.args", "--allowed-ips");
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    /**
     * тестовый метод для осуществления аутентификации
     */
    @Test
    public void loginTest() {
        //получение доступа к методам класса LoginPage для взаимодействия с элементами страницы
        //значение login/password берутся из файла настроек по аналогии с chromedriver
        //и loginpage
        loginPage.inputLogin(ConfProperties.getProperty("email"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn1();
        //вводим пароль
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn2();
        mainPage.closeAdvertising();
        mainPage.scRight();
        mainPage.scRight();
        mainPage.entryMenu();
//        и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("login"), profilePage.getUsername());
    }

    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */
    @After
    public void tearDown() {
        profilePage.logoutUser();
        driver.quit();
    }

}