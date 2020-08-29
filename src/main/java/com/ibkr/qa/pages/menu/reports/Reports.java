package com.ibkr.qa.pages.menu.reports;

import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public OtherReports withOtherReports() {

        return new OtherReports()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public Statements withStatements() {

        return new Statements()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public FlexQueries withFlexQueries() {

        return new FlexQueries()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public TaxForms withTaxForms() {

        return new TaxForms()
                .withDriver(driver)
                .withReporter(reporter);
    }

    protected WebElement labelReports() {

        return elementPresent(By.xpath("//h3[contains(.,'Reports')]"));
    }

    private WebElement labelAccountNumber() {

        return elementPresent(By.xpath("//span[@class='account-numbers']"));
    }

    private WebElement labelAccountsTab() {

        return elementPresent(By.xpath("//a[@data-toggle='tab' and text()='Accounts']"));
    }

    protected WebElement tabReports(ReportsTab tab) {

        return elementPresent(By.xpath("//li[contains(@ng-repeat,'tab')]" +
                "/a[contains(text(),'" + tab.toString().replaceAll("_", " ") + "')]"));
    }

    protected WebElement buttonActionRightpanel(Action action) {

        return elementPresent(By.xpath("//div[@class='panel-btn-right']" +
                "//am-button[@btn-text='" + action.toString().replaceAll("_", " ") + "']"));
    }

    protected WebElement dropDownOutputFormat() {

        return elementPresent(By.xpath("//select[@name='outputFormat']"));
    }

    protected WebElement reportModalTitle() {

        return elementPresent(By.xpath("//span[@id='amModalTitle']"));
    }

    protected WebElement buttonActionLeftpanel(Action action) {

        return elementPresent(By.xpath("//div[@class='panel-btn-left']" +
                "//am-button[@btn-text='" + action.toString().replaceAll("_", " ") + "']"));
    }

    protected WebElement panelSection() {

        return elementPresent(By.xpath("//section[@class='panel']"));
    }

    protected WebElement labelAlertSuccess() {

        return elementPresent(By.xpath("//div[contains(@class,'alert alert-success')]/p"));
    }

    private List<WebElement> radioButtonsAccountPicker() {
        return elementsPresent(By.xpath("//span[@ng-switch-when='status' and text()!='Unknown']/ancestor::tbody//i[@class='fa fa-lg fa-circle-thin']"));
    }

    protected WebElement buttonAccountSelector(Action action) {
        return elementPresent(By.xpath("//am-button[@btn-text='" + action.toString() + "']"));
    }

    private WebElement labelCreateCustomReport() {
        return elementPresent(By.xpath("//h4[text()='Create Custom Statement']"));
    }

    protected WebElement labelReviewReport(String name) {
        return elementPresent(By.xpath("//h2[text()='" + name + "']"));
    }

    protected WebElement labelReportConfirmation(String name) {
        return elementPresent(By.xpath("//h1[text()='" + name + "']"));
    }

    protected WebElement buttonCreate(String name) {
        return elementPresent(By.xpath("//span[text()='" + name + "']" +
                "/ancestor::section[@class='panel']//i[@data-original-title='Create']"));
    }

    protected List<WebElement> buttonReportAction(String section, Action action) {
        return elementsPresent(By.xpath("//span[text()='" + section + "']" +
                "/ancestor::section[@class='panel']//i[@data-original-title='" + action.toString() + "']"));
    }

    protected List<WebElement> reportList(String section) {
        return elementsPresent(By.xpath("//span[text()='" + section + "']/ancestor::section[@class='panel']//div[@ng-repeat]"));
    }

    protected WebElement labelReport(String section, String name) {
        return elementPresent(By.xpath("//span[text()='" + section + "']" +
                "/ancestor::section[@class='panel']//p/strong[text()='" + name + "']"));
    }

    protected WebElement inputReportName() {
        return elementPresent(By.xpath("//input[@name='reportName']"));
    }

    protected WebElement inputQueryName() {
        return elementPresent(By.xpath("//input[@name='queryName']"));
    }

    protected List<WebElement> buttonSections() {
        return elementsPresent(By.xpath("//p[@ng-repeat]/a"));
    }

    protected WebElement buttonSectionTradeConfirmation() {
        return elementPresent(By.xpath("//p[@ng-repeat]/a[contains(text(),'Trade Confirmation')]"));
    }

    protected List<WebElement> inputsCheckboxes() {
        return elementsPresent(By.xpath("//div[input[@type='checkbox']]"));
    }

    protected WebElement dropDownActivityPeriod() {

        return elementPresent(By.xpath("//select[@name='activityPeriod']"));
    }

    protected WebElement buttonOk() {

        return elementPresent(By.xpath("//p/a[text()='Ok']"));
    }

    private WebElement labelDeleteActivityStatement() {

        return elementPresent(By.xpath("//span[text()='Delete Activity Statement']"));
    }

    protected WebElement sectionReport(String name) {

        return elementPresent(By.xpath("//section//span[text()='" + name + "']"));
    }

    protected void pickAccount() {

        random(radioButtonsAccountPicker(), 1).get(0).click();
        sleep(500);
        buttonAccountSelector(Action.Continue).click();
        sleep(3000);
    }

    protected enum ReportsTab {Statements, Flex_Queries, Other_Reports, Tax}

    protected enum Action {Run_Report, Reset, Continue, Delete, Edit, Run, Create, Save_Changes, No, Yes, Close, Save}
}
