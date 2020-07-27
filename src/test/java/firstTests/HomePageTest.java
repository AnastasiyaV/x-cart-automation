package firstTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.SignInSelector;
import pageobjects.TopLinkSelector;
import org.apache.log4j.Logger;

public class HomePageTest extends BaseTest {
private static final Logger logger = Logger.getLogger(HomePageTest.class.getName());


    @Test (priority = 2, description = "Verify that Clicking New Will Open NewArr Page")
    public void verifyClickingNewWillOpenNewArrPage (){
        homePage.getLinksNavbarModule().click(TopLinkSelector.NEW);
        Assert.assertEquals(driver.getCurrentUrl().contains(TopLinkSelector.NEW.getCssSelectorSuffix()), true);
    }

    @Test(dataProvider="getTopUrl", priority = 1, description = "Verify that Clicking TopUrl Instance Will Open Expected Page")
    @Feature("Feature1: Top Url Module")
    @Severity(SeverityLevel.NORMAL)
    public void verifyClickingTopUrlInstanceWillOpenExpectedPage(TopLinkSelector topLinkSelector) {
        homePage.getLinksNavbarModule().click(topLinkSelector);
        logger.info("Verify that CurrentUrl same as expected in the Top Navbar Menu");
        if (!topLinkSelector. equals(TopLinkSelector.HOME)) {
            Assert.assertEquals(driver.getCurrentUrl().contains(topLinkSelector.getCssSelectorSuffix()), true);
        }else if (topLinkSelector.equals(TopLinkSelector.HOME)) {
            Assert.assertEquals(driver.getCurrentUrl().contains("https://cloud.x-cart.com/nazarkraniagmailcom/"), true);
        }
    }
    @DataProvider (name = "getTopUrl")//read about "parallel = true"
    public Object[] getTopUrl() {
        return new Object[] {TopLinkSelector.NEW, TopLinkSelector.SHIPPING, TopLinkSelector.COMMINGSOON, TopLinkSelector.CONTACTUS, TopLinkSelector.HOME};
    }

    @Test (priority = 2, description = "Verify that clicking HeaderBarSignIn will open SignIn dialog")
    public void verifyClickingHeaderBarSignInWillOpenSignInDialog (){
        homePage.getSignInModule().click(signInSelector);
        //how to assert that id="ui-id-9" is opened? assert that .gettext  = "Sign in"?
    }

}
