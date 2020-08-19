package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.modals.TraderWorkstation;
import reporter.TestReporter;
import utils.FileUtil;

import java.util.Arrays;

public class WhiteBranding extends AccountSettings {

    public WhiteBranding withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public WhiteBranding withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelWhiteBranding() {
        return elementPresent(By.xpath("//h3[contains(.,'White Branding')]"));
    }

    private WebElement buttonViewBanner() {
        return elementPresent(By.xpath("//i[@data-original-title='View']"));
    }

    private WebElement labelBanner() {
        return elementPresent(By.xpath("//i[@data-original-title='View']/ancestor::label"));
    }

    private WebElement buttonConfigure(Heading heading) {
        return elementPresent(By.xpath("//section[div[span[text()='" + heading.toString().replaceAll("_", " ") + "']]]//i[@data-original-title='Configure']"));
    }

    public WhiteBranding validateWhiteBranding() {

        reporter.createChild("White Branding Validation")
                .assertChild(softly.assertThat(labelWhiteBranding().isDisplayed())
                                .as("White Branding Label is displayed")
                                .isEqualTo(true),
                        "White Branding Label is displayed");

        String name = Arrays.asList(labelBanner().getText().trim().split("\\.")).get(0);
        buttonViewBanner().click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(new FileUtil().getLatestFilefromDir().getName())
                        .as("Banner Download")
                        .contains(name),
                "Banner Download");

        buttonConfigure(Heading.Trader_Workstation).click();
        sleep(1000);

        new TraderWorkstation()
                .withDriver(driver)
                .withReporter(reporter)
                .validateTraderWorkstation();

        return this;
    }

    enum Heading {Trader_Workstation}
}
