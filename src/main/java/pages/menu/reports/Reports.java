package pages.menu.reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Portal;
import reporter.TestReporter;
import utils.FileUtil;

import java.util.List;

public class Reports extends Portal {

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

    private WebElement buttonActionRightpanel(Action action) {

        return elementPresent(By.xpath("//div[@class='panel-btn-right']" +
                "//am-button[@btn-text='" + action.toString().replaceAll("_", " ") + "']"));
    }

    private WebElement buttonActionLeftpanel(Action action) {

        return elementPresent(By.xpath("//div[@class='panel-btn-left']" +
                "//am-button[@btn-text='" + action.toString().replaceAll("_", " ") + "']"));
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

    private WebElement labelAlertSuccess() {

        return elementPresent(By.xpath("//div[contains(@class,'alert alert-success')]/p"));
    }

    private WebElement checkboxAllAccount() {
        return elementPresent(By.xpath("//i[contains(@ng-class,'allSelected')]"));
    }

    private List<WebElement> radioButtonsAccountPicker() {
        return elementsPresent(By.xpath("//i[@class='fa fa-lg fa-circle-thin']"));
    }

    private WebElement buttonAccountSelector(Action action) {
        return elementPresent(By.xpath("//am-button[@btn-text='" + action.toString() + "']"));
    }

    private WebElement labelCreateCustomReport() {
        return elementPresent(By.xpath("//h4[text()='Create Custom Statement']"));
    }

    private WebElement labelReviewCustomReport() {
        return elementPresent(By.xpath("//h2[text()='Review Your Custom Statement']"));
    }

    private WebElement labelCustomReportConfirmation() {
        return elementPresent(By.xpath("//h1[text()='Custom Statement Saved']"));
    }

    private WebElement buttonCreateCustomReport() {
        return elementPresent(By.xpath("//i[@data-original-title='Create']"));
    }

    private List<WebElement> buttonCustomReportAction(Action action) {
        return elementsPresent(By.xpath("//span[text()='Custom Statements']" +
                "/ancestor::section[@class='panel']//i[@data-original-title='" + action.toString() + "']"));
    }

    private List<WebElement> reportList() {
        return elementsPresent(By.xpath("//span[text()='Custom Statements']/ancestor::section[@class='panel']//div[@ng-repeat]"));
    }

    private WebElement labelCustomReport(String name) {
        return elementPresent(By.xpath("//span[text()='Custom Statements']" +
                "/ancestor::section[@class='panel']//p/strong[text()='" + name + "']"));
    }

    private WebElement inputReportName() {
        return elementPresent(By.xpath("//input[@name='reportName']"));
    }

    private List<WebElement> buttonSections() {
        return elementsPresent(By.xpath("//p[@ng-repeat]/a"));
    }

    private WebElement dropDownActivityPeriod() {

        return elementPresent(By.xpath("//select[@name='activityPeriod']"));
    }

    private WebElement buttonOk() {

        return elementPresent(By.xpath("//p/a[text()='Ok']"));
    }

    private WebElement labelDeleteActivityStatement() {

        return elementPresent(By.xpath("//span[text()='Delete Activity Statement']"));
    }

    private WebElement sectionCustomStatements() {

        return elementPresent(By.xpath("//section//span[text()='Custom Statements']"));
    }

    public Reports validateRiskMarginReport() {

        navigateToReport("Risk Margin");

        changeDropdown(dropDownReportType(), "Margin");
        changeDropdown(dropDownSubType(), "Default");
        inputDate().click();
        previousMonth().get(0).click();
        random(datePicker(), 1).get(0).click();
        changeDropdown(dropDownFormat(), "HTML/View");
        changeDropdown(dropDownLanguage(), "English");
        buttonAction(Action.Run_Report).click();
        sleep(4000);

        reporter.assertChild(softly.assertThat(statementSection().isDisplayed())
                        .as("Margin Reports is displayed")
                        .isEqualTo(true),
                "Margin Reports is displayed");

        return this;
    }

    public Reports validateStressTestReport() {

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

    public Reports validateValueAtRiskReport() {

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

    public Reports validateTransactionCostAnalysisReport() {

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

    public Reports validatePnLMarkupReport() {

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

    public Reports validateAdvisoryFeeInvoiceReport() {

        navigateToReport("Advisory Fee Invoice");

        changeDropdown(dropDownReportType(), "Advisory Fee Invoice");
        sleep(500);

        reporter.assertChild(softly.assertThat(labelNoInvoicesAlert().isDisplayed())
                        .as("No Invoices Alert Message is displayed")
                        .isEqualTo(true),
                "No Invoices Alert Message is displayed");

        return this;
    }

    public Reports validateTaxLotHoldingPeriodChangeReport() {

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

    public Reports validateAccountConfirmationLetterReport() {

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
        sleep(4000);

        pickAccount();
    }

    private void pickAccount() {

        random(radioButtonsAccountPicker(), 1).get(0).click();
        sleep(500);
        buttonAccountSelector(Action.Continue).click();
        sleep(3000);
    }

    private void navigateToCustomReport(String description) {

        menu("Reports / Tax Docs").click();
        sleep(1500);
        pickAccount();

        reporter.createChild(description)
                .assertChild(softly.assertThat(sectionCustomStatements().isDisplayed())
                                .as("Custom Statement Section is displayed")
                                .isEqualTo(true),
                        "Custom Statement Section is displayed");
    }

    public Reports runCustomReport() {

        navigateToCustomReport("Validate Run Custom Report");

        random(buttonCustomReportAction(Action.Run), 1).get(0).click();
        sleep(1000);
        buttonActionRightpanel(Action.Run).click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(panelSection().isDisplayed())
                        .as("Custom Report is displayed")
                        .isEqualTo(true),
                "Custom Report is displayed");

        return this;
    }

    public Reports deleteCustomReport() {

        navigateToCustomReport("Validate Delete Custom Report");

        int count = reportList().size();
        random(buttonCustomReportAction(Action.Delete), 1).get(0).click();
        sleep(1000);
        buttonActionLeftpanel(Action.No).click();
        sleep(500);
        random(buttonCustomReportAction(Action.Delete), 1).get(0).click();
        sleep(1000);
        buttonActionRightpanel(Action.Yes).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelAlertSuccess().isDisplayed())
                        .as("Custom Report Deleted")
                        .isEqualTo(true),
                "Custom Report Deleted");

        buttonActionRightpanel(Action.Close).click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(reportList().size())
                        .as("Custom report is deleted [Old Custom Reports count vs New Custom Reports count validated]")
                        .isEqualTo(count - 1),
                "Custom report is deleted [Old Custom Reports count vs New Custom Reports count validated]");

        return this;
    }

    public Reports editCustomReport() {

        navigateToCustomReport("Validate Edit Custom Report");

        random(buttonCustomReportAction(Action.Edit), 1).get(0).click();
        sleep(2000);
        random(buttonSections(), 2).forEach(section -> section.click());
        buttonActionRightpanel(Action.Continue).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReviewCustomReport().isDisplayed())
                        .as("Review Custom Report label is displayed")
                        .isEqualTo(true),
                "Review Custom Report label is displayed");

        buttonActionRightpanel(Action.Save_Changes).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelCustomReportConfirmation().isDisplayed())
                        .as("Custom Report Saved label is displayed")
                        .isEqualTo(true),
                "Custom Report Saved label is displayed");

        buttonOk().click();
        sleep(1000);

        return this;
    }

    public Reports createCustomReport() {

        navigateToCustomReport("Validate Edit Custom Report");

        String name = "Regression Test " + getCurrentTime();
        buttonCreateCustomReport().click();
        sleep(1500);
        inputReportName().sendKeys(name);
        random(buttonSections(), 1).get(0).click();
        changeDropdown(dropDownActivityPeriod(), "Monthly");
        buttonActionRightpanel(Action.Continue).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReviewCustomReport().isDisplayed())
                        .as("Review Custom Report label is displayed")
                        .isEqualTo(true),
                "Review Custom Report label is displayed");

        buttonActionRightpanel(Action.Create).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelCustomReportConfirmation().isDisplayed())
                        .as("Custom Report Saved label is displayed")
                        .isEqualTo(true),
                "Custom Report Saved label is displayed");

        buttonOk().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelCustomReport(name).isDisplayed())
                        .as(name + " Custom Report is created")
                        .isEqualTo(true),
                name + " Custom Report is created");

        return this;
    }

    private enum ReportsTab {Statements, Flex_Queries, Other_Reports, Tax}

    private enum Action {Run_Report, Reset, Continue, Delete, Edit, Run, Create, Save_Changes, No, Yes, Close}
}
