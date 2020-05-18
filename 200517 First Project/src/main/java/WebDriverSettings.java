import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {

    public WebDriver driver;
    public String baseUrl;

    @Before
    public void setUp() throws Exception {
        //done via PATH. hot to do it via directory?
        System.setProperty("webdriver.chrome.driver", "/Users/admin/Drivers/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.get(baseUrl);
        //driver.manage().timeouts().implicitlyWait(DriverConfig.WAIT_SEC, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
