package pageobjects.module;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.SignInSelector;
import pageobjects.TopLinkSelector;

public class SignInModule {
    public WebDriver driver;
    private static final Logger logger = Logger.getLogger(SignInModule.class.getName());

    public SignInModule(WebDriver driver) {
        this.driver = driver;
    }

    public void click (SignInSelector signInSelector) {
        logger.info("Clicking on signInSelector " + signInSelector.getHeaderBarSignIn());
        driver.findElement(By.cssSelector(signInSelector.getHeaderBarSignIn())).click();
    }

}
