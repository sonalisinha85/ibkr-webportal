package pages.tabs.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Portal;
import reporter.TestReporter;

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

    private List<WebElement> buttonsViewContact() {
        return elementsPresent(By.xpath("//section[@class='panel']//i[contains(@class,'fa-info-circle')]"));
    }

    private WebElement buttonAddContact() {
        return elementPresent(By.xpath("//section[@class='panel']//i[@data-original-title='Add Contact']"));
    }

    private WebElement buttonAddContactByManualInput() {
        return elementPresent(By.xpath("//a[text()='Contact by Manual Input']"));
    }

    protected WebElement buttonFilterContact() {
        return elementPresent(By.xpath("//section[@class='panel']//i[@data-original-title='Filters']"));
    }

    protected WebElement buttonSettingsContact() {
        return elementPresent(By.xpath("//section[@class='panel']//i[@data-original-title='Settings']"));
    }

    protected List<WebElement> listColumnType() {
        return elementsPresent(By.xpath("//td[contains(@ng-show,'type')]"));
    }

    protected List<WebElement> listColumnAccountType() {
        return elementsPresent(By.xpath("//td[contains(@ng-show,'accounts')]//tr[@ng-repeat='account in item.accounts']/td[1]"));
    }

    private List<WebElement> listColumnAccountNumber() {
        return elementsPresent(By.xpath("//td[contains(@ng-show,'accounts')]//tr[@ng-repeat='account in item.accounts']/td[2]"));
    }

    protected List<WebElement> listColumnStatus() {
        return elementsPresent(By.xpath("//td[contains(@ng-show,'accounts')]//tr[@ng-repeat='account in item.accounts']/td[3]"));
    }

    private WebElement inputSearchContact() {
        return elementPresent(By.xpath("//input[@name='filter_contactSearchText']"));
    }

    private WebElement buttonClearSearch() {
        return elementPresent(By.xpath("//span[@class='input-group-addon']/i[@class='fa fa-times']"));
    }

    protected WebElement headerColumn(String columnName) {
        return elementPresent(By.xpath("//th[@ng-show and contains(@class,'ng-hide') and contains(text(),'" + columnName + "')]"));
    }

    public Contacts addContact() {

        tabs(Tabs.Contacts).click();
        sleep(500);
        buttonAddContact().click();
        buttonAddContactByManualInput().click();
        sleep(1000);

        new AddContact()
                .withDriver(driver)
                .withReporter(reporter)
                .addAndReviwContactForm();

        return this;
    }

    public Contacts filterContacts() {

        tabs(Tabs.Contacts).click();
        sleep(500);
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
        sleep(500);

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

    public Contacts viewContact() {

        tabs(Tabs.Contacts).click();
        sleep(500);
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
        sleep(500);
        buttonSettingsContact().click();
        sleep(500);

        new ContactSettings()
                .withDriver(driver)
                .withReporter(reporter)
                .validateSettingsMenu();

        return this;
    }

}
