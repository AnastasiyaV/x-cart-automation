package driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * This class contains all utils functions for WebDriver creation.
 * It also contains additional utils for Wait methods, etc...
 */
public class WebDriverUtils {
    private static final Logger logger = Logger.getLogger(WebDriverUtils.class.getName());
    private static WebDriver driver;
    private static WebDriverWait wait;

    /**
     * Initialize WebDriver for Chrome browser.
     * @return {WebDriver}
     */
    public static WebDriver initWebDriver() {
        logger.info("Initialization of WebDriver started...");
        try {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            logger.info("Initialization of Chrome Driver completed...");
        } catch (WebDriverException e) {
            logger.error(String.format("Failed to initialize Chrome Driver due to [%s]", e.getMessage()));
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitWebDriver() {
        logger.info("Quit from the current WebDriver session");
        try {
            driver.quit();
        } catch (WebDriverException e) {
            logger.info(String.format("Error while tried to quit from the current WebDriver session - %s", e.getMessage()));
        }
    }

    public static void closeWebDriver() {
        logger.info("Close the current WebDriver window");
        try {
            driver.close();
        } catch (WebDriverException e) {
            logger.info(String.format("Error while tried to close current WebDriver window - %s", e.getMessage()));
        }
    }

    /**
     * Initialize WebDriver Wait utils class.
     * @param driver - initialized WebDriver instance;
     * @return {WebDriverWait}
     */
    public static WebDriverWait initWebDriverWait(WebDriver driver) {
        logger.info("Initialization of WebDriver Wait utils...");
        try {
            wait = new WebDriverWait(driver, 20);
            logger.info("Initialization of WebDriver Wait completed...");
        } catch (WebDriverException e) {
            logger.error(String.format("Failed to initialize WebDriver Wait due to [%s]", e.getMessage()));
        }
        return wait;
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
