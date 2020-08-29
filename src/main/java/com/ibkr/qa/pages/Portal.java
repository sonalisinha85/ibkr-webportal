package com.ibkr.qa.pages;

import com.ibkr.qa.enums.PortalName;
import com.ibkr.qa.navigation.WebOperation;
import com.ibkr.qa.pages.menu.AccountSettings;
import com.ibkr.qa.pages.menu.PortfolioAnalyst;
import com.ibkr.qa.pages.menu.PreTradeCompliance;
import com.ibkr.qa.pages.menu.TransactionStatusAndHistory;
import com.ibkr.qa.pages.menu.reports.Reports;
import com.ibkr.qa.pages.tabs.Calendar;
import com.ibkr.qa.pages.tabs.Dashboard;
import com.ibkr.qa.pages.tabs.FeeAdmin;
import com.ibkr.qa.pages.tabs.Groups;
import com.ibkr.qa.pages.tabs.contacts.Contacts;
import com.ibkr.qa.pages.tabs.tools.DataQueries;
import com.ibkr.qa.pages.tabs.tools.RiskScores;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Portal extends WebOperation {

    private String portalName;

    public Portal withPortalName(PortalName portalName) {
        this.portalName = portalName.toString().replaceAll("_", " ");

//        if(this.portalName.contains("Broker")){
//
//            buttonNewAm().click();
//            switchToDefaultContext();
//        }
        validateLogin();
        return this;
    }

    public Portal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public Employee withEmployee() {

        return new Employee()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public Contacts withContacts() {

        return new Contacts()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public Dashboard withDashboard() {

        return new Dashboard()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public Groups withGroups() {

        return new Groups()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public Calendar withCalendar() {

        return new Calendar()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public AccountSettings withAccountSettings() {

        return new AccountSettings()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public FeeAdmin withFeeAdmin() {

        return new FeeAdmin()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public PortfolioAnalyst withPortfolioAnalyst() {

        return new PortfolioAnalyst()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public TransactionStatusAndHistory withTransactionStatusAndHistory() {

        return new TransactionStatusAndHistory()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public DataQueries withDataQueries() {

        return new DataQueries()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public RiskScores withRiskScores() {

        return new RiskScores()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public Reports withReports() {

        return new Reports()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public PreTradeCompliance withPreTradeCompliance() {

        return new PreTradeCompliance()
                .withDriver(driver)
                .withReporter(reporter);
    }

    //    Method used to set instance of Reporter
    public Portal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelPortal() {

        return elementPresent(By.xpath("//h3[contains(text(),'" + portalName + "')]"));
    }

    protected WebElement buttonNewAm() {

        switchFrame("footer");
        return elementPresent(By.xpath("//li[a[text()='New AM']]"));
    }

    private WebElement buttonUserOption() {

        return elementPresent(By.xpath("//user-options//span[@class='fa fa-angle-down']"));
    }

    private WebElement buttonLogout() {

        return elementPresent(By.xpath("//i[contains(@class,'fa-sign-out')]"));
    }

    protected WebElement tabs(Tabs tabs) {
        return elementPresent(By.xpath("//a[@data-toggle='tab' and contains(text(),'"
                + tabs.toString().replaceAll("_", " ") + "')]"));
    }

    protected WebElement menu(Menu menu) {
        return elementPresent(By.xpath("//i[@data-original-title='"
                + menu.toString().replaceAll("_", " ").replaceAll("And", "&") + "']"));
    }

    protected WebElement menu(String menu) {
        return elementPresent(By.xpath("//i[@data-original-title='"
                + menu + "']"));
    }

    protected WebElement subMenu(SubMenu subMenu) {
        return elementPresent(By.xpath("//li[contains(@ng-repeat,'subMenu')]" +
                "/a[contains(text(),'" + subMenu.toString().replaceAll("_", " ").replaceAll("And", "&") + "')]"));
    }

    public Portal validateLogin() {

        reporter.assertChild(softly.assertThat(labelPortal().isDisplayed())
                        .as("Successfully Logged Into " + portalName)
                        .isEqualTo(true),
                "Successfully Logged Into " + portalName);
        return this;
    }

    public Portal logout() {

        sleep(1000);
        buttonUserOption().click();
        sleep(200);
        buttonLogout().click();
        sleep(500);
        return this;
    }

    protected enum Tabs {Dashboard, Contacts, Fee_Administration, Tools, Groups, Transaction_History, Calendar, Email}

    protected enum Menu {Home, Trading, PortfolioAnalyst, Settings, Transfer_And_Pay}

    protected enum SubMenu {Account_Settings, Transaction_Status_And_History}
}
