package com.ibkr.qa.pages.client.portfolioanalyst;

import com.ibkr.qa.pages.client.modals.AllHoldingsModal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FundParser extends PortfolioAnalyst {

    private List<String> concentrationReportSections = new ArrayList(
            Arrays.asList(
                    "Holdings",
                    "Asset Class Allocation",
                    "Sector Allocation",
                    "Region Allocation",
                    "Country Allocation",
                    "Financial Instrument Allocation",
                    "Exposure"
            ));

    public FundParser withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public FundParser withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelConcentrationReport() {
        return elementVisible(By.xpath("//div[@ng-controller='ConcentrationReportCtrl as ctrl']"));
    }

    private WebElement labelSection(String sectionName) {
        return elementVisible(By.xpath("//span[text()='" + sectionName + "']/ancestor::section[@class='panel']"));
    }

    private WebElement buttonViewAll() {
        return elementVisible(By.xpath("//a[contains(text(),'View All')]"));
    }

    private WebElement textBoxFundSearch() {
        return elementVisible(By.xpath("//input[@name='fundSearch']"));
    }

    private List<WebElement> labelsFund() {
        return elementsVisible(By.xpath("//div[@ng-repeat='fund in $ctrl.list']"));
    }

    private WebElement buttonSearch() {
        return elementVisible(By.xpath("//i[@class='fa fa-search']"));
    }

    private WebElement labelFundHeader(String fundName) {
        return elementVisible(By.xpath("//span[contains(. ,'Fund Parser (" + fundName + "')]"));
    }

    private WebElement labelFundDesc(String fundDesc) {
        return elementVisible(By.xpath("//p[contains(.,'" + fundDesc + "')]"));
    }

    private WebElement sectionMutualFundSummary() {
        return elementVisible(By.xpath("//div[contains(@ng-if,'FundSummary')]//section"));
    }

    public FundParser validateConcentrationReport() {

        navigateToFundParser("Concentration Report Validation");

        reporter.assertChild(softly.assertThat(labelConcentrationReport().isDisplayed())
                        .as("Concentration Report Label is displayed")
                        .isEqualTo(true),
                "Concentration Report Label is displayed");

        concentrationReportSections.forEach(sectionName ->
                reporter.assertChild(softly.assertThat(labelSection(sectionName).isDisplayed())
                                .as(sectionName + " section is displayed")
                                .isEqualTo(true),
                        sectionName + " section is displayed"));

        buttonViewAll().click();
        sleep(1000);

        new AllHoldingsModal()
                .withDriver(driver)
                .withReporter(reporter)
                .validateAllHoldingsModal();

        return this;
    }

    public FundParser validateExchangeTradedFundSearch() {

        navigateToFundParser("ETF Search Validation");

        String symbol = "TQQQ";
        textBoxFundSearch().sendKeys(symbol);
        sleep(1000);
        random(labelsFund(), 1).get(0).click();
        sleep(1000);
        buttonSearch().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelFundHeader(symbol).isDisplayed())
                        .as(symbol + " fund header is displayed")
                        .isEqualTo(true),
                symbol + " fund header is displayed");

        return this;
    }

    public FundParser validateMutualFundSearch() {

        navigateToFundParser("Mutual Fund Search Validation");

        String symbol = "PTTRX";
        textBoxFundSearch().sendKeys(symbol);
        sleep(500);
        random(labelsFund(), 1).get(0).click();
        sleep(500);
        buttonSearch().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelFundHeader(symbol).isDisplayed())
                        .as(symbol + " fund header is displayed")
                        .isEqualTo(true),
                symbol + " fund header is displayed")
                .assertChild(softly.assertThat(sectionMutualFundSummary().isDisplayed())
                                .as("Mutual Fund summary section is displayed")
                                .isEqualTo(true),
                        "Mutual Fund summary section is displayed");

        return this;
    }

    private void navigateToFundParser(String description) {

        navigateToPortfolioAnalyst(description);
        tab("Fund Parser").click();
        sleep(1000);
    }
}
