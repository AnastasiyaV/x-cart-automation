import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.HomePageObject;

public class HomePageTest extends BaseTest {
    @Test
    public void assertHomeNavBar(){
        Assert.assertEquals(homePage.getHomeNavbarText(), HomePageObject.homeNavbarTextExpected);
    }
    @Test
    public void clickContactUs(){
        homePage.clickContactUsLink();
        HomePageObject.contactUsUrlActual = driver.getCurrentUrl();
        Assert.assertEquals(homePage.contactUsUrlActual, Urls.CONTACTUS.getUrl());
    }



}
