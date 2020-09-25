package zfirstTestsDeprecated;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

@Deprecated
public class SignInTest extends BaseTest {
    private static final Logger logger = Logger.getLogger(SignInTest.class.getName());

    @Test (priority = 1, description = "SignIn, Positive: Verify that signing in under valid user will display MyAccount")
    public void verifySigningInUnderValidUserWillDisplayMyAccountLink(){
        homePage.clickSignInUpButton().performSignIn("anastasiya.vynogradska@hotmail.com", "anastasiya");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(homePage.getMyAccountSelector().isMyAccountModuleDisplayed());
    }
    @Test (priority = 2, description = "SignIn, Negative: Verify that signing in under invalid user will display \"Invalid login or password.\" Error")
    public void verifySigningInUnderInvalidUserWillDisplayInvalidLoginOrPasswordError(){
        homePage.clickSignInUpButton().performSignIn("a@hotmail.com", "a");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(homePage.getHeaderBarSignInModule().isSignInInvalidLoginOrPasswordErrorDisplayed());
    }
    @Test  (priority = 1, description = "SignIn, Positive: Verify that clicking on CreateNewAccount Link will display New account creation form")
    public void verifyClickingOnCreateNewAccountLinkWillDisplayNewAccountCreationForm(){
        homePage.clickSignInUpButton().clickSignInCreateAccountLink();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(homePage.getHeaderBarSignInModule().isSignUpModuleDisplayed());
    }
    @Test (priority = 4, description = "SignUp, Negative: Verify that Sign in up under existed user will display email is used error")
    public void verifySigningUPUnderAnastasiyaWillDisplayEmailIsUsedError(){
        homePage.clickSignInUpButton().clickSignInCreateAccountLink().performSignUp("anastasiya.vynogradska@hotmail.com", "anastasiya", "anastasiya");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(homePage.clickSignInUpButton().isSignUpEmailIsUsedErrorDisplayed());
    }

}
