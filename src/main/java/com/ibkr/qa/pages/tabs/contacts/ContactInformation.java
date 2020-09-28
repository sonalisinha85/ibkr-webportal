package com.ibkr.qa.pages.tabs.contacts;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactInformation extends Contacts {

    public ContactInformation withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public ContactInformation withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement tab(String name) {
        return elementVisible(By.xpath("//a[@data-toggle='tab' and contains(text(),'" + name + "')]"));
    }

    private List<WebElement> labelWorkflows(String firstName) {
        return elementsVisible(By.xpath("//div[@id='workflow-list']//p[contains(.,'" + firstName + "')]"));
    }

    private List<WebElement> labelNotes(String firstName) {
        return elementsVisible(By.xpath("//ul[@id='note-list']//div[contains(.,'" + firstName + "')]"));
    }

    private List<WebElement> labelEvents(String firstName) {
        return elementsVisible(By.xpath("//ul[@class='event-list-item']//strong[contains(.,'" + firstName + "')]"));
    }

    public ContactInformation validateWorkflow(String firstName) {

        tab("Agenda").click();
        sleep(1000);

        reporter.createChild("Validate Workflow in Agenda Tab")
                .assertChild(softly.assertThat(labelWorkflows(firstName).size())
                                .as("Workflows are displayed")
                                .isGreaterThan(0),
                        "Workflows are displayed");

        return this;
    }

    public ContactInformation validateNote(String firstName) {

        tab("Agenda").click();
        sleep(1000);

        reporter.createChild("Validate Note in Agenda Tab")
                .assertChild(softly.assertThat(labelNotes(firstName).size())
                                .as("Notes are displayed")
                                .isGreaterThan(0),
                        "Notes are displayed");

        return this;
    }

    public ContactInformation validateEvent(String firstName) {

        tab("Agenda").click();
        sleep(1000);

        reporter.createChild("Validate Event in Agenda Tab")
                .assertChild(softly.assertThat(labelEvents(firstName).size())
                                .as("Events are displayed")
                                .isGreaterThan(0),
                        "Events are displayed");

        return this;
    }
}
