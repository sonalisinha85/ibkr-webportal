package com.ibkr.qa.pages.client.portfolioanalyst;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home extends PortfolioAnalyst {

    public Home withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public Home withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement buttonSearchIcon() {
        return elementVisible(By.xpath("//i[@data-original-title='Search']"));
    }

    private WebElement inputSearchBox() {
        return elementVisible(By.xpath("//input[@ng-model='searchInput']"));
    }

    private WebElement buttonSearch() {
        return elementVisible(By.xpath("//a[contains(text(),'Search')]"));
    }

    private WebElement labelSearchResult() {
        return elementVisible(By.xpath("//div[@ng-if='paSearch.results.rc === 0']/h5[contains(text(),'Search Results')]"));
    }

    private WebElement tableBrokeragePosition() {
        return elementVisible(By.xpath("//div[@ng-show='filteredPos.length > 0' and h6[contains(text(),'Brokerage Positions')]]//table"));
    }

    private WebElement buttonMWR() {
        return elementVisible(By.xpath("//a[@ng-click='$ctrl.toggleFn()' and contains(text(),'MWR')]"));
    }

    private WebElement buttonTWR() {
        return elementVisible(By.xpath("//a[@ng-click='$ctrl.toggleFn()' and contains(text(),'TWR')]"));
    }

    private WebElement dropDownViewBy() {
        return elementVisible(By.xpath("//select"));
    }

    private WebElement panel(String name) {
        return elementVisible(By.xpath("//span[@class='heading' " +
                "and contains(.,'" + name + "')]/ancestor::section[@class='panel']"));
    }

    private WebElement buttonBrokerage() {
        return elementVisible(By.xpath("//p[contains(.,'Brokerage')]/i"));
    }

    public Home validateSearch() {

        navigateToPortfolioAnalyst("Validate Search");

        String symbol = "KODK";
        buttonSearchIcon().click();
        inputSearchBox().sendKeys(symbol);
        buttonSearch().click();
        sleep(1000);

        reporter.createChild("Search Results for " + symbol + " Validation")
                .assertChild(softly.assertThat(labelSearchResult().isDisplayed())
                                .as("Search Results for " + symbol + " Label is displayed")
                                .isEqualTo(true),
                        "Search Results for " + symbol + " Label is displayed")
                .assertChild(softly.assertThat(tableBrokeragePosition().isDisplayed())
                                .as("Brokerage Position table is displayed")
                                .isEqualTo(true),
                        "Brokerage Position table is displayed");

        return this;
    }

    public Home validateTwrMwrToggle() {

        navigateToPortfolioAnalyst("Validate Twr Mwr Toggle");

        buttonMWR().click();
        buttonTWR().click();

        return this;
    }

    public Home validateViewByDropDown() {

        navigateToPortfolioAnalyst("Validate View By Drop Down");

        buttonBrokerage().click();

        changeDropdown(dropDownViewBy(), "Account");
        sleep(1000);
        reporter.assertChild(softly.assertThat(panel("NAV").isDisplayed())
                        .as("NAV section is displayed")
                        .isEqualTo(true),
                "NAV section is displayed");

        changeDropdown(dropDownViewBy(), "Financial Instrument");
        sleep(1000);
        reporter.assertChild(softly.assertThat(panel("Financial Instruments").isDisplayed())
                        .as("Financial Instruments section is displayed")
                        .isEqualTo(true),
                "Financial Instruments section is displayed");

        return this;
    }
}
