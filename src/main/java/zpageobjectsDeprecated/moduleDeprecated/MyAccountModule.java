package zpageobjectsDeprecated.moduleDeprecated;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Deprecated
public class MyAccountModule {
    private WebDriver driver;
    private WebElement parentAccountLinks;
    private static final Logger logger = Logger.getLogger(MyAccountModule.class.getName());

    public MyAccountModule (WebDriver driver) {
        this.driver = driver;
        this.parentAccountLinks = driver.findElement(By.cssSelector(".account-links"));
    }


    public boolean isMyAccountModuleDisplayed() {
        return this.parentAccountLinks.isDisplayed();
    }
}
