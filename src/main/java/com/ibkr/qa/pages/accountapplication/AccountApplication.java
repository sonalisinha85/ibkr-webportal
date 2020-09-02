package com.ibkr.qa.pages.accountapplication;

import com.ibkr.qa.navigation.WebOperation;
import com.ibkr.qa.pages.Login;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public AccountApplication fillAboutYou() {

        return new AboutYou()
                .withDriver(driver)
                .withReporter(reporter)
                .fillForm();
    }

    public AccountApplication fillRegulatory() {

        return new Regulatory()
                .withDriver(driver)
                .withReporter(reporter)
                .fillForm();
    }

    public AccountApplication fillAgreement() {

        return new Agreement()
                .withDriver(driver)
                .withReporter(reporter)
                .fillForm();
    }

    public AccountApplication fillAccountSetup() {

        return new AccountSetup()
                .withDriver(driver)
                .withReporter(reporter)
                .fillForm();
    }

    public AccountApplication loginChineseNative() {

        new Login()
                .withDriver(driver)
                .withReporter(reporter)
//                .withUserName("ibk" + getDate())
                .withUserName("ibk200831")
                .withPassword("tester12")
                .login();

        return this;
    }

    public AccountRegistration withAccountRegistration() {

        return new AccountRegistration()
                .withDriver(driver);
    }

    protected WebElement buttonOpenAccount() {
        return elementPresent(By.xpath("//li[@class='nav-item d-none d-lg-block']/a[text()='Open Account']"));
    }

    protected WebElement buttonStartApplication() {
        return elementPresent(By.xpath("//p/a[text()='Start Application']"));
    }

    protected WebElement buttonContinue() {
        return elementPresent(By.id("continue"));
    }
}
