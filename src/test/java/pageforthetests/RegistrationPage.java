package pageforthetests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    //поле Пароль
    private final By passwordField = By.xpath(".//div[./label[text()='Пароль']]/input[@name='Пароль']");
    //кнопка Зарегистрироваться
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    //текста Некорректный пароль
    public final By uncorrectPasswordText = By.xpath(".//div/p[text()='Некорректный пароль']");
    //ссылка Войти
    private final By loginLink = By.xpath(".//div/p/a[@href='/login' and text()='Войти']");
    //страница Регистрация
    public final By registrationPage = By.xpath(".//div/h2[text()='Регистрация']");
    //поле Имя
    private final By nameField = By.xpath(".//div[./label[text()='Имя']]/input[@name='name']");
    //поле Email
    private final By emailField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");



    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }


    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }


    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }


    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }


    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }


    public void waitForLoadRegisterPage() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(registrationPage));

    }


    public void registerUser(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegistrationButton();
    }

}