package pages.client.portfolioanalyst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.client.ClientPortal;
import reporter.TestReporter;

public class PortfolioAnalyst extends ClientPortal {

    public PortfolioAnalyst withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public PortfolioAnalyst withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    protected WebElement labelPortfolioAnalyst() {
        return elementPresent(By.xpath("//h3[contains(.,'PortfolioAnalyst')]"));
    }

    protected WebElement tab(String tabName) {
        return elementPresent(By.xpath("//a[@data-toggle='tab' and contains(text(),'" + tabName + "')]"));
    }

    public FundParser withFundParser() {

        return new FundParser()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public Home withHome() {

        return new Home()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public PortfolioCheckup withPortfolioCheckup() {

        return new PortfolioCheckup()
                .withDriver(driver)
                .withReporter(reporter);
    }
}
