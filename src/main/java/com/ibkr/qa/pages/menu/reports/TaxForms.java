package com.ibkr.qa.pages.menu.reports;

import com.ibkr.qa.reporter.TestReporter;
import com.ibkr.qa.utils.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaxForms extends Reports {

    public TaxForms withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public TaxForms withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement panelTaxForms() {
        return elementVisible(By.xpath("//span[text()='Tax Forms']/ancestor::section[@ng-if='taxCtrl.isTaxFormsAccessible']"));
    }

    private WebElement dropdownTaxYear() {
        return elementVisible(By.xpath("//select[contains(@ng-model,'taxForm.selectedTaxYear')]"));
    }

    private WebElement buttonPDF() {
        return elementVisible(By.xpath("//i[@class='fa fa-arrow-down margin-right-10']/ancestor::a[contains(.,'PDF')]"));
    }

    private WebElement buttonCSV() {
        return elementVisible(By.xpath("//i[@class='fa fa-arrow-down margin-right-10']/ancestor::a[contains(.,'CSV')]"));
    }

    public TaxForms navigateToTax() {

        tabReports(ReportsTab.Tax).click();
        sleep(2000);
        pickAccount();

        reporter.createChild("Tax Forms")
                .assertChild(softly.assertThat(panelTaxForms().isDisplayed())
                                .as("Tax Forms Section is displayed")
                                .isEqualTo(true),
                        "Tax Forms Section is displayed");
        return this;
    }

    public TaxForms validateTaxForms() {

        changeDropdown(dropdownTaxYear(), "2018");
        sleep(1000);

        buttonPDF().click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("Tax Form PDF is Download")
                        .contains("U1139849.2018"),
                "Tax Form PDF is Download");

        sleep(2000);
        buttonCSV().click();
        sleep(2000);

        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("Tax Form CSV is Download")
                        .contains("U1139849.2018"),
                "Tax Form CSV is Download");

        sleep(2000);

        return this;
    }
}