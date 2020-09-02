package com.ibkr.qa.pages.client.reports;

import com.ibkr.qa.pages.client.ClientPortal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        return elementVisible(By.xpath("//h3[contains(.,'Reports')]"));
    }

    private WebElement checkboxSelectAllAccount() {
        return elementVisible(By.xpath("//a[contains(@ng-if,'selectAll')]/i"));
    }

    private WebElement buttonAccountPickerContinue() {
        return elementVisible(By.xpath("//div[@id='amPicker']//am-button[@btn-text='Continue']"));
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
