package source.pageobject;

import driver.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import source.module.HeaderModule;
import source.module.LinksNavbarModule;
import source.module.signInUp.SignInModule;

public abstract class BasePageObject {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    private final LinksNavbarModule linksNavbarModule;
    public LinksNavbarModule getLinksNavbarModule() {
        return this.linksNavbarModule;
    }

    private final HeaderModule headerModule;
    
    public HeaderModule getHeaderModule() {
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@class='header_bar-sign_in']/button[@class='btn  regular-button  popup-button popup-login' and @type='button']"))));
        return this.headerModule;
    }

    private final SignInModule signInModule;
    public SignInModule getSignInModule() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-dialog"));
        return this.signInModule;
    }
    
    public BasePageObject() {
        this.driver = WebDriverUtils.getDriver();
        this.wait = WebDriverUtils.getWait();
        this.linksNavbarModule = new LinksNavbarModule(this.driver);
        this.headerModule = new HeaderModule(this.driver);
        this.signInModule = new SignInModule(this.driver);
    }
}
