package base;

import driver.WebDriverUtils;
import navigation.WebDriverNavigation;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import source.pageobject.HomePage;
import utils.TestUtils;

public abstract class BaseTestSetup {
    private static final Logger logger = Logger.getLogger(BaseTestSetup.class.getName());

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverNavigation navigate;

    protected HomePage homePage;
    protected TestUtils testUtils;

    @BeforeSuite
    public void setUp() {
        logger.info("Starting to initialize all Tests components...");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = WebDriverUtils.initWebDriver();

        navigate = new WebDriverNavigation(driver);
        navigate.toHomePage();

        wait = WebDriverUtils.getWebDriverWait(driver);
        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));

        homePage = new HomePage();
        testUtils = new TestUtils();
    }

    @AfterSuite
    public void tearDown() {
        WebDriverUtils.closeWebDriver();
        WebDriverUtils.quitWebDriver();
    }
}
