package pageobjects.module;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInDialogModule {
    public WebDriver driver;
    private static final Logger logger = Logger.getLogger(SignInDialogModule.class.getName());


    public SignInDialogModule(WebDriver driver) {
        this.driver = driver;
    }
    class InnerSignInModule{
        public WebDriver driver;

        private WebElement loginEmailTextFieldSelector;
        private WebElement loginPasswordTextFieldSelector;
        private WebElement submitButton;
        private InnerSignInModule innerSignInModule; // how to put inside NEW InnerSignInModule object?

        public InnerSignInModule(WebDriver driver) {
            this.driver = driver;
            this.loginEmailTextFieldSelector =  driver.findElement(By.id("login-email"));
            this.loginPasswordTextFieldSelector =  driver.findElement(By.id("login-password"));
            this.submitButton =  driver.findElement(By.className("btn  regular-button  submit"));
        }
        public InnerSignInModule getInnerSignInModule() {
            return innerSignInModule;
        }

        public void sendKeysEmailAnastasiyaVynogradskaHotmailCom () {
            logger.info("Entering anastasiya.vynogradska@hotmail.com to Email Text Field");
            loginEmailTextFieldSelector.sendKeys("anastasiya.vynogradska@hotmail.com");
        }
        public void sendKeysPasswordAnastasiyaVynogradskaHotmailCom () {
            logger.info("Entering password '12345678' for anastasiya.vynogradska@hotmail.com to Password Text Field");
            loginEmailTextFieldSelector.sendKeys("12345678");
        }
        public void clickSubmitButton () {
            logger.info("Clicking Sign in Button");
            loginEmailTextFieldSelector.click();
        }

    }
}
