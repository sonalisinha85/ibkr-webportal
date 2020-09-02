package com.ibkr.qa.pages.tabs.tools;

import com.ibkr.qa.enums.PortalName;
import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.pages.modals.SelectAssetsModal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DataQueries extends Portal {

    public DataQueries withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public DataQueries withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelTools() {
        return elementVisible(By.xpath("//div[@class='panel-heading']/span[text()='Tools']"));
    }

    private WebElement labelRunReport() {
        return elementVisible(By.xpath("//div[@class='panel-heading']/span[text()='Run a Report']"));
    }

    private WebElement buttonClientDataQueries() {
        return elementVisible(By.xpath("//a/span[contains(text(),'Data Queries')]"));
    }

    private WebElement dropDownReportType() {
        return elementVisible(By.xpath("//select[@name='reportType']"));
    }

    private WebElement dropDownPerformancePeriod() {
        return elementVisible(By.xpath("//select[@name='performancePeriod']"));
    }

    private WebElement dropDownPeriod() {
        return elementVisible(By.xpath("//select[@name='period']"));
    }

    private WebElement dropDownSearchIn() {
        return elementVisible(By.xpath("//select[@name='searchIn']"));
    }

    private WebElement inputDate() {
        return elementVisible(By.xpath(" //input[@name='singleDate']"));
    }

    private List<WebElement> previousMonth() {
        return elementsPresent(By.xpath("//th[@class='prev']"));
    }

    private List<WebElement> datePicker() {
        return elementsVisible(By.xpath("//div[@class='datepicker-days']//tr/td[not(contains(@class,'disabled'))]"));
    }

    private WebElement inputPerformancePercentage() {
        return elementVisible(By.xpath("//input[@name='performancePercentage']"));
    }

    private WebElement dropDownFormat() {
        return elementVisible(By.xpath("//select[@name='format']"));
    }

    private WebElement buttonAction(Action action) {

        return elementVisible(By.xpath("//am-button[@btn-text='"
                + action.toString().replaceAll("_", " ") + "']"));
    }

    private WebElement buttonAccountSelector() {
        return elementVisible(By.xpath("//am-picker-button[@name='accountSelections']"));
    }

    private WebElement checkBoxAllAccounts() {
        return elementVisible(By.xpath("//div[input[@type='checkbox']]"));
    }

    private WebElement checkBoxAllAccountsInAccountSelector() {
        return elementVisible(By.xpath("//i[contains(@ng-class,'allSelected')]"));
    }

    private WebElement reportPanel() {
        return elementVisible(By.xpath("//section[@class='panel report statement']"));
    }

    private WebElement alertSelectedAsset() {
        return elementVisible(By.xpath("//div[contains(@class,'alert')]/p[contains(text(),'Required')]"));
    }

    private WebElement inputMinimumCount() {
        return elementVisible(By.xpath("//input[@name='minVolume']"));
    }

    public DataQueries validatePerformanceReport() {

        navigateToDataQueries("Performance Report Validation");

        reporter.assertChild(softly.assertThat(labelRunReport().isDisplayed())
                        .as("Run a Report Label is displayed")
                        .isEqualTo(true),
                "Run a Report Label is displayed");

        changeDropdown(dropDownReportType(),
                ReportType.Performance.toString().replaceAll("_", " "));
        changeDropdown(dropDownPerformancePeriod(), "12 Months");
        inputPerformancePercentage().sendKeys("10");
        changeDropdown(dropDownFormat(), "HTML/Web");
        buttonAction(Action.Run_Report).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(reportPanel().isDisplayed())
                        .as("Performance Report is displayed")
                        .isEqualTo(true),
                "Performance Report is displayed");

        return this;
    }

    public DataQueries validateSymbolReport(PortalName portalName) {

        navigateToDataQueries("Symbol Report Validation");

        reporter.assertChild(softly.assertThat(labelRunReport().isDisplayed())
                        .as("Run a Report Label is displayed")
                        .isEqualTo(true),
                "Run a Report Label is displayed");

        changeDropdown(dropDownReportType(),
                ReportType.Symbol.toString().replaceAll("_", " "));
        checkBoxAllAccounts().click();
        sleep(500);
        changeDropdown(dropDownPeriod(), "Daily");
        inputDate().click();
        previousMonth().get(0).click();
        random(datePicker(), 1).get(0).click();
        sleep(500);
        changeDropdown(dropDownSearchIn(), "Activity and Positions");
        changeDropdown(dropDownFormat(), "HTML/Web");

        if (portalName.equals(PortalName.Broker_Portal)) {

            buttonAction(Action.Run_Report).click();
            sleep(1000);

            reporter.assertChild(softly.assertThat(alertSelectedAsset().isDisplayed())
                            .as("Selected Asset Required Alert is displayed")
                            .isEqualTo(true),
                    "Selected Asset Required Alert is displayed");

        } else if (portalName.equals(PortalName.Compliance_Portal)) {

            buttonAction(Action.Select).click();
            sleep(1000);

            new SelectAssetsModal()
                    .withDriver(driver)
                    .withReporter(reporter)
                    .selectAssets();

            buttonAction(Action.Run_Report).click();
            sleep(1500);

            reporter.assertChild(softly.assertThat(reportPanel().isDisplayed())
                            .as("Symbol Report is displayed")
                            .isEqualTo(true),
                    "Symbol Report is displayed");
        }

        return this;
    }

    public DataQueries validateTransactionCountReport(PortalName portalName) {

        navigateToDataQueries("Transaction Count Report Validation");

        reporter.assertChild(softly.assertThat(labelRunReport().isDisplayed())
                        .as("Run a Report Label is displayed")
                        .isEqualTo(true),
                "Run a Report Label is displayed");

        changeDropdown(dropDownReportType(),
                ReportType.Transaction_Count.toString().replaceAll("_", " "));

        if (portalName.equals(PortalName.Broker_Portal)) {

            buttonAccountSelector().click();
            sleep(500);
            checkBoxAllAccountsInAccountSelector().click();
            buttonAction(Action.Continue).click();
            sleep(1000);
        }

        changeDropdown(dropDownPeriod(), "Daily");
        inputDate().click();
        previousMonth().get(0).click();
        random(datePicker(), 1).get(0).click();
        sleep(500);
        inputMinimumCount().sendKeys("9");
        changeDropdown(dropDownFormat(), "HTML/Web");
        buttonAction(Action.Run_Report).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(reportPanel().isDisplayed())
                        .as("Transaction Count Report is displayed")
                        .isEqualTo(true),
                "Transaction Count Report is displayed");

        return this;
    }

    private void navigateToDataQueries(String reportName) {

        tabs(Tabs.Tools).click();
        sleep(1000);

        reporter.createChild(reportName)
                .assertChild(softly.assertThat(labelTools().isDisplayed())
                                .as("Tools Label is displayed")
                                .isEqualTo(true),
                        "Tools Label is displayed");

        buttonClientDataQueries().click();
        sleep(1000);
    }

    private enum ReportType {Performance, Symbol, Transaction_Count}

    private enum Action {Run_Report, Reset, Continue, Select}
}
