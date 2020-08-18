package pages.menu.reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Portal;
import pages.menu.PortfolioAnalyst;
import reporter.TestReporter;
import utils.FileUtil;

import java.util.List;

public class OtherReports extends Portal {

    enum ReportsTab {Statements, Flex_Queries, Other_Reports, Tax}

    enum Action {Run_Report, Reset, Continue}

    public OtherReports withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public OtherReports withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelReports() {

        return elementPresent(By.xpath("//h3[contains(.,'Reports')]"));
    }

    private WebElement labelAccountNumber() {

        return elementPresent(By.xpath("//span[@class='account-numbers']"));
    }

    private WebElement labelAccountsTab() {

        return elementPresent(By.xpath("//a[@data-toggle='tab' and text()='Accounts']"));
    }

    private WebElement tabReports(ReportsTab tab) {

        return elementPresent(By.xpath("//li[contains(@ng-repeat,'tab')]" +
                "/a[contains(text(),'" + tab.toString().replaceAll("_", " ") + "')]"));
    }

    private WebElement dropDownReportType() {

        return elementPresent(By.xpath("//select[@name='selectedRptType']"));
    }

    private WebElement dropDownDate() {

        return elementPresent(By.xpath("//select[contains(@ng-model,'Date')]"));
    }

    private WebElement inputDate() {

        return elementPresent(By.xpath("//am-date-picker/input"));
    }

    private List<WebElement> previousMonth() {
        return elementsPresent(By.xpath("//th[@class='prev']"));
    }

    private List<WebElement> datePicker() {
        return elementsPresent(By.xpath("//div[@class='datepicker-days']//tr/td[not(contains(@class,'disabled'))]"));
    }

    private WebElement inputFromDate() {
        return elementPresent(By.xpath("//input[@name='fromDate']"));
    }

    private WebElement inputToDate() {
        return elementPresent(By.xpath("//input[@name='toDate']"));
    }

    private WebElement dropDownFormat() {

        return elementPresent(By.xpath("//select[contains(@ng-model,'Format')]"));
    }

    private WebElement dropDownPeriod() {

        return elementPresent(By.xpath("//select[contains(@ng-model,'period')]"));
    }

    private WebElement dropDownLotsLongTerm() {

        return elementPresent(By.xpath("//select[contains(@ng-model,'currentDaysToLong')]"));
    }

    private WebElement dropDownSubType() {

        return elementPresent(By.xpath("//select[contains(@ng-model,'SubType')]"));
    }

    private WebElement dropDownLanguage() {

        return elementPresent(By.xpath("//select[contains(@ng-model,'language')]"));
    }

    private WebElement buttonAction(Action action) {

        return elementPresent(By.xpath("//button[text()='"
                + action.toString().replaceAll("_", " ") + "']"));
    }

    private WebElement statementSection() {

        return elementPresent(By.xpath("//section[@class='statement']"));
    }

    private WebElement panelSection() {

        return elementPresent(By.xpath("//section[@class='panel']"));
    }

    private WebElement labelNoStatementAlert() {

        return elementPresent(By.xpath("//div[contains(@class,'alert')]/p[contains(text(),'no statement available')]"));
    }

    private WebElement labelNoDataAlert() {

        return elementPresent(By.xpath("//div[contains(@class,'alert')]/p[contains(text(),'no data available')]"));
    }

    private WebElement labelNoInvoicesAlert() {

        return elementPresent(By.xpath("//div[contains(@class,'alert')]/p[contains(text(),'No invoices available')]"));
    }

    private WebElement labelAlert() {

        return elementPresent(By.xpath("//div[contains(@class,'alert')]/p"));
    }

    private WebElement checkboxAllAccount() {
        return elementPresent(By.xpath("//i[contains(@ng-class,'allSelected')]"));
    }

    protected List<WebElement> radioButtonsAccountPicker() {
        return elementsPresent(By.xpath("//i[@class='fa fa-lg fa-circle-thin']"));
    }

    private WebElement buttonAccountSelector(Action action) {
        return elementPresent(By.xpath("//am-button[@btn-text='" + action.toString() + "']"));
    }

    public OtherReports validateRiskMarginReport() {

        navigateToReport("Risk Margin");

        changeDropdown(dropDownReportType(), "Margin");
        changeDropdown(dropDownSubType(), "Default");
        inputDate().click();
        previousMonth().get(0).click();
        random(datePicker(), 1).get(0).click();
        changeDropdown(dropDownFormat(), "HTML/View");
        changeDropdown(dropDownLanguage(), "English");
        buttonAction(Action.Run_Report).click();
        sleep(3000);

        reporter.assertChild(softly.assertThat(statementSection().isDisplayed())
                        .as("Margin Reports is displayed")
                        .isEqualTo(true),
                "Margin Reports is displayed");

        return this;
    }

