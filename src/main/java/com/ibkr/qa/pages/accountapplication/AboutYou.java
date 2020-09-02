package com.ibkr.qa.pages.accountapplication;

import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AboutYou extends AccountApplication {

    public AboutYou withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public AboutYou withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelAboutYou() {
        return elementPresent(By.xpath("//h1[contains(text(),'About You')]"));
    }

    private WebElement dropDownSalution() {
        return elementPresent(By.id("salutation"));
    }

    private WebElement inputFirstName() {
        return elementPresent(By.id("firstName"));
    }

    private WebElement inputLastName() {
        return elementPresent(By.id("lastName"));
    }

    private WebElement checkBoxNoAlternateName() {
        return elementPresent(By.xpath("//div[input[@id='noAlternateName']]"));
    }

    private WebElement inputAddressLineOne() {
        return elementPresent(By.id("street1Main"));
    }

    private WebElement dropDownState() {
        return elementPresent(By.id("stateMain_chosen"));
    }

    private WebElement inputState() {
        return elementPresent(By.xpath("//div[@id='stateMain_chosen']//div[@class='chosen-search']/input"));
    }

    private WebElement inputCityMain() {
        return elementPresent(By.id("cityMain"));
    }

    private WebElement inputPostalCodeMain() {
        return elementPresent(By.id("postalCodeMain"));
    }

    private WebElement inputNumber1() {
        return elementPresent(By.id("number1"));
    }

    private WebElement inputDob() {
        return elementPresent(By.id("date"));
    }

    private WebElement dropDownMaritalStatus() {
        return elementPresent(By.id("maritalStatus"));
    }

    private WebElement dropDownDependents() {
        return elementPresent(By.id("numOfDependents"));
    }

    private WebElement inputResidencyNumber() {
        return elementPresent(By.id("taxResidency1Number"));
    }

    private WebElement dropDownDocumentType() {
        return elementPresent(By.id("identificationDocumentType1"));
    }

    private WebElement inputIdentificationNumber() {
        return elementPresent(By.id("identificationNumber1"));
    }

    private WebElement dropDownEmploymentType() {
        return elementPresent(By.id("employmentType"));
    }

    private List<WebElement> checkBoxSourcesOfWealth() {
        return elementsPresent(By.xpath("//div[@class='source-of-wealth']//div[input[@type='checkbox']]"));
    }

    private WebElement dropDownSecurityQuestionOne() {
        return elementPresent(By.id("question0"));
    }

    private WebElement inputAnswerOne() {
        return elementPresent(By.id("answer0"));
    }

    private WebElement dropDownSecurityQuestionTwo() {
        return elementPresent(By.id("question1"));
    }

    private WebElement inputAnswerTwo() {
        return elementPresent(By.id("answer1"));
    }

    private WebElement dropDownSecurityQuestionThree() {
        return elementPresent(By.id("question2"));
    }

    private WebElement inputAnswerThree() {
        return elementPresent(By.id("answer2"));
    }

    public AccountApplication fillForm() {

        changeDropdown(dropDownSalution(), "Mr.");
        inputFirstName().sendKeys("黄");
        inputLastName().sendKeys("丁");
        checkBoxNoAlternateName().click();
        inputAddressLineOne().sendKeys("test123");
        inputCityMain().sendKeys("Beijing");
        dropDownState().click();
        inputState().sendKeys("Beijing" + Keys.ENTER);
        inputPostalCodeMain().sendKeys("10103");
        inputNumber1().sendKeys("+8615177309457");
        inputDob().sendKeys("1980-08-30");
        changeDropdown(dropDownMaritalStatus(), "Single");
        changeDropdown(dropDownDependents(), "0");
        inputResidencyNumber().sendKeys("450329198904304321");
        changeDropdown(dropDownDocumentType(), "Resident Identity Card Identification Number (RIC)");
        sleep(500);
        inputIdentificationNumber().sendKeys("450329198904304321");
        changeDropdown(dropDownEmploymentType(), "Homemaker");
        sleep(1000);
        random(checkBoxSourcesOfWealth(), 2).forEach(checkBox -> checkBox.click());
        sleep(500);
        changeDropdown(dropDownSecurityQuestionOne(), "What is name of first boyfriend/girlfriend?");
        inputAnswerOne().sendKeys("test123");
        changeDropdown(dropDownSecurityQuestionTwo(), "What is the name of a school you attended?");
        inputAnswerTwo().sendKeys("test1234");
        changeDropdown(dropDownSecurityQuestionThree(), "In what city were you married?");
        inputAnswerThree().sendKeys("test12345");
        buttonContinue().click();
        sleep(8000);

        reporter.createChild("About You Page Validation")
                .childInfo("About You Page Filled");

        return (AccountApplication) this;
    }
}
