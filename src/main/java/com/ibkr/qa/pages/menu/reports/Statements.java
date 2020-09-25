package com.ibkr.qa.pages.menu.reports;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.WebDriver;

public class Statements extends Reports {

    public Statements withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public Statements withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    public Statements runCustomStatements() {

        reporter.createChild("Validate Run Custom Statements");

        random(buttonReportAction("Custom Statements", Action.Run), 1).get(0).click();
        sleep(1000);
        buttonActionRightpanel(Action.Run).click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(panelSection().isDisplayed())
                        .as("Custom Report is displayed")
                        .isEqualTo(true),
                "Custom Report is displayed");

        return this;
    }

    public Statements deleteCustomStatements() {

        reporter.createChild("Validate Delete Custom Statements");

        int count = reportList("Custom Statements").size();
        random(buttonReportAction("Custom Statements", Action.Delete), 1).get(0).click();
        sleep(1000);
        buttonActionLeftpanel(Action.No).click();
        sleep(500);
        random(buttonReportAction("Custom Statements", Action.Delete), 1).get(0).click();
        sleep(1000);
        buttonActionRightpanel(Action.Yes).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelAlertSuccess().isDisplayed())
                        .as("Custom Report Deleted")
                        .isEqualTo(true),
                "Custom Report Deleted");

        buttonActionRightpanel(Action.Close).click();
        sleep(3000);

        if (count < 10)
            reporter.assertChild(softly.assertThat(reportList("Custom Statements").size())
                            .as("Custom report is deleted [Old Custom Reports count vs New Custom Reports count validated]")
                            .isEqualTo(count - 1),
                    "Custom report is deleted [Old Custom Reports count vs New Custom Reports count validated]");

        return this;
    }

    public Statements editCustomStatements() {

        reporter.createChild("Validate Edit Custom Statements");

        random(buttonReportAction("Custom Statements", Action.Edit), 1).get(0).click();
        sleep(2000);
//        random(buttonSections(), 2).forEach(section -> section.click());
        buttonActionRightpanel(Action.Continue).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReviewReport("Review Your Custom Statement").isDisplayed())
                        .as("Review Custom Report label is displayed")
                        .isEqualTo(true),
                "Review Custom Report label is displayed");

        buttonActionRightpanel(Action.Save_Changes).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReportConfirmation("Custom Statement Saved").isDisplayed())
                        .as("Custom Report Saved label is displayed")
                        .isEqualTo(true),
                "Custom Report Saved label is displayed");

        buttonOk().click();
        sleep(1000);

        return this;
    }

    public Statements createCustomStatements() {

        reporter.createChild("Validate Create Custom Statements");

        String name = "Regression Test " + getCurrentTime();
        buttonCreate("Custom Statements").click();
        sleep(2000);
        inputReportName().sendKeys(name);
        random(buttonSections(), 1).get(0).click();
        changeDropdown(dropDownActivityPeriod(), "Monthly");
        buttonActionRightpanel(Action.Continue).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReviewReport("Review Your Custom Statement").isDisplayed())
                        .as("Review Custom Report label is displayed")
                        .isEqualTo(true),
                "Review Custom Report label is displayed");

        buttonActionRightpanel(Action.Create).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReportConfirmation("Custom Statement Saved").isDisplayed())
                        .as("Custom Report Saved label is displayed")
                        .isEqualTo(true),
                "Custom Report Saved label is displayed");

        buttonOk().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelReport("Custom Statements", name).isDisplayed())
                        .as(name + " Custom Report is created")
                        .isEqualTo(true),
                name + " Custom Report is created");

        return this;
    }

    public Statements navigateToReport() {

        menu("Reports / Tax Docs").click();
        sleep(1500);
        pickAccount();

        return this;
    }

    public Statements validateStatementTab() {

        reporter.createChild("Custom Statements Navigation")
                .assertChild(softly.assertThat(sectionReport("Custom Statements").isDisplayed())
                                .as("Custom Statement Section is displayed")
                                .isEqualTo(true),
                        "Custom Statement Section is displayed");

        return this;
    }
}
