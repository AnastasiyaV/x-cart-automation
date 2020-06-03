package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePageObject {
    public HomePageObject(WebDriver driver) {
        super(driver);
    }
    private By bannerRotationWidget =By.id("banner-rotation-widget");
    private By homeNavbar =By.linkText("Home");
    private By contactUs =By.linkText("Contact us");
    String contactUsUrl;

    public final static String homeNavbarTextExpected = "Home";
    public static String contactUsUrlActual;

    public String getHomeNavbarText() {
        return driver.findElement(homeNavbar).getText();
    }

    public void clickContactUsLink() {
        driver.findElement(contactUs).click();
    }

}
