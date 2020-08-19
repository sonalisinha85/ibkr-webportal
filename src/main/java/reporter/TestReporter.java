package reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import enums.TestAuthor;
import enums.TestCategory;
import org.assertj.core.api.SoftAssertions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestReporter {

    static Map<Integer, ExtentTest> testMap = new HashMap();
    static Map<Integer, ExtentTest> childMap = new HashMap();
    private static ExtentReports report;
    private ExtentHtmlReporter extent;
    private ExtentSparkReporter spark;
    private ExtentTest test;
    private ExtentTest child;
    private SoftAssertions softly;
    private int counter;

    //    Test Reporter constructor to create reporter
    public TestReporter() {

        extent = new ExtentHtmlReporter("target/TestExecutionReport " + getCurrentTime() + ".html");
        extent.config().setDocumentTitle("IBKR Web Portal Test Execution Report");
        extent.config().setReportName("IBKR Web Portal Test Execution Report");
//        spark = new ExtentSparkReporter("target/TestExecutionReport.html");
//        spark.config().setDocumentTitle("IBKR Web Portal Test Execution Report");
//        spark.config().setReportName("IBKR Web Portal Test Execution Report");
        report = new ExtentReports();
        report.attachReporter(extent);

//        JsonFormatter json = new JsonFormatter("target/extent.json");
//        try {
//            report.createDomainFromJsonArchive("target/extent.json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        report.attachReporter(json, spark);
    }

    public static ExtentReports report() {

        if (report == null)
            new TestReporter();

        return report;
    }

    public static synchronized ExtentTest getTest() {

        if (childMap.get((int) (long) (Thread.currentThread().getId())) != null)
            return childMap.get((int) (long) (Thread.currentThread().getId()));
        else
            return testMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void remove() {

        report().removeTest(testMap.get((int) (long) (Thread.currentThread().getId())));
    }

    //    Method to create test in the report
    public TestReporter createTest(String name) {

        test = report().createTest(name);
        testMap.put((int) (Thread.currentThread().getId()), test);
        return this;
    }

    public TestReporter withCategory(TestCategory category) {

        test.assignCategory(category.toString());
        return this;
    }

    public TestReporter withAuthor(TestAuthor author) {

        test.assignAuthor(author.toString());
        return this;
    }

    //    Method to create child node in the test
    public TestReporter createChild(String name) {

        child = test.createNode(name);
        childMap.put((int) (Thread.currentThread().getId()), child);
        return this;
    }

    public TestReporter withSoftAssertion(SoftAssertions softly) {

        this.softly = softly;
        return this;
    }

    //Method to assert the test
    public TestReporter assertTest(Object obj, String description) {

        if (softly.errorsCollected().size() != 0 && softly.errorsCollected().size() != counter) {

            test.log(Status.FAIL, softly.errorsCollected().get(counter).getMessage());
            counter++;
        } else
            test.log(Status.PASS, description);

        return this;
    }

    // Method to assert child node
    public TestReporter assertChild(Object obj, String description) {

        if (softly.errorsCollected().size() != 0 && softly.errorsCollected().size() != counter) {
            child.log(Status.FAIL, softly.errorsCollected().get(counter).getMessage());
            counter++;
        } else
            child.log(Status.PASS, description);

        return this;
    }

    // Method to log test info
    public TestReporter testInfo(String description) {

        test.log(Status.INFO, description);
        return this;
    }

    // Method to log child node info
    public TestReporter childInfo(String description) {

        child.log(Status.INFO, description);
        return this;
    }

    // Method to log test info
    public TestReporter testError(String description) {

        if (child == null)
            test.log(Status.FAIL, description);
        else
            child.log(Status.FAIL, description);
        report.flush();
        org.testng.Assert.fail(description);
        return this;
    }

    // Method to persist the report
    public synchronized TestReporter persist() {

        report.flush();
        return this;
    }

    public SoftAssertions softly() {
        return softly;
    }

    private String getCurrentTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh-mm-ss");
        return sdf.format(new Date());
    }
}