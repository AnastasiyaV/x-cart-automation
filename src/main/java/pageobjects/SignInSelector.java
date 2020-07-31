package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Deprecated
public class SignInSelector extends BasePageObject {
    public SignInSelector(WebDriver driver) {
        super(driver);
    }

    public SignInSelector signInSelector;  //why do i need this variable here? :-/

    private By headerBarSignIn = By.className("header_bar-sign_in button");

    public WebElement getHeaderBarSignIn(WebElement element) {
        return driver.findElement(headerBarSignIn);
    }

    //should i delete this getter?
    /*public By getHeaderBarSignIn() {
        return headerBarSignIn;
    }*/

}
