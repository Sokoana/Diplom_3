package test;

import elements.AddInfoUser;
import elements.Drivers;
import elements.Users;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import  pageforthetests.*;

public class RegistrationUserTest extends Drivers {
    private String url = "https://stellarburgers.nomoreparties.site/";
    private Users user;
    private String accessToken;
    BasePage basePage;
    RegistrationPage registrationPage;
    AutorizationPage autorizationPage;
    WebDriver driver;

    @Before
    public void settingUp() {

        Drivers browserPage = new Drivers();
        driver = browserPage.getWebdriver("chrome");
        basePage = new BasePage(driver);
        registrationPage = new RegistrationPage(driver);
        autorizationPage = new AutorizationPage(driver);
        user = Users.randomDataUser();

    }
    @Test

    public void testNotSuccessfulRegistration() {
        driver.get(url);
        basePage.clickLoginButton();
        autorizationPage.clickRegistrationLink();
        registrationPage.waitForLoadRegisterPage();
        registrationPage.registerUser(user.getName(), user.getEmail(), "password");
        Assert.assertTrue("Ошибки нет", driver.findElement(registrationPage.uncorrectPasswordText).isDisplayed());

    }
    @Test

    public void testSuccessfulRegistration() {
        driver.get(url);
        basePage.clickLoginButton();
        autorizationPage.clickRegistrationLink();
        registrationPage.waitForLoadRegisterPage();
        registrationPage.registerUser(user.getName(), user.getEmail(), user.getPassword());
        autorizationPage.waitLoginPage();
        autorizationPage.logInUser(user.getEmail(), user.getPassword());
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        basePage.waitForLoadMainPage();
        Assert.assertTrue("Пусто", driver.findElement(basePage.makeBurger).isDisplayed());
    }



    @After
    public void cleanUp() {
        if (accessToken != null) {
            AddInfoUser.deleteUser(accessToken);
        }
        driver.quit();
    }

}