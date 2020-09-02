package com.ibkr.qa.pages.accountapplication;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Agreement extends AccountApplication {

    public Agreement withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public Agreement withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement checkBoxTaxTreaty() {
        return elementPresent(By.xpath("//div[input[@id='usTreatyQualifyT']]"));
    }

    private WebElement dropDownCountry() {
        return elementPresent(By.id("part_2_9a_country_chosen"));
    }

    private WebElement inputCountry() {
        return elementPresent(By.xpath("//div[@id='part_2_9a_country_chosen']//div[@class='chosen-search']/input"));
    }

    private WebElement inputSignature() {
        return elementPresent(By.id("signatures0"));
    }

    private WebElement labelAccountTitle() {
        return elementPresent(By.xpath("//div[label[text()='Account Title']]/p"));
    }

    private WebElement labelSignature() {
        return elementPresent(By.xpath("//label[@for='signatures0']"));
    }

    public AccountApplication fillForm() {

        checkBoxTaxTreaty().click();
        sleep(500);
        dropDownCountry().click();
        inputCountry().sendKeys("China" + Keys.ENTER);

        inputSignature().sendKeys(labelSignature().getText().replace("Signature - ", ""));
        buttonContinue().click();
        sleep(5000);

        inputSignature().sendKeys(labelSignature().getText().replace("Signature - ", ""));
        buttonContinue().click();
        sleep(5000);

        buttonContinue().click();
        sleep(5000);

        reporter.createChild("Agreement Page Validation")
                .childInfo("Agreement Page Filled");

        return (AccountApplication) this;
    }
}
