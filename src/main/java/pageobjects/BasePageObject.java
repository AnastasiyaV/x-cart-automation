package pageobjects;

import org.openqa.selenium.WebDriver;
import pageobjects.module.LinksNavbarModule;
import pageobjects.module.SignInModule;

abstract class BasePageObject {
    protected WebDriver driver;
    private LinksNavbarModule linksNavbarModule;
    private SignInModule signInModule;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.linksNavbarModule =  new LinksNavbarModule(driver);
        this.signInModule =  new SignInModule(driver);
    }

    public LinksNavbarModule getLinksNavbarModule() {
        return linksNavbarModule;
    }
   public SignInModule getSignInModule() {
        return signInModule;
    }
}
