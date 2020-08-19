package pages.client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reporter.TestReporter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvestorMarketplace extends ClientPortal {

    private List<String> services = new ArrayList(
            Arrays.asList(
                    "Business Development",
                    "Administration",
                    "Research",
                    "Investing",
                    "Technology"
            ));

    public InvestorMarketplace withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public InvestorMarketplace withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelFindServices() {
        return elementPresent(By.xpath("//h3[contains(.,'Find Services')]"));
    }

    private List<WebElement> labelServices() {
        return elementsPresent(By.xpath("//div[@ng-repeat]/h6"));
    }

    private WebElement buttonService(String serviceName) {
        return elementPresent(By.xpath("//a[contains(.,'" + serviceName + "')]"));
    }

    private WebElement labelService(String serviceName) {
        return elementPresent(By.xpath("//h3[contains(.,'" + serviceName + "')]"));
    }

    private List<WebElement> cardsProviders() {
        return elementsPresent(By.xpath("//div[@class='provider']"));
    }

    public InvestorMarketplace validateFindServicesNavigation() {

        buttonMenu().click();
        sleep(500);
        menu("Marketplace").click();
        sleep(200);
        subMenu("Find Services").click();
        sleep(1000);

        reporter.createChild("Find Services Validation")
                .assertChild(softly.assertThat(labelFindServices().isDisplayed())
                                .as("Find Services Label is displayed")
                                .isEqualTo(true),
                        "Find Services Label is displayed");

        labelServices().forEach(label ->
                reporter.assertChild(softly.assertThat(label.getText())
                                .as(label.getText() + " service is displayed")
                                .isIn(services),
                        label.getText() + " service is displayed"));

        buttonService("Advisors").click();
        sleep(1000);

        reporter.assertChild(softly.assertThat(labelService("Advisors").isDisplayed())
                        .as("Advisors Label is displayed")
                        .isEqualTo(true),
                "Advisors Label is displayed");


        random(cardsProviders(), 5).forEach(card ->
                reporter.assertChild(softly.assertThat(card.isDisplayed())
                                .as("Advisor card is displayed")
                                .isEqualTo(true),
                        "Advisor card is displayed"));

        return this;
    }
}
