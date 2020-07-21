package firstTests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyAllureListener  extends BaseTest implements ITestListener{
    /*private static String getTestMethodName(ItestResult itestResult){
        //return itestResult.getMethod().getConstructorOrMethod().getName(); //???
    }*/

    @Attachment
    public byte[] saveFailureScreenshot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method "+ iTestContext.getName());
       // iTestContext.setAttribute("WebDriver", BasePageObject.getDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
