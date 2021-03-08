package com.ibkr.qa.pages.client;

import com.ibkr.qa.navigation.WebOperation;
import com.ibkr.qa.pages.client.portfolioanalyst.PortfolioAnalyst;
import com.ibkr.qa.pages.client.reports.ClientPortalReports;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        return elementVisible(By.xpath("//div[@class='bar3-logo']/button"));
    }

    protected WebElement menu(String menu) {
        return elementVisible(By.xpath("//a[contains(@id,'tool') and contains(.,'" + menu + "')]"));
    }

    protected WebElement subMenu(String subMenu) {
        return elementVisible(By.xpath("//a[text()='" + subMenu + "']"));
    }

    private WebElement buttonUser() {

        return elementVisible(By.xpath("//button[@aria-label='User']"));
    }

    private WebElement buttonLogout() {

        return elementVisible(By.xpath("//div[contains(@class,'bottom')]" +
                "//button[contains(text(),'Log Out') or contains(text(),'Log out')]"));
    }

    private WebElement labelAccountTitle() {

        return elementVisible(By.xpath("//span[@class='bar-fg fs7']"));
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

        sleep(500);
        buttonUser().click();
        sleep(500);
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
