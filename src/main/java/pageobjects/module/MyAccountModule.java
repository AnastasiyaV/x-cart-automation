package pageobjects.module;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountModule {
    private WebDriver driver;
    private WebElement parent;
    private static final Logger logger = Logger.getLogger(MyAccountModule.class.getName());

    public MyAccountModule (WebDriver driver) {
        this.driver = driver;
        this.parent = driver.findElement(By.cssSelector(".account-links"));
    }


    public boolean isMyAccountModuleDisplayed() {
        return this.parent.isDisplayed();
    }
}
