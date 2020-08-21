package pageobjects.module;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderBarSignInModule {
    private WebDriver driver;
    private static final Logger logger = Logger.getLogger(HeaderBarSignInModule.class.getName());
    private InnerSignInModule innerSignInModule;
    private InnerSignUpModule innerSignUpModule;

    public HeaderBarSignInModule(WebDriver driver) {
        this.driver = driver;
    }

    public void openSignUpForm(){} //add one more method perform signUp

    public HeaderBarSignInModule performSignIn(String email, String password){
        this.innerSignInModule = new InnerSignInModule(driver);
        this.innerSignInModule.sendKeysSignInEmail(email);
        this.innerSignInModule.sendKeysSignInPassword(password);
        this.innerSignInModule.clickSignInSubmitButton();
        return this;
    }
    public HeaderBarSignInModule clickSignInCreateAccountLink (){
        this.innerSignInModule = new InnerSignInModule(driver);
        this.innerSignInModule.clickSignInCreateAccountLink();
        return this;
    }
    public HeaderBarSignInModule performSignUp (String email, String password, String confirmPassword){
        this.innerSignUpModule = new InnerSignUpModule(driver);
        this.innerSignUpModule.sendKeysSignUpEmail(email);
        this.innerSignUpModule.sendKeysSignUpPassword(password);
        this.innerSignUpModule.sendKeysSignUpConfirmPassword(confirmPassword);
        this.innerSignUpModule.clickSignUpCreateButton();
        return this;
    }
    public boolean isSignUpModuleDisplayed(){
        return this.innerSignUpModule.isSignUpModuleDisplayed();
    }
    public boolean isSignUpEmailIsUsedErrorDisplayed(){
        return this.innerSignUpModule.isSignUpEmailIsUsedErrorDisplayed();
    }

    class InnerSignInModule{
        public WebDriver driver;
        private WebElement signInEmailTextFieldSelector;
        private WebElement signInPasswordTextFieldSelector;
        private WebElement signInsubmitButtonSelector;
        private WebElement signIncreateAccountLinkSelector;
        private WebElement signInforgotPasswordSelector;

        public InnerSignInModule(WebDriver driver) {
            this.driver = driver;
            this.signInEmailTextFieldSelector =  driver.findElement(By.id("login-email"));
            this.signInPasswordTextFieldSelector =  driver.findElement(By.id("login-password"));
            this.signInsubmitButtonSelector =  driver.findElement(By.cssSelector(".login-form .submit"));
            this.signIncreateAccountLinkSelector =  driver.findElement(By.cssSelector(".popup-button default-popup-button create-account-link"));
            this.signInforgotPasswordSelector =  driver.findElement(By.cssSelector("popup-button default-popup-button forgot"));
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
            signIncreateAccountLinkSelector.click();
        }
        public void clickSignInForgotPasswordLink () {
            logger.info("Clicking SignIn Forgot Password Link");
            signInforgotPasswordSelector.click();
        }

    }

    class InnerSignUpModule{
        public WebDriver driver;
        private WebElement signUpEmailTextFieldSelector;
        private WebElement signUpPasswordTextFieldSelector;
        private WebElement signUpConfirmPasswordTextFieldSelector;
        private WebElement signUpCreateButtonSelector;
        private WebElement signUpSignInLinkSelector;
        private WebElement signUpEmailIsUsedErrorSelector;

        public InnerSignUpModule(WebDriver driver) {
            this.driver = driver;
            this.signUpEmailTextFieldSelector =  driver.findElement(By.cssSelector(".input-text-email .login-label"));
            this.signUpPasswordTextFieldSelector =  driver.findElement(By.cssSelector(".input-password .password-label"));
            this.signUpConfirmPasswordTextFieldSelector =  driver.findElement(By.cssSelector(".input-password .password-conf-label"));
            this.signUpCreateButtonSelector =  driver.findElement(By.cssSelector(".button .submit"));
            this.signUpSignInLinkSelector =  driver.findElement(By.cssSelector(".sign-in"));
            this.signUpEmailIsUsedErrorSelector =  driver.findElement(By.cssSelector(".status-messages-wrapper .error"));// how to specify text "<li class="error" style="">This email address is already in use by another user.</li>"
        }
        public void sendKeysSignUpEmail (String email) {
            logger.info("Entering SignUp Email Text Field");
            signUpEmailTextFieldSelector.sendKeys(email);
        }
        public void sendKeysSignUpPassword(String password) {
            logger.info("Entering password to SignUp Password Text Field");
            signUpPasswordTextFieldSelector.sendKeys(password);
        }
        public void sendKeysSignUpConfirmPassword(String password) {
            logger.info("Entering password to SignUp Password Text Field");
            signUpConfirmPasswordTextFieldSelector.sendKeys(password);
        }
        public void clickSignUpCreateButton () {
            logger.info("Clicking Sign Up Create Button");
            signUpCreateButtonSelector.click();
        }
        public void clickSignUpSignInLink () {
            logger.info("Clicking SignUp|SignIn Link");
            signUpSignInLinkSelector.click();
        }

        public boolean isSignUpModuleDisplayed (){
            return this.signUpConfirmPasswordTextFieldSelector.isDisplayed();
        }

        public boolean isSignUpEmailIsUsedErrorDisplayed (){
            return this.signUpEmailIsUsedErrorSelector.isDisplayed();
        }

    }

}
