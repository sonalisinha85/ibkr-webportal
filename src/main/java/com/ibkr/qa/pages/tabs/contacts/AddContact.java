package com.ibkr.qa.pages.tabs.contacts;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddContact extends Contacts {

    public AddContact withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public AddContact withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelAddContacts() {
        return elementVisible(By.xpath("//h4[text()='Configure Contact Profile for Primary Account Holder']"));
    }

    private WebElement dropDownSalutation() {
        return elementVisible(By.xpath("//am-select[contains(@ng-model,'salutation')]/select"));
    }

    private WebElement inputFirstName() {
        return elementVisible(By.xpath("//input[@name='firstName']"));
    }

    private WebElement inputLastName() {
        return elementVisible(By.xpath("//input[@name='lastName']"));
    }

    private WebElement inputPhoneNumber1() {
        return elementVisible(By.xpath("//input[@name='phoneNumber1']"));
    }

    private WebElement dropDownCountry() {
        return elementVisible(By.xpath("//select[@name='country']"));
    }

    private WebElement buttonContinue() {
        return elementVisible(By.xpath("//div[@class='panel-btn-right']//am-button[@btn-text='Continue']"));
    }

    private WebElement labelReviewContactProfile() {
        return elementVisible(By.xpath("//h4[text()='Review Contact Profile']"));
    }

    private WebElement buttonOk() {
        return elementVisible(By.xpath("//am-button[@btn-text='Ok']"));
    }

    private WebElement labelContactAdded(String label) {
        return elementVisible(By.xpath("//h3[contains(text(),'" + label + "')]"));
    }

    public AddContact addAndReviwContactForm(String firstName) {

        reporter.createChild("Add Contacts")
                .assertChild(softly.assertThat(labelAddContacts().isDisplayed())
                                .as("Configure Contact Profile for Primary Account Holder label is displayed")
                                .isEqualTo(true),
                        "Configure Contact Profile for Primary Account Holder label is displayed");

        String lastName = "Test";

        changeDropdown(dropDownSalutation(), "Mr.");
        inputFirstName().sendKeys(firstName);
        inputLastName().sendKeys(lastName);
        inputPhoneNumber1().sendKeys("2019770987");
        changeDropdown(dropDownCountry(), "United States");
        buttonContinue().click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelReviewContactProfile().isDisplayed())
                        .as("Review Contact Profile label is displayed")
                        .isEqualTo(true),
                "Review Contact Profile label is displayed");

        buttonOk().click();

        reporter.assertChild(softly.assertThat(labelContactAdded("Contact " + firstName + " " + lastName + " added.").isDisplayed())
                        .as("Contact added label is displayed")
                        .isEqualTo(true),
                "Contact added label is displayed");

        buttonOk().click();

        return this;
    }
}
