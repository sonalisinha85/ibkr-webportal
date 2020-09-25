package com.ibkr.qa.pages.menu.reports;

import com.ibkr.qa.reporter.TestReporter;
import com.ibkr.qa.utils.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlexQueries extends Reports {

    public FlexQueries withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public FlexQueries withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    public FlexQueryDelivery withFlexQueryDelivery() {

        return new FlexQueryDelivery()
                .withDriver(driver)
                .withReporter(reporter);
    }

    protected WebElement buttonFlexQueryDeliveryConfigure() {
        return elementVisible(By.xpath("//i [@class='fa fa-gear' and @data-original-title='Configure']"));
    }

    public FlexQueries createActivityFlexQuery() {

        reporter.createChild("Validate Create Activity Flex Query");

        String name = "Regression Test " + getCurrentTime();
        buttonCreate("Activity Flex Query").click();
        sleep(2000);
        inputQueryName().sendKeys(name);
        random(buttonSections(), 1).get(0).click();
        sleep(1500);
        random(inputsCheckboxes(), 1).get(0).click();
        buttonActionRightpanel(Action.Save).click();
        sleep(1000);
        buttonActionRightpanel(Action.Continue).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReviewReport("Review Your Activity Flex Query").isDisplayed())
                        .as("Review Activity Flex Query label is displayed")
                        .isEqualTo(true),
                "Review Activity Flex Query label is displayed");

        buttonActionRightpanel(Action.Create).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReportConfirmation("Activity Flex Query Saved").isDisplayed())
                        .as("Activity Flex Query Saved label is displayed")
                        .isEqualTo(true),
                "Activity Flex Query Saved label is displayed");

        buttonOk().click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(labelReport("Activity Flex Query", name).isDisplayed())
                        .as(name + " Activity Flex Query is created")
                        .isEqualTo(true),
                name + " Activity Flex Query is created");

        return this;
    }

    public FlexQueries editActivityFlexQuery() {

        reporter.createChild("Validate Edit Activity Flex Query");

        random(buttonReportAction("Activity Flex Query", Action.Edit), 1).get(0).click();
        sleep(2000);
//        random(buttonSections(), 2).forEach(section -> {
//            section.click();
//            sleep(1500);
//            random(inputsCheckboxes(), 1).get(0).click();
//            buttonActionRightpanel(Action.Save).click();
//            sleep(1000);
//        });
        buttonActionRightpanel(Action.Continue).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReviewReport("Review Your Activity Flex Query").isDisplayed())
                        .as("Review Activity Flex Query label is displayed")
                        .isEqualTo(true),
                "Review Activity Flex Query label is displayed");

        buttonActionRightpanel(Action.Save_Changes).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReportConfirmation("Activity Flex Query Saved").isDisplayed())
                        .as("Activity Flex Query Saved label is displayed")
                        .isEqualTo(true),
                "Activity Flex Query Saved label is displayed");

        buttonOk().click();
        sleep(1000);

        return this;
    }

    public FlexQueries runActivityFlexQuery() {

        reporter.createChild("Validate Run Activity Flex Query");

        random(buttonReportAction("Activity Flex Query", Action.Run), 1).get(0).click();
        sleep(1000);
        buttonActionRightpanel(Action.Run).click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(panelSection().isDisplayed())
                        .as("Activity Flex Query is displayed")
                        .isEqualTo(true),
                "Activity Flex Query is displayed");

        return this;
    }

    public FlexQueries deleteActivityFlexQuery() {

        reporter.createChild("Validate Delete Activity Flex Query");

        int count = reportList("Activity Flex Query").size();
        random(buttonReportAction("Activity Flex Query", Action.Delete), 1).get(0).click();
        sleep(1000);
        buttonActionLeftpanel(Action.No).click();
        sleep(500);
        random(buttonReportAction("Activity Flex Query", Action.Delete), 1).get(0).click();
        sleep(1000);
        buttonActionRightpanel(Action.Yes).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelAlertSuccess().isDisplayed())
                        .as("Activity Flex Query Deleted")
                        .isEqualTo(true),
                "Activity Flex Query Deleted");

        buttonActionRightpanel(Action.Close).click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(reportList("Activity Flex Query").size())
                        .as("Activity Flex Query is deleted [Old Activity Flex Query count vs New Activity Flex Query count validated]")
                        .isEqualTo(count - 1),
                "Activity Flex Query is deleted [Old Activity Flex Query count vs New Activity Flex Query count validated]");

        return this;
    }

    public FlexQueries createTradeConfirmationFlexQuery() {

        reporter.createChild("Validate Create Trade Confirmation Flex Query");

        String name = "Regression Test " + getCurrentTime();
        buttonCreate("Trade Confirmation Flex Query").click();
        sleep(1500);
        inputQueryName().sendKeys(name);
        buttonSectionTradeConfirmation().click();
        sleep(1500);
        random(inputsCheckboxes(), 1).forEach(checkBox -> checkBox.click());
        buttonActionRightpanel(Action.Save).click();
        sleep(1000);
        buttonActionRightpanel(Action.Continue).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReviewReport("Review Your Trade Confirmation Flex Query").isDisplayed())
                        .as("Review Your Trade Confirmation Flex Query label is displayed")
                        .isEqualTo(true),
                "Review Your Trade Confirmation Flex Query label is displayed");

        buttonActionRightpanel(Action.Create).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReportConfirmation("Trade Confirm Flex Query Saved").isDisplayed())
                        .as("Trade Confirm Flex Query Saved label is displayed")
                        .isEqualTo(true),
                "Trade Confirm Flex Query Saved label is displayed");

        buttonOk().click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(labelReport("Trade Confirmation Flex Query", name).isDisplayed())
                        .as(name + " Trade Confirmation Flex Query is created")
                        .isEqualTo(true),
                name + " Trade Confirmation Flex Query is created");

        return this;
    }

    public FlexQueries editTradeConfirmationFlexQuery() {

        reporter.createChild("Validate Edit Trade Confirmation Flex Query");

        random(buttonReportAction("Trade Confirmation Flex Query", Action.Edit), 1).get(0).click();
        sleep(2000);
//        random(buttonSections(), 2).forEach(section -> {
//            section.click();
//            sleep(1500);
//            random(inputsCheckboxes(), 1).get(0).click();
//            buttonActionRightpanel(Action.Save).click();
//            sleep(1000);
//        });
        buttonActionRightpanel(Action.Continue).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReviewReport("Review Your Trade Confirmation Flex Query").isDisplayed())
                        .as("Review Your Trade Confirmation Flex Query label is displayed")
                        .isEqualTo(true),
                "Review Your Trade Confirmation Flex Query label is displayed");

        buttonActionRightpanel(Action.Save_Changes).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReportConfirmation("Trade Confirm Flex Query Saved").isDisplayed())
                        .as("Trade Confirm Flex Query Saved label is displayed")
                        .isEqualTo(true),
                "Trade Confirm Flex Query Saved label is displayed");

        buttonOk().click();
        sleep(1000);

        return this;
    }

    public FlexQueries runTradeConfirmationFlexQuery() {

        reporter.createChild("Validate Run Trade Confirmation Flex Query");

        random(buttonReportAction("Trade Confirmation Flex Query", Action.Run), 1).get(0).click();
        sleep(1000);
        String name = reportModalTitle().getText();
        changeDropdown(dropDownOutputFormat(), "CSV");
        buttonActionRightpanel(Action.Run).click();
        sleep(4000);

        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("Trade Confirmation Flex Query is Download")
                        .contains(name.replaceAll("\\ | |:| ", "_")),
                "Trade Confirmation Flex Query is Download");

        return this;
    }

    public FlexQueries deleteTradeConfirmationFlexQuery() {

        reporter.createChild("Validate Delete Trade Confirmation Flex Query");

        int count = reportList("Trade Confirmation Flex Query").size();
        random(buttonReportAction("Trade Confirmation Flex Query", Action.Delete), 1).get(0).click();
        sleep(1000);
        buttonActionLeftpanel(Action.No).click();
        sleep(500);
        random(buttonReportAction("Trade Confirmation Flex Query", Action.Delete), 1).get(0).click();
        sleep(1000);
        buttonActionRightpanel(Action.Yes).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelAlertSuccess().isDisplayed())
                        .as("Trade Confirmation Flex Query Deleted")
                        .isEqualTo(true),
                "Trade Confirmation Flex Query Deleted");

        buttonActionRightpanel(Action.Close).click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(reportList("Trade Confirmation Flex Query").size())
                        .as("Trade Confirmation Flex Query is deleted [Old Trade Confirmation Flex Query count vs New Trade Confirmation Flex Query count validated]")
                        .isEqualTo(count - 1),
                "Trade Confirmation Flex Query is deleted [Old Trade Confirmation Flex Query count vs New Trade Confirmation Flex Query count validated]");

        return this;
    }

    public FlexQueries navigateToReport() {

        menu("Reports / Tax Docs").click();
        sleep(1500);
        pickAccount();

        return this;
    }

    public FlexQueries navigateToFlexQueries() {

        tabReports(ReportsTab.Flex_Queries).click();
        sleep(2000);

        reporter.createChild("Flex Queries Navigation")
                .assertChild(softly.assertThat(sectionReport("Activity Flex Query").isDisplayed())
                                .as("Activity Flex Query Section is displayed")
                                .isEqualTo(true),
                        "Activity Flex Query Section is displayed");

        return this;
    }
}
