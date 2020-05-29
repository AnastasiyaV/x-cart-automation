package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.BasePageObject;

public class HomePageObject extends BasePageObject {
    public HomePageObject(WebDriver driver) {
        super(driver);
    }
    private By bannerRotationWidget =By.id("banner-rotation-widget");

}
