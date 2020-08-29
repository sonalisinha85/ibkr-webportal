package com.ibkr.qa.listener;

import com.aventstack.extentreports.Status;
import com.ibkr.qa.base.TestBase;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestBase implements ITestListener {

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext context) {
        context.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext context) {
        TestReporter.report().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

        //Get driver from BaseTest and assign to local webDriver variable.
        Object testClass = result.getInstance();
        WebDriver driver = ((TestBase) testClass).driver();

        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.BASE64);

        //ExtentReports log and screenshot operations for failed tests.
        TestReporter.getTest().log(Status.FAIL, result.getThrowable())
                .addScreenCaptureFromBase64String(base64Screenshot);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        TestReporter.remove();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
}