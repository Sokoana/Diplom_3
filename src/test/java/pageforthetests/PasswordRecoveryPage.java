package pageforthetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PasswordRecoveryPage {
    private final WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }
    //ссылка Войти
    private final By loginLink = By.xpath(".//div/p/a[@href='/login' and text()='Войти']");
    //Восстановление пароля
    public final By recoveryPassword = By.xpath(".//main/div/h2[text()='Восстановление пароля']");




    public void waitForLoadRecoveryPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(recoveryPassword));
    }


    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
