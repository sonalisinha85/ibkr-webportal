package com.ibkr.qa.pages.client.modals;

import com.ibkr.qa.pages.client.portfolioanalyst.Reports;
import com.ibkr.qa.reporter.TestReporter;
import com.ibkr.qa.utils.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RunCustomReportModal extends Reports {

    public RunCustomReportModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public RunCustomReportModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement dropDownConsolidate() {
        return elementVisible(By.xpath("//select[@name='option']"));
    }

    private WebElement buttonRunCR() {
        return elementVisible(By.xpath("//p//am-button[@btn-text='Run']/a[contains(.,'Run')]"));
    }

    public RunCustomReportModal runCustomReportModal() {

        changeDropdown(dropDownConsolidate(), "Consolidate Selected Accounts into Single Report");
        buttonRunCR().click();
        sleep(4000);

        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("Custom Report is Download")
                        .contains("Steve_Sanders_TEST_ACCOUNT"),
                "Custom Report is Download");

        return this;
    }
}
