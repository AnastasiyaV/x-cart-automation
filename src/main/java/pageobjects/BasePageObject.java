package pageobjects;

import org.openqa.selenium.WebDriver;
import pageobjects.module.LinksNavbarModule;

abstract class BasePageObject {
    protected WebDriver driver;
    private LinksNavbarModule linksNavbarModule;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.linksNavbarModule =  new LinksNavbarModule(driver);;
    }

    public LinksNavbarModule getLinksNavbarModule() {
        return linksNavbarModule;
    }
}
