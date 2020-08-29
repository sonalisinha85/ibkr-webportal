package com.ibkr.qa.pages.menu.reports;

import com.ibkr.qa.reporter.TestReporter;
import com.ibkr.qa.utils.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OtherReports extends Reports {

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

    private WebElement dropDownReportType() {

        return elementPresent(By.xpath("//select[@name='selectedRptType']"));
    }

    private WebElement dropDownSubType() {

        return elementPresent(By.xpath("//select[contains(@ng-model,'SubType')]"));
    }

    private WebElement inputDate() {

        return elementPresent(By.xpath("//am-date-picker/input"));
    }

    private WebElement dropDownDate() {

        return elementPresent(By.xpath("//select[contains(@ng-model,'Date')]"));
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

    public Reports validateRiskMarginReport() {

        navigateToOtherReport("Risk Margin");

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

        navigateToOtherReport("Stress Test");

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

        navigateToOtherReport("Value At Risk");

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

        navigateToOtherReport("Transaction Cost Analysis");

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

        navigateToOtherReport("P/L Markup");

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

        navigateToOtherReport("Advisory Fee Invoice");

        changeDropdown(dropDownReportType(), "Advisory Fee Invoice");
        sleep(500);

        reporter.assertChild(softly.assertThat(labelNoInvoicesAlert().isDisplayed())
                        .as("No Invoices Alert Message is displayed")
                        .isEqualTo(true),
                "No Invoices Alert Message is displayed");

        return this;
    }

    public Reports validateTaxLotHoldingPeriodChangeReport() {

        navigateToOtherReport("Tax Lot Holding Period Change");

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

        navigateToOtherReport("Account Confirmation Letter");

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

    private void navigateToOtherReport(String reportName) {

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
}