package com.ibkr.qa.pages.modals;

import com.ibkr.qa.pages.menu.WhiteBranding;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TraderWorkstation extends WhiteBranding {

    public TraderWorkstation withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public TraderWorkstation withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelTraderWorkstation() {
        return elementVisible(By.xpath("//h4//span[text()='Trader Workstation']"));
    }

    protected WebElement buttonAction(Action action) {
        return elementVisible(By.xpath("//am-button[@btn-text='" + action.toString() + "']"));
    }

    public TraderWorkstation validateTraderWorkstation() {

        reporter.createChild("Trader Workstation Validation")
                .assertChild(softly.assertThat(labelTraderWorkstation().isDisplayed())
                                .as("Trader Workstation Label is displayed")
                                .isEqualTo(true),
                        "Trader Workstation Label is displayed");

        buttonAction(Action.Close).click();
        sleep(1000);

        return this;
    }

    private enum Action {Save, Close}
}
