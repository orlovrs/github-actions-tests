package extensions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

    public static WebDriver get() {
        try {
            switch (System.getProperty("browser")) {
                case "headless-chrome":
                    return getHeadlessChrome();
                case "firefox":
                    return getHeadlessChrome();
                case "edge":
                    return getHeadlessChrome();
                case "safari":
                    return getHeadlessChrome();
            }
        } catch (Exception e) {
            return getChrome();
        }
        return null;
    }

    private static WebDriver getHeadlessChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }

    private static ChromeDriver getChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
