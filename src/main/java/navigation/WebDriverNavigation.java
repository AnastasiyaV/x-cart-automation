package navigation;

import enums.Urls;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 * This class is gonna be used to provide general navigation.
 * TODO:
 * 1. each function is gonna return appropriate page object;
 */
public class WebDriverNavigation {
    private static final Logger logger = Logger.getLogger(WebDriverNavigation.class.getName());

    private final WebDriver driver;

    public WebDriverNavigation(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigates to Home Page.
     */
    public void toHomePage() {
        String url = Urls.HOME.getUrl();
        logger.info(String.format("Navigate to [%S]", url));
        try {
            this.driver.get(url);
        } catch (WebDriverException e) {
            logger.error(String.format("Navigation to [%s] failed due to the [%s]", url, e.getMessage()));
        }
    }
}
