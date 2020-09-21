package com.ibkr.qa.pages.client;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    private List<String> advertiseServices = new ArrayList(
            Arrays.asList(
                    "Technology",
                    "Research",
                    "Business Development"
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
        return elementVisible(By.xpath("//h3[contains(.,'Find Services')]"));
    }

    private List<WebElement> labelServices() {
        return elementsVisible(By.xpath("//div[@ng-repeat]/h6"));
    }

    private WebElement buttonService(String serviceName) {
        return elementVisible(By.xpath("//a[contains(.,'" + serviceName + "')]"));
    }

    private WebElement labelService(String serviceName) {
        return elementVisible(By.xpath("//h3[contains(.,'" + serviceName + "')]"));
    }

    private List<WebElement> cardsProviders() {
        return elementsVisible(By.xpath("//div[@class='provider']"));
    }

    private WebElement labelAdvertiseServices() {
        return elementVisible(By.xpath("//h3[contains(.,'Advertise Services')]"));
    }

    private List<WebElement> labelAdvertise() {
        return elementsVisible(By.xpath("//div[@ng-repeat]/h6"));
    }

    private WebElement buttonCareers() {
        return elementVisible(By.xpath("//a[contains(.,'Careers')]"));
    }

    private WebElement labelCareersMarketplace() {
        return elementVisible(By.xpath("//h3[contains(.,'Application for the Careers Marketplace')]"));
    }

    private WebElement inputContactName() {
        return elementVisible(By.xpath("//input[@name='contactName']"));
    }

    private WebElement inputEmailAddress() {
        return elementVisible(By.xpath("//input[@name='emailAddress']"));
    }

    private WebElement dropDownCountry() {
        return elementVisible(By.xpath("//select[@name='country']"));
    }

    private WebElement inputCity() {
        return elementVisible(By.xpath("//input[@name='city']"));
    }

    private WebElement dropDownPhoneCountry() {
        return elementVisible(By.xpath("//select[@name='phoneNumberCountry_0']"));
    }

    private WebElement inputPhoneNumber() {
        return elementVisible(By.xpath("//input[@name='phoneNumber_0']"));
    }

    private WebElement inputJobTitle() {
        return elementVisible(By.xpath("//input[@name='jobTitle']"));
    }

    private WebElement inputYearsOfExperience() {
        return elementVisible(By.xpath("//input[@name='yearsExperience']"));
    }

    private WebElement inputResume() {
        return elementVisible(By.xpath("//textarea[@name='summary']"));
    }

    private WebElement buttonContinue() {
        return elementVisible(By.xpath("//div[@class='panel-btn-right']//am-button[@btn-text='Continue']"));
    }

    private WebElement inputSignature() {
        return elementVisible(By.xpath("//input[@name='signature_0']"));
    }

    private WebElement buttonSubmitApplication() {
        return elementVisible(By.xpath("//div[@class='panel-btn-right']//am-button[@btn-text='Submit Application']"));
    }

    private WebElement labelApplicationSubmitted() {
        return elementVisible(By.xpath("//h3[text ()='Your application has been submitted']"));
    }

    private WebElement buttonOk() {
        return elementVisible(By.xpath("//div[@class='panel-btn-right']//am-button[@btn-text='Ok']"));
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

    public InvestorMarketplace validateAdvertiseServicesNavigation() {

        buttonMenu().click();
        sleep(500);
        menu("Marketplace").click();
        sleep(200);
        subMenu("Advertise Services").click();
        sleep(1000);

        reporter.createChild("Advertise Services Validation")
                .assertChild(softly.assertThat(labelAdvertiseServices().isDisplayed())
                                .as("Advertise Services Label is displayed")
                                .isEqualTo(true),
                        "Advertise Services Label is displayed");

        labelAdvertise().forEach(label ->
                reporter.assertChild(softly.assertThat(label.getText())
                                .as(label.getText() + " service is displayed")
                                .isIn(advertiseServices),
                        label.getText() + " service is displayed"));

        buttonCareers().click();
        sleep(1000);

        fillApplicantInformation();

        return this;
    }

    private void fillApplicantInformation() {

        reporter.assertChild(softly.assertThat(labelCareersMarketplace().isDisplayed())
                        .as("Application for the Careers Marketplace Label is displayed")
                        .isEqualTo(true),
                "Application for the Careers Marketplace Label is displayed");

        inputContactName().sendKeys("Test");
        inputEmailAddress().sendKeys("Test123@gmail.com");
        changeDropdown(dropDownCountry(), "United States");
        inputCity().sendKeys("Jersey City");
        changeDropdown(dropDownPhoneCountry(), "United States");
        inputPhoneNumber().sendKeys("2016869911");
        inputJobTitle().sendKeys("RegTest");
        inputYearsOfExperience().sendKeys("9");
        inputResume().sendKeys("Regression Test");
        buttonContinue().click();
        sleep(500);
        inputSignature().sendKeys("Test");
        buttonSubmitApplication().click();
        sleep(500);

        reporter.assertChild(softly.assertThat(labelApplicationSubmitted().isDisplayed())
                        .as("Your application has been submitted Label is displayed")
                        .isEqualTo(true),
                "Your application has been submitted Label is displayed");

        buttonOk().click();
    }

}
