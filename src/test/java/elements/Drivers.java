package elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class Drivers {

    public WebDriver getWebdriver(String browser) {
        switch (browser.toLowerCase(Locale.ROOT)) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/drivers/yandexdriver.exe");
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException(browser);
        }
    }
}
