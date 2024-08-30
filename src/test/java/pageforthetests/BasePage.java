package pageforthetests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //главная страница
    private final By basePage = By.xpath(".//h1[text()='Соберите бургер']");
    //кнопка Войти в аккаунт
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка Личный кабинет
    private final By accountButton = By.xpath(".//a[@href='/account']");
    //кнопка Соусы
    private final By sauce = By.xpath(".//span[@class='text text_type_main-default'][text()='Соусы']");
    //кнопка Начинки
    private final By filling = By.xpath(".//span[@class='text text_type_main-default'][text()='Начинки']");
    //раздел
    private final By section = By.xpath("//div[starts-with(@class, 'tab_tab__1SPyG tab_tab_type_current__2BEPc')]//span");
    //надпись Соберите бургер
    public final By makeBurger = By.xpath(".//h1[text()='Соберите бургер']");
    //кнопка Булки
    private final By buns = By.xpath(".//span[@class='text text_type_main-default'][text()='Булки']");




    public void waitForLoadMainPage() {
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(basePage));
    }


    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }


    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }


    public void clickBunsButton() {
        driver.findElement(buns).click();
    }


    public void clickSauceButton() {
        driver.findElement(sauce).click();
    }


    public void clickFillingButton() {
        driver.findElement(filling).click();
    }


    public String getTextCurrentSection() {
        return driver.findElement(section).getText();
    }
}