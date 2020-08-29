package com.ibkr.qa.pages.tabs;

import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Calendar extends Portal {

    public Calendar withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public Calendar withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelCalendar() {
        return elementPresent(By.xpath("//div[@class='panel-heading']/span[text()='Calendar']"));
    }

    private List<WebElement> labelMonthEventEntry() {
        return elementsPresent(By.xpath("//td[@class='fc-event-container']//span[contains(text(),'Regression Test')]"));
    }

    private List<WebElement> labelListEventEntry() {
        return elementsPresent(By.xpath("//td/a[contains(text(),'Regression Test')]"));
    }

    private WebElement buttonAction(Action action) {

        return elementPresent(By.xpath("//button[text()='" + action.toString() + "']"));
    }

    public Calendar viewFullCalendar() {

        reporter.createChild("View Full Calendar Validation")
                .assertChild(softly.assertThat(labelCalendar().isDisplayed())
                                .as("Calendar Label is displayed")
                                .isEqualTo(true),
                        "Calendar Label is displayed")
                .assertChild(softly.assertThat(random(labelMonthEventEntry(), 1).get(0).isDisplayed())
                                .as("Event is displayed in Month View")
                                .isEqualTo(true),
                        "Event is displayed in Month View");

        buttonAction(Action.list).click();
        sleep(200);

        reporter.assertChild(softly.assertThat(random(labelListEventEntry(), 1).get(0).isDisplayed())
                        .as("Event is displayed in List View")
                        .isEqualTo(true),
                "Event is displayed in List View");

        return this;
    }

    private enum Action {month, list}
}
