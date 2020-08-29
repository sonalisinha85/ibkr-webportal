package com.ibkr.qa.pages.tabs;

import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.pages.modals.DocumentModal;
import com.ibkr.qa.pages.modals.EventModal;
import com.ibkr.qa.pages.modals.NotesModal;
import com.ibkr.qa.pages.modals.WorkflowModal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Dashboard extends Portal {

    public Dashboard withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public Dashboard withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    public WorkflowModal withWorkflowModal() {

        return new WorkflowModal()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public NotesModal withNotesModal() {

        return new NotesModal()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public DocumentModal withDocumentModal() {

        return new DocumentModal()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public EventModal withEventModal() {

        return new EventModal()
                .withDriver(driver)
                .withReporter(reporter);
    }

    protected List<WebElement> buttonsViewWorkflow() {
        return elementsPresent(By.xpath("//section[@class='panel crm-workflows']//i[contains(@class,'fa-info-circle')]"));
    }

    protected WebElement buttonAddWorkflow() {
        return elementPresent(By.xpath("//section[@class='panel crm-workflows']//i[@data-original-title='Add Workflow']"));
    }

    protected List<WebElement> buttonsEditWorkflow() {
        return elementsPresent(By.xpath("//section[@class='panel crm-workflows']//i[@data-original-title='Edit Workflow']"));
    }

    protected List<WebElement> buttonsDeleteWorkflow() {
        return elementsPresent(By.xpath("//section[@class='panel crm-workflows']//i[@data-original-title='Delete Workflow']"));
    }

    protected WebElement buttonAddNotes() {
        return elementPresent(By.xpath("//section[@id='crm-notes']//i[@data-original-title='Add']"));
    }

    protected List<WebElement> buttonsEditNotes() {
        return elementsPresent(By.xpath("//section[@id='crm-notes']//i[@data-original-title='Edit Note']"));
    }

    protected List<WebElement> buttonsDeleteNotes() {
        return elementsPresent(By.xpath("//section[@id='crm-notes']//i[@data-original-title='Delete Note']"));
    }

    protected WebElement buttonViewMoreWorkflows() {
        return elementPresent(By.xpath("//p/a[text()='View More Workflows']"));
    }

    protected WebElement buttonViewMoreNotes() {
        return elementPresent(By.xpath("//p/a[text()='View More Notes']"));
    }

    protected List<WebElement> listWorkflow() {
        return elementsPresent(By.xpath("//div[@class='from-bordered' and @id='workflow-list']"));
    }

    protected List<WebElement> listNotes() {
        return elementsPresent(By.xpath("//li[@ng-repeat='nt in $ctrl.notes']"));
    }

    protected WebElement buttonAddDocument() {
        return elementPresent(By.xpath("//section[@id='crm-documents-id']//i[@data-original-title='Add']"));
    }

    protected List<WebElement> labelsDocumentLink() {
        return elementsPresent(By.xpath("//section[@id='crm-documents-id']//p[@ng-repeat]/span[@class='link-label']"));
    }

    protected WebElement labelDocumentLink(String documentName) {
        return elementPresent(By.xpath("//section[@id='crm-documents-id']//p[@ng-repeat]" +
                "/span[@class='link-label' and contains(.,'" + documentName + "')]"));
    }

    protected List<WebElement> buttonViewDocument(String documentName) {
        return elementsPresent(By.xpath("//span[@class='link-label' and contains(text(),'" + documentName + "')]" +
                "/ancestor::section[@id='crm-documents-id']//p[@ng-repeat]//am-button[@tooltip-text='View']"));
    }

    protected WebElement labelAum() {
        return elementPresent(By.xpath("//div[@class='panel-heading']/span[text()='Assets Under Management (AUM)']"));
    }

    protected WebElement labelConsolidatedAum() {
        return elementPresent(By.xpath("//span[text()='Consolidated']/ancestor::h5/span[text()!='Consolidated']"));
    }

    protected WebElement labelChangeInUsd() {
        return elementPresent(By.xpath("//span[contains(text(),'Change in')]/ancestor::h5/span[not(contains(text(),'Change in'))]"));
    }

    private WebElement buttonNav() {
        return elementPresent(By.xpath("//*[local-name()='g']//*[local-name()='tspan' and text()='Net Asset Value']"));
    }

    private WebElement buttonReturn() {
        return elementPresent(By.xpath("//*[local-name()='g']//*[local-name()='tspan' and text()='Return']"));
    }

    protected WebElement labelMasterAccountBalance() {
        return elementPresent(By.xpath("//div[@class='panel-heading']/span[text()='Master Account Balance']"));
    }

    protected WebElement labelMasterAccountBalanceUsd() {
        return elementPresent(By.xpath("//section[contains(@ng-if,'MasterBalance')]//h5/span"));
    }

    protected WebElement buttonAddEvent() {
        return elementPresent(By.xpath("//section[@class='panel crm-calendar']//i[@data-original-title='Add']"));
    }

    protected List<WebElement> buttonEditEvent() {
        return elementsPresent(By.xpath("//section[@class='panel crm-calendar']//a[@class='editEvent fa fa-pencil']"));
    }

    protected WebElement labelEventName(String name) {
        return elementPresent(By.xpath("//section[@class='panel crm-calendar']//a[contains(text(),'" + name + "')]"));
    }

    private WebElement buttonViewFullCalendar() {
        return elementPresent(By.xpath("//section[@class='panel crm-calendar']//a[@class='btn-view-all']"));
    }

    public Dashboard validateAum() {

        buttonNav().click();
        buttonReturn().click();
        buttonNav().click();
        buttonReturn().click();

        reporter.createChild("Assets Under Management (AUM) Validation")
                .assertChild(softly.assertThat(labelAum().isDisplayed())
                                .as("Assets Under Management (AUM) section is displayed")
                                .isEqualTo(true),
                        "Assets Under Management (AUM) section is displayed")
                .assertChild(softly.assertThat(labelConsolidatedAum().isDisplayed())
                                .as("Consolidated AUM is displayed")
                                .isEqualTo(true),
                        "Consolidated AUM is displayed")
                .assertChild(softly.assertThat(labelChangeInUsd().isDisplayed())
                                .as("Change in USD is displayed")
                                .isEqualTo(true),
                        "Change in USD is displayed");

        return this;
    }

    public Dashboard validateMasterAccountBalance() {

        reporter.createChild("Master Account Balance Validation")
                .assertChild(softly.assertThat(labelMasterAccountBalance().isDisplayed())
                                .as("Master Account Balance section is displayed")
                                .isEqualTo(true),
                        "Master Account Balance section is displayed")
                .assertChild(softly.assertThat(labelMasterAccountBalanceUsd().isDisplayed())
                                .as("Master Account Balance amount is displayed")
                                .isEqualTo(true),
                        "Master Account Balance amount is displayed");

        return this;
    }

    public Dashboard viewFullCalendar() {

        buttonViewFullCalendar().click();
        sleep(1000);

        new Calendar()
                .withDriver(driver)
                .withReporter(reporter)
                .viewFullCalendar();

        return this;
    }
}
