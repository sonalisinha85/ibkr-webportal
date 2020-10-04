package com.ibkr.qa.pages.menu.reports;

import com.ibkr.qa.reporter.TestReporter;
import com.ibkr.qa.utils.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    protected WebElement statementModal() {

        return elementVisible(By.xpath("//am-modal/div"));
    }

    protected WebElement buttonClose() {

        return elementVisible(By.xpath("//am-button[@btn-text='Close']"));
    }

    protected WebElement buttonStatementDeliveryConfigure() {
        return elementVisible(By.xpath("//i[@class='fa fa-gear tooltips' and @data-original-title='Configure']"));
    }

    protected WebElement labelStatementDelivery() {
        return elementVisible(By.xpath("//span[text()='Statements Delivery']"));
    }

    protected WebElement labelStatement(String statementName) {
        //Statement Name - "Daily Activity Statement" "Monthly Activity Statement"
        return elementVisible(By.xpath("//span[contains(.,'" + statementName + "')]"));
    }

    protected WebElement labelAccount() {
        return elementVisible(By.xpath("//span[@class='account-numbers']/a"));
    }

    public StatementDelivery withStatementDelivery() {

        return new StatementDelivery()
                .withDriver(driver)
                .withReporter(reporter);
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
        sleep(1000);
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

//        reporter.assertChild(softly.assertThat(labelReport("Custom Statements", name).isDisplayed())
//                        .as(name + " Custom Report is created")
//                        .isEqualTo(true),
//                name + " Custom Report is created");

        return this;
    }

    public Statements runDefaultStatements() {

        reporter.createChild("Validate Run Default Statements");

        random(buttonReportAction("Default Statements", Action.Run), 1).get(0).click();
        sleep(1000);
        buttonActionRightpanel(Action.Run).click();
        sleep(3000);

        reporter.assertChild(softly.assertThat(panelSection().isDisplayed())
                        .as("Custom Report is displayed")
                        .isEqualTo(true),
                "Custom Report is displayed");

        return this;
    }

    public Statements viewDefaultStatements() {

        reporter.createChild("Validate View Default Statements");

        random(buttonReportAction("Default Statements", Action.Info), 1).get(0).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(statementModal().isDisplayed())
                        .as("Default Statement modal is displayed")
                        .isEqualTo(true),
                "Default Statement modal is displayed");

        buttonClose().click();

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

    public Statements validateThirdPartyDownloads() {

        reporter.createChild("Validate Third Party Downloads")
                .assertChild(softly.assertThat(sectionReport("Third-Party Downloads").isDisplayed())
                                .as("Third-Party Downloads Section is displayed")
                                .isEqualTo(true),
                        "Third-Party Downloads Section is displayed");

        return this;
    }

    public Statements runThirdPartyDownloads() {

        String account = labelAccount().getText().trim();

        random(buttonReportAction("Third-Party Downloads", Action.Run), 1).get(0).click();
        sleep(1000);
        buttonActionRightpanel(Action.Run).click();
        sleep(3000);

        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("Third-Party Report is Downloaded")
                        .contains(account),
                "Third-Party Report is Downloaded");

        return this;
    }
}
