package com.ibkr.qa.pages.modals;

import com.ibkr.qa.pages.Employee;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommentModal extends Employee {

    public CommentModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public CommentModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelNotes(String name) {

        return elementVisible(By.xpath("//div[@id='amModalContent']//span[text()='" + name + "']"));
    }

    private WebElement inputComment() {

        return elementVisible(By.xpath("//textarea[@placeholder='Required']"));
    }

    private List<WebElement> listComments() {
        return elementsVisible(By.xpath("//div[@ng-repeat and @class='row']"));
    }

    private WebElement buttonAction(Action action) {

        return elementVisible(By.xpath("//div[@id='amModalContent']//am-button[@btn-text='" + action.toString() + "']"));
    }

    public CommentModal addComment() {

        int size = listComments().size();

        buttonAddComment().click();
        sleep(1000);
        reporter.createChild("Add Comments")
                .assertChild(softly.assertThat(labelNotes("Add Comment").isDisplayed())
                                .as("Add Comment Label is displayed")
                                .isEqualTo(true),
                        "Add Comment Label is displayed");

        buttonAction(Action.Cancel).click();
        sleep(500);
        buttonAddComment().click();
        sleep(1000);
        inputComment().sendKeys("Regression Test");
        buttonAction(Action.Add).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(listComments().size())
                        .as("Added Comment is Listed")
                        .isGreaterThanOrEqualTo(size),
                "Added Comment is Listed");

        return this;
    }

    private enum Action {Add, Cancel}
}
