package pageobjectsDeprecated;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjectsDeprecated.moduleDeprecated.HeaderBarSignInModule;
import pageobjectsDeprecated.moduleDeprecated.LinksNavbarModule;
import pageobjectsDeprecated.moduleDeprecated.MyAccountModule;

@Deprecated
abstract class BasePageObject {
    private static final Logger logger = Logger.getLogger(BasePageObject.class.getName());
    protected WebDriver driver;
    private LinksNavbarModule linksNavbarModule;
    private HeaderBarSignInModule headerBarSignInModule;
    private WebElement signInUpSelector;
    private MyAccountModule myAccountModule;
    private WebElement myAccountSelector;
    WebDriverWait wait;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        this.linksNavbarModule =  new LinksNavbarModule(driver);
        //this.headerBarSignInModule = new HeaderBarSignInModule(driver);//the selector is not visible yet, only after click SignIN|UP button
        //this.myAccountModule = new MyAccountModule(driver); //the selector is not visible yet, so we will create it later in clickMyAccount method
        this.signInUpSelector =  driver.findElement(By.cssSelector(".header_bar-sign_in button[data-without-close=\"1\"]"));
    }
    public LinksNavbarModule getLinksNavbarModule() {
        return linksNavbarModule;
    }

    public HeaderBarSignInModule clickSignInUpButton () {
        logger.info("Clicking on 'Sign In / sign up' button");
        signInUpSelector.click();
        wait.until(ExpectedConditions.presenceOfElementLocated((By) By.cssSelector(".ui-dialog")));//create variable for locator
        getHeaderBarSignInModule();
        this.headerBarSignInModule = new HeaderBarSignInModule(driver); // Why it is not visible here?
        return headerBarSignInModule;
    }
    public HeaderBarSignInModule getHeaderBarSignInModule () {
        return headerBarSignInModule;
    }

    public MyAccountModule clickMyAccount () {
        logger.info("Clicking on 'My account'");
        myAccountSelector.click();
        wait.until(ExpectedConditions.presenceOfElementLocated((By) By.cssSelector(".account-links")));//create variable
        this.myAccountModule = new MyAccountModule(driver);
        this.myAccountSelector =  driver.findElement(By.cssSelector(".header_bar-my_account"));
        return myAccountModule;
    }
    public MyAccountModule getMyAccountSelector() {
        return myAccountModule;
    }
}
