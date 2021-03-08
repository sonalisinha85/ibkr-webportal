package com.ibkr.qa.pages.tabs.contacts;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterContactMenu extends Contacts {

    private List<String> mainPanels = new ArrayList(
            Arrays.asList("ContactType",
                    "ClientAccountType",
                    "ClientAccountStatus"));
    private List<String> filterContactTypes = new ArrayList(
            Arrays.asList("Prospect",
                    "Client"));
    private List<String> filterAccountTypes = new ArrayList(
            Arrays.asList("Financial Advisor",
                    "Individual",
                    "IRA",
                    "Savings Account",
                    "Joint",
                    "Organization",
                    "Single Hedge Fund",
                    "Trust",
                    "UGMA/UTMA"));
    private List<String> filterAccountStatus = new ArrayList(
            Arrays.asList("Application - In Progress",
                    "Application - Pending Consent",
                    "Application - Pending Approval",
                    "Application - Abandoned",
                    "Application - Rejected",
                    "Account - Open",
                    "Account - Closed"));

    public FilterContactMenu withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public FilterContactMenu withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement buttonMainPanel(Panel panel) {
        return elementVisible(By.xpath("//div[contains(@id,'" + panel.toString() + "')]//a"));
    }

    private WebElement buttonMainPanel(String panel) {
        return elementVisible(By.xpath("//div[contains(@id,'" + panel + "')]//a"));
    }

    private WebElement buttonFilter(Panel panel, String filterName) {
        return elementVisible(By.xpath("//div[contains(@id,'" + panel.toString() + "')]//td[text()='" + filterName + "']"));
    }

    private List<WebElement> buttonFilters(Panel panel) {
        return elementsVisible(By.xpath("//div[contains(@id,'" + panel.toString() + "')]//td"));
    }

    private List<WebElement> buttonFilters(String panel) {
        return elementsVisible(By.xpath("//div[contains(@id,'" + panel + "')]//td"));
    }

    private WebElement buttonAction(Action action) {
        return elementVisible(By.xpath("//a[text()='" + action.toString().replaceAll("_", " ") + "']"));
    }

    public FilterContactMenu validateFilterMenu() {

        reporter.createChild("Filter Menu validation");

        mainPanels.forEach(panel -> {

            buttonMainPanel(panel).click();
            sleep(500);

            if (panel.equals("ContactType")) {

                reporter.assertChild(softly.assertThat(buttonFilters(panel).size())
                                .as(panel + " filters count")
                                .isEqualTo(filterContactTypes.size()),
                        panel + " filters count");

                buttonFilters(panel).forEach(filter ->
                        reporter.assertChild(softly.assertThat(filter.getText())
                                .as(filter.getText() + " is listed under Type")
                                .isIn(filterContactTypes), filter.getText() + " is listed Type"));

            } else if (panel.equals("ClientAccountType")) {

                reporter.assertChild(softly.assertThat(buttonFilters(panel).size())
                                .as(panel + " filters count")
                                .isEqualTo(filterAccountTypes.size()),
                        panel + " filters count");

                buttonFilters(panel).forEach(filter ->
                        reporter.assertChild(softly.assertThat(filter.getText())
                                .as(filter.getText() + " is listed under Account Type")
                                .isIn(filterAccountTypes), filter.getText() + " is listed under Account Type"));

            } else if (panel.equals("ClientAccountStatus")) {

                reporter.assertChild(softly.assertThat(buttonFilters(panel).size())
                                .as(panel + " filters count")
                                .isEqualTo(filterAccountStatus.size()),
                        panel + " filters count");

                buttonFilters(panel).forEach(filter ->
                        reporter.assertChild(softly.assertThat(filter.getText())
                                .as(filter.getText() + " is listed under Status")
                                .isIn(filterAccountStatus), filter.getText() + " is listed under Status"));
            }
        });

        buttonAction(Action.Reset_All).click();
        return this;
    }

    public FilterContactMenu validateFilterResults(Panel panel, String filterName) {

        buttonFilterContact().click();
        sleep(500);
        buttonMainPanel(panel).click();
        sleep(200);
        buttonFilter(panel, filterName).click();
        buttonAction(Action.Apply).click();
        sleep(1000);

        List<String> columnValues = new ArrayList<>();

        if (panel.equals(Panel.ContactType))
            listColumnType().forEach(column -> columnValues.add(column.getText()));
        else if (panel.equals(Panel.ClientAccountType))
            listColumnAccountType().forEach(column -> columnValues.add(column.getText()));
        else if (panel.equals(Panel.ClientAccountStatus))
            listColumnStatus().forEach(column -> columnValues.add(column.getText()));

        List<String> distinctColumnValues = columnValues.stream().distinct().collect(Collectors.toList());

        reporter.createChild("Filtered Records validation for filter " + panel.toString() + " = " + filterName)
                .assertChild(softly.assertThat(distinctColumnValues.size())
                                .as("Number of distinct values displayed")
                                .isEqualTo(1),
                        "Number of distinct values displayed")
                .assertChild(softly.assertThat(distinctColumnValues.get(0))
                                .as("Filtered column value displayed")
                                .isEqualTo(filterName),
                        "Filtered column value displayed");

        return this;
    }

    public FilterContactMenu resetAllFilters() {

        buttonFilterContact().click();
        sleep(500);
        buttonAction(Action.Reset_All).click();

        return this;
    }

    protected enum Panel {ContactType, ClientAccountType, ClientAccountStatus}

    private enum Action {Apply, Reset_All}
}
