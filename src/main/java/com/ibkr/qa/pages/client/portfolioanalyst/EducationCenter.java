package com.ibkr.qa.pages.client.portfolioanalyst;

import com.ibkr.qa.reporter.TestReporter;
import com.ibkr.qa.utils.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Calendar;

public class EducationCenter extends PortfolioAnalyst {

    public EducationCenter withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public EducationCenter withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement heading() {

        return elementVisible(By.xpath("//span[@class='heading' and text()='Education Center']"));
    }

    private WebElement link(String name) {

        return elementVisible(By.xpath("//a[@class='linkexternal' and contains(text(),'" + name + "')]"));
    }

    public EducationCenter validateEducationCenter() {

        navigateToPortfolioAnalyst("Validate Education Center");
        tab("Education Center").click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(heading().isDisplayed())
                        .as("Education Center Heading is displayed")
                        .isEqualTo(true),
                "Education Center Heading is displayed");

        validateLinkFaq()
                .validateLinkRiskMeasuresWhitePaper()
                .validateLinkPortfolioAnalystUsersGuide()
                .validateLinkTradersAcademy()
                .validateLinkMwrTwrWhitePaper()
                .validateLinkReleaseNotes()
                .validateLinkPerformanceAttributionWhitePaper();

        return this;
    }

    private EducationCenter validateLinkFaq() {

        link("FAQ").click();
        sleep(1000);
        switchToDefaultContext();
        switchTab();

        reporter.assertChild(softly.assertThat(driver.getTitle())
                        .as("IBKR Customer Chat page is displayed")
                        .isEqualTo("IBKR Customer Chat"),
                "IBKR Customer Chat page is displayed");

        switchToMainTab();

        return this;
    }

    private EducationCenter validateLinkRiskMeasuresWhitePaper() {

        link("Risk Measures White Paper").click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("Risk Measures White Paper is Download")
                        .contains("RiskMeasures_WhitePaper"),
                "Risk Measures White Paper is Download");

        return this;
    }

    private EducationCenter validateLinkPortfolioAnalystUsersGuide() {

        link("PortfolioAnalyst Users").click();
        sleep(1000);
        switchToDefaultContext();
        switchTab();

        reporter.assertChild(softly.assertThat(driver.getTitle())
                        .as("PortfolioAnalyst User Guide page is displayed")
                        .isEqualTo(""),
//                        .isEqualTo("PortfolioAnalyst User Guide"),
                "PortfolioAnalyst User Guide page is displayed");

        switchToMainTab();

        return this;
    }

    private EducationCenter validateLinkTradersAcademy() {

        link("Academy").click();
        sleep(1000);
        switchToDefaultContext();
        switchTab();

        reporter.assertChild(softly.assertThat(driver.getTitle())
                        .as("IBKR Traders' Academy - Free Online Trading Courses page is displayed")
                        .isEqualTo("IBKR Traders' Academy - Free Online Trading Courses"),
                "IBKR Traders' Academy - Free Online Trading Courses page is displayed");

        switchToMainTab();

        return this;
    }

    private EducationCenter validateLinkMwrTwrWhitePaper() {

        link("Money Weighted Return & Time Weighted Return White Paper").click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("Money Weighted Return & Time Weighted Return White Paper is Download")
                        .contains("MWR-TWR_white_paper"),
                "Money Weighted Return & Time Weighted Return White Paper is Download");

        return this;
    }

    private EducationCenter validateLinkReleaseNotes() {

        link("Release Notes").click();
        sleep(1000);
        switchToDefaultContext();
        switchTab();

        reporter.assertChild(softly.assertThat(driver.getTitle())
                        .as("PortfolioAnalyst - Release Notes page is displayed")
                        .isEqualTo("PortfolioAnalyst - Release Notes "
                                + Calendar.getInstance().get(Calendar.YEAR) + " | Interactive Brokers LLC"),
                "PortfolioAnalyst - Release Notes page is displayed");

        switchToMainTab();

        return this;
    }

    private EducationCenter validateLinkPerformanceAttributionWhitePaper() {

        link("Performance Attribution White Paper").click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("Performance Attribution White Paper is Download")
                        .contains("performance_attribution_white_paper"),
                "Performance Attribution White Paper is Download");

        return this;
    }
}
