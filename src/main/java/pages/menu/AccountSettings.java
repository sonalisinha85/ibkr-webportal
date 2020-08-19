package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Portal;
import reporter.TestReporter;

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
        return elementPresent(By.xpath("//h3[contains(.,'Account Settings')]"));
    }

    private WebElement buttonConfigure(Configuration configuration) {
        return elementPresent(By.xpath("//strong[contains(text(),'" + configuration.toString().replaceAll("_", " ") + "')]/ancestor::p//i[@data-original-title='Configure']"));
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
