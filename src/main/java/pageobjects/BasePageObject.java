package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

abstract class BasePageObject {
    protected WebDriver driver;
    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }
    WebElement navBar;


    public void getNavBar() {
        navBar = driver.findElement(By.id ("header-bar"));
        //navBar = driver.findElement(By.className ("navbar"));
        //navBar = driver.findElement(By.className ("navbar navbar-inverse mobile-hidden"));
        //navBar = driver.findElement (By.xpath(".//class[contains(text()."navbar")]"));
        //navBar = driver.findElement (By.cssSelector("[name=navbar navbar-inverse mobile-hidden]"));
           //#header-area > div.desktop-header.affix-top > div > div.navbar.navbar-inverse.mobile-hidden
           ///html/body/div[1]/div[1]/div[2]/div[1]/div/div[4]/div/ul/li[6]/a
        String text = navBar.getText();
        System.out.println(text);
        //return navBar
    }



}
