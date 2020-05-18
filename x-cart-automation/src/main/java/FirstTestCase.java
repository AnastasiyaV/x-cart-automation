
import org.openqa.selenium.*;
import org.testng.annotations.Test;


public class FirstTestCase extends WebDriverSettings {
    private By driverSearchField = By.className("gLFyf gsfi");


    @Test
    void openGoogle throws Exception() {

        WebElement searchField = driver.findElement(driverSearchField);
        String text = searchField.getText();
        System.out.println(text);
        //String text = searchField.getText();
       // System.out.println(text);

    }
}
