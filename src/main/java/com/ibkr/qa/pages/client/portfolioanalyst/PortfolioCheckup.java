package com.ibkr.qa.pages.client.portfolioanalyst;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PortfolioCheckup extends PortfolioAnalyst {

    private List<String> sections = new ArrayList(
            Arrays.asList(
                    "Return",
                    "Risk",
                    "Asset Class Allocation",
                    "Sector Allocation",
                    "Geographic Allocation",
                    "ESG Ratings"
            ));

    public PortfolioCheckup withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public PortfolioCheckup withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelConcentrationReport() {
        return elementVisible(By.xpath("//div[@ng-controller='ConcentrationReportCtrl as ctrl']"));
    }

    private WebElement labelSection(String sectionName) {
        return elementVisible(By.xpath("//span[contains(text(),'" + sectionName + "')]/ancestor::section[@class='panel']"));
    }

    private WebElement labelNotes() {
        return elementVisible(By.xpath("//div[@class='notes']"));
    }

    public PortfolioCheckup validatePortfolioCheckup() {

        navigateToPortfolioAnalyst("Validate Portfolio Checkup");

        tab("Portfolio Checkup").click();
        sleep(1000);

        reporter.createChild("Portfolio Checkup Validation")
                .assertChild(softly.assertThat(labelNotes().isDisplayed())
                                .as("Important Notes Label is displayed")
                                .isEqualTo(true),
                        "Important Notes Label is displayed");

        sections.forEach(sectionName ->
                reporter.assertChild(softly.assertThat(labelSection(sectionName).isDisplayed())
                                .as(sectionName + " section is displayed")
                                .isEqualTo(true),
                        sectionName + " section is displayed"));

        return this;
    }
}
