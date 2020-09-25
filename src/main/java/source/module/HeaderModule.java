package source.module;

import driver.WebDriverUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderModule { //?from Ana: this (SignInUp) HeaderModule can be mixed with navbar header
    private static final Logger logger = Logger.getLogger(LinksNavbarModule.class.getName());
    private final WebDriver driver;
    private final By headerBarSignInButton = By.cssSelector(".header_bar-sign_in button");
    private final By SignInDialogSelector = By.cssSelector(".ui-dialog");
    private WebDriverWait wait;

    public HeaderModule(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderModule clickSignInUpButton() {
        logger.info("Clicking on [Sign in/Sign up] button");
        this.driver.findElement(headerBarSignInButton).click();
        this.wait = WebDriverUtils.getWait(); //
        //wait.until(ExpectedConditions.presenceOfElementLocated((By) By.cssSelector(".ui-dialog")));
        return this;
    }
    class InnerSignInModule{
        public WebDriver driver;
        private WebElement signInEmailTextFieldSelector;
        private WebElement signInPasswordTextFieldSelector;
        private WebElement signInsubmitButtonSelector;
        private WebElement signInCreateAccountLinkSelector;
        private WebElement signInforgotPasswordSelector;
        private WebElement SignInInvalidLoginOrPasswordErrorSelector;


        public InnerSignInModule(WebDriver driver) {
            this.driver = driver;
            this.signInEmailTextFieldSelector =  driver.findElement(By.id("login-email"));
            this.signInPasswordTextFieldSelector =  driver.findElement(By.id("login-password"));
            this.signInsubmitButtonSelector =  driver.findElement(By.cssSelector(".login-form .submit"));
            this.signInCreateAccountLinkSelector =  driver.findElement(By.xpath("//a[contains(.,'Create new account']"));  // todo: to figure out how to write locators!
            this.signInforgotPasswordSelector =  driver.findElement(By.cssSelector(".popup-button default-popup-button forgot"));
            this.SignInInvalidLoginOrPasswordErrorSelector =  driver.findElement(By.cssSelector(".form-error"));// how to specify text "<li class="error" style="">This email address is already in use by another user.</li>"
        }

        public void sendKeysSignInEmail (String email) {
            logger.info("Entering SignIn Email Text Field");
            signInEmailTextFieldSelector.sendKeys(email);
        }
        public void sendKeysSignInPassword(String password) {
            logger.info("Entering password to SignIn Password Text Field");
            signInPasswordTextFieldSelector.sendKeys(password);
        }
        public void clickSignInSubmitButton () {
            logger.info("Clicking Sign in Button");
            signInsubmitButtonSelector.click();
        }
        public void clickSignInCreateAccountLink () {
            logger.info("Clicking SignIn CreateNewAccountLink");
            signInCreateAccountLinkSelector.click();
        }
        public void clickSignInForgotPasswordLink () {
            logger.info("Clicking SignIn Forgot Password Link");
            signInforgotPasswordSelector.click();
        }
        public boolean isSignInInvalidLoginOrPasswordErrorDisplayed (){
            return this.SignInInvalidLoginOrPasswordErrorSelector.isDisplayed();
        }

        public boolean isSignInModuleDisplayed() {
            return this.signInCreateAccountLinkSelector.isDisplayed();
        }
    }

}
