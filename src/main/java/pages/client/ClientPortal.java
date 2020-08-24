package pages.client;

import navigation.WebOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.client.portfolioanalyst.PortfolioAnalyst;
import pages.client.reports.ClientPortalReports;
import reporter.TestReporter;

public class ClientPortal extends WebOperation {

    public ClientPortal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public ClientPortal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    protected WebElement buttonMenu() {
        return elementPresent(By.xpath("//div[@class='bar3-logo']/button"));
    }

    protected WebElement menu(String menu) {
        return elementPresent(By.xpath("//a[contains(@id,'tool') and contains(.,'" + menu + "')]"));
    }

    protected WebElement subMenu(String subMenu) {
        return elementPresent(By.xpath("//a[text()='" + subMenu + "']"));
    }

    private WebElement buttonUser() {

        return elementPresent(By.xpath("//button[@aria-label='User']"));
    }

    private WebElement buttonLogout() {

        return elementPresent(By.xpath("//div[contains(@class,'bottom')]//button[contains(text(),'Log out')]"));
    }

    private WebElement labelAccountTitle() {

        return elementPresent(By.xpath("//span[@class='bar-fg fs7']"));
    }

    public InvestorMarketplace withInvestorMarketplace() {

        return new InvestorMarketplace()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public PortfolioAnalyst withPortfolioAnalyst() {

        return new PortfolioAnalyst()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public ClientPortalReports withClientPortalReports() {

        return new ClientPortalReports()
                .withDriver(driver)
                .withReporter(reporter);
    }

    public ClientPortal logout() {

        buttonUser().click();
        sleep(200);
        buttonLogout().click();
        sleep(500);
        return this;
    }

    public ClientPortal validateLogin() {

        reporter.assertChild(softly.assertThat(labelAccountTitle().isDisplayed())
                        .as("Account Title " + labelAccountTitle().getText() + " is displayed")
                        .isEqualTo(true),
                "Account Title " + labelAccountTitle().getText() + " is displayed");
        return this;
    }
}
