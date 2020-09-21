package com.ibkr.qa.pages.accountapplication.chinesenative;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Regulatory extends AccountApplication {

    public Regulatory withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public Regulatory withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelRegulatory() {
        return elementPresent(By.xpath("//h1[contains(text(),'Configure Your Trading Account')]"));
    }

    private WebElement dropDownAnnualIncome() {
        return elementPresent(By.xpath("//select[@name='annualIncome']"));
    }

    private WebElement dropDownNetWorth() {
        return elementPresent(By.xpath("//select[@name='netWorth']"));
    }

    private WebElement dropDownLiquidNetWorth() {
        return elementPresent(By.xpath("//select[@name='liquidNetWorth']"));
    }

    private WebElement dropDownStockYears() {
        return elementPresent(By.xpath("//select[@name='STOCK_years']"));
    }

    private WebElement dropDownStockTrades() {
        return elementPresent(By.xpath("//select[@name='STOCK_trades']"));
    }

    private WebElement dropDownStockKnowledge() {
        return elementPresent(By.xpath("//select[@name='STOCK_knowledge']"));
    }

    private WebElement buttonStockAdd() {
        return elementPresent(By.xpath("//am-button[@btn-text='Add']"));
    }

    private WebElement buttonStockSave() {
        return elementPresent(By.xpath("//am-button[@btn-text='Save']"));
    }

    private WebElement checkBoxInvestmentObjective(String label) {

        return driver.findElement(By.xpath("//p[@class='ng-binding' and contains(.,'" + label + "')]/div"));
    }

    private WebElement checkBoxMarketPermission(String label) {

        return driver.findElement(By.xpath("//strong[text()='" + label + "']/ancestor::p/div"));
    }

    public AccountApplication fillForm() {

        changeDropdown(dropDownAnnualIncome(), "200,000 - 249,999");
        changeDropdown(dropDownNetWorth(), "25,000,000 - 29,999,999");
        changeDropdown(dropDownLiquidNetWorth(), "250,000 - 499,999");

        checkBoxInvestmentObjective("Growth").click();
        checkBoxInvestmentObjective("Profits from Active Trading and Speculation").click();

        buttonStockAdd().click();
        sleep(1000);

        checkBoxMarketPermission("All Asia Pacific").click();
        checkBoxMarketPermission("All Europe").click();
        checkBoxMarketPermission("All North America").click();
        buttonStockSave().click();

        changeDropdown(dropDownStockYears(), "1 Years of Experience");
        changeDropdown(dropDownStockTrades(), "1 - 10 Trades per Year");
        changeDropdown(dropDownStockKnowledge(), "Good Knowledge");

        buttonContinue().click();
        sleep(8000);

        reporter.createChild("Regulatory Page")
                .childInfo("Regulatory Page Filled");

        return (AccountApplication) this;
    }
}
