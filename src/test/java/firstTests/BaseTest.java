package firstTests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageobjects.HomePageObject;

import java.util.concurrent.TimeUnit;

abstract class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl = "https://trial.x-cart.com/nazarkraniagmailcom/";
    protected HomePageObject homePage;


    @BeforeSuite
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

         /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        wait = new WebDriverWait(driver, 20);
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        /*Boolean complete = wait.until(new ExpectedCondition<Boolean>() {
                                          public Boolean apply(WebDriver wdriver) {
                                              return ((JavascriptExecutor) driver).executeScript(
                                                      "return document.readyState"
                                              ).equals("complete");
                                          }
                                      });

        /*public static boolean isloadComplete(WebDriver driver)
        {*/

        homePage = new HomePageObject(driver);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
