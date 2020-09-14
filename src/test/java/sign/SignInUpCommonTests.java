package sign;

import base.BaseTestSetup;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignInUpCommonTests extends BaseTestSetup {

    @Test
    public void verifySignInUpModuleDisplayedAfterButtonClick() {
        homePage.getHeaderModule().clickSignInUpButton();
        testUtils.waitForElementToBeDisplayed(By.cssSelector(".ui-dialog")); // TODO: refactor
    }
}
