package pages.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.menu.PortfolioAnalyst;
import reporter.TestReporter;

public class SynopsesModal extends PortfolioAnalyst {

    enum Action {Save,Cancel,Edit,Yes,No,Close}

    public SynopsesModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public SynopsesModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelCreateNewSynopses() {
        return elementPresent(By.xpath("//span[text()='Create New Synopsis']"));
    }

    private WebElement labelDeleteSynopses() {
        return elementPresent(By.xpath("//span[text()='Delete Synopsis']"));
    }

    private WebElement labelDeleteSuccess() {
        return elementPresent(By.xpath("//div[@class='alert alert-success']"));
    }

    private WebElement inputName() {
        return elementPresent(By.xpath("//input[@name='title']"));
    }

    private WebElement inputText() {
        return elementPresent(By.xpath("//textarea[@name='text']"));
    }

    private WebElement buttonAction(Action action){
        return elementPresent(By.xpath("//am-button[@btn-text='" + action.toString() + "']"));
    }

    private WebElement labelSynopsesName(String name) {
        return elementPresent(By.xpath("//span[contains(.,'" + name + "')]"));
    }

    public SynopsesModal createSynopses(){

        buttonCreateSynopses().click();
        sleep(1000);

        reporter.createChild("Create Synopses Validation")
                .assertChild(softly.assertThat(labelCreateNewSynopses().isDisplayed())
                                .as("Create Synopses label is displayed")
                                .isEqualTo(true),
                        "Create Synopses label is displayed");

        String name = getCurrentTime();
        inputName().sendKeys(name);
        inputText().sendKeys(name);
        buttonAction(Action.Save).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelSynopsesName(name).isDisplayed())
                                .as(name + " Synopses is created")
                                .isEqualTo(true),
                name + " Synopses is created");

        return this;
    }

    public SynopsesModal editSynopses(){

        random(buttonsViewSynopses(),1).get(0).click();
        sleep(1000);

        buttonAction(Action.Edit).click();

        String name = getCurrentTime();
        inputName().clear();
        inputName().sendKeys(name);
        buttonAction(Action.Save).click();
        sleep(1000);

        reporter.createChild("Delete Synopses Validation")
                .assertChild(softly.assertThat(labelSynopsesName(name).isDisplayed())
                        .as(name + " Synopses is updated")
                        .isEqualTo(true),
                name + " Synopses is updated");

        return this;
    }

    public SynopsesModal deleteSynopses(){

        random(buttonsDeleteSynopses(),1).get(0).click();
        sleep(1000);

        reporter.createChild("Delete Synopses Validation")
                .assertChild(softly.assertThat(labelDeleteSynopses().isDisplayed())
                                .as("Delete Synopses label is displayed")
                                .isEqualTo(true),
                        "Delete Synopses label is displayed");

        buttonAction(Action.No).click();
        sleep(1000);

        random(buttonsDeleteSynopses(),1).get(0).click();
        sleep(1000);
        buttonAction(Action.Yes).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelDeleteSuccess().isDisplayed())
                        .as(" Synopses is delete")
                        .isEqualTo(true),
                " Synopses is delete");

        buttonAction(Action.Close).click();
        sleep(1000);

        return this;
    }
}
