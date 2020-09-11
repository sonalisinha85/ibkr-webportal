package com.ibkr.qa.pages.client;

import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BillPay extends ClientPortal{

    private List<String> tabs = new ArrayList(
            Arrays.asList(
                    "Home",
                    "Search Directory",
                    "Add Payee",
                    "Manage Payees",
                    "Make Payment",
                    "Payment Activity"
            ));

    public BillPay withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public BillPay withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement buttonContinue() {
        return elementVisible(By.xpath("//div[@class='panel-btn-right']//am-button[@btn-text='Continue']"));
    }

    private WebElement tab(String tab) {
        return elementVisible(By.xpath("//div[@id='billpay-menu']//a/span[text()='" + tab + "']"));
    }

    private List<WebElement> tabs() {
        return elementsVisible(By.xpath("//div[@id='billpay-menu']//a/span"));
    }

    private WebElement buttonSearch() {
        return elementVisible(By.xpath("//input[@id='search']"));
    }

    private WebElement link(String name) {
        return elementVisible(By.xpath("//a[text()='" + name + "']"));
    }

    private WebElement labelBillPay() {
        return elementVisible(By.xpath("//h3[contains(.,'Bill Pay')]"));
    }

    public BillPay validateBillPay(){

        buttonMenu().click();
        sleep(500);
        menu("Transfer & Pay").click();
        sleep(500);
        subMenu("Bill Pay").click();
        sleep(3000);
        buttonContinue().click();
        sleep(3000);

        reporter.createChild("Validate Bill Pay")
                .assertChild(softly.assertThat(labelBillPay().isDisplayed())
                                .as("Bill Pay label is displayed")
                                .isTrue(),
                        "Bill Pay label is displayed");

        tabs().forEach(tab->{

            reporter.assertChild(softly.assertThat(tab.getText())
                                    .as(tab.getText() + " tab is displayed")
                                    .isIn(tabs),
                    tab.getText() + " tab is displayed");

            tab.click();
            if (tab.getText().equals("Home"))
                reporter.assertChild(softly.assertThat(link("Make Payment").isDisplayed())
                                .as("Make Payment link is displayed")
                                .isTrue(),
                        "Make Payment link is displayed");
            else if (tab.getText().equals("Search Directory") || tab.getText().equals("Add Payee"))
                reporter.assertChild(softly.assertThat(buttonSearch().isDisplayed())
                                .as("Search Button is displayed")
                                .isTrue(),
                        "Search Button is displayed");
            else if (tab.getText().equals("Manage Payees"))
                reporter.assertChild(softly.assertThat(link("Add Payee").isDisplayed())
                                .as("Add Payee link is displayed")
                                .isTrue(),
                        "Add Payee link is displayed");

        });

        return this;
    }
}
