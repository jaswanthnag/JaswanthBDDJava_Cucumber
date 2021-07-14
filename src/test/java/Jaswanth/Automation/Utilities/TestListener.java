package Jaswanth.Automation.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class TestListener extends Login implements ITestListener
{
	private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
 
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
    }
 
  
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }
 
    
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }
 
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).
            getScreenshotAs(OutputType.BASE64);
 
        //ExtentReports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed",
            ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }
 
   
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
 
        //Get driver from BaseTest and assign to local webDriver variable.
        Object testClass = iTestResult.getInstance();
 
        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).
            getScreenshotAs(OutputType.BASE64);
 
        //ExtentReports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed",
            ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }
 
   public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).
            getScreenshotAs(OutputType.BASE64);
 
        //ExtentReports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped",
            ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }
 
   
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}
