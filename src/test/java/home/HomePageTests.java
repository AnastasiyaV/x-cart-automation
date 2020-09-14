package home;

import base.BaseTestSetup;
import enums.TopLinkSelector;
import enums.Urls;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTestSetup {

    @Test(dataProvider = "getTopUrl")
    public void verifyClickingOnTopLinkWillOpenAppropriatePage(TopLinkSelector topLinkSelector) {
        homePage.getLinksNavbarModule().clickNavbarLink(topLinkSelector);
        Assert.assertEquals(
                Urls.HOME.getUrl() + topLinkSelector.getCssSelectorSuffix(),
                testUtils.getCurrentUrl()
        );
    }

    @DataProvider
    public Object[] getTopUrl() {
        return new Object[] {
                TopLinkSelector.NEW,
                TopLinkSelector.SHIPPING,
                TopLinkSelector.COMMINGSOON,
                TopLinkSelector.CONTACTUS,
                TopLinkSelector.HOME
        };
    }
}
