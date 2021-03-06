package com.ibkr.qa.pages.tabs.contacts;

import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Contacts extends Portal {

    public Contacts withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public Contacts withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    public ContactInformation withContactInformation() {

        return new ContactInformation()
                .withDriver(driver)
                .withReporter(reporter);
    }

    private List<WebElement> buttonsViewContact() {
        return elementsVisible(By.xpath("//section[@class='panel']//i[contains(@class,'fa-info-circle')]"));
    }

    private WebElement buttonAddContact() {
        return elementVisible(By.xpath("//section[@class='panel']//i[@data-original-title='Add Contact']"));
    }

    private WebElement buttonAddContactByManualInput() {
        return elementVisible(By.xpath("//a[text()='Contact by Manual Input']"));
    }

    protected WebElement buttonFilterContact() {
        return elementVisible(By.xpath("//section[@class='panel']//i[@data-original-title='Filters']"));
    }

    protected WebElement buttonSettingsContact() {
        return elementVisible(By.xpath("//section[@class='panel']//i[@data-original-title='Settings']"));
    }

    protected List<WebElement> listColumnType() {
        return elementsVisible(By.xpath("//td[@ng-show]/div[contains(@ng-if,'type')]"));
    }

    protected List<WebElement> listColumnAccountType() {
        return elementsVisible(By.xpath("//table[contains(@ng-if,'account')]//tr[@ng-repeat='account in item.accounts']/td[1]"));
    }

    private List<WebElement> listColumnAccountNumber() {
        return elementsVisible(By.xpath("//tr[@ng-repeat='account in item.accounts']/td[2]"));
    }

    protected List<WebElement> listColumnStatus() {
        return elementsVisible(By.xpath("//tr[@ng-repeat='account in item.accounts']/td[3]"));
    }

    private WebElement inputSearchContact() {
        return elementVisible(By.xpath("//input[@name='filter_contactSearchText']"));
    }

    private WebElement buttonClearSearch() {
        return elementVisible(By.xpath("//span[@class='input-group-addon']/i[@class='fa fa-times']"));
    }

    protected WebElement headerColumn(String columnName) {
        return elementPresent(By.xpath("//th[@ng-show and contains(@class,'ng-hide')]/div[contains(text(),'" + columnName + "')]"));
    }

    private WebElement dropDownPageSize() {
        return elementPresent(By.xpath("//select[@name='pageSize']"));
    }

    private WebElement labelLastPage() {
        return elementPresent(By.xpath("//p[contains(@ng-if,'totalPages')]/span[3]"));
    }

    private WebElement inputPageNumber() {
        return elementPresent(By.xpath("//p[contains(@ng-if,'totalPages')]/input"));
    }

    private WebElement inputPageNumberNoLog() {
        return elementNoLog(By.xpath("//p[contains(@ng-if,'totalPages')]/input"));
    }

    private WebElement buttonPageLeft() {
        return elementPresent(By.xpath("//am-button[@btn-icon='fa-chevron-left']"));
    }

    private WebElement buttonPageRight() {
        return elementPresent(By.xpath("//am-button[@btn-icon='fa-chevron-right']"));
    }

    private WebElement buttonViewContact(String contact) {
        return elementClickable(By.xpath("//div[contains(text(),'" + contact + "')]/ancestor::tr//td/a"));
    }

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public Contacts addContact() {

        firstName = getDateTime();
        tabs(Tabs.Contacts).click();
        sleep(4000);
        buttonAddContact().click();
        buttonAddContactByManualInput().click();
        sleep(1000);

        new AddContact()
                .withDriver(driver)
                .withReporter(reporter)
                .addAndReviwContactForm(firstName);

        return this;
    }

    public Contacts filterContacts() {

        tabs(Tabs.Contacts).click();
        sleep(2000);
        buttonFilterContact().click();
        sleep(500);

        new FilterContactMenu()
                .withDriver(driver)
                .withReporter(reporter)
                .validateFilterMenu()
                .validateFilterResults(FilterContactMenu.Panel.ContactType, "Prospect")
                .resetAllFilters()
                .validateFilterResults(FilterContactMenu.Panel.ClientAccountType, "IRA")
                .resetAllFilters()
                .validateFilterResults(FilterContactMenu.Panel.ClientAccountStatus, "Application - In Progress")
                .resetAllFilters();

        return this;
    }

    public Contacts searchContacts() {

        tabs(Tabs.Contacts).click();
        sleep(2000);

        String accountNumber = listColumnAccountNumber().get(0).getText();
        int recordCount = listColumnAccountNumber().size();
        inputSearchContact().sendKeys(accountNumber);
        inputSearchContact().sendKeys(Keys.ENTER);
        sleep(500);

        reporter.createChild("Search Contacts Validation")
                .assertChild(softly.assertThat(listColumnAccountNumber().get(0).getText())
                                .as("Search Contacts Result")
                                .isEqualTo(accountNumber),
                        "Search Contacts Result");

        buttonClearSearch().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(listColumnAccountNumber().size())
                        .as("Search Contacts Result after clearing")
                        .isEqualTo(recordCount),
                "Search Contacts Result are restored after clearing");

        return this;
    }

    public Contacts searchAndViewContactsByAssociatedName(String contact) {

        menu("Home").click();
        sleep(1000);
        tabs(Tabs.Contacts).click();
        sleep(500);

        changeDropdown(dropDownPageSize(),"100 Results");
        sleep(3000);

        if(!isNotDisplayed(inputPageNumberNoLog())){
            inputPageNumber().clear();
            inputPageNumber().sendKeys(labelLastPage().getText());
            inputPageNumber().sendKeys(Keys.ENTER);
            sleep(3000);
        }

        click(buttonViewContact(contact));
        sleep(1000);

//        inputSearchContact().sendKeys(getFirstName());
//        inputSearchContact().sendKeys(Keys.ENTER);
//        sleep(1000);
//        buttonsViewContact().get(0).click();
//        sleep(1000);

        return this;
    }

    public Contacts viewContact() {

        tabs(Tabs.Contacts).click();
        sleep(2000);
        buttonsViewContact().get(0).click();
        sleep(500);

        new ViewContact()
                .withDriver(driver)
                .withReporter(reporter)
                .validateViewContact();

        return this;
    }

    public Contacts contactSettings() {

        tabs(Tabs.Contacts).click();
        sleep(4000);
        buttonSettingsContact().click();
        sleep(1000);

        new ContactSettings()
                .withDriver(driver)
                .withReporter(reporter)
                .validateSettingsMenu();

        return this;
    }

    public Contacts navigateToContacts() {

        tabs(Tabs.Contacts).click();
        sleep(500);
        return this;
    }

}
