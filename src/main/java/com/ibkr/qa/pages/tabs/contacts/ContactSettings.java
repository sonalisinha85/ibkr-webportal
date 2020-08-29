package com.ibkr.qa.pages.tabs.contacts;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactSettings extends Contacts {

    private List<String> columnsSettings = new ArrayList(
            Arrays.asList(
                    "Title",
                    "Contact",
                    "Type",
                    "Accounts",
                    "Email",
                    "Phone",
                    "Address",
                    "NAV"
            ));

    public ContactSettings withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public ContactSettings withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private List<WebElement> buttonsColumns() {
        return elementsPresent(By.xpath("//p[contains(@ng-repeat,'columnName')]/a"));
    }

    private WebElement buttonReset() {
        return elementPresent(By.xpath("//p/a[text()='Reset']"));
    }

    public ContactSettings validateSettingsMenu() {

        buttonReset().click();
        buttonSettingsContact().click();
        sleep(500);

        reporter.createChild("Settings Menu validation");

        buttonsColumns().forEach(column -> {

            String colName = column.getText().trim();

            reporter.assertChild(softly.assertThat(colName)
                    .as("Column is listed in Settings Menu")
                    .isIn(columnsSettings), colName + "is listed in Settings Menu");

            if (!colName.equals("Accounts")) {

                column.click();
                sleep(500);
                reporter.assertChild(softly.assertThat(headerColumn(colName).isDisplayed())
                        .as(colName + " is removed from header")
                        .isEqualTo(false), colName + " is removed from header");
            }
        });

        buttonReset().click();
        return this;
    }
}
