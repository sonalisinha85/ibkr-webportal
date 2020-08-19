package pages.tabs.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reporter.TestReporter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewContact extends Contacts {

    private List<String> tabs = new ArrayList(
            Arrays.asList("Information",
                    "Agenda",
                    "Reports / Tax Docs",
                    "Transfer & Pay",
                    "Tools",
                    "PortfolioAnalyst",
                    "Margin Requirements"));

    private List<String> headingsInformationTab = new ArrayList(
            Arrays.asList("Information",
                    "Profile Information",
                    "Financial Information",
                    "Trading Experience & Permissions",
                    "Configuration"));

    private List<String> headingsAgendaTab = new ArrayList(
            Arrays.asList("Agenda",
                    "Workflows",
                    "Notes",
                    "Documents",
                    "Events",
                    "Notifications"));

    public ViewContact withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public ViewContact withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private List<WebElement> listNavigationTabs() {
        return elementsPresent(By.xpath("//ul[@class='nav nav-tabs nav-lines-large']//a"));
    }

    private List<WebElement> listHeadingsInformationTab() {
        return elementsPresent(By.xpath("//div[contains(@id,'details-tab-information')]//span[@class='heading']"));
    }

    private List<WebElement> listHeadingsAgendaTab() {
        return elementsPresent(By.xpath("//div[contains(@id,'details-tab-communication')]//span[@class='heading']"));
    }

    public ViewContact validateViewContact() {

        reporter.createChild("View Contact Validation");

        listNavigationTabs().forEach(tab -> {

            sleep(500);
            reporter.assertChild(softly.assertThat(tab.getText().trim())
                            .as("Tab is present")
                            .isIn(tabs),
                    tab.getText().trim() + " Tab is present");

            if (tab.getText().trim().equals("Information")) {

                tab.click();

                listHeadingsInformationTab().forEach(heading ->
                        reporter.assertChild(softly.assertThat(heading.getText().trim())
                                        .as("Information Tab Heading is present")
                                        .isIn(headingsInformationTab),
                                heading.getText().trim() + " Heading is present"));
            } else if (tab.getText().trim().equals("Agenda")) {

                tab.click();

                listHeadingsAgendaTab().forEach(heading ->
                        reporter.assertChild(softly.assertThat(heading.getText().trim())
                                        .as("Agenda Tab Heading is present")
                                        .isIn(headingsAgendaTab),
                                heading.getText().trim() + " Heading is present"));
            }
        });

        return this;
    }
}
