package com.ibkr.qa.pages.modals;

import com.ibkr.qa.navigation.Robo;
import com.ibkr.qa.pages.Employee;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class ImportEmployeesModal extends Employee {

    public ImportEmployeesModal withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public ImportEmployeesModal withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelImportEmployeesbyCsv() {
        return elementVisible(By.xpath("//h4//span[text()='Import Employees by CSV File']"));
    }

    private WebElement buttonSubmit() {
        return elementVisible(By.xpath("//am-button[@btn-text='Submit']"));
    }

    private WebElement buttonChooseFile() {
        return elementVisible(By.xpath("//label[contains(text(),'Choose a File')]"));
    }

    private WebElement buttonClose() {
        return elementVisible(By.xpath("//button[@class='close']"));
    }

    private WebElement labelAlert() {
        return elementVisible(By.xpath("//div[contains(@class,'alert-success')]//p[contains(.,'contacts successfully imported')]"));
    }

    public ImportEmployeesModal uploadEmployeesByCsv() {

        reporter.createChild("Validate Upload Employee")
                .assertChild(softly.assertThat(labelImportEmployeesbyCsv().isDisplayed())
                                .as("Import Employees by CSV File label is displayed")
                                .isTrue(),
                        "Import Employees by CSV File label is displayed");

        buttonChooseFile().click();
        sleep(1000);

        String filePath = Arrays.asList(this.getClass()
                .getProtectionDomain().getCodeSource().getLocation().getPath()
                .split("webportal")).get(0) + "webportal";

        new Robo()
                .selectFile(filePath.substring(1), "ET_Sample_Bulk_Upload.csv");
        sleep(1000);

        buttonSubmit().click();
        sleep(4000);

        reporter.assertChild(softly.assertThat(labelAlert().isDisplayed())
                        .as("Contact Successfully Imported Alert is displayed")
                        .isTrue(),
                "Contact Successfully Imported Alert is displayed");

        buttonClose().click();
        sleep(1000);

        return this;
    }
}