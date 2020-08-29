package pages.client.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.client.portfolioanalyst.Reports;
import reporter.TestReporter;

public class CustomReportModal extends Reports {

    public CustomReportModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public CustomReportModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelDeleteText() {
        return elementPresent(By.xpath("//confirm-modal/div/p/strong"));
    }

    private WebElement buttonYes() {
        return elementPresent(By.xpath("//am-button[@btn-text='Yes']"));
    }

    private WebElement labelDeleteReportAlert() {
        return elementPresent(By.xpath("//div[@class='alert alert-success']/p"));
    }

    private WebElement buttonClose() {
        return elementPresent(By.xpath("//am-button[@btn-text='Close']"));
    }

    public CustomReportModal deleteCustomReport() {

        reporter.assertChild(softly.assertThat(labelDeleteText().isDisplayed())
                        .as("Delete Text label is displayed")
                        .isEqualTo(true),
                "Delete Text Label is displayed");

        buttonYes().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelDeleteReportAlert().isDisplayed())
                        .as("Delete Custom Report Alert is displayed")
                        .isEqualTo(true),
                "Delete Custom Report Alert is displayed");

        buttonClose().click();

        return this;
    }
}
