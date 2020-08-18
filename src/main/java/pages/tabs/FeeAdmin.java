package pages.tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Portal;
import reporter.TestReporter;

import java.util.List;

public class FeeAdmin extends Portal {

    enum AdminFunction {Configure_Client_Fees,Configure_Client_Fee_Templates,Invoicing,Fee_Reimbursement}
    enum Action {Continue,Ok,Yes,No,Close,Reset}

    public FeeAdmin withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public FeeAdmin withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelFeeAdmin() {
        return elementPresent(By.xpath("//div[@class='panel-heading']/span[text()='Fee Administration']"));
    }

    private WebElement buttonConfigureFee(AdminFunction adminFunction) {
        return elementPresent(By.xpath("//p//span[text()='" + adminFunction.toString().replaceAll("_"," ") + "']"));
    }

    private WebElement labelConfigureClientFeeTemplate() {
        return elementPresent(By.xpath("//span[@class='heading' and contains(text(),'Configure Client Fee Templates')]"));
    }

    private WebElement labelClientFees() {
        return elementPresent(By.xpath("//span[@class='heading' and contains(text(),'Client Fees')]"));
    }

    private WebElement buttonAdd(){
        return elementPresent(By.xpath("//section[@class='panel']//i[@data-original-title='Add']"));
    }

    private WebElement labelCreateClientFeeTemplate() {
        return elementPresent(By.xpath("//h4[text()='Create a Client Fee Template']"));
    }

    private WebElement labelResendConfirmationNumber() {
        return elementNoLog(By.xpath("//a[contains(.,'Resend Confirmation Number')]"));
    }

    private WebElement inputTemplateName(){
        return elementPresent(By.xpath("//input[@name='templateName']"));
    }

    private WebElement buttonAction(Action action){
        return elementPresent(By.xpath("//p/am-button[@btn-text='" + action.toString() + "']"));
    }

    private WebElement labelClientFeeTemplateSuccess() {
        return elementPresent(By.xpath("//h3[text()='Your client fee template has been created.']"));
    }

    private WebElement buttonDelete(String templateName){
        return elementPresent(By.xpath("//p/strong[text()='" + templateName + "']" +
                "/ancestor::div[@ng-repeat]//i[@data-original-title='Delete']"));
    }

    private WebElement labelDeleteSuccess(String templateName){
        return elementPresent(By.xpath("//p[text()='" + templateName + " has been deleted.']"));
    }

    private List<WebElement> buttonsApply(){
        return elementsPresent(By.xpath("//section//i[@data-original-title='Apply']"));
    }

    private WebElement buttonEdit(){
        return elementPresent(By.xpath("//i[@data-original-title='Edit']"));
    }

    private WebElement labelApplyFeeTemplate() {
        return elementPresent(By.xpath("//h4[text()='Apply Fee Template']"));
    }

    private WebElement buttonAddAccount() {
        return elementPresent(By.xpath("//am-picker-button/button[text()='Add/Edit Account(s)']"));
    }

    private List<WebElement> checkboxesAccountPicker() {
        return elementsPresent(By.xpath("//i[contains(@ng-if,'pickerEntry')]"));
    }

    private WebElement buttonAccountPickerAction(Action action){
        return elementPresent(By.xpath("//div/am-button[@btn-text='" + action.toString() + "']"));
    }

    private WebElement labelApplyFeeTemplateSuccess() {
        return elementPresent(By.xpath("//h5[@translate='applyFeesTemplate.result.SUCCESS']"));
    }

    public FeeAdmin configureClientFeeTemplateNavigation(){

        tabs(Tabs.Fee_Administration).click();
        sleep(500);

        reporter.createChild("Fee Admin Validation")
                .assertChild(softly.assertThat(labelFeeAdmin().isDisplayed())
                                .as("Fee Admin Label is displayed")
                                .isEqualTo(true),
                        "Fee Admin Label is displayed");

        buttonConfigureFee(AdminFunction.Configure_Client_Fee_Templates).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelConfigureClientFeeTemplate().isDisplayed())
                        .as("Configure Client Fee Template label is displayed")
                        .isEqualTo(true),
                "Configure Client Fee Template label is displayed");

        return this;
    }


    public FeeAdmin addAndDeleteClientFeeTemplate(){

        buttonAdd().click();
        sleep(1000);

        reporter.createChild("Create Client Fee Template Validation")
                .assertChild(softly.assertThat(labelCreateClientFeeTemplate().isDisplayed())
                        .as("Create a Client Fee Template label is displayed")
                        .isEqualTo(true),
                "Create a Client Fee Template label is displayed");

        String templateName = "Regression Test " + getCurrentTime();
        inputTemplateName().sendKeys(templateName);
        buttonAction(Action.Continue).click();
        sleep(500);
        buttonAction(Action.Continue).click();
        sleep(500);
        buttonAction(Action.Continue).click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelClientFeeTemplateSuccess().isDisplayed())
                        .as("Client Fee Template label is successfully created")
                        .isEqualTo(true),
                "Client Fee Template label is successfully created");

        buttonAction(Action.Ok).click();
        sleep(1000);

        buttonDelete(templateName).click();
        sleep(500);
        buttonAction(Action.Yes).click();
        sleep(500);

        reporter.createChild("Delete Client Fee Template Validation")
                .assertChild(softly.assertThat(labelDeleteSuccess(templateName).isDisplayed())
                        .as("Client Fee Template label is successfully delete")
                        .isEqualTo(true),
                "Client Fee Template label is successfully delete");

        buttonAction(Action.Close).click();
        sleep(1000);

        return this;
    }

    public FeeAdmin applyClientFeeTemplate(){

        random(buttonsApply(),1).get(0).click();
        sleep(1000);

        reporter.createChild("Apply Fee Template Validation")
                .assertChild(softly.assertThat(labelApplyFeeTemplate().isDisplayed())
                                .as("Apply Fee Template label is displayed")
                                .isEqualTo(true),
                        "Apply Fee Template label is displayed");

        buttonAddAccount().click();
        sleep(500);
        random(checkboxesAccountPicker(),1).get(0).click();
        buttonAccountPickerAction(Action.Continue).click();
        sleep(500);
        buttonAction(Action.Continue).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelApplyFeeTemplateSuccess().isDisplayed())
                        .as("Fee Template label is successfully applied")
                        .isEqualTo(true),
                "Fee Template label is successfully applied");

        buttonAction(Action.Ok).click();
        sleep(1000);

        return this;
    }

    public FeeAdmin configureClientFee(){

        tabs(Tabs.Fee_Administration).click();
        sleep(500);

        reporter.createChild("Fee Admin Validation")
                .assertChild(softly.assertThat(labelFeeAdmin().isDisplayed())
                                .as("Fee Admin Label is displayed")
                                .isEqualTo(true),
                        "Fee Admin Label is displayed");

        buttonConfigureFee(AdminFunction.Configure_Client_Fees).click();
        sleep(1000);

        random(checkboxesAccountPicker(),1).get(0).click();
        buttonAccountPickerAction(Action.Continue).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelClientFees().isDisplayed())
                        .as("Client Fees label is displayed")
                        .isEqualTo(true),
                "Client Fees label is displayed");

        buttonEdit().click();
        sleep(1000);

        while(isNotDisplayed(labelResendConfirmationNumber())){

            buttonAction(Action.Continue).click();
            sleep(1500);
        }

        return this;
    }
}
