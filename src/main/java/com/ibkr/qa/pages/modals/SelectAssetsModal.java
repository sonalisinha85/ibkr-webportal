package com.ibkr.qa.pages.modals;

import com.ibkr.qa.pages.tabs.tools.DataQueries;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        return elementVisible(By.xpath("//div[@id='amModalContent']//span[text()='Select Assets']"));
    }

    private List<WebElement> checkBoxesSymbol() {
        return elementsVisible(By.xpath("//input[@type='checkbox' and @ng-model='symbol.selected']"));
    }

    private WebElement buttonSelect() {
        return elementVisible(By.xpath("//am-button[@btn-type='primary' and @btn-text='Select']"));
    }

    public SelectAssetsModal selectAssets() {

        reporter.assertChild(softly.assertThat(labelSelectAssets().isDisplayed())
                        .as("Select Assets Label is displayed")
                        .isEqualTo(true),
                "Select Assets Label is displayed");

        random(checkBoxesSymbol(), 1).get(0).click();
        buttonSelect().click();
        sleep(1000);

        return this;
    }
}
