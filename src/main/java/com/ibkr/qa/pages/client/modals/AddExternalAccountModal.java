package com.ibkr.qa.pages.client.modals;

import com.ibkr.qa.pages.client.portfolioanalyst.ExternalAccount;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddExternalAccountModal extends ExternalAccount {

    public AddExternalAccountModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public AddExternalAccountModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement buttonContinue() {
        return elementVisible(By.xpath("//div[@class='panel-btn-right']//am-button[@btn-text='Continue']"));
    }

    private WebElement buttonOfflineAccount() {
        return elementVisible(By.xpath("//a[@class='btn-account-type' and contains(.,'Offline Account')]"));
    }

    public ExternalAccount navigate() {

        buttonContinue().click();
        sleep(1000);
        buttonOfflineAccount().click();
        sleep(1000);
        buttonContinue().click();
        sleep(1000);

        return this;
    }
}
