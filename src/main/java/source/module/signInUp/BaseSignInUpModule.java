package source.module.signInUp;

import driver.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseSignInUpModule {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //private final By signInModuleRootElement = By.cssSelector(".ui-dialog");
    //private final By signInModuleRootElement = By.xpath("//div[@class='header_bar-sign_in']/button[@class='btn  regular-button  popup-button popup-login' and @type='button']");
    private final By createAccountLinkElement = By.cssSelector(".create-account-link");


    public BaseSignInUpModule(WebDriver webDriver) {
        driver = webDriver;
        wait = WebDriverUtils.getWait();
    }

    public boolean isSignInUpModuleDisplayed() {
        //this .wait.until(ExpectedConditions.presenceOfElementLocated((By) signInModuleRootElement));
        this.wait.until(ExpectedConditions.presenceOfElementLocated((By) createAccountLinkElement));
        return this.driver.findElement(createAccountLinkElement).isDisplayed();
    }
}
