package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.module.HeaderBarSignInModule;
import pageobjects.module.LinksNavbarModule;
import pageobjects.module.MyAccountModule;

abstract class BasePageObject {
    private static final Logger logger = Logger.getLogger(BasePageObject.class.getName());
    protected WebDriver driver;
    private LinksNavbarModule linksNavbarModule;
    private HeaderBarSignInModule headerBarSignInModule;
    private WebElement signInUpSelector;
    private MyAccountModule myAccountModule;
    private WebElement myAccountSelector;
    WebDriverWait wait = new WebDriverWait(driver, 5);

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.linksNavbarModule =  new LinksNavbarModule(driver);
        //this.headerBarSignInModule = new HeaderBarSignInModule(driver);// SignInModule is not visible yet, only after click SignIN|UP button
        //this.myAccountModule = new MyAccountModule(driver); //MyAccount selector is not visible yet, so we will create it later in clickMyAccount method
        this.signInUpSelector =  driver.findElement(By.cssSelector(".header_bar-sign_in button[data-without-close=\"1\"]"));
        this.myAccountSelector =  driver.findElement(By.cssSelector(".header_bar-my_account"));
    }
    public LinksNavbarModule getLinksNavbarModule() {
        return linksNavbarModule;
    }

    public HeaderBarSignInModule clickSignInUpButton () {
        logger.info("Clicking on 'Sign In / sign up' button");
        signInUpSelector.click();
        wait.until(ExpectedConditions.presenceOfElementLocated((By) By.cssSelector(".ui-dialog")));//create variable for locator
        this.headerBarSignInModule = new HeaderBarSignInModule(driver);
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
        return myAccountModule;
    }
    public MyAccountModule getMyAccountSelector() { //should it be WebElement or MyAccountModule?
        return myAccountModule;
    }
}
