package com.ibkr.qa.pages.client.modals;

import com.ibkr.qa.pages.client.portfolioanalyst.Reports;
import com.ibkr.qa.reporter.TestReporter;
import com.ibkr.qa.utils.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DefaultReportModal extends Reports {

    public DefaultReportModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public DefaultReportModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement panelBenchmark() {
        return elementVisible(By.xpath("//h6[text()='Benchmarks']/ancestor::div[contains(@ng-if,'benchmarks')]"));
    }

    private WebElement panelReportDetails() {
        return elementVisible(By.xpath("//h6[text()='Report Details']/ancestor::div[contains(@ng-controller,'PaReportInfoCtrl')]"));
    }

    private WebElement buttonClose() {
        return elementVisible(By.xpath("//p//am-button[@btn-text='Close']/a[contains(.,'Close')]"));
    }

    private WebElement buttonConsolidateReport() {
        return elementVisible(By.xpath("//a[contains(.,'Consolidate Selected Accounts into Single Report')]"));
    }

    public DefaultReportModal viewDefaultReportModal() {

        reporter.assertChild(softly.assertThat(panelReportDetails().isDisplayed())
                        .as("Panel Report Details is displayed")
                        .isEqualTo(true),
                "Panel Report Details is displayed");

        reporter.assertChild(softly.assertThat(panelBenchmark().isDisplayed())
                        .as("Panel Benchmark is displayed")
                        .isEqualTo(true),
                "Panel Benchmark is displayed");

        buttonClose().click();

        return this;
    }

    public DefaultReportModal runDefaultReportSnapshot() {

        buttonConsolidateReport().click();
        sleep(2000);


        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("Snapshot Default Report is Download")
                        .contains("IBLLC_Steve_Sanders_TEST_ACCOUNT"),
                "Snapshot Default Report is Download");

        sleep(1000);

        return this;
    }

    public DefaultReportModal runDetailPdfReport() {

        buttonConsolidateReport().click();
        sleep(2000);


        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("Detail PDF Default Report is Download")
                        .contains("IBLLC_Steve_Sanders_TEST_ACCOUNT"),
                "Detail PDF Default Report is Download");

        sleep(1000);

        return this;
    }


    public DefaultReportModal runDetailCsvReport() {

        buttonConsolidateReport().click();
        sleep(2000);


        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("Detail CSV Default Report is Download")
                        .contains("IBLLC_Steve_Sanders_TEST_ACCOUNT"),
                "Detail CSV Default Report is Download");

        sleep(1000);

        return this;
    }


}
