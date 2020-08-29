package com.ibkr.qa.pages.accountapplication;

import com.ibkr.qa.navigation.WebOperation;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.WebDriver;

public class AccountApplication extends WebOperation {

    public AccountApplication withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public AccountApplication withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    public AboutYou withAboutYou() {

        return new AboutYou()
                .withDriver(driver)
                .withReporter(reporter);
    }

}
