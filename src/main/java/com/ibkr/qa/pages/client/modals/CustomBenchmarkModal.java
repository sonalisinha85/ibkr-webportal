package com.ibkr.qa.pages.client.modals;

import com.ibkr.qa.pages.client.portfolioanalyst.Reports;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomBenchmarkModal extends Reports {

    public CustomBenchmarkModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public CustomBenchmarkModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelCreateNewCustomBenchMark() {
        return elementVisible(By.xpath("//span[text()='Create New Custom Benchmark']"));
    }

    private WebElement inputTextName() {
        return elementVisible(By.xpath("//input[@name='cbName']"));
    }

    private WebElement inputTextAbbreviation() {
        return elementVisible(By.xpath("//input[@name='abbrev']"));
    }

    private List<WebElement> checkBoxes() {
        return elementsVisible(By.xpath("//div[@class='icheckbox_square-blue']"));
    }

    private List<WebElement> inputWeight() {
        return elementsPresent(By.xpath("//input[@name='weight']"));
    }

    private WebElement buttonSave() {
        return elementVisible(By.xpath("//a[@class='btn btn-primary' and contains(.,'Save')]"));
    }

    private WebElement buttonEdit() {
        return elementVisible(By.xpath("//a[contains(.,'Edit')]"));
    }

    private WebElement buttonYes() {
        return elementVisible(By.xpath("//a[contains(.,'Yes')]"));
    }

    private WebElement labelNewCustomBenchMarkDelete() {
        return elementVisible(By.xpath("//div[@class='alert alert-success']/p"));
    }

    private WebElement buttonClose() {
        return elementVisible(By.xpath("//a[contains(.,'Close')]"));
    }

    private String getTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
        return sdf.format(new Date());
    }

    public CustomBenchmarkModal createCustomBenchmarkModal(String name) {

        reporter.createChild("Create Custom Benchmark Modal Validation")
                .assertChild(softly.assertThat(labelCreateNewCustomBenchMark().isDisplayed())
                                .as("Create New Custom Benchmark Label is displayed")
                                .isEqualTo(true),
                        "Create New Custom Benchmark Label is displayed");

        inputTextName().sendKeys(name);
        inputTextAbbreviation().sendKeys(getTime());

        checkBoxes().get(0).click();
        inputWeight().get(0).sendKeys("50");
        checkBoxes().get(1).click();
        inputWeight().get(1).sendKeys("50");
        buttonSave().click();

        return this;
    }

    public CustomBenchmarkModal editCustomBenchmarkModal() {

        buttonEdit().click();
        inputTextAbbreviation().sendKeys(getTime());
        buttonSave().click();
        sleep(500);

        reporter.createChild("Edit Custom Benchmark Validation")
                .childInfo("Custom Benchmark is updated");

        return this;
    }

    public CustomBenchmarkModal deleteCustomBenchmarkModal() {

        buttonYes().click();
        reporter.createChild("Delete Custom Benchmark Validation")
                .assertChild(softly.assertThat(labelNewCustomBenchMarkDelete().isDisplayed())
                                .as("The custom benchmark has been deleted Label is displayed")
                                .isEqualTo(true),
                        "The custom benchmark has been deleted Label is displayed");

        buttonClose().click();
        sleep(500);

        return this;
    }
}
