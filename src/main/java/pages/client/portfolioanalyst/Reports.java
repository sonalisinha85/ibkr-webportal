package pages.client.portfolioanalyst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reporter.TestReporter;

public class Reports extends PortfolioAnalyst {

    public Reports withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public Reports withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }


    private WebElement buttonReportsTab() {
        return elementPresent(By.xpath("//a[contains(.,'Reports') and @data-toggle='tab']"));
    }

    private WebElement buttonConfigureIcon() {
        return elementPresent(By.xpath("//i[@class='fa fa-gear tooltips']"));
    }

    private WebElement buttonAddEditAccount() {
        return elementPresent(By.xpath("//button[contains(.,'Add/Edit')]"));
    }

    private WebElement checkboxSelectAllAccount() {
        return elementPresent(By.xpath("//a[contains(@ng-if,'selectAll')]/i"));
    }

    private WebElement buttonAccountPickerContinue() {
        return elementPresent(By.xpath("//div[@id='amPicker']//am-button[@btn-text='Continue']"));
    }

    private WebElement buttonContinue2() {
        return elementPresent(By.xpath("//am-sequence[@submit-button-text='word.continue']//a[@class='btn btn-primary']"));
    }

    private WebElement labelComplete() {
        return elementPresent(By.xpath("//h1[@class='text-center text-success' and contains(text(),'Complete')]"));
    }

    private WebElement labelSettings() {
        return elementPresent(By.xpath("//h3[@class='text-center text-black' and contains(text(),'Your delivery settings have been')]"));
    }

    private WebElement buttonOk() {
        return elementPresent(By.xpath("//a[@class='btn btn-success' and contains(text(),'Ok')]"));
    }

    public Reports validateReportDelivery() {

        navigateToPortfolioAnalyst("Validate Report Delivery");

        buttonReportsTab().click();
        buttonConfigureIcon().click();
        sleep(1000);
        buttonAddEditAccount().click();
        sleep(200);
        checkboxSelectAllAccount().click();
        buttonAccountPickerContinue().click();
        sleep(1000);
        buttonContinue2().click();
        sleep(1000);
        buttonContinue2().click();

        reporter.assertChild(softly.assertThat(labelComplete().isDisplayed())
                        .as("Complete Label is displayed")
                        .isEqualTo(true),
                "Complete Label is displayed");

        reporter.assertChild(softly.assertThat(labelSettings().isDisplayed())
                        .as("Your delivery settings have been saved Label is displayed")
                        .isEqualTo(true),
                "Your delivery settings have been saved Label is displayed");

        buttonOk().click();

        return this;
    }
}