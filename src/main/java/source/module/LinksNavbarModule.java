package source.module;

import enums.TopLinkSelector;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinksNavbarModule {
    private static final Logger logger = Logger.getLogger(LinksNavbarModule.class.getName());
    private final WebDriver driver;

    public LinksNavbarModule(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNavbarLink(TopLinkSelector selector) {
        logger.info(String.format("Clicking on [%s]", selector.getCssSelectorSuffix()));
        this.driver.findElement(By.cssSelector(selector.getCssSelector())).click();
    }
}
