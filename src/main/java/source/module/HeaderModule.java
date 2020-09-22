package source.module;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderModule { //?from Ana: this (SignInUp) HeaderModule can be mixed with navbar header
    private static final Logger logger = Logger.getLogger(LinksNavbarModule.class.getName());
    private final WebDriver driver;
    private final By headerBarSignInButton = By.cssSelector(".header_bar-sign_in button");

    public HeaderModule(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderModule clickSignInUpButton() {
        logger.info("Clicking on [Sign in/Sign up] button");
        this.driver.findElement(headerBarSignInButton).click();
        return this;
    }
}
