package pages.client.portfolioanalyst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.client.modals.AddExternalAccountModal;
import reporter.TestReporter;

import java.util.List;

public class ExternalAccount extends PortfolioAnalyst {

    public ExternalAccount withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public ExternalAccount withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement buttonExternalAccountBeta() {
        return elementPresent(By.xpath("//a[contains(.,'External Accounts (Beta)')]"));
    }

    private WebElement buttonAdd() {
        return elementPresent(By.xpath("//i[@data-original-title='Add']"));
    }

    private WebElement dropDownAccountType() {
        return elementPresent(By.xpath("//select[@name='type']"));
    }

    private WebElement inputAccountTitle() {
        return elementPresent(By.xpath("//am-input[contains(@ng-model,'title')]/input"));
    }

    private WebElement dropDownCurrency() {
        return elementPresent(By.xpath("//am-select[contains(@options,'currencies')]/select"));
    }

    private WebElement dropDownDate() {

        return elementPresent(By.xpath("//input[@name='date']"));
    }

    private List<WebElement> datePicker() {
        return elementsPresent(By.xpath("//div[@class='datepicker-days']//tr/td[not(contains(@class,'disabled'))]"));
    }

    private WebElement inputValue() {
        return elementPresent(By.xpath("//am-input[contains(@ng-model,'amt')]/input"));
    }

    private WebElement buttonContinue() {
        return elementPresent(By.xpath("//div[@class='panel-body']//am-button[@btn-text='Continue']"));
    }

    private WebElement labelSuccess() {
        return elementPresent(By.xpath("//h1[contains(.,'Your account has been added!')]"));
    }

    private WebElement buttonOk() {
        return elementPresent(By.xpath("//a[contains(.,'Ok')]"));
    }

    private WebElement labelAccountTitle(String title) {
        return elementPresent(By.xpath("//p[contains(.,'" + title + "')]"));
    }

    public ExternalAccount addExternalAccount() {

        buttonMenu().click();
        sleep(500);
        menu("PortfolioAnalyst").click();
        sleep(2000);

        reporter.createChild("Validate Add External Account")
                .assertChild(softly.assertThat(labelPortfolioAnalyst().isDisplayed())
                                .as("PortfolioAnalyst Label is displayed")
                                .isEqualTo(true),
                        "PortfolioAnalyst Label is displayed");

        buttonExternalAccountBeta().click();
        sleep(1000);
        buttonAdd().click();
        sleep(1000);

        new AddExternalAccountModal()
                .withDriver(driver)
                .withReporter(reporter)
                .navigate();

        String title = "Regression Test " + getCurrentTime();
        changeDropdown(dropDownAccountType(), "Other Asset");
        inputAccountTitle().sendKeys(title);
        changeDropdown(dropDownCurrency(), "USD");
        dropDownDate().click();
        datePicker().get(datePicker().size() - 1).click();
        inputValue().sendKeys("900");
        buttonContinue().click();
        sleep(1000);
        buttonContinue().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelSuccess().isDisplayed())
                        .as("Your account has been added Label is displayed")
                        .isEqualTo(true),
                "Your account has been added Label is displayed");
        buttonOk().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelAccountTitle(title).isDisplayed())
                        .as(title + " account is created")
                        .isEqualTo(true),
                title + " account is created");

        return this;
    }
}