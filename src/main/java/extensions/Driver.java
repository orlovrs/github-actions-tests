package extensions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = Browser.get();
        }

        return driver;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }
}
