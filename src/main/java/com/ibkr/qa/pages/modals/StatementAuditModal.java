package com.ibkr.qa.pages.modals;

import com.ibkr.qa.pages.Employee;
import com.ibkr.qa.reporter.TestReporter;
import com.ibkr.qa.utils.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatementAuditModal extends Employee {

    private List<String> listReviewStatus = new ArrayList(
            Arrays.asList("Pending Review",
                    "Reviewed",
                    "Not Applicable"));

    public StatementAuditModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public StatementAuditModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private String panelReviewStatus(String reviewStatus) {
        return "//a[text()='" + reviewStatus + "']";
    }

    private WebElement badge(String reviewStatus) {

        return elementPresent(By.xpath(panelReviewStatus(reviewStatus) +
                "/ancestor::div[@class='panel-heading']//span[@class='badge bg-red']"));
    }

    private List<WebElement> listReviewEntries(String reviewStatus) {

        return elementsPresent(By.xpath(panelReviewStatus(reviewStatus) +
                "//ancestor::div[@class='panel panel-default']//tr[@ng-repeat]"));
    }

    private WebElement noReviewEntries(String reviewStatus) {

        return elementNoLog(By.xpath(panelReviewStatus(reviewStatus) +
                "//ancestor::div[@class='panel panel-default']//p[contains(text(),'No Entries')]"));
    }

    private WebElement buttonExpandCollapse(String reviewStatus) {

        return elementPresent(By.xpath("//a[text()='" + reviewStatus + "']"));
    }

    private WebElement labelNotes(String name) {

        return elementPresent(By.xpath("//div[@id='amModalContent']//span[text()='" + name + "']"));
    }

    private WebElement buttonAction(Action action) {

        return elementPresent(By.xpath("//div[@id='amModalContent']" +
                "//am-button[@btn-text='" + action.toString().replaceAll("_", " ") + "']"));
    }

    private WebElement buttonExport() {

        return elementPresent(By.xpath("//i[@data-original-title='Export']"));
    }

    private WebElement buttonOk() {

        return elementPresent(By.xpath("//am-button[@btn-text='Ok']"));
    }

    private WebElement dropDownReportDate() {

        return elementPresent(By.xpath("//select[@name='reportDate']"));
    }

    public StatementAuditModal viewLog() {

        sleep(1000);

        reporter.createChild("Statement Audit")
                .assertChild(softly.assertThat(labelNotes("Statement Audit").isDisplayed())
                                .as("Statement Audit Label is displayed")
                                .isEqualTo(true),
                        "Statement Audit Label is displayed");

        changeDropdown(dropDownReportDate(), "202006");
        buttonAction(Action.View_Log).click();
        sleep(1000);

        reporter.createChild("View Log");

        listReviewStatus.forEach(reviewStatus -> {

            sleep(500);
            buttonExpandCollapse(reviewStatus).click();
            sleep(500);

            int entryCount = 0;
            if (isNotDisplayed(noReviewEntries(reviewStatus)))
                entryCount = listReviewEntries(reviewStatus).size();

            reporter.assertChild(softly.assertThat(entryCount)
                            .as("View Log Entries for " + reviewStatus)
                            .isEqualTo(Integer.parseInt(badge(reviewStatus).getText())),
                    "View Log Entries for " + reviewStatus);
            buttonExpandCollapse(reviewStatus).click();
        });

        sleep(500);
        buttonExport().click();
        sleep(1500);
        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("Audit Report Summary Download")
                        .contains("AuditReportSummary"),
                "Audit Report Summary Download");

        return this;
    }

    public StatementAuditModal review() {

        menu(Menu.Home).click();
        sleep(500);
        buttonsStatementAudit().click();
        sleep(500);

        changeDropdown(dropDownReportDate(), "202006");
        buttonAction(Action.Review).click();
        buttonAction(Action.Yes).click();

        while (buttonOk().isDisplayed())
            buttonOk().click();
        sleep(1000);
        reporter.createChild("Review");

        return this;
    }

    private enum Action {View_Log, Review, Cancel, Yes, No}
}
