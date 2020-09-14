package pageobjects.module;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class HeaderBarSignInModule {
    private WebDriver driver;
    private static final Logger logger = Logger.getLogger(HeaderBarSignInModule.class.getName());
    private InnerSignInModule innerSignInModule;
    private InnerSignUpModule innerSignUpModule;
    WebDriverWait wait;

    public HeaderBarSignInModule(WebDriver driver) {
        this.driver = driver;
    }

    public void openSignUpForm(){} //add one more method perform signUp


    public HeaderBarSignInModule performSignIn(String email, String password){
        //this.innerSignInModule = new InnerSignInModule(driver);//is not visible here
        wait.until(ExpectedConditions.presenceOfElementLocated((By) this.innerSignInModule.signInEmailTextFieldSelector));
        this.innerSignInModule.sendKeysSignInEmail(email);
        this.innerSignInModule.sendKeysSignInPassword(password);
        this.innerSignInModule.clickSignInSubmitButton();
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
    public HeaderBarSignInModule clickSignInCreateAccountLink (){
        //this.innerSignInModule = new InnerSignInModule(driver); //?delete from here?
        this.innerSignInModule.clickSignInCreateAccountLink();
        return this;
    }

    public boolean isSignInModuleDisplayed(){
        return this.innerSignInModule.isSignInModuleDisplayed();
    }

    public boolean isSignUpModuleDisplayed(){
        return this.innerSignUpModule.isSignUpModuleDisplayed();
    }

    public boolean isSignUpEmailIsUsedErrorDisplayed(){
        return this.innerSignUpModule.isSignUpEmailIsUsedErrorDisplayed();
    }
    public boolean isSignInInvalidLoginOrPasswordErrorDisplayed(){
        return this.innerSignInModule.isSignInInvalidLoginOrPasswordErrorDisplayed();
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

            //this.signInCreateAccountLinkSelector =  driver.findElement(By.cssSelector(".create-account-link"));
            //this.signInCreateAccountLinkSelector =  driver.findElement(By.cssSelector(".popup-button create-account-link"));
            //this.signInCreateAccountLinkSelector =  driver.findElement(By.cssSelector(".popup-button.create-account-link"));
            //this.signInCreateAccountLinkSelector =  driver.findElement(By.className("create-account-link"));
            //this.signInCreateAccountLinkSelector =  driver.findElement(By.xpath("//*[@id=\"form-1599170924857\"]/table/tbody[1]/tr[4]/td/a[1]"));
            //this.signInCreateAccountLinkSelector =  driver.findElement(By.xpath("//html/body/div[4]/div[2]/div/div/form/table/tbody[1]/tr[4]/td/a[1]"));
            //this.signInCreateAccountLinkSelector =  driver.findElement(By.cssSelector("#form-1599170924857 > table > tbody:nth-child(1) > tr:nth-child(4) > td > a.popup-button.default-popup-button.create-account-link"));
            //this.signInCreateAccountLinkSelector =  driver.findElement(By.xpath("//*[contains(@class,'create-account-link']"));
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

            // ?? TODO: to find it later, - signUpEmailIsUsedErrorSelector is not visible here
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
