package com.ibkr.qa.pages.tabs.tools;

import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RiskScores extends Portal {

    private List<String> tabsQuestionnaire = new ArrayList(
            Arrays.asList(
                    "Score Calculation",
                    "View Scores",
                    "Questions",
                    "Need",
                    "Tolerance",
                    "Capacity"
            ));
    private List<String> questionKeys = new ArrayList(
            Arrays.asList(
                    "estimated annual income",
                    "highest earning years",
                    "total investments",
                    "convert to cash",
                    "plan on using this investment",
                    "significant value drop",
                    "investment risk",
                    "tolerance to risk",
                    "outcome of the investment decisions",
                    "financial goal",
                    "special future and non-recurring expenses"
            ));

    public RiskScores withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public RiskScores withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelTools() {
        return elementVisible(By.xpath("//div[@class='panel-heading']/span[text()='Tools']"));
    }

    private WebElement labelRiskScores() {
        return elementVisible(By.xpath("//h4[text()='Risk Scores']"));
    }

    private WebElement labelCalculatedRiskScores() {
        return elementVisible(By.xpath("//span[contains(text(),'The Risk Score is')]"));
    }

    private WebElement labelDisclosures() {
        return elementVisible(By.xpath("//h5[contains(text(),'Disclosures')]"));
    }

    private WebElement labelQuestionnaire() {
        return elementVisible(By.xpath("//h4/span[text()='Your Questionnaire']"));
    }

    private WebElement buttonRiskScores() {
        return elementVisible(By.xpath("//a/span[contains(text(),'Risk Scores')]"));
    }

    private List<WebElement> tabsQuestionnaire() {
        return elementsVisible(By.xpath("//div[@role='tablist']/a"));
    }

    private WebElement tabQuestionnaire(String name) {
        return elementVisible(By.xpath("//div[@role='tablist']/a[@title='" + name + "']"));
    }

    private WebElement buttonAction(Action action) {

        return elementVisible(By.xpath("//am-button[@btn-text='"
                + action.toString().replaceAll("_", " ") + "']"));
    }

    private WebElement buttonAction(String action) {

        return elementVisible(By.xpath("//button[contains(text(),'" + action + "')]"));
    }

    private List<WebElement> questions(String key) {
        return elementsVisible(By.xpath("//h6[contains(text(),'" + key + "')]" +
                "/ancestor::div[@class='has-label']//span[@aria-hidden]"));
    }

    public RiskScores validateRiskScores() {

        tabs(Tabs.Tools).click();
        sleep(1000);

        reporter.createChild("Risk Scores Validation")
                .assertChild(softly.assertThat(labelTools().isDisplayed())
                                .as("Tools Label is displayed")
                                .isEqualTo(true),
                        "Tools Label is displayed");

        buttonRiskScores().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelRiskScores().isDisplayed())
                        .as("Risk Scores Label is displayed")
                        .isEqualTo(true),
                "Risk Scores Label is displayed");

        buttonAction(Action.Continue).click();
        sleep(2000);

        switchFrame("questionnaireFrame");

        reporter.assertChild(softly.assertThat(labelQuestionnaire().isDisplayed())
                        .as("Questionnaire is displayed")
                        .isEqualTo(true),
                "Questionnaire is displayed")
                .assertChild(softly.assertThat(buttonAction("Important Disclosures").isDisplayed())
                                .as("Important Disclosures button is displayed")
                                .isEqualTo(true),
                        "Important Disclosures button is displayed")
                .assertChild(softly.assertThat(buttonAction("Instructions").isDisplayed())
                                .as("Instructions button is displayed")
                                .isEqualTo(true),
                        "Instructions button is displayed")
                .assertChild(softly.assertThat(labelDisclosures().isDisplayed())
                                .as("Disclosures are displayed")
                                .isEqualTo(true),
                        "Disclosures are displayed");

        tabsQuestionnaire().forEach(tab ->
                reporter.assertChild(softly.assertThat(tab.getText())
                        .as(tab.getText() + " Tab is present")
                        .isIn(tabsQuestionnaire), tab.getText() + " Tab is present"));

        //        Navigate to different tabs
        tabsQuestionnaire.forEach(tab -> tabQuestionnaire(tab).click());
        buttonAction("preview").click();
        sleep(3000);

        switchToDefaultContext();
        switchTab();

        questionKeys.forEach(key -> random(questions(key), 1).get(0).click());
        buttonAction("Submit").click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelCalculatedRiskScores().isDisplayed())
                        .as("Calculated Risk Score is displayed")
                        .isEqualTo(true),
                "Calculated Risk Score is displayed");

        switchToMainTab();
        sleep(1000);

        return this;
    }

    private enum Action {Continue, Select}
}
