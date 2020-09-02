package com.ibkr.qa.pages.accountapplication;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSetup extends AccountApplication {

    public AccountSetup withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public AccountSetup withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement dropDownHowFound() {
        return elementPresent(By.id("howFoundL1"));
    }

    public AccountApplication fillForm() {

        changeDropdown(dropDownHowFound(), "Email or Postal Mail");
        buttonContinue().click();
        sleep(5000);

        reporter.createChild("Account Setup Page Validation")
                .childInfo("Account Setup Page Filled");

        return (AccountApplication) this;
    }
}
