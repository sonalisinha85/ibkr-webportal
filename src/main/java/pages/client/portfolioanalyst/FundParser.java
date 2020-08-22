package pages.client.portfolioanalyst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.client.modals.AllHoldingsModal;
import reporter.TestReporter;

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
        return elementPresent(By.xpath("//div[@ng-controller='ConcentrationReportCtrl as ctrl']"));
    }

    private WebElement labelSection(String sectionName) {
        return elementPresent(By.xpath("//span[text()='" + sectionName + "']/ancestor::section[@class='panel']"));
    }

    private WebElement buttonViewAll() {
        return elementPresent(By.xpath("//a[contains(text(),'View All')]"));
    }

    private WebElement textBoxFundSearch() {
        return elementPresent(By.xpath("//input[@name='fundSearch']"));
    }

    private List<WebElement> labelsFund() {
        return elementsPresent(By.xpath("//div[@ng-repeat='fund in $ctrl.list']"));
    }

    private WebElement buttonSearch() {
        return elementPresent(By.xpath("//i[@class='fa fa-search']"));
    }

    private WebElement labelFundHeader(String fundName) {
        return elementPresent(By.xpath("//span[contains(. ,'Fund Parser (" + fundName + "')]"));
    }

    private WebElement labelFundDesc(String fundDesc) {
        return elementPresent(By.xpath("//p[contains(.,'" + fundDesc + "')]"));
    }

    private WebElement sectionMutualFundSummary() {
        return elementPresent(By.xpath("//div[contains(@ng-if,'FundSummary')]//section"));
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

        String symbol = "SPY";
        textBoxFundSearch().sendKeys(symbol);
        sleep(500);
        WebElement labelFund = random(labelsFund(), 1).get(0);
        String fundDesc = labelFund.getText().replaceAll("-", "").trim();
        labelFund.click();
        sleep(500);
        buttonSearch().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelFundHeader(symbol).isDisplayed())
                        .as(symbol + " fund header is displayed")
                        .isEqualTo(true),
                symbol + " fund header is displayed")
                .assertChild(softly.assertThat(labelFundDesc(fundDesc).isDisplayed())
                                .as(fundDesc + " fund is displayed")
                                .isEqualTo(true),
                        fundDesc + " fund is displayed");

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

        buttonMenu().click();
        sleep(500);
        menu("PortfolioAnalyst").click();
        sleep(2000);

        reporter.createChild(description)
                .assertChild(softly.assertThat(labelPortfolioAnalyst().isDisplayed())
                                .as("PortfolioAnalyst Label is displayed")
                                .isEqualTo(true),
                        "PortfolioAnalyst Label is displayed");

        tab("Fund Parser").click();
        sleep(1000);
    }
}
