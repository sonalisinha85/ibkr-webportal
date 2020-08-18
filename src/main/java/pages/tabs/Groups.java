package pages.tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AccountSelector;
import pages.Portal;
import pages.tabs.contacts.ViewContact;
import reporter.TestReporter;

import java.util.List;

public class Groups extends Portal {

    enum Action {Yes, No}

    public Groups withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public Groups withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    protected WebElement labelGroups() {
        return elementPresent(By.xpath("//div[@class='crm-page-title']/h4"));
    }

    protected WebElement buttonAdd() {
        return elementPresent(By.xpath("//i[@data-original-title='Add Group']"));
    }

    protected List<WebElement> buttonsDelete() {
        return elementsPresent(By.xpath("//i[@data-original-title='Delete']"));
    }

    protected List<WebElement> buttonsEdit() {
        return elementsPresent(By.xpath("//i[@data-original-title='Edit']"));
    }

    protected List<WebElement> buttonView(String groupName) {
        return elementsPresent(By.xpath("//a[contains(text(),'" + groupName + "')]" +
                "/ancestor::div[@class='panel panel-default']//i[@class='fa fa-info-circle']"));
    }

    protected List<WebElement> labelsGroupName() {
        return elementsPresent(By.xpath("//h4[@class='panel-title']/a"));
    }

    protected WebElement labelGroupName(String groupName) {
        return elementNoLog(By.xpath("//a[contains(text(),'" + groupName + "')]"));
    }

    protected WebElement buttonDelete(String groupName) {
        return elementPresent(By.xpath("//a[contains(text(),'" + groupName + "')]" +
                "/ancestor::h4[@class='panel-title']//i[@data-original-title='Delete']"));
    }

    protected WebElement buttonEdit(String groupName) {
        return elementPresent(By.xpath("//a[contains(text(),'" + groupName + "')]" +
                "/ancestor::h4[@class='panel-title']//i[@data-original-title='Edit']"));
    }
    protected WebElement inputGroupName() {
        return elementPresent(By.xpath("//input[@name='groupName']"));
    }

    protected WebElement buttonAddEditGroupMembers() {
        return elementPresent(By.xpath("//button[contains(text(),'Add/Edit Group Members')]"));
    }

    protected List<WebElement> checkBoxAccountPicker() {
        return elementsPresent(By.xpath("//picker-entry-icon/i"));
    }

    protected WebElement buttonPickerContinue() {
        return elementPresent(By.xpath("//am-button[contains(@on-click,'pickerSubmit')]/a"));
    }

    protected WebElement buttonContinue() {
        return elementPresent(By.xpath("//am-button[contains(@on-click,'continueBtn')]/a"));
    }

    protected WebElement buttonAction(Action action) {
        return elementPresent(By.xpath("//am-button[@btn-text='" + action.toString() + "']/a"));
    }

    protected WebElement buttonReset() {
        return elementPresent(By.xpath("//am-button[@btn-text='Reset']/a"));
    }

    protected WebElement labelReviewGroup() {
        return elementNoLog(By.xpath("//h3/strong"));
    }

    public Groups validateAddGroup() {

        tabs(Tabs.Groups).click();
        sleep(1000);

        reporter.createChild("Add Group Validation")
                .assertChild(softly.assertThat(labelGroups().isDisplayed())
                                .as("Groups label is displayed")
                                .isEqualTo(true),
                        "Groups label is displayed");

        String groupName = "Regression Test " + getCurrentTime();

        buttonAdd().click();
        sleep(500);
        inputGroupName().sendKeys(groupName);
        buttonAddEditGroupMembers().click();

        random(checkBoxAccountPicker(), 2).forEach(element -> element.click());

        buttonPickerContinue().click();
        sleep(500);
        buttonContinue().click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReviewGroup().getText())
                        .as("Group is created")
                        .isEqualTo(groupName),
                "Group "+ groupName + " is created");

        buttonContinue().click();
        sleep(500);

        return this;
    }

    public Groups validateDeleteGroup() {

        tabs(Tabs.Groups).click();
        sleep(1000);

        reporter.createChild("Delete Group Validation")
                .assertChild(softly.assertThat(labelGroups().isDisplayed())
                                .as("Groups label is displayed")
                                .isEqualTo(true),
                        "Groups label is displayed");

        String groupName = random(labelsGroupName(), 1).get(0).getText().trim();

        buttonDelete(groupName).click();
        sleep(500);
        buttonAction(Action.No).click();
        sleep(500);
        buttonDelete(groupName).click();
        sleep(500);
        buttonAction(Action.Yes).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(isNotDisplayed(labelGroupName(groupName)))
                        .as("Group " + groupName + " is deleted")
                        .isEqualTo(true),
                "Group " + groupName + " is deleted");

        return this;
    }

    public Groups validateEditGroup() {

        tabs(Tabs.Groups).click();
        sleep(1000);

        reporter.createChild("Edit Group Validation")
                .assertChild(softly.assertThat(labelGroups().isDisplayed())
                                .as("Groups label is displayed")
                                .isEqualTo(true),
                        "Groups label is displayed");

        String groupName = random(labelsGroupName(), 1).get(0).getText().trim();

        buttonEdit(groupName).click();
        sleep(500);
        buttonAddEditGroupMembers().click();
        sleep(200);
        buttonReset().click();
        sleep(200);
        random(checkBoxAccountPicker(), 3).forEach(element -> element.click());
        buttonPickerContinue().click();
        sleep(500);
        buttonContinue().click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReviewGroup().getText())
                        .as("Group is edited")
                        .isEqualTo(groupName),
                "Group "+ groupName + " is edited");

        buttonContinue().click();
        sleep(500);

        return this;
    }

    public Groups validateViewGroup() {

        tabs(Tabs.Groups).click();
        sleep(1000);

        reporter.createChild("View Group Validation")
                .assertChild(softly.assertThat(labelGroups().isDisplayed())
                                .as("Groups label is displayed")
                                .isEqualTo(true),
                        "Groups label is displayed");

        WebElement element = random(labelsGroupName(), 1).get(0);
        String groupName = element.getText().trim();

        element.click();
        sleep(200);
        random(buttonView(groupName), 1).get(0).click();
        sleep(500);

        new AccountSelector()
                .withDriver(driver)
                .withReporter(reporter)
                .selectAccount();

        new ViewContact()
                .withDriver(driver)
                .withReporter(reporter)
                .validateViewContact();

        return this;
    }
}
