package com.ibkr.qa.pages.accountapplication.chinesenative;

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

    private WebElement checkBoxConsent() {
        return elementPresent(By.xpath("//div[input[@type='checkbox']]"));
    }

    private WebElement dropDownCountry() {
        return elementPresent(By.id("part_2_9a_country_chosen"));
    }

    private WebElement checkBoxAustraliaTaxTrue() {
        return elementPresent(By.id("AusQualifyT"));
    }

    private WebElement dropDownAustraliaTreaty() {
        return elementPresent(By.id("AusTreatyCountry_chosen"));
    }

    private WebElement inputAustraliaOption() {
        return elementPresent(By.xpath("//div[@id='AusTreatyCountry_chosen']//div[@class='chosen-search']/input"));
    }

    private WebElement checkBoxAustraliaTaxFalse() {
        return elementPresent(By.id("AusQualifyF"));
    }

    private WebElement checkBoxCanadaTaxTrue() {
        return elementPresent(By.id("CanQualifyT"));
    }

    private WebElement dropDownCanadaTreaty() {
        return elementPresent(By.id("CanTreatyCountry_chosen"));
    }

    private WebElement inputCanadaOption() {
        return elementPresent(By.xpath("//div[@id='CanTreatyCountry_chosen']//div[@class='chosen-search']/input"));
    }

    private WebElement checkBoxCanadaTaxFalse() {
        return elementPresent(By.id("CanQualifyF"));
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

        dropDownAustraliaTreaty().click();
        inputAustraliaOption().sendKeys("China" + Keys.ENTER);

        inputSignature().sendKeys(labelSignature().getText().replace("Signature - ", ""));
        checkBoxConsent().click();
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
