package firstTests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class SignInTest extends BaseTest {
    private static final Logger logger = Logger.getLogger(SignInTest.class.getName());
    WebDriverWait wait = new WebDriverWait(driver, 2);

    @Test
    public void verifySigningInUnderAnastasiyaWillDisplayMyAccountLink(){
        homePage.clickSignInUpButton().performSignIn("anastasiya.vynogradska@hotmail.com", "anastasiya");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(homePage.getMyAccountSelector().isMyAccountModuleDisplayed());
    }
    @Test
    public void verifyClickingOnCreateNewAccountLinkWillDisplayNewAccountCreationForm(){
        homePage.clickSignInUpButton().clickSignInCreateAccountLink();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(homePage.getHeaderBarSignInModule().isSignUpModuleDisplayed());
    }
    @Test
    public void verifySigningUPUnderAnastasiyaWillDisplayEmailIsUsedError(){
        homePage.clickSignInUpButton().clickSignInCreateAccountLink().performSignUp("anastasiya.vynogradska@hotmail.com", "anastasiya", "anastasiya");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(homePage.clickSignInUpButton().isSignUpEmailIsUsedErrorDisplayed());
    }

}
