package pages.menu.reports;

import org.openqa.selenium.WebDriver;
import reporter.TestReporter;

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

    public Reports createActivityFlexQuery() {

        reporter.createChild("Validate Create Activity Flex Query");

        String name = "Regression Test " + getCurrentTime();
        buttonCreate("Activity Flex Query").click();
        sleep(1500);
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

    public Reports editActivityFlexQuery() {

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

    public Reports runActivityFlexQuery() {

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

    public Reports deleteActivityFlexQuery() {

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
