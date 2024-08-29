package test;

import elements.Drivers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import  pageforthetests.*;

public class TransitionsSectionsConstructorTest extends Drivers {
    WebDriver driver;
    BasePage basePage;
    private String url = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void setUp() {
        Drivers browserPage = new Drivers();
        driver = browserPage.getWebdriver("chrome");
        driver.get(url);
        basePage = new BasePage(driver);
    }
    @Test

    public void testGoToSectionSauce() {
        basePage.waitForLoadMainPage();
        basePage.clickSauceButton();
        Assert.assertEquals("Соусы", basePage.getTextCurrentSection());
    }

    @Test

    public void testGoToSectionFilling() {
        basePage.waitForLoadMainPage();
        basePage.clickFillingButton();
        Assert.assertEquals("Начинки", basePage.getTextCurrentSection());
    }

    @Test

    public void testGoToSectionBun() {
        basePage.waitForLoadMainPage();
        basePage.clickSauceButton();
        basePage.clickBunsButton();
        Assert.assertEquals("Булки", basePage.getTextCurrentSection());
    }


    @After
    public void cleanUp() {
        driver.quit();
    }
}
