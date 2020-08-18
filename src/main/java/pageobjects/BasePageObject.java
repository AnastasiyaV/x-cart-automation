package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.module.HeaderBarSignInModule;
import pageobjects.module.LinksNavbarModule;
import pageobjects.module.MyAccountModule;

abstract class BasePageObject {
    private static final Logger logger = Logger.getLogger(BasePageObject.class.getName());
    protected WebDriver driver;
    private LinksNavbarModule linksNavbarModule;
    private HeaderBarSignInModule headerBarSignInModule;
    private WebElement signInSelector;
    private MyAccountModule myAccountModule;
    private WebElement myAccountSelector;
    WebDriverWait wait = new WebDriverWait(driver, 5);

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.linksNavbarModule =  new LinksNavbarModule(driver);
        this.headerBarSignInModule = new HeaderBarSignInModule(driver);
        this.myAccountModule = new MyAccountModule(driver);
        this.signInSelector =  driver.findElement(By.cssSelector(".header_bar-sign_in button[data-without-close=\"1\"]"));
        this.myAccountSelector =  driver.findElement(By.cssSelector(".dropdown header_bar-my_account"));
        //this.signInSelector.isDisplayed();
    }

    public WebElement getMyAccountrSelector() {
        return myAccountSelector;
    }
    public LinksNavbarModule getLinksNavbarModule() {
        return linksNavbarModule;
    }

    public HeaderBarSignInModule clickSignInUpButton () {
        logger.info("Clicking on 'Sign In / sign up' button");
        signInSelector.click();
       // WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated((By) myAccountSelector));//how to do it without casting (By)?
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return headerBarSignInModule;
    }

    public MyAccountModule clickMyAccount () {
        logger.info("Clicking on 'My account'");
        myAccountSelector.click();
        //WebDriverWait wait =
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myAccountModule;
    }

}
