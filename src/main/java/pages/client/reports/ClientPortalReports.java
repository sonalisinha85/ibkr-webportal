package pages.client.reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.client.ClientPortal;
import reporter.TestReporter;

public class ClientPortalReports extends ClientPortal {

    public ClientPortalReports withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public ClientPortalReports withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelReports() {
        return elementPresent(By.xpath("//h3[contains(.,'Reports')]"));
    }

    private WebElement checkboxSelectAllAccount() {
        return elementPresent(By.xpath("//a[contains(@ng-if,'selectAll')]/i"));
    }

    private WebElement buttonAccountPickerContinue() {
        return elementPresent(By.xpath("//div[@id='amPicker']//am-button[@btn-text='Continue']"));
    }

    public ClientPortalReports navigateToReports() {

        buttonMenu().click();
        sleep(500);
        menu("Reports / Tax Docs").click();
        sleep(2000);
        checkboxSelectAllAccount().click();
        buttonAccountPickerContinue().click();
        sleep(2000);

        reporter.createChild("Validate Reports Navigation")
                .assertChild(softly.assertThat(labelReports().isDisplayed())
                                .as("Reports Label is displayed")
                                .isEqualTo(true),
                        "Reports Label is displayed");

        return this;
    }
}
