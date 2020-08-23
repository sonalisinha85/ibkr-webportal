package pages.client.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.client.portfolioanalyst.ExternalAccount;
import reporter.TestReporter;

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
        return elementPresent(By.xpath("//div[@class='panel-btn-right']//am-button[@btn-text='Continue']"));
    }

    private WebElement buttonOfflineAccount() {
        return elementPresent(By.xpath("//a[@class='btn-account-type' and contains(.,'Offline Account')]"));
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
