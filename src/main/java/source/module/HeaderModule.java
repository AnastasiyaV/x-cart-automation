package source.module;

import driver.WebDriverUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderModule {
    private static final Logger logger = Logger.getLogger(LinksNavbarModule.class.getName());
    private final WebDriver driver;
    private final By headerBarSignInButton = By.cssSelector(".header_bar-sign_in button");
    //private final By SignInDialogSelector = By.cssSelector(".ui-dialog");
    private WebDriverWait wait;

    public HeaderModule(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderModule clickSignInUpButton() {
        logger.info("Clicking on [Sign in/Sign up] button");
        this.driver.findElement(headerBarSignInButton).click();
        this.wait = WebDriverUtils.getWait();
        //wait.until(ExpectedConditions.presenceOfElementLocated((By) By.cssSelector(".ui-dialog")));
        return this;
    }
    public boolean IsDisplayedButton() {
        return driver.findElement(headerBarSignInButton).isDisplayed();
    }

}
