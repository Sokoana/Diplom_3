package pageforthetests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PersonalAccountPage {
    private final WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //надпись В этом разделе вы можете изменить свои персональные данные
    public final By profileInscription = By.xpath(".//nav/p[text()='В этом разделе вы можете изменить свои персональные данные']");

    //кнопка Выход
    private final By exitButton = By.xpath(".//button[text()='Выход']");


    public void waitForLoadAccountPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(profileInscription));
        driver.findElement(profileInscription);
    }


    public void clickExitButton() {
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();

    }
}