package pageobjectsDeprecated.moduleDeprecated;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import enums.TopLinkSelector;

@Deprecated
public class LinksNavbarModule {
    public WebDriver driver;
    private static final Logger logger = Logger.getLogger(LinksNavbarModule.class.getName());

    public LinksNavbarModule(WebDriver driver) {
        this.driver = driver;
    }

    public void click(TopLinkSelector topLink) {
        logger.info("Clicking on TopModule selector " + topLink.getCssSelector());
        driver.findElement(By.cssSelector(topLink.getCssSelector())).click();
    }
}
