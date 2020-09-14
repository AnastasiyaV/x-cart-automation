package pageobjects.module;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

@Deprecated
public class SignInModule {
    public WebDriver driver;
    private static final Logger logger = Logger.getLogger(SignInModule.class.getName());

    public SignInModule(WebDriver driver) {
        this.driver = driver;
    }



}
