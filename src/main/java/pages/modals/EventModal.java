package pages.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.tabs.Dashboard;
import reporter.TestReporter;

import java.util.List;

public class EventModal extends Dashboard {

    enum Action {Create, Yes, No, Cancel, Close}

    public EventModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public EventModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelEvent(String name) {
//  name -  Add Event, Delete Event, Edit Event
        return elementPresent(By.xpath("//div[@id='amModalContent']//span[text()='" + name + "']"));
    }

    private WebElement inputContact() {

        return elementPresent(By.xpath("//input[@name='addedContactName']"));
    }

    private WebElement inputName() {

        return elementPresent(By.xpath("//input[contains(@ng-model,'originalTitle')]"));
    }

    private List<WebElement> radioButtonsContact() {
        return elementsPresent(By.xpath("//tr[@ng-repeat]//div[@class='iradio_square-blue']"));
    }

    private WebElement buttonAction(Action action) {

        return elementPresent(By.xpath("//am-button[@btn-text='" + action.toString() + "']"));
    }

    public EventModal addEvent(){

        buttonAddEvent().click();
        sleep(1000);

        reporter.createChild("Add Event Validation")
                .assertChild(softly.assertThat(labelEvent("Add Event").isDisplayed())
                                .as("Add Event Label is displayed")
                                .isEqualTo(true),
                        "Add Event Label is displayed");

        String name = "Regression Test " + getCurrentTime();
        inputName().clear();
        inputName().sendKeys(name);
        inputContact().sendKeys("test");
        sleep(500);
        random(radioButtonsContact(),1).get(0).click();
        buttonAction(Action.Create).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelEventName(name).isDisplayed())
                                .as(name + " Event is added in Calendar")
                                .isEqualTo(true),
                name + " Event is added in Calendar");

        return this;
    }

    public EventModal editEvent(){

        random(buttonEditEvent(),1).get(0).click();
        sleep(1000);

        reporter.createChild("Edit Event Validation")
                .assertChild(softly.assertThat(labelEvent("Edit Event").isDisplayed())
                                .as("Edit Event Label is displayed")
                                .isEqualTo(true),
                        "Edit Event Label is displayed");

        String name = "Regression Test " + getCurrentTime();
        inputName().clear();
        inputName().sendKeys(name);
        buttonAction(Action.Create).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelEventName(name).isDisplayed())
                        .as(name + " Event is updated in Calendar")
                        .isEqualTo(true),
                name + " Event is updated in Calendar");

        return this;
    }
}
