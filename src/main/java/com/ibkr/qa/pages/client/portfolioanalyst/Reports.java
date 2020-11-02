package com.ibkr.qa.pages.client.portfolioanalyst;

import com.ibkr.qa.pages.client.modals.CustomBenchmarkModal;
import com.ibkr.qa.pages.client.modals.CustomReportModal;
import com.ibkr.qa.pages.client.modals.DefaultReportModal;
import com.ibkr.qa.pages.client.modals.RunCustomReportModal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Reports extends PortfolioAnalyst {

    public Reports withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public Reports withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement buttonReportsTab() {
        return elementVisible(By.xpath("//a[contains(.,'Reports') and @data-toggle]"));
    }

    private WebElement buttonConfigureIcon() {
        return elementVisible(By.xpath("//span[text()='Reports Delivery']/ancestor::section" +
                "//i[@data-original-title='Configure']"));
    }

    private WebElement buttonAddEditAccount() {
        return elementVisible(By.xpath("//button[contains(.,'Add/Edit')]"));
    }

    private WebElement checkboxSelectAllAccount() {
        return elementVisible(By.xpath("//a[contains(@ng-if,'selectAll')]/i"));
    }

    private WebElement buttonAccountPickerContinue() {
        return elementVisible(By.xpath("//div[@id='amPicker']//am-button[@btn-text='Continue']"));
    }

    private WebElement buttonContinue2() {
        return elementVisible(By.xpath("//am-sequence[@submit-button-text='word.continue']//a[@class='btn btn-primary']"));
    }

    private WebElement labelComplete() {
        return elementVisible(By.xpath("//h1[@class='text-center text-success' and contains(text(),'Complete')]"));
    }

    private WebElement labelSettings() {
        return elementVisible(By.xpath("//h3[@class='text-center text-black' and contains(text(),'Your delivery settings have been')]"));
    }

    private WebElement buttonOk() {
        return elementVisible(By.xpath("//a[@class='btn btn-success' and contains(text(),'Ok')]"));
    }

    private WebElement buttonAdd() {
        return elementVisible(By.xpath("//a[@ng-click='paReports.openCustomBenchmarkModal()' and @class='btn-icon']"));
    }

    private WebElement labelCustomBenchmark(String name) {
        return elementVisible(By.xpath("//span[@class='link-label' and contains(.,'" + name + "')]"));
    }

    private List<WebElement> buttonView() {
        return elementsVisible(By.xpath("//i[@data-original-title='View']"));
    }

    private List<WebElement> buttonDelete() {
        return elementsVisible(By.xpath("//p[contains(@ng-repeat,'customBenchmark')]//i[@data-original-title='Delete']"));
    }

    private WebElement buttonAddCustomReport() {
        return elementVisible(By.xpath("//a[@ng-click='$ctrl.navigateToCreateEditCustom()']/i"));
    }

    private WebElement labelCreateCustomReport() {
        return elementVisible(By.xpath("//h4[contains(.,'Create Custom Report')]"));
    }

    private WebElement inputReportName() {
        return elementVisible(By.xpath("//input[@name='reportName']"));
    }

    private WebElement dropDownTime() {
        return elementVisible(By.xpath("//select[@name='timePeriod']"));
    }

    private WebElement dropDownFrequency() {
        return elementVisible(By.xpath("//select[@name='frequency']"));
    }

    private WebElement buttonBreakdown() {
        return elementVisible(By.xpath("//a[contains(.,'Breakdown of Accounts')]"));
    }

    private WebElement buttonAccountOverview() {
        return elementVisible(By.xpath("//a[contains(.,'Account Overview')]"));
    }

    private WebElement buttonContinue3() {
        return elementVisible(By.xpath("//p//am-button[@btn-text='Continue']/a[contains(.,'Continue')]"));
    }

    private WebElement buttonCreateCR() {
        return elementVisible(By.xpath("//am-button[@btn-text='Create']/a[contains(.,'Create')]"));
    }

    private WebElement labelReportSaved() {
        return elementVisible(By.xpath("//h1[contains(.,'Report Saved')]"));
    }

    private WebElement labelReportTitle() {
        return elementVisible(By.xpath("//h3[contains(.,'Your custom PortfolioAnalyst report titled ')]/strong"));
    }

    private WebElement buttonOkCR() {
        return elementVisible(By.xpath("//a[contains(.,'Ok')]"));
    }

    private WebElement titleCustomReport(String name) {
        return elementVisible(By.xpath("//p/strong[text()='" + name + "']"));
    }

    private List<WebElement> buttonEditCR() {
        return elementsVisible(By.xpath("//custom-reports-data//i[@data-original-title='Edit']"));
    }

    private WebElement buttonFeesSummary() {
        return elementVisible(By.xpath("//a[contains(.,'Fee Summary')]"));
    }

    private WebElement buttonSaveChangesCR() {
        return elementVisible(By.xpath("//p//am-button[@btn-text='Save Changes']/a[contains(.,'Save Changes')]"));
    }

    private List<WebElement> buttonDeleteCR() {
        return elementsVisible(By.xpath("//custom-reports-data//i[@data-original-title='Delete']"));
    }

    private List<WebElement> buttonRunCR() {
        return elementsVisible(By.xpath("//custom-reports-data//i[@data-original-title='Run']"));
    }

    private List<WebElement> buttonViewDR() {
        return elementsVisible(By.xpath("//span[text()='Default Reports']/ancestor::section[@class='panel']//i[@data-original-title='Info']"));
    }

    private List<WebElement> buttonSnapshot() {
        return elementsVisible(By.xpath("//i[@data-original-title='Snapshot (PDF)']"));
    }

    private List<WebElement> buttonDetailedPdf() {
        return elementsVisible(By.xpath("//i[@data-original-title='Detailed (PDF)']"));
    }

    private List<WebElement> buttonDetailedCSV() {
        return elementsVisible(By.xpath("//i[@data-original-title='Detailed (CSV)']"));
    }

    public Reports validateReportDelivery() {

        navigateToPortfolioAnalyst("Validate Report Delivery");

        buttonReportsTab().click();
        buttonConfigureIcon().click();
        sleep(1000);
        buttonAddEditAccount().click();
        sleep(200);
        checkboxSelectAllAccount().click();
        buttonAccountPickerContinue().click();
        sleep(1000);
        buttonContinue2().click();
        sleep(1000);
        buttonContinue2().click();

        reporter.assertChild(softly.assertThat(labelComplete().isDisplayed())
                        .as("Complete Label is displayed")
                        .isEqualTo(true),
                "Complete Label is displayed");

        reporter.assertChild(softly.assertThat(labelSettings().isDisplayed())
                        .as("Your delivery settings have been saved Label is displayed")
                        .isEqualTo(true),
                "Your delivery settings have been saved Label is displayed");

        buttonOk().click();

        return this;
    }

    public Reports createCustomBenchmarks() {

        navigateToPortfolioAnalyst("Validate Create Custom Benchmarks");

        buttonReportsTab().click();
        sleep(1000);
        buttonAdd().click();
        sleep(1000);

        String name = getCurrentTime();

        new CustomBenchmarkModal()
                .withDriver(driver)
                .withReporter(reporter)
                .createCustomBenchmarkModal(name);

        reporter.assertChild(softly.assertThat(labelCustomBenchmark(name).isDisplayed())
                        .as(name + " account is created")
                        .isEqualTo(true),
                name + " account is created");

        return this;
    }

    public Reports editCustomBenchmarks() {

        navigateToPortfolioAnalyst("Validate Edit Custom Benchmarks");

        buttonReportsTab().click();
        random(buttonView(), 1).get(0).click();
        sleep(1000);

        new CustomBenchmarkModal()
                .withDriver(driver)
                .withReporter(reporter)
                .editCustomBenchmarkModal();

        return this;
    }

    public Reports deleteCustomBenchmarks() {

        navigateToPortfolioAnalyst("Validate Delete Custom Benchmarks");

        buttonReportsTab().click();
        random(buttonDelete(), 1).get(0).click();
        sleep(1000);

        new CustomBenchmarkModal()
                .withDriver(driver)
                .withReporter(reporter)
                .deleteCustomBenchmarkModal();

        return this;
    }

    public Reports createCustomReports() {

        navigateToPortfolioAnalyst("Validate Create Custom Reports");

        buttonReportsTab().click();
        sleep(1000);
        buttonAddCustomReport().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelCreateCustomReport().isDisplayed())
                        .as("Create Custom Report Label is displayed")
                        .isEqualTo(true),
                "Create Custom Report Label is displayed");

        String reportName = "Regression Test " + getCurrentTime();

        inputReportName().sendKeys(reportName);
        changeDropdown(dropDownTime(), "Previous Month");
        changeDropdown(dropDownFrequency(), "Monthly");
        buttonBreakdown().click();
        buttonAccountOverview().click();
        buttonContinue3().click();
        sleep(1000);
        buttonCreateCR().click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReportSaved().isDisplayed())
                        .as("Report Saved label is displayed")
                        .isEqualTo(true),
                "Report Saved Label is displayed");

        reporter.assertChild(softly.assertThat(labelReportTitle().isDisplayed())
                        .as("Report Title label is displayed")
                        .isEqualTo(true),
                "Report Title Label is displayed");

        buttonOkCR().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(titleCustomReport(reportName).isDisplayed())
                        .as(reportName + " Custom Report is created")
                        .isEqualTo(true),
                reportName + " Custom Report is created");

        return this;
    }

    public Reports editCustomReport() {

        navigateToPortfolioAnalyst("Validate Edit Custom Report");

        buttonReportsTab().click();
        random(buttonEditCR(), 1).get(0).click();
        sleep(1000);

//        buttonFeesSummary().click();
        buttonContinue3().click();
        buttonSaveChangesCR().click();

        reporter.assertChild(softly.assertThat(labelReportSaved().isDisplayed())
                        .as("Report Saved label is displayed")
                        .isEqualTo(true),
                "Report Saved Label is displayed");

        reporter.assertChild(softly.assertThat(labelReportTitle().isDisplayed())
                        .as("Report Title label is displayed")
                        .isEqualTo(true),
                "Report Title Label is displayed");

        buttonOkCR().click();
        sleep(1000);

        return this;
    }

    public Reports deleteCustomReport() {

        navigateToPortfolioAnalyst("Validate Delete Custom Report");

        buttonReportsTab().click();
        random(buttonDeleteCR(), 1).get(0).click();
        sleep(1000);

        new CustomReportModal()
                .withDriver(driver)
                .withReporter(reporter)
                .deleteCustomReport();

        return this;
    }

    public Reports runCustomReport() {

        navigateToPortfolioAnalyst("Validate Run Custom Benchmarks");

        buttonReportsTab().click();
        random(buttonRunCR(), 1).get(0).click();
        sleep(1000);

        new RunCustomReportModal()
                .withDriver(driver)
                .withReporter(reporter)
                .runCustomReportModal();

        return this;
    }

    public Reports viewDefaultReport() {

        navigateToPortfolioAnalyst("Validate Delete Custom Benchmarks");

        buttonReportsTab().click();
        random(buttonViewDR(), 1).get(0).click();
        sleep(1000);

        new DefaultReportModal()
                .withDriver(driver)
                .withReporter(reporter)
                .viewDefaultReportModal();

        return this;
    }

    public Reports runSnapshotDefaultReport() {

        navigateToPortfolioAnalyst("Validate Snapshot Default Report");

        buttonReportsTab().click();
        random(buttonSnapshot(), 1).get(0).click();
        sleep(1000);

        new DefaultReportModal()
                .withDriver(driver)
                .withReporter(reporter)
                .runDefaultReportSnapshot();

        return this;
    }

    public Reports runDetailPdfDefaultReport() {

        navigateToPortfolioAnalyst("Validate Detail PDF Default Report");

        buttonReportsTab().click();
        random(buttonDetailedPdf(), 1).get(0).click();
        sleep(1000);

        new DefaultReportModal()
                .withDriver(driver)
                .withReporter(reporter)
                .runDetailPdfReport();

        return this;
    }

    public Reports runDetailCsvDefaultReport() {

        navigateToPortfolioAnalyst("Validate Detail CSV Default Report");

        buttonReportsTab().click();
        random(buttonDetailedCSV(), 1).get(0).click();
        sleep(1000);

        new DefaultReportModal()
                .withDriver(driver)
                .withReporter(reporter)
                .runDetailCsvReport();

        return this;
    }
}