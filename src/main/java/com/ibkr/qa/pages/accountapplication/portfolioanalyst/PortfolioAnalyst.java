package com.ibkr.qa.pages.accountapplication.portfolioanalyst;

import com.ibkr.qa.navigation.WebOperation;
import com.ibkr.qa.pages.Login;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PortfolioAnalyst extends WebOperation {

    public PortfolioAnalyst withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public PortfolioAnalyst withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private List<String> addOptions = new ArrayList(
            Arrays.asList(
                    "Financial Institution",
                    "Offline Account",
                    "Real Estate"
            ));

    private WebElement labelPortfolioAnalyst() {
        return elementVisible(By.xpath("//h3[contains(.,'PortfolioAnalyst')]"));
    }

    private List<WebElement> addOptions() {
        return elementsVisible(By.xpath("//p/a[@class='btn-account-type']"));
    }

    private WebElement addOption(String option) {
        return elementVisible(By.xpath("//p/a[@class='btn-account-type' and contains(.,'" + option + "')]"));
    }

    public PortfolioAnalyst loginPortfolioAnalyst() {

        new Login()
                .withDriver(driver)
                .withReporter(reporter)
//                .withUserName("ibk" + getDate())
                .withUserName("ibk200001")
                .withPassword("tester12")
                .login();

        return this;
    }

    public PortfolioAnalyst validatePortfolioAnalyst() {

        reporter.createChild("Portfolio Analyst Validation")
                .assertChild(softly.assertThat(labelPortfolioAnalyst().isDisplayed())
                                .as("Portfolio Analyst Label is displayed")
                                .isTrue(),
                        "Portfolio Analyst Label is displayed");

        addOptions.forEach(option -> reporter.assertChild(softly.assertThat(addOption(option).isDisplayed())
                        .as(option + " option is displayed")
                        .isTrue(),
                option + " is displayed"));

        return this;
    }

}
