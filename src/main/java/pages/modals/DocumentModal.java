package pages.modals;

import navigation.Robo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.tabs.Dashboard;
import reporter.TestReporter;
import utils.FileUtil;

import java.util.Arrays;
import java.util.List;

public class DocumentModal extends Dashboard {

    enum Action {Cancel, Upload}

    public DocumentModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public DocumentModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelUploadDocument() {

        return elementPresent(By.xpath("//h4//span[text()='Upload Document']"));
    }

    private WebElement inputContactName() {

        return elementPresent(By.xpath("//am-input/input[@name='addedContactName']"));
    }

    private List<WebElement> radioButtonsContact() {
        return elementsPresent(By.xpath("//tr[@ng-repeat]//div[@class='iradio_square-blue']"));
    }

    protected WebElement buttonAction(Action action) {
        return elementPresent(By.xpath("//am-button[@btn-text='" + action.toString() + "']/a"));
    }

    private WebElement buttonUploadFile() {

        return elementPresent(By.xpath("//label/i[@class='fa fa-upload']"));
    }

    public DocumentModal viewDocument() {

        String documentName = Arrays.asList(random(labelsDocumentLink(), 1).get(0).getText().split("\n")).get(0).trim();
        buttonViewDocument(documentName).get(0).click();
        sleep(1000);

        reporter.createChild("Validate View Document")
                .assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                                .as("Document Name Downloaded")
                                .contains(Arrays.asList(documentName.split("\\.")).get(0)),
                        "Document Name Downloaded");

        return this;
    }

    public DocumentModal addDocument() {

        buttonAddDocument().click();
        sleep(500);

        reporter.createChild("Validate Add Document")
                .assertChild(softly.assertThat(labelUploadDocument().isDisplayed())
                                .as("Upload Document Label is present")
                                .isEqualTo(true),
                        "Upload Document Label is present");

        inputContactName().sendKeys("test");
        random(radioButtonsContact(),1).get(0).click();
        buttonUploadFile().click();
        sleep(1000);
        String filePath = Arrays.asList(this.getClass()
                .getProtectionDomain().getCodeSource().getLocation().getPath()
                .split("webportal")).get(0) + "webportal";

        new Robo()
                .selectFile(filePath.substring(1),"Test.png");
        sleep(1000);

        buttonAction(Action.Upload).click();
        sleep(1000);

        reporter.childInfo("Document uploaded successfully");

        return this;
    }
}
