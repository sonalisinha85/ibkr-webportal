package com.ibkr.qa.pages.accountapplication.chinesenative;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountRegistration extends AccountApplication {

    public AccountRegistration withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    private WebElement inputEmail() {
        return elementPresent(By.id("emailAddress"));
    }

    private WebElement inputUserName() {
        return elementPresent(By.id("username"));
    }

    private WebElement inputPassword() {
        return elementPresent(By.id("password"));
    }

    private WebElement inputConfirmPassword() {
        return elementPresent(By.id("password2"));
    }

    private WebElement dropDownCountry() {
        return elementPresent(By.id("countryResidentialResidence_chosen"));
    }

    private WebElement inputCountry() {
        return elementPresent(By.xpath("//div[@id='countryResidentialResidence_chosen']//div[@class='chosen-search']/input"));
    }

    private WebElement checkBoxAcknowledgement() {
        return elementPresent(By.xpath("//div[input[@type='checkbox']]"));
    }

    private WebElement buttonCreateAccount() {
        return elementPresent(By.xpath("//button[contains(text(),'Create Account')]"));
    }

    public AccountRegistration fillForm() {

        buttonOpenAccount().click();
        sleep(1000);
        buttonStartApplication().click();
        sleep(3000);

        inputEmail().sendKeys("ssinha@interactivebrokers.com");
//        inputUserName().sendKeys("ibk" + getDate());
        inputUserName().sendKeys("ibk210226");
        inputPassword().sendKeys("tester12");
        sleep(1000);
        inputConfirmPassword().sendKeys("tester12");
        dropDownCountry().click();
        inputCountry().sendKeys("China" + Keys.ENTER);
        checkBoxAcknowledgement().click();
        buttonCreateAccount().click();
        sleep(10000);

        return this;
    }
}
