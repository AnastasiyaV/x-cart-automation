package pageobjects.module;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.TopLinkSelector;

public class LinksNavbarModule {
    public WebDriver driver;

    public LinksNavbarModule(WebDriver driver) {
        this.driver = driver;
    }

    public void click(TopLinkSelector topLink) {
        driver.findElement(By.cssSelector(topLink.getCssSelector())).click();
    }
}
