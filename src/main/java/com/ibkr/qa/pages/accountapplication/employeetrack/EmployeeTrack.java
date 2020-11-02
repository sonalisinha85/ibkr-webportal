package com.ibkr.qa.pages.accountapplication.employeetrack;

import com.ibkr.qa.navigation.WebOperation;
import com.ibkr.qa.pages.Login;
import com.ibkr.qa.reporter.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeTrack extends WebOperation {

    public EmployeeTrack withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public EmployeeTrack withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement dropDownSecurityQuestionOne() {
        return elementPresent(By.xpath("//select[@name='question_0']"));
    }

    private WebElement inputAnswerOne() {
        return elementPresent(By.xpath("//input[@name='answer_0']"));
    }

    private WebElement dropDownSecurityQuestionTwo() {
        return elementPresent(By.xpath("//select[@name='question_1']"));
    }

    private WebElement inputAnswerTwo() {
        return elementPresent(By.xpath("//input[@name='answer_1']"));
    }

    private WebElement dropDownSecurityQuestionThree() {
        return elementPresent(By.xpath("//select[@name='question_2']"));
    }

    private WebElement inputAnswerThree() {
        return elementPresent(By.xpath("//input[@name='answer_2']"));
    }

    private WebElement buttonContinue() {
        return elementPresent(By.xpath("//div[@class='panel-btn-right']//am-button[@btn-text='Continue']"));
    }

    private WebElement buttonContinueAccountManagement() {
        return elementPresent(By.xpath("//am-button[@btn-text='Continue to Account Management']"));
    }

    private WebElement labelPortal() {

        return elementVisible(By.xpath("//h3[contains(text(),'Compliance Portal')]"));
    }

    public EmployeeTrack loginComplianceOfficer() {

        new Login()
                .withDriver(driver)
                .withReporter(reporter)
//                .withUserName("ibk" + getDate())
                .withUserName("ibk200002")
                .withPassword("tester12")
                .login();

        return this;
    }

    public EmployeeTrack validateComplianceOfficer() {

        reporter.createChild("Compliance Officer Validation");

        selectDropDown(dropDownSecurityQuestionOne()).selectByIndex(1);
        inputAnswerOne().sendKeys("test123");
        selectDropDown(dropDownSecurityQuestionTwo()).selectByIndex(1);
        inputAnswerTwo().sendKeys("test1234");
        selectDropDown(dropDownSecurityQuestionThree()).selectByIndex(1);
        inputAnswerThree().sendKeys("test12345");

        buttonContinue().click();
        sleep(2000);
        buttonContinueAccountManagement().click();
        sleep(3000);

        reporter.assertChild(softly.assertThat(labelPortal().isDisplayed())
                        .as("Successfully Logged into Compliance Portal")
                        .isEqualTo(true),
                "Successfully Logged into Compliance Portal");

        return this;
    }
}
