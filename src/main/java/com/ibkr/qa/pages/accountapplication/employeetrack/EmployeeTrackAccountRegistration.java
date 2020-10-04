package com.ibkr.qa.pages.accountapplication.employeetrack;

import com.ibkr.qa.navigation.WebOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeTrackAccountRegistration extends WebOperation {

    public EmployeeTrackAccountRegistration withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    private WebElement buttonOpenAccount() {
        return elementPresent(By.xpath("//li[@class='nav-item d-none d-lg-block']/a[text()='Open Account']"));
    }

    private WebElement buttonComplianceOfficer() {
        return elementPresent(By.xpath("//li/a[text()='Compliance Officer']"));
    }

    private WebElement inputUserName() {
        return elementPresent(By.id("usernamePrefix"));
    }

    private WebElement inputPassword() {
        return elementPresent(By.id("password"));
    }

    private WebElement inputPassword2() {
        return elementPresent(By.id("password2"));
    }

    private WebElement inputEmail() {
        return elementPresent(By.id("email_address"));
    }

    private WebElement inputEmail2() {
        return elementPresent(By.id("email_address2"));
    }

    private WebElement dropDownCountry() {
        return elementPresent(By.id("legal_country"));
    }

    private WebElement dropDownState() {
        return elementPresent(By.id("us_state"));
    }

    private WebElement buttonContinue() {
        return elementPresent(By.id("continueID"));
    }

    private WebElement inputCompanyName() {
        return elementPresent(By.id("company_name"));
    }

    private WebElement inputAbbrevName() {
        return elementPresent(By.id("abbrev_name"));
    }

    private WebElement inputFirstName() {
        return elementPresent(By.id("first_name"));
    }

    private WebElement inputLastName() {
        return elementPresent(By.id("last_name"));
    }

    private WebElement inputPrimaryPhone() {
        return elementPresent(By.id("home_phone"));
    }

    private WebElement inputStreet1() {
        return elementPresent(By.id("street"));
    }

    private WebElement inputCity() {
        return elementPresent(By.id("city"));
    }

    private WebElement inputZipCode() {
        return elementPresent(By.id("postal_code"));
    }

    private WebElement dropDownAccountSupport() {
        return elementPresent(By.id("how_found"));
    }

    public EmployeeTrackAccountRegistration fillForm1() {

        buttonOpenAccount().click();
        sleep(1000);
        buttonComplianceOfficer().click();
        sleep(2000);
        inputUserName().sendKeys("ibk" + getDate());
        sleep(1000);
        inputPassword().sendKeys("tester12");
        inputPassword2().sendKeys("tester12");
        inputEmail().sendKeys("ssinha@interactivebrokers.com");
        inputEmail2().sendKeys("ssinha@interactivebrokers.com");
        changeDropdown(dropDownCountry(), "United States");
        changeDropdown(dropDownState(), "New Jersey");
        buttonContinue().click();
        sleep(2000);

        return this;
    }

    public EmployeeTrackAccountRegistration fillForm2() {

        inputCompanyName().sendKeys("ibk" + getDate());
        inputAbbrevName().sendKeys("ibk" + getDate());
        inputFirstName().sendKeys("Regression");
        inputLastName().sendKeys("Test");
        inputPrimaryPhone().sendKeys("2014542211");
        inputStreet1().sendKeys("111 Webster Avenue");
        inputCity().sendKeys("Jersey City");
        changeDropdown(dropDownState(), "New Jersey");
        inputZipCode().sendKeys("07307");
        sleep(1000);
        changeDropdown(dropDownAccountSupport(), "Other");
        buttonContinue().click();
        sleep(1000);
        buttonContinue().click();
        sleep(2000);

        return this;
    }

}
