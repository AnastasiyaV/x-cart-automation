package sign;

import base.BaseTestSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInUpCommonTests extends BaseTestSetup {

    @Test
    public void verifySignInUpModuleDisplayedAfterButtonClick() {
        homePage.getHeaderModule().clickSignInUpButton();
        Assert.assertTrue(homePage.getSignInModule().isSignInUpModuleDisplayed());
    }
}
