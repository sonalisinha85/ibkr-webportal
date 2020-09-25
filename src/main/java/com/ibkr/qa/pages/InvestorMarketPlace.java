package com.ibkr.qa.pages;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.ibkr.qa.staticdata.AdvisorInvestorMarketPlaceServices.*;
import static com.ibkr.qa.staticdata.BrokerInvestorMarketPlaceServices.*;
import static com.ibkr.qa.staticdata.HedgeFundAdvisorInvestorMarketPlaceServices.*;

public class InvestorMarketPlace extends Portal {

    public InvestorMarketPlace withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public InvestorMarketPlace withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private List<WebElement> labelServices() {
        return elementsVisible(By.xpath("//div[@ng-repeat]/h6"));
    }

    private WebElement labelSubService(String service, String subService) {
        return elementVisible(By.xpath("//h6[text()='" + service + "']" +
                "/ancestor::div[@ng-repeat]//a[contains(text(),'" + subService + "')]"));
    }

    private WebElement buttonAdvisors() {
        return elementVisible(By.xpath("//a[contains(.,'Advisor')]"));
    }

    private WebElement buttonProgrammingConsultants() {
        return elementVisible(By.xpath("//a[contains(.,'Programming Consultants')]"));
    }

    private WebElement labelProgrammingConsultants() {
        return elementVisible(By.xpath("//h3[contains(.,'Application for the Programming Consultants Marketplace')]"));
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

    private WebElement inputLanguage() {
        return elementVisible(By.xpath("//input[@name='programmingLanguages_0']"));
    }

    private WebElement inputServicesRequired() {
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

    private List<WebElement> cardsProviders() {
        return elementsVisible(By.xpath("//div[@class='provider']"));
    }

    private WebElement buttonSoftwareVendor() {
        return elementVisible(By.xpath("//a[contains(.,'Software Vendors')]"));
    }

    private List<WebElement> radioButtonsAccountPicker() {
        return elementsVisible(By.xpath("//span[@ng-switch-when='status' and text()!='Unknown']/ancestor::tbody//i[@class='fa fa-lg fa-circle-thin']"));
    }

    protected WebElement buttonAccountSelector(String action) {
        return elementVisible(By.xpath("//am-button[@btn-text='" + action + "']"));
    }

    private WebElement buttonFinancingFirms() {
        return elementVisible(By.xpath("//a[contains(.,'Financing Firms')]"));
    }

    private WebElement labelFinancingFirms() {
        return elementVisible(By.xpath("//h3[contains(.,'Application for the Financing Firms Marketplace')]"));
    }

    private WebElement buttonAdvertisingFirms() {
        return elementVisible(By.xpath("//a[contains(.,'Advertising Firms')]"));
    }

    private WebElement labelAdvertisingFirms() {
        return elementVisible(By.xpath("//h3[contains(.,'Application for the Advertising Firms Marketplace')]"));
    }

    public InvestorMarketPlace validateAdvisorFindServicesNavigation() {

        menuContains("Marketplace").click();
        sleep(1000);
        subMenu("Find Services").click();
        sleep(1000);

        reporter.createChild("Advisor Find Service Validation");

        labelServices().forEach(label -> reporter.assertChild(softly.assertThat(label.getText())
                        .as(label.getText() + " service label is displayed")
                        .isIn(advisorServices),
                label.getText() + " service label is displayed"));

        advisorResearchServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Research", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        advisorTechnologyServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Technology", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));


        advisorBusinessDevelopmentServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Business Development", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));


        advisorAdministrationServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Administration", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));


        advisorInvestingServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Investing", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        buttonAdvisors().click();
        sleep(2000);

        random(cardsProviders(), 5).forEach(card ->
                reporter.assertChild(softly.assertThat(card.isDisplayed())
                                .as("Advisor card is displayed")
                                .isEqualTo(true),
                        "Advisor card is displayed"));

        return this;
    }

