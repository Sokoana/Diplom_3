package pageforthetests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AutorizationPage {
    private final WebDriver driver;

    public AutorizationPage(WebDriver driver) {
        this.driver = driver;
    }
    //поле Email
    private final By emailField = By.xpath(".//input[@name='name']");
    //поле Пароль
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    //кнопка Войти
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    //ссылка Зарегистрироваться
    private final By registrLink = By.xpath(".//a[@href='/register' and text()='Зарегистрироваться']");
    //ссылка Восстановить пароль
    private final By restorePasswordLink = By.xpath(".//a[@href='/forgot-password' and text()='Восстановить пароль']");
    //кнопка Конструктор
    private final By constructorButton = By.xpath(".//a/p[text()='Конструктор']");
    //кнопка Логотип "
    private final By logoButton = By.xpath(".//div/a[@href='/']");
    //Вход
    public final By entrance = By.xpath(".//main/div/h2[text()='Вход']");



    public void waitLoginPage() {
        new WebDriverWait(driver, 5).until(driver -> (driver.findElement(entrance).getText() != null
                && !driver.findElement(entrance).getText().isEmpty()
        ));
    }
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }


    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }


    public void clickEntranceButton() {
        driver.findElement(loginButton).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }


    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }





    public void logInUser(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickEntranceButton();
    }


    public void clickRegistrationLink() {
        driver.findElement(registrLink).click();
    }


    public void clickPasswordLink() {
        driver.findElement(restorePasswordLink).click();
    }

}