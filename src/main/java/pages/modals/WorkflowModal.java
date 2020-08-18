package pages.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.tabs.Dashboard;
import reporter.TestReporter;

import java.util.List;

public class WorkflowModal extends Dashboard {

    enum Action {Create, Save, Cancel}

    public WorkflowModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public WorkflowModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelWorkflow(String name) {

        return elementPresent(By.xpath("//div[@id='amModalContent']//span[text()='" + name + "']"));
    }

    private WebElement inputAssociatedContact() {

        return elementPresent(By.xpath("//input[@name='addedContactName']"));
    }

    private WebElement inputDetails() {

        return elementPresent(By.xpath("//input[@name='taskDescription']"));
    }

    private List<WebElement> radioButtonsContact() {
        return elementsPresent(By.xpath("//tr[@ng-repeat]//div[@class='iradio_square-blue']"));
    }

    private WebElement buttonCloseModal() {

        return elementPresent(By.xpath("//div[@id='amModalContent']//button[@class='close']"));
    }

    private WebElement buttonAction(Action action) {

        return elementPresent(By.xpath("//div[@id='amModalContent']//am-button[@btn-text='" + action.toString() + "']"));
    }

    public WorkflowModal viewWorkflow() {

        buttonsViewWorkflow().get(0).click();
        sleep(1000);
        reporter.createChild("View Workflow")
                .assertChild(softly.assertThat(labelWorkflow("View Workflow").isDisplayed())
                                .as("View Workflow Label is displayed")
                                .isEqualTo(true),
                        "View Workflow Label is displayed");
        buttonCloseModal().click();
        return this;
    }

    public WorkflowModal addWorkflow() {

        buttonAddWorkflow().click();
        sleep(1000);
        reporter.createChild("Add Workflow")
                .assertChild(softly.assertThat(labelWorkflow("Add Workflow").isDisplayed())
                        .as("Add Workflow Label is displayed")
                        .isEqualTo(true),
                        "Add Workflow Label is displayed");

        inputAssociatedContact().sendKeys("test");
        radioButtonsContact().get(0).click();
        inputDetails().sendKeys("Regression Test");
        buttonAction(Action.Create).click();
        sleep(1000);

        return this;
    }

    public WorkflowModal editWorkflow() {

        random(buttonsEditWorkflow(),1).get(0).click();
        sleep(1000);
        reporter.createChild("Edit Workflow")
                .assertChild(softly.assertThat(labelWorkflow("Edit Workflow").isDisplayed())
                        .as("Edit Workflow Label is displayed")
                        .isEqualTo(true),
                        "Edit Workflow Label is displayed");

        inputDetails().clear();
        inputDetails().sendKeys("Regression Test");
        buttonAction(Action.Save).click();
        sleep(1000);

        return this;
    }

    public WorkflowModal deleteWorkflow() {

        random(buttonsDeleteWorkflow(),1).get(0).click();
        sleep(500);
        reporter.createChild("Delete Workflow")
                .childInfo("Workflow Deleted");

        return this;
    }

    public WorkflowModal viewMoreWorkflows() {

        sleep(500);
        int size = listWorkflow().size();
        buttonViewMoreWorkflows().click();
        sleep(1000);

        reporter.createChild("View More Workflows")
                .assertChild(softly.assertThat(listWorkflow().size())
                        .as("More Workflows are displayed")
                        .isGreaterThanOrEqualTo(size),
                        "More Workflows are displayed");
        return this;
    }
}
