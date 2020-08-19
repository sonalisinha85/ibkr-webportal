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

    public FundParser validateConcentrationReport() {

        buttonMenu().click();
        sleep(500);
        menu("PortfolioAnalyst").click();
        sleep(2000);

        reporter.createChild("Concentration Report Validation")
                .assertChild(softly.assertThat(labelPortfolioAnalyst().isDisplayed())
                                .as("PortfolioAnalyst Label is displayed")
                                .isEqualTo(true),
                        "PortfolioAnalyst Label is displayed");

        tab("Fund Parser").click();
        sleep(1000);

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
}