    public InvestorMarketPlace validateAdvisorAdvertiseServicesNavigation() {

        menuContains("Marketplace").click();
        sleep(1000);
        subMenu("Advertise Services").click();
        sleep(1000);

        reporter.createChild("Advisor Advertise Service Validation");

        labelServices().forEach(label -> reporter.assertChild(softly.assertThat(label.getText())
                        .as(label.getText() + " service label is displayed")
                        .isIn(advisorServices),
                label.getText() + " service label is displayed"));

        advisorResearchAdvertiseServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Research", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        advisorTechnologyAdvertiseServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Technology", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));


        advisorBusinessDevelopmentAdvertiseServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Business Development", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));


        advisorInvestingAdvertiseServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Investing", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        buttonProgrammingConsultants().click();
        sleep(1000);

        fillApplicantInformation();

        return this;
    }

    private void fillApplicantInformation() {

        reporter.assertChild(softly.assertThat(labelProgrammingConsultants().isDisplayed())
                        .as("Application for the Programming Consultants Marketplace Label is displayed")
                        .isEqualTo(true),
                "Application for the Programming Consultants Marketplace Label is displayed");

        inputContactName().sendKeys("Test");
        inputEmailAddress().sendKeys("Test123@gmail.com");
        changeDropdown(dropDownCountry(), "United States");
        inputCity().sendKeys("Jersey City");
        changeDropdown(dropDownPhoneCountry(), "United States");
        inputPhoneNumber().sendKeys("2016869911");
        inputLanguage().sendKeys("English");
        inputServicesRequired().sendKeys("Test");
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

    public InvestorMarketPlace validateBrokerFindServicesNavigation() {

        menuContains("Marketplace").click();
        sleep(1000);
        subMenu("Find Services").click();
        sleep(1000);
        pickAccount();

        reporter.createChild("Broker Find Service Validation");

        labelServices().forEach(label -> reporter.assertChild(softly.assertThat(label.getText())
                        .as(label.getText() + " service label is displayed")
                        .isIn(brokerFindServices),
                label.getText() + " service label is displayed"));

        brokerResearchFindServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Research", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        brokerTechnologyFindServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Technology", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        brokerBusinessDevelopmentFindServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Business Development", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        brokerAdministrationFindServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Administration", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        buttonSoftwareVendor().click();
        sleep(2000);

        random(cardsProviders(), 5).forEach(card ->
                reporter.assertChild(softly.assertThat(card.isDisplayed())
                                .as("Software Vendors card is displayed")
                                .isEqualTo(true),
                        "Software Vendors is displayed"));

        return this;
    }

    public InvestorMarketPlace validateBrokerAdvertiseServicesNavigation() {

        menuContains("Marketplace").click();
        sleep(1000);
        subMenu("Advertise Services").click();
        sleep(1000);
        pickAccount();

        reporter.createChild("Broker Advertise Service Validation");

        labelServices().forEach(label -> reporter.assertChild(softly.assertThat(label.getText())
                        .as(label.getText() + " service label is displayed")
                        .isIn(brokerAdvertiseServices),
                label.getText() + " service label is displayed"));

        brokerResearchAdvertiseServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Research", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        brokerTechnologyAdvertiseServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Technology", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));


        brokerBusinessDevelopmentAdvertiseServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Business Development", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));


        brokerInvestingAdvertiseServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Investing", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        buttonFinancingFirms().click();
        sleep(1000);

        fillBrokerApplicantInformation();

        return this;
    }

    private void fillBrokerApplicantInformation() {

        reporter.assertChild(softly.assertThat(labelFinancingFirms().isDisplayed())
                        .as("Application for the Financing Firms Marketplace Label is displayed")
                        .isEqualTo(true),
                "Application for the Financing Firms Marketplace Label is displayed");

        inputContactName().sendKeys("Test");
        inputEmailAddress().sendKeys("Test123@gmail.com");
        changeDropdown(dropDownCountry(), "United States");
        inputCity().sendKeys("Jersey City");
        changeDropdown(dropDownPhoneCountry(), "United States");
        inputPhoneNumber().sendKeys("2016869911");
        inputServicesRequired().sendKeys("Test");
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

    protected void pickAccount() {

        random(radioButtonsAccountPicker(), 1).get(0).click();
        sleep(500);
        buttonAccountSelector("Continue").click();
        sleep(3000);
    }

    public InvestorMarketPlace validateHedgeFundFindServicesNavigation() {

        menuContains("Marketplace").click();
        sleep(1000);
        subMenu("Find Services").click();
        sleep(1000);

        reporter.createChild("Hedge Fund Advisor Find Service Validation");

        labelServices().forEach(label -> reporter.assertChild(softly.assertThat(label.getText())
                        .as(label.getText() + " service label is displayed")
                        .isIn(hedgeFundAdvisorFindServices),
                label.getText() + " service label is displayed"));

        hedgeFundAdvisorResearchFindServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Research", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        hedgeFundAdvisorTechnologyFindServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Technology", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));


        hedgeFundAdvisorBusinessDevelopmentFindServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Business Development", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));


        hedgeFundAdvisorAdministrationFindServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Administration", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));


        hedgeFundAdvisorInvestingFindServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Investing", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        buttonAdvisors().click();
        sleep(2000);

        random(cardsProviders(), 5).forEach(card ->
                reporter.assertChild(softly.assertThat(card.isDisplayed())
                                .as("Advisor card is displayed")
                                .isEqualTo(true),
                        "Advisor card is displayed"));

        return this;
    }

    public InvestorMarketPlace validateHedgeFundAdvisorAdvertiseServicesNavigation() {

        menuContains("Marketplace").click();
        sleep(1000);
        subMenu("Advertise Services").click();
        sleep(1000);

        reporter.createChild("Hedge Fund Advisor Advertise Service Validation");

        labelServices().forEach(label -> reporter.assertChild(softly.assertThat(label.getText())
                        .as(label.getText() + " service label is displayed")
                        .isIn(hedgeFundAdvisorFindServices),
                label.getText() + " service label is displayed"));

        hedgeFundAdvisorResearchAdvertiseServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Research", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        hedgeFundAdvisorTechnologyAdvertiseServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Technology", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));


        hedgeFundAdvisorBusinessDevelopmentAdvertiseServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Business Development", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));


        hedgeFundAdvisorInvestingAdvertiseServices.forEach(subService ->
                reporter.assertChild(softly.assertThat(labelSubService("Investing", subService).isDisplayed())
                                .as(subService + " label is displayed")
                                .isTrue(),
                        subService + " label is displayed"));

        buttonAdvertisingFirms().click();
        sleep(1000);

        fillHedgeFundAdvisorApplicantInformation();

        return this;
    }

    private void fillHedgeFundAdvisorApplicantInformation() {

        reporter.assertChild(softly.assertThat(labelAdvertisingFirms().isDisplayed())
                        .as("Application for the Programming Consultants Marketplace Label is displayed")
                        .isEqualTo(true),
                "Application for the Programming Consultants Marketplace Label is displayed");

        inputContactName().sendKeys("Test");
        inputEmailAddress().sendKeys("Test123@gmail.com");
        changeDropdown(dropDownCountry(), "United States");
        inputCity().sendKeys("Jersey City");
        changeDropdown(dropDownPhoneCountry(), "United States");
        inputPhoneNumber().sendKeys("2016869911");
        inputServicesRequired().sendKeys("Test");
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