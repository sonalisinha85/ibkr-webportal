package com.ibkr.qa.pages.client.modals;

import com.ibkr.qa.pages.client.portfolioanalyst.FundParser;
import com.ibkr.qa.pages.client.portfolioanalyst.PortfolioAnalyst;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllHoldingsModal extends FundParser {

    public AllHoldingsModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public AllHoldingsModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelAllHoldings() {
        return elementPresent(By.xpath("//span[contains(text(),'All Holdings')]"));
    }

    private WebElement buttonClose() {
        return elementPresent(By.xpath("//a[contains(text(),'Close')]"));
    }

    private WebElement tableAllHoldings() {
        return elementPresent(By.xpath("//div[@class='modal-content']//table"));
    }

    public PortfolioAnalyst validateAllHoldingsModal() {

        reporter.createChild("All Holdings Modal Validation")
                .assertChild(softly.assertThat(labelAllHoldings().isDisplayed())
                                .as("All Holdings Label is displayed")
                                .isEqualTo(true),
                        "All Holdings Label is displayed")
                .assertChild(softly.assertThat(tableAllHoldings().isDisplayed())
                                .as("All Holdings table is displayed")
                                .isEqualTo(true),
                        "All Holdings table is displayed");

        buttonClose().click();
        sleep(1000);

        return this;
    }
}
