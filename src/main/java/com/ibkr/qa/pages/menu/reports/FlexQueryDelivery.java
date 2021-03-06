package com.ibkr.qa.pages.menu.reports;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlexQueryDelivery extends FlexQueries {

    public FlexQueryDelivery withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public FlexQueryDelivery withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement buttonConfigure(String flexQueryType) {
        return elementVisible(By.xpath("//span[text()='" + flexQueryType + "']" +
                "/ancestor::section//i[@data-original-title='Configure']"));
    }

    private List<WebElement> checkBoxesUnchecked() {
        return elementsVisible(By.xpath("//div[not(contains(@class,'checked')) and input[@type='checkbox']]"));
    }

    private List<WebElement> checkBoxesChecked() {
        return elementsVisible(By.xpath("//div[contains(@class,'checked') and input[@type='checkbox']]"));
    }

    private List<WebElement> checkBoxes() {
        return elementsVisible(By.xpath("//div[input[@type='checkbox']]"));
    }

    private WebElement buttonContinue() {
        return elementVisible(By.xpath("//div[@class='panel-btn-right']" +
                "//a[@class='btn btn-primary' and contains(text(),'Continue')]"));
    }

    private WebElement labelComplete() {
        return elementVisible(By.xpath("//h1[contains(text(),'Complete')]"));
    }

    private List<WebElement> listRows(String flexQueryType) {
        return elementsVisible(By.xpath("//span[text()='" + flexQueryType + "']" +
                "/ancestor::section//div[@class='row' and @ng-repeat]"));
    }

    public FlexQueryDelivery flexQueryDeliveryConfiguration(String flexQueryType) {

        reporter.createChild("Validate " + flexQueryType);

        buttonFlexQueryDeliveryConfigure().click();
        sleep(1000);
        buttonConfigure(flexQueryType).click();
        sleep(1000);
        uncheckAll();
        random(checkBoxesUnchecked(), 1).get(0).click();
        buttonContinue().click();
        sleep(500);
        buttonContinue().click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(labelComplete().isDisplayed())
                        .as("Delivery Settings complete label is displayed")
                        .isEqualTo(true),
                "Delivery Settings complete label is displayed");

        buttonOk().click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(listRows(flexQueryType).size())
                        .as(flexQueryType + " is created")
                        .isEqualTo(1),
                flexQueryType + " is created");

        buttonConfigure(flexQueryType).click();
        sleep(1000);
        checkBoxesChecked().forEach(checkBox -> checkBox.click());
        buttonContinue().click();
        sleep(500);
        buttonContinue().click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(labelComplete().isDisplayed())
                        .as("Delivery Settings complete label is displayed")
                        .isEqualTo(true),
                "Delivery Settings complete label is displayed");

        buttonOk().click();
        sleep(2000);

        return this;
    }

    private void uncheckAll() {

        checkBoxes().forEach(checkBox -> {

            if (checkBox.getAttribute("class").contains("checked"))
                checkBox.click();
        });
    }

    private void checkAll() {

        checkBoxes().forEach(checkBox -> {

            if (!checkBox.getAttribute("class").contains("checked"))
                checkBox.click();
        });
    }
}
