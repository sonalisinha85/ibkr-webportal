package com.ibkr.qa.base;

import com.ibkr.qa.pages.accountapplication.AccountApplication;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Properties;

import static com.google.common.base.Preconditions.checkNotNull;

public class AccountRegistrationTestBase {

    private static final String BROWSER;

    static {
        BROWSER = checkNotNull(System.getProperty("BROWSER"), "Please specify a Browser using Maven Profile");
    }

    protected SoftAssertions softly;
    protected WebDriver driver;

    public AccountRegistrationTestBase() {

        Properties prop = new Properties();

        try {
            prop.load(getClass().getClassLoader().getResourceAsStream("credentials.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void before() {

        if (BROWSER.equals("Chrome"))
            chrome();
        else if (BROWSER.equals("Firefox"))
            firefox();
        else if (BROWSER.equals("IE"))
            ie();

        driver.manage().window().maximize();
        driver.get("https://www.interactivebrokers.com/");

        softly = new SoftAssertions();
    }

    public WebDriver driver() {
        return driver;
    }

    private void chrome() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
//        driver = new ChromeDriver(options);
    }

    private void firefox() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
    }

    private void ie() {
        System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
    }

    protected AccountApplication accountApplication() {

        return new AccountApplication()
                .withDriver(driver);
    }

    //    After test method to quit the driver and generate test execution report
//    ITestResult result
    @AfterMethod(alwaysRun = true)
    public void after() {

        driver.quit();
    }
}
