package com.ibkr.qa.pages.menu;

import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TransactionStatusAndHistory extends Portal {

    public TransactionStatusAndHistory withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public TransactionStatusAndHistory withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    //div[@class='table-responsive']/table

    private WebElement labelTransactionStatusAndHistory() {
        return elementVisible(By.xpath("//h3[contains(.,'Transaction Status & History')]"));
    }

    private WebElement inputFromDate() {
        return elementVisible(By.xpath("//input[@name='fromDate']"));
    }

    private WebElement inputToDate() {
        return elementVisible(By.xpath("//input[@name='toDate']"));
    }

    private List<WebElement> previousMonth() {
        return elementsPresent(By.xpath("//th[@class='prev']"));
    }

    private List<WebElement> datePicker() {
        return elementsVisible(By.xpath("//div[@class='datepicker-days']//tr/td[not(contains(@class,'disabled day'))]"));
    }

    private WebElement tableTransactionHistory() {
        return elementVisible(By.xpath("//div[@ng-if and @class='table-responsive']/table"));
    }

    public TransactionStatusAndHistory validateTransactionHistory() {

        menu(Menu.Transfer_And_Pay).click();
        sleep(500);
        subMenu(SubMenu.Transaction_Status_And_History).click();
        sleep(2000);

        reporter.createChild("Transaction Status And History Validation")
                .assertChild(softly.assertThat(labelTransactionStatusAndHistory().isDisplayed())
                                .as("Transaction Status And History Label is displayed")
                                .isEqualTo(true),
                        "Transaction Status And History Label is displayed");

        inputFromDate().click();
        sleep(500);
        previousMonth().get(0).click();
        sleep(500);
        datePicker().get(0).click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(tableTransactionHistory().isDisplayed())
                        .as("Transaction History is displayed")
                        .isEqualTo(true),
                "Transaction History Label is displayed");
        return this;
    }

}
