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

public class TransitionsPersonalAccountTest extends Drivers {
    WebDriver driver;
    private String url = "https://stellarburgers.nomoreparties.site/";
    private Users user;
    private String accessToken;
    BasePage basePage;
    AutorizationPage autorizationPage;
    RegistrationPage registrationPage;
    PersonalAccountPage personalAccountPage;


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
    }
    @Test

    public void testGoToAccountPageGoToBurger() {
        basePage.clickLoginButton();
        autorizationPage.waitLoginPage();
        autorizationPage.clickLogoButton();
        basePage.waitForLoadMainPage();
        Assert.assertTrue(driver.findElement(basePage.makeBurger).isDisplayed());
    }

    @Test

    public void testExitPersonalAccountPage() {
        basePage.clickAccountButton();
        autorizationPage.waitLoginPage();
        autorizationPage.logInUser(user.getEmail(), user.getPassword());
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        basePage.waitForLoadMainPage();
        basePage.clickAccountButton();
        personalAccountPage.waitForLoadAccountPage();
        personalAccountPage.clickExitButton();
        autorizationPage.waitLoginPage();
        Assert.assertTrue(driver.findElement(autorizationPage.entrance).isDisplayed());
    }

    @Test

    public void testGoToAccountPage() {
        basePage.waitForLoadMainPage();
        basePage.clickLoginButton();
        autorizationPage.waitLoginPage();
        Assert.assertTrue(driver.findElement(autorizationPage.entrance).isDisplayed());
    }

    @Test

    public void testGoToAccountPageGoToConstructor() {
        basePage.waitForLoadMainPage();
        basePage.clickLoginButton();
        autorizationPage.waitLoginPage();
        autorizationPage.clickConstructorButton();
        basePage.waitForLoadMainPage();
        Assert.assertTrue(driver.findElement(basePage.makeBurger).isDisplayed());
    }


    @After
    public void deleteUp() {
        if (accessToken != null) {
            AddInfoUser.deleteUser(accessToken);
        }
        driver.quit();
    }
}
