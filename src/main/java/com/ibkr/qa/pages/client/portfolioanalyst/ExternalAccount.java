package com.ibkr.qa.pages.client.portfolioanalyst;

import com.ibkr.qa.pages.client.modals.AddExternalAccountModal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        return elementVisible(By.xpath("//a[contains(.,'External Accounts (Beta)')]"));
    }

    private WebElement buttonAdd() {
        return elementVisible(By.xpath("//i[@data-original-title='Add']"));
    }

    private WebElement dropDownAccountType() {
        return elementVisible(By.xpath("//select[@name='type']"));
    }

    private WebElement inputAccountTitle() {
        return elementVisible(By.xpath("//am-input[contains(@ng-model,'title')]/input"));
    }

    private WebElement dropDownCurrency() {
        return elementVisible(By.xpath("//am-select[contains(@options,'currencies')]/select"));
    }

    private WebElement dropDownDate() {

        return elementVisible(By.xpath("//input[@name='date']"));
    }

    private List<WebElement> datePicker() {
        return elementsVisible(By.xpath("//div[@class='datepicker-days']//tr/td[not(contains(@class,'disabled'))]"));
    }

    private WebElement inputValue() {
        return elementVisible(By.xpath("//am-input[contains(@ng-model,'amt')]/input"));
    }

    private WebElement buttonContinue() {
        return elementVisible(By.xpath("//div[@class='panel-body']//am-button[@btn-text='Continue']"));
    }

    private WebElement labelSuccess() {
        return elementVisible(By.xpath("//h1[contains(.,'Your account has been added!')]"));
    }

    private WebElement buttonOk() {
        return elementVisible(By.xpath("//a[contains(.,'Ok')]"));
    }

    private WebElement labelAccountTitle(String title) {
        return elementVisible(By.xpath("//p[contains(.,'" + title + "')]"));
    }

    public ExternalAccount addExternalAccount() {

        navigateToPortfolioAnalyst("Validate Add External Account");

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