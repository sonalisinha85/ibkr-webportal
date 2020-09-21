package com.ibkr.qa.pages.accountapplication.portfolioanalyst;

import com.ibkr.qa.navigation.WebOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortfolioAnalystAccountRegistration extends WebOperation {

    public PortfolioAnalystAccountRegistration withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    private WebElement menuServices() {
        return elementPresent(By.xpath("//li/a[@id='nav-products' and text()='Services']"));
    }

    private WebElement dropDownPortfolioAnalyst() {
        return elementPresent(By.xpath("//div/a[@class='dropdown-item' and text()='PortfolioAnalyst']"));
    }

    private WebElement buttonOpenAccount() {
        return elementPresent(By.xpath("//li/a[text()='Open Account']"));
    }

    private WebElement buttonOpenFreeAccount() {
        return elementPresent(By.xpath("//div/a[text()='Open FREE PortfolioAnalyst Account']"));
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

    private WebElement inputFirstName() {
        return elementPresent(By.id("firstName"));
    }

    private WebElement inputLastName() {
        return elementPresent(By.id("lastName"));
    }

    private WebElement inputDob() {
        return elementPresent(By.id("date"));
    }

    private WebElement buttonCreateAccount() {
        return elementPresent(By.xpath("//button[contains(text(),'Create Account')]"));
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

    private WebElement buttonAgree() {
        return elementPresent(By.xpath("//div/button[text()='Agree']"));
    }

    public PortfolioAnalystAccountRegistration fillForm() {

        menuServices().click();
        dropDownPortfolioAnalyst().click();
        sleep(1500);
        switchTab(1);
        buttonOpenAccount().click();
        sleep(1500);
        buttonOpenFreeAccount().click();
        sleep(1500);
        switchTab(2);

        inputEmail().sendKeys("ssinha@interactivebrokers.com");
        inputUserName().sendKeys("ibk" + getDate());
        inputPassword().sendKeys("tester12");
        sleep(1000);
        inputConfirmPassword().sendKeys("tester12");
        inputFirstName().sendKeys("Regression");
        inputLastName().sendKeys("Test");
        inputDob().sendKeys("19800101");
        selectDropDown(dropDownSecurityQuestionOne()).selectByIndex(1);
        inputAnswerOne().sendKeys("test123");
        selectDropDown(dropDownSecurityQuestionTwo()).selectByIndex(1);
        inputAnswerTwo().sendKeys("test1234");
        selectDropDown(dropDownSecurityQuestionThree()).selectByIndex(1);
        inputAnswerThree().sendKeys("test12345");
        buttonAgree().click();
        sleep(1000);
        buttonCreateAccount().click();
        sleep(10000);

        return this;
    }
}
