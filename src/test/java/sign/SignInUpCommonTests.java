package sign;

import base.BaseTestSetup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInUpCommonTests extends BaseTestSetup {

    @Test
    public void verifySignInUpModuleDisplayedAfterButtonClick() {
        homePage.getHeaderModule().clickSignInUpButton();
        Assert.assertTrue(homePage.getHeaderModule().IsDisplayedButton());
        boolean b = homePage.getSignInModule().isSignInUpModuleDisplayed();
        Assert.assertTrue(b);
        //Assert.assertTrue(homePage.getSignInModule().isSignInUpModuleDisplayed());
    }
}
