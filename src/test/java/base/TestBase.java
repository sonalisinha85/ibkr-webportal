package base;

import static com.google.common.base.Preconditions.checkNotNull;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import reporter.TestReporter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestBase {

    protected SoftAssertions softly;
    protected TestReporter reporter;
    protected WebDriver driver;
    protected Map<String, String> credentials = new HashMap();
    private static final String BROWSER;

    static {
        BROWSER = checkNotNull(System.getProperty("BROWSER"), "Please specify a Browser using Maven Profile");
    }

    public TestBase() {

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
    public void before(){

        if(BROWSER.equals("Chrome"))
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

    public WebDriver driver(){
        return driver;
    }

    private void chrome(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    private void firefox(){
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
    }

    private void ie(){
        System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
    }

    protected void loginAdvisor(){

        login()
                .withUserName(credentials.get("ADVISOR_USER"))
                .withPassword(credentials.get("ADVISOR_PASSWORD"))
                .login();
    }

    protected void loginBroker(){

        login()
                .withUserName(credentials.get("BROKER_USER"))
                .withPassword(credentials.get("BROKER_PASSWORD"))
                .login();
    }

    protected void loginCompliance(){

        login()
                .withUserName(credentials.get("COMPLIANCE_USER"))
                .withPassword(credentials.get("COMPLIANCE_PASSWORD"))
                .login();
    }

    protected void loginClient(){

        login()
                .withUserName(credentials.get("CLIENT_USER"))
                .withPassword(credentials.get("CLIENT_PASSWORD"))
                .login();
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

    //    After test method to quit the driver and generate test execution report
//    ITestResult result
    @AfterMethod(alwaysRun = true)
    public void after() {

        driver.quit();
        reporter.persist();
    }
}
