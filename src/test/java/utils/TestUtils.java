package utils;

import driver.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public TestUtils() {
        this.driver = WebDriverUtils.getDriver();
        this.wait = WebDriverUtils.getWait();
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public void waitForElementToBeDisplayed(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated((By) by));
    }
}
