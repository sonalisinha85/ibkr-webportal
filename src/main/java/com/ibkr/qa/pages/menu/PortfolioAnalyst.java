package com.ibkr.qa.pages.menu;

import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.pages.modals.SynopsesModal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PortfolioAnalyst extends Portal {

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

    public SynopsesModal withSynopsesModal() {

        return new SynopsesModal()
                .withDriver(driver)
                .withReporter(reporter);
    }

    private List<WebElement> checkboxesAccountPicker() {
        return elementsVisible(By.xpath("//i[contains(@ng-if,'pickerEntry')]"));
    }

    private WebElement checkboxAllAccount() {
        return elementVisible(By.xpath("//i[contains(@ng-class,'allSelected')]"));
    }

    private WebElement buttonAction(Action action) {
        return elementVisible(By.xpath("//am-button[@btn-text='" + action.toString() + "']"));
    }

    private WebElement sectionNav() {
        return elementVisible(By.xpath("//span[@class='heading' and contains(text(),'NAV')]/ancestor::section[@class='panel']"));
    }

    private WebElement tabsPortfolioAnalyst(Tabs tabs) {
        return elementVisible(By.xpath("//a[@data-toggle='tab' and contains(text(),'"
                + tabs.toString().replaceAll("_", " ") + "')]"));
    }

    protected WebElement buttonCreateSynopses() {
        return elementVisible(By.xpath("//span[text()='Synopses']/ancestor::section[@class='panel']//i[@data-original-title='Create']"));
    }

    protected List<WebElement> buttonsViewSynopses() {
        return elementsVisible(By.xpath("//span[text()='Synopses']/ancestor::section[@class='panel']//i[@data-original-title='View']"));
    }

    protected List<WebElement> buttonsDeleteSynopses() {
        return elementsVisible(By.xpath("//span[text()='Synopses']/ancestor::section[@class='panel']//i[@data-original-title='Delete']"));
    }

    public PortfolioAnalyst validatePortfolioAnalystAccountSelector() {

        menu(Menu.PortfolioAnalyst).click();
        sleep(1000);
        checkboxAllAccount().click();
        sleep(1000);
        buttonAction(Action.Continue).click();
        sleep(1000);

        reporter.createChild("NAV Section Validation")
                .assertChild(softly.assertThat(sectionNav().isDisplayed())
                                .as("NAV Section is displayed")
                                .isEqualTo(true),
                        "NAV Section is displayed");

        return this;
    }

    public PortfolioAnalyst navigateToReports() {

        menu(Menu.PortfolioAnalyst).click();
        sleep(1000);
        random(checkboxesAccountPicker(), 1).get(0).click();
        sleep(1000);
        buttonAction(Action.Continue).click();
        sleep(2000);
        tabsPortfolioAnalyst(Tabs.Reports).click();
        sleep(1000);

        return this;
    }

    enum Tabs {Home, Reports, Fund_Parser, Education_Center}

    enum Action {Continue, Ok, Yes, No, Close, Reset}
}
