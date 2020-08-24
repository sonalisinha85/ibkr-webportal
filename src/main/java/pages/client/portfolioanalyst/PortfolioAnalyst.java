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

    private WebElement labelPortfolioAnalyst() {
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

    public ExternalAccount withExternalAccount() {

        return new ExternalAccount()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public Reports withReports() {

        return new Reports()
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

    protected PortfolioAnalyst navigateToPortfolioAnalyst(String description) {

        buttonMenu().click();
        sleep(500);
        menu("PortfolioAnalyst").click();
        sleep(2000);

        reporter.createChild(description)
                .assertChild(softly.assertThat(labelPortfolioAnalyst().isDisplayed())
                                .as("PortfolioAnalyst Label is displayed")
                                .isEqualTo(true),
                        "PortfolioAnalyst Label is displayed");

        return this;
    }
}
