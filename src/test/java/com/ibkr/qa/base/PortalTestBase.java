package com.ibkr.qa.base;

import com.ibkr.qa.pages.Login;
import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.pages.accountapplication.chinesenative.AccountApplication;
import com.ibkr.qa.pages.accountapplication.employeetrack.EmployeeTrack;
import com.ibkr.qa.pages.accountapplication.portfolioanalyst.PortfolioAnalyst;
import com.ibkr.qa.pages.client.ClientPortal;
import com.ibkr.qa.reporter.TestReporter;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.google.common.base.Preconditions.checkNotNull;

public class PortalTestBase {

    private static final String BROWSER;

    static {
        BROWSER = checkNotNull(System.getProperty("BROWSER"), "Please specify a Browser using Maven Profile");
    }

    protected SoftAssertions softly;
    protected TestReporter reporter;
    protected WebDriver driver;
    protected Map<String, String> credentials = new HashMap();

    public PortalTestBase() {

        Properties prop = new Properties();

        try {
            prop.load(getClass().getClassLoader().getResourceAsStream("credentials.properties"));
            prop.forEach((k, v) -> credentials.put(k.toString(), v.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        reporter = new TestReporter();
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
        driver.get("https://ndcdyn.interactivebrokers.com/sso/Login?RL=1");

        softly = new SoftAssertions();
        reporter.withSoftAssertion(softly);
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

        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.download.folderList", 2);
        options.addPreference( "browser.download.manager.showWhenStarting", false );
        options.addPreference("browser.download.dir", "C:\\Users\\ssinha\\Downloads");
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "image/png");

        driver = new FirefoxDriver(options);
    }

    private void ie() {
        System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
    }

    protected void loginAdvisor() {

        login()
                .withUserName(credentials.get("ADVISOR_USER"))
                .withPassword(credentials.get("ADVISOR_PASSWORD"))
                .login();
    }

    protected void loginBroker() {

        login()
                .withUserName(credentials.get("BROKER_USER_FULLY_DISCLOSED"))
                .withPassword(credentials.get("BROKER_PASSWORD_FULLY_DISCLOSED"))
                .login();
    }

    protected void loginBrokerNonDisclosed() {

        login()
                .withUserName(credentials.get("BROKER_USER_NON_DISCLOSED"))
                .withPassword(credentials.get("BROKER_PASSWORD_NON_DISCLOSED"))
                .login();
        portal().navigateWithAmButton();
    }

    protected void loginCompliance() {

        login()
                .withUserName(credentials.get("COMPLIANCE_USER"))
                .withPassword(credentials.get("COMPLIANCE_PASSWORD"))
                .login();
    }

    protected void loginClient() {

        login()
                .withUserName(credentials.get("CLIENT_USER"))
                .withPassword(credentials.get("CLIENT_PASSWORD"))
                .login();
    }

    protected void loginHedgeFundAdvisor() {

        login()
                .withUserName(credentials.get("HEDGE_FUND_USER"))
                .withPassword(credentials.get("HEDGE_FUND_PASSWORD"))
                .login();
//        portal().navigateWithAmButton();
    }

    protected Login login() {

        return new Login()
                .withDriver(driver)
                .withReporter(reporter);
    }

    protected Portal portal() {

        return new Portal()
                .withDriver(driver)
                .withReporter(reporter);
    }

    protected AccountApplication accountApplication() {

        return new AccountApplication()
                .withDriver(driver)
                .withReporter(reporter);
    }

    protected PortfolioAnalyst portfolioAnalyst() {

        return new PortfolioAnalyst()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public ClientPortal clientPortal() {

        return new ClientPortal()
                .withDriver(driver)
                .withReporter(reporter);
    }

    protected EmployeeTrack employeeTrack() {

        return new EmployeeTrack()
                .withDriver(driver)
                .withReporter(reporter);
    }

    //    After test method to quit the driver and generate test execution report
//    ITestResult result
    @AfterMethod(alwaysRun = true)
    public void after() {

        driver.quit();
        reporter.persist();
    }
}
