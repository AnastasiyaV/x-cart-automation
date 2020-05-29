import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.HomePageObject;

import java.util.concurrent.TimeUnit;

abstract class BaseTest {
    public WebDriver driver;//?why static?
    public String baseUrl = "https://trial.x-cart.com/nazarkraniagmailcom/";
    protected HomePageObject homePage;

    @BeforeSuite
    public void setDriver() { // Base test
        System.setProperty("webdriver.chrome.driver", "/Users/admin/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePageObject(driver);

    }
    @BeforeClass
    public void navigateToHomePage() {
        driver.get(baseUrl);
        String basePageTitle = driver.getTitle();
        Assert.assertEquals(basePageTitle,"*Your company name* > Catalog");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
