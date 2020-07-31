package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.module.LinksNavbarModule;
import pageobjects.module.SignInModule;

abstract class BasePageObject {
    private static final Logger logger = Logger.getLogger(BasePageObject.class.getName());
    protected WebDriver driver;
    private LinksNavbarModule linksNavbarModule;
    private WebElement signInSelector;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.linksNavbarModule =  new LinksNavbarModule(driver);
        this.signInSelector =  driver.findElement(By.className("header_bar-sign_in button"));
    }

    public LinksNavbarModule getLinksNavbarModule() {
        return linksNavbarModule;
    }

    public void click () {
        logger.info("Clicking on 'Sign In / sign up' button");
        signInSelector.click();
    }

}
