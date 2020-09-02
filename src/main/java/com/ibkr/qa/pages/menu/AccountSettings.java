package com.ibkr.qa.pages.menu;

import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSettings extends Portal {

    public AccountSettings withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public AccountSettings withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelAccountSettings() {
        return elementVisible(By.xpath("//h3[contains(.,'Account Settings')]"));
    }

    private WebElement buttonConfigure(Configuration configuration) {
        return elementVisible(By.xpath("//strong[contains(text(),'" + configuration.toString().replaceAll("_", " ") + "')]/ancestor::p//i[@data-original-title='Configure']"));
    }

    public AccountSettings configureWhiteBranding() {

        menu(Menu.Settings).click();
        subMenu(SubMenu.Account_Settings).click();
        sleep(1000);

        reporter.createChild("Account Settings Validation")
                .assertChild(softly.assertThat(labelAccountSettings().isDisplayed())
                                .as("Account Settings Label is displayed")
                                .isEqualTo(true),
                        "Account Settings Label is displayed");

        buttonConfigure(Configuration.White_Branding).click();
        sleep(1000);

        new WhiteBranding()
                .withDriver(driver)
                .withReporter(reporter)
                .validateWhiteBranding();

        return this;
    }

    enum Configuration {White_Branding}
}
