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

public class LoginPageTest extends Drivers {
    WebDriver driver;
    private String url = "https://stellarburgers.nomoreparties.site/";
    private Users user;
    private String accessToken;
    BasePage basePage;
    AutorizationPage autorizationPage;
    RegistrationPage registrationPage;
    PersonalAccountPage personalAccountPage;
    PasswordRecoveryPage passwordRecoveryPage;

    @Before
    public void settingUp() {
        Drivers browserPage = new Drivers();
        driver = browserPage.getWebdriver("chrome");
        driver.get(url);
        user = Users.randomDataUser();
        AddInfoUser.buildUser(user);
        basePage = new BasePage(driver);
        autorizationPage = new AutorizationPage(driver);
        registrationPage = new RegistrationPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
    }
    @Test

    public void testPasswordRecoveryPage() {
        basePage.clickAccountButton();
        autorizationPage.clickPasswordLink();
        passwordRecoveryPage.waitForLoadRecoveryPage();
        passwordRecoveryPage.clickLoginLink();
        autorizationPage.logInUser(user.getEmail(), user.getPassword());
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        basePage.waitForLoadMainPage();
        Assert.assertTrue("Пусто", driver.findElement(basePage.makeBurger).isDisplayed());
    }

    @Test
        public void testAutorizationButton() {
        basePage.clickLoginButton();
        autorizationPage.waitLoginPage();
        autorizationPage.logInUser(user.getEmail(), user.getPassword());
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        basePage.waitForLoadMainPage();
        Assert.assertTrue("Пусто", driver.findElement(basePage.makeBurger).isDisplayed());
    }

    @Test

    public void testPersonalAccountButton() {
        basePage.clickAccountButton();
        autorizationPage.logInUser(user.getEmail(), user.getPassword());
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        basePage.waitForLoadMainPage();
        Assert.assertTrue("Пусто", driver.findElement(basePage.makeBurger).isDisplayed());
    }

    @Test

    public void testRegisterPage() {
        basePage.clickAccountButton();
        autorizationPage.clickRegistrationLink();
        registrationPage.clickLoginLink();
        autorizationPage.logInUser(user.getEmail(), user.getPassword());
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        basePage.waitForLoadMainPage();
        Assert.assertTrue("Пусто", driver.findElement(basePage.makeBurger).isDisplayed());
    }


    @After
    public void deleteUp() {
        if (accessToken != null) {
            AddInfoUser.deleteUser(accessToken);
        }
        driver.quit();
    }
}
