package pageobjects.module;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MyAccountModule {
    private WebDriver driver;
    private static final Logger logger = Logger.getLogger(MyAccountModule.class.getName());

    public MyAccountModule (WebDriver driver) {
        this.driver = driver;
    }

}
