package com.ibkr.qa.pages.menu;

import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PreTradeCompliance extends Portal {

    public PreTradeCompliance withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public PreTradeCompliance withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

//    private List<String> restrictionMethods = new ArrayList(
//            Arrays.asList(
//                    "Trading Restriction",
//                    "Holding Restriction"
////                    "WhiteList Symbols"
//            ));
//
//    private List<String> rules = new ArrayList(
//            Arrays.asList(
//                    "Net Margin",
//                    "Liquidation/Closing-only",
//                    "Issuer of Symbol",
//                    "Symbol (Underlying)",
//                    "Product or Security Type",
//                    "Custom Trading Hours",
//                    "Orders by Side",
//                    "No Negative Cash",
//                    "Days To Expiration"
//            ));

    private WebElement labelPreTradeCompliance() {
        return elementVisible(By.xpath("//span[text()='Pre-Trade Compliance']"));
    }

    private WebElement labelRestrictions() {
        return elementVisible(By.xpath("//h5[text()='Restrictions']"));
    }

    private List<WebElement> linksRestrictionName() {
        return elementsVisible(By.xpath("//tr//a[@href]"));
    }

    private WebElement linkRestrictionName(String name) {
        return elementVisible(By.xpath("//td/a[text()='" + name + "']"));
    }

    private WebElement buttonNewRestriction() {
        return elementVisible(By.xpath("//button[text()='New Restriction']"));
    }

    private List<WebElement> buttonsRemove() {
        return elementsVisible(By.xpath("//button[@title='Remove']"));
    }

    private List<WebElement> buttonsCopy() {
        return elementsVisible(By.xpath("//button[@title='Copy']"));
    }


    private WebElement selectRestrictionMethod() {
        return elementVisible(By.xpath("//label[text()='Select Restriction Method']/ancestor::span[@role='combobox']"));
    }

    private WebElement inputName() {
        return elementVisible(By.xpath("//input[@name='name']"));
    }

    private WebElement listSelection(String selection) {
        return elementVisible(By.xpath("//li[text()='" + selection + "']"));
    }

    private WebElement selectAddRule() {
        return elementVisible(By.xpath("//label[contains(text(),'Add rule')]/ancestor::span[@role='combobox']"));
    }

    private WebElement buttonSave() {
        return elementVisible(By.xpath("//button[contains(text(),'Save')]"));
    }

    private WebElement buttonCancel() {
        return elementVisible(By.xpath("//button[contains(text(),'Cancel')]"));
    }

    private WebElement buttonDelete() {
        return elementVisible(By.xpath("//button[contains(text(),'Delete')]"));
    }

    private WebElement form() {
        return elementVisible(By.xpath("//form"));
    }

    public PreTradeCompliance validateNewRestriction() {

        navigateToPreTradeCompliance("Validate New Restriction");

        String name = "Regression Test " + getCurrentTime();

        buttonNewRestriction().click();
        sleep(1000);
        selectRestrictionMethod().click();
        sleep(200);
        listSelection("Trading Restriction").click();
        sleep(200);

        inputName().sendKeys(name);
        selectAddRule().click();
        sleep(200);
        listSelection("No Negative Cash").click();
        sleep(200);
        buttonSave().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(linkRestrictionName(name).isDisplayed())
                        .as(name + " restriction is created")
                        .isEqualTo(true),
                name + " restriction is created");

        switchToMainTab();
        sleep(1000);

        return this;
    }

    public PreTradeCompliance validateCopyRestriction() {

        navigateToPreTradeCompliance("Validate Copy Restriction");

        int count = linksRestrictionName().size();

        random(buttonsCopy(), 1).get(0).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(linksRestrictionName().size())
                        .as("Restriction is copied [Old Restrictions count vs New Restrictions count validated]")
                        .isEqualTo(count + 1),
                "Restriction is copied [Old Restrictions count vs New Restrictions count validated]");

        switchToMainTab();
        sleep(1000);

        return this;
    }

    public PreTradeCompliance validateDeleteRestriction() {

        navigateToPreTradeCompliance("Validate Delete Restriction");

        int count = linksRestrictionName().size();

        random(buttonsRemove(), 1).get(0).click();
        sleep(1000);
        buttonDelete().click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(linksRestrictionName().size())
                        .as("Restriction is deleted [Old Restrictions count vs New Restrictions count validated]")
                        .isEqualTo(count - 1),
                "Restriction is deleted [Old Restrictions count vs New Restrictions count validated]");

        switchToMainTab();
        sleep(1000);

        return this;
    }

    public PreTradeCompliance validateViewRestriction() {

        navigateToPreTradeCompliance("Validate View Restriction");

        random(linksRestrictionName(), 1).get(0).click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(form().isDisplayed())
                        .as("Restriction form is displayed")
                        .isEqualTo(true),
                "Restriction form is displayed");

        buttonCancel().click();
        sleep(1000);

        switchToMainTab();
        sleep(1000);

        return this;
    }


    private void navigateToPreTradeCompliance(String description) {

        menu("Pre-Trade Compliance").click();
        sleep(4000);

        switchToDefaultContext();
        switchTab();

        reporter.createChild(description)
                .assertChild(softly.assertThat(labelPreTradeCompliance().isDisplayed())
                                .as("Pre Trade Compliance label is displayed")
                                .isEqualTo(true),
                        "Pre Trade Compliance label is displayed")
                .assertChild(softly.assertThat(labelRestrictions().isDisplayed())
                                .as("Restrictions label is displayed")
                                .isEqualTo(true),
                        "Restrictions label is displayed");
    }
}
