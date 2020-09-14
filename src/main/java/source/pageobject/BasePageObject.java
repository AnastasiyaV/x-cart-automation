package source.pageobject;

import driver.WebDriverUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import source.module.HeaderModule;
import source.module.LinksNavbarModule;

public abstract class BasePageObject {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    private final LinksNavbarModule linksNavbarModule;
    public LinksNavbarModule getLinksNavbarModule() {
        return this.linksNavbarModule;
    }

    private final HeaderModule headerModule;
    public HeaderModule getHeaderModule() {
        return this.headerModule;
    }

    public BasePageObject() {
        this.driver = WebDriverUtils.getDriver();
        this.wait = WebDriverUtils.getWait();
        this.linksNavbarModule = new LinksNavbarModule(this.driver);
        this.headerModule = new HeaderModule(this.driver);
    }
}
