package pages.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.tabs.tools.DataQueries;
import reporter.TestReporter;

import java.util.List;

public class SelectAssetsModal extends DataQueries {

    public SelectAssetsModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public SelectAssetsModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelSelectAssets() {
        return elementPresent(By.xpath("//div[@id='amModalContent']//span[text()='Select Assets']"));
    }

    private List<WebElement> checkBoxesSymbol() {
        return elementsPresent(By.xpath("//input[@type='checkbox' and @ng-model='symbol.selected']"));
    }

    private WebElement buttonSelect() {

        return elementPresent(By.xpath("//am-button[@btn-type='primary' and @btn-text='Select']"));
    }

    public SelectAssetsModal selectAssets(){

        reporter.assertChild(softly.assertThat(labelSelectAssets().isDisplayed())
                        .as("Select Assets Label is displayed")
                        .isEqualTo(true),
                "Select Assets Label is displayed");

        random(checkBoxesSymbol(),1).get(0).click();
        buttonSelect().click();
        sleep(1000);

        return this;
    }
}