    public OtherReports validateStressTestReport() {

        navigateToReport("Stress Test");

        changeDropdown(dropDownReportType(), "Stress Test");
        buttonAction(Action.Run_Report).click();
        sleep(3000);

        reporter.assertChild(softly.assertThat(panelSection().isDisplayed())
                        .as("Stress Test Reports is displayed")
                        .isEqualTo(true),
                "Stress Test Reports is displayed");

        return this;
    }

    public OtherReports validateValueAtRiskReport() {

        navigateToReport("Value At Risk");

        changeDropdown(dropDownReportType(), "Value at Risk");
        changeDropdown(dropDownDate(), "Current");
        changeDropdown(dropDownFormat(), "HTML/View");
        changeDropdown(dropDownLanguage(), "English");
        buttonAction(Action.Run_Report).click();
        sleep(3000);

        reporter.assertChild(softly.assertThat(labelNoStatementAlert().isDisplayed())
                        .as("No Statement Alert Message is displayed")
                        .isEqualTo(true),
                "No Statement Alert Message is displayed");

        return this;
    }

    public OtherReports validateTransactionCostAnalysisReport() {

        navigateToReport("Transaction Cost Analysis");

        changeDropdown(dropDownReportType(), "Transaction Cost Analysis");
        inputFromDate().click();
        previousMonth().get(0).click();
        random(datePicker(), 1).get(0).click();
        buttonAction(Action.Run_Report).click();
        sleep(3000);

        reporter.assertChild(softly.assertThat(labelNoDataAlert().isDisplayed())
                        .as("No Data Alert Message is displayed")
                        .isEqualTo(true),
                "No Data Alert Message is displayed");

        return this;
    }

    public OtherReports validatePnLMarkupReport() {

        navigateToReport("P/L Markup");

        changeDropdown(dropDownReportType(), "P/L Markup");
        changeDropdown(dropDownPeriod(), "Quarterly");
        changeDropdown(dropDownLanguage(), "English");
        String name = selectDropDown(dropDownDate()).getFirstSelectedOption().getText();
        buttonAction(Action.Run_Report).click();
        sleep(3000);

        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("P/L Markup Report Download")
                        .contains(name),
                "P/L Markup Report Download");

        return this;
    }

    public OtherReports validateAdvisoryFeeInvoiceReport() {

        navigateToReport("Advisory Fee Invoice");

        changeDropdown(dropDownReportType(), "Advisory Fee Invoice");
        sleep(500);

        reporter.assertChild(softly.assertThat(labelNoInvoicesAlert().isDisplayed())
                        .as("No Invoices Alert Message is displayed")
                        .isEqualTo(true),
                "No Invoices Alert Message is displayed");

        return this;
    }

    public OtherReports validateTaxLotHoldingPeriodChangeReport() {

        navigateToReport("Tax Lot Holding Period Change");

        changeDropdown(dropDownReportType(), "Tax Lot Holding Period Change");
        changeDropdown(dropDownLotsLongTerm(), "9");
        changeDropdown(dropDownFormat(), "HTML/View");
        changeDropdown(dropDownLanguage(), "English");
        buttonAction(Action.Run_Report).click();
        sleep(3000);

        reporter.assertChild(softly.assertThat(labelAlert().isDisplayed())
                        .as("Statement not available Alert Message is displayed")
                        .isEqualTo(true),
                "Statement not available Alert Message is displayed");

        return this;
    }

    public OtherReports validateAccountConfirmationLetterReport() {

        navigateToReport("Account Confirmation Letter");

        changeDropdown(dropDownReportType(), "Account Confirmation Letter");
        changeDropdown(dropDownSubType(), "With Net Liquidation Value");
        changeDropdown(dropDownLanguage(), "English");
        buttonAction(Action.Run_Report).click();
        sleep(3000);

        reporter.assertChild(softly.assertThat(panelSection().isDisplayed())
                        .as("Account Confirmation Letter Reports is displayed")
                        .isEqualTo(true),
                "Account Confirmation Letter Reports is displayed");

        return this;
    }

    private void navigateToReport(String reportName) {

        menu("Reports / Tax Docs").click();
        sleep(1500);

        checkboxAllAccount().click();
        sleep(500);
        buttonAccountSelector(Action.Continue).click();
        sleep(3000);

        reporter.createChild("Validate " + reportName + " Report")
                .assertChild(softly.assertThat(labelReports().isDisplayed())
                                .as("Reports Label is displayed")
                                .isEqualTo(true),
                        "Reports Label is displayed");

        tabReports(ReportsTab.Other_Reports).click();
        sleep(3000);

        random(radioButtonsAccountPicker(), 1).get(0).click();
        sleep(500);
        buttonAccountSelector(Action.Continue).click();
        sleep(3000);
    }
}
