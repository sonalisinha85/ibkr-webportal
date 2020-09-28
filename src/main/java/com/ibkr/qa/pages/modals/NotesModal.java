package com.ibkr.qa.pages.modals;

import com.ibkr.qa.pages.tabs.Dashboard;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NotesModal extends Dashboard {

    public NotesModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public NotesModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelNotes(String name) {

        return elementVisible(By.xpath("//div[@id='amModalContent']//span[text()='" + name + "']"));
    }

    private WebElement inputContact() {

        return elementVisible(By.xpath("//input[@name='addedContactName']"));
    }

    private WebElement inputDescription() {

        return elementVisible(By.xpath("//textarea[@placeholder='Required']"));
    }

    private List<WebElement> radioButtonsContact() {
        return elementsVisible(By.xpath("//tr[@ng-repeat]//div[@class='iradio_square-blue']"));
    }

    private WebElement buttonCloseModal() {

        return elementVisible(By.xpath("//div[@id='amModalContent']//button[@class='close']"));
    }

    private WebElement buttonAction(Action action) {

        return elementVisible(By.xpath("//div[@id='amModalContent']//am-button[@btn-text='" + action.toString() + "']"));
    }

    private WebElement labelDeleteAlert() {

        return elementVisible(By.xpath("//div[@class='alert alert-success']/p[text()='Note has been deleted.']"));
    }

    public NotesModal viewNotes() {

        buttonsEditNotes().get(0).click();
        sleep(1000);
        reporter.createChild("Edit Notes")
                .assertChild(softly.assertThat(labelNotes("Edit Note").isDisplayed())
                                .as("Edit Note Label is displayed")
                                .isEqualTo(true),
                        "Edit Note Label is displayed");

        buttonAction(Action.Cancel).click();
        sleep(1000);

        return this;
    }

    public NotesModal addNotes() {

        buttonAddNotes().click();
        sleep(1000);
        reporter.createChild("Add Notes")
                .assertChild(softly.assertThat(labelNotes("Add Note").isDisplayed())
                                .as("Add Note Label is displayed")
                                .isEqualTo(true),
                        "Add Note Label is displayed");

        inputContact().sendKeys("test");
        radioButtonsContact().get(0).click();
        inputDescription().sendKeys("Regression Test");
        buttonAction(Action.Create).click();
        sleep(1000);

        return this;
    }

    public NotesModal addNotes(String contact) {

        buttonAddNotes().click();
        sleep(1000);
        reporter.createChild("Add Notes")
                .assertChild(softly.assertThat(labelNotes("Add Note").isDisplayed())
                                .as("Add Note Label is displayed")
                                .isEqualTo(true),
                        "Add Note Label is displayed");

        inputContact().sendKeys(contact);
        radioButtonsContact().get(0).click();
        inputDescription().sendKeys("Regression Test");
        buttonAction(Action.Create).click();
        sleep(1000);

        return this;
    }

    public NotesModal editNotes() {

        random(buttonsEditNotes(), 1).get(0).click();
        sleep(1000);
        reporter.createChild("Edit Notes")
                .assertChild(softly.assertThat(labelNotes("Edit Note").isDisplayed())
                                .as("Edit Note Label is displayed")
                                .isEqualTo(true),
                        "Edit Note Label is displayed");

        inputDescription().clear();
        inputDescription().sendKeys("Regression Test");
        buttonAction(Action.Create).click();
        sleep(1000);

        return this;
    }

    public NotesModal deleteNotes() {

        random(buttonsDeleteNotes(), 1).get(0).click();
        sleep(500);
        reporter.createChild("Delete Notes")
                .assertChild(softly.assertThat(labelNotes("Delete Note").isDisplayed())
                                .as("Delete Note Label is displayed")
                                .isEqualTo(true),
                        "Delete Note Label is displayed");
        buttonAction(Action.No).click();
        buttonsDeleteNotes().get(0).click();
        sleep(500);
        buttonAction(Action.Yes).click();
        sleep(500);
        reporter.assertChild(softly.assertThat(labelDeleteAlert().isDisplayed())
                        .as("Delete Note Alert is displayed")
                        .isEqualTo(true),
                "Delete Note Alert is displayed");
        buttonAction(Action.Close).click();
        sleep(1000);

        return this;
    }

    public NotesModal viewMoreNotes() {

        if (!isNotDisplayed(buttonViewMoreNotesNoLog())) {

            int size = listNotes().size();

            buttonViewMoreNotes().click();
            sleep(1000);

            reporter.createChild("View More Notes")
                    .assertChild(softly.assertThat(listNotes().size())
                                    .as("More Notes are displayed")
                                    .isGreaterThanOrEqualTo(size),
                            "More Notes are displayed");
        }

        return this;
    }

    private enum Action {Create, Yes, No, Cancel, Close}
}
