package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.modals.CommentModal;
import pages.modals.StatementAuditModal;
import reporter.TestReporter;

import java.util.List;

public class Employee extends Portal {

    public Employee withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public Employee withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private List<WebElement> buttonsEmployeeDetails() {
        return elementsPresent(By.xpath("//i[@data-original-title='Employee Details']"));
    }

    protected WebElement buttonsStatementAudit() {
        return elementPresent(By.xpath("//i[@data-original-title='Statement Audit']"));
    }

    private List<WebElement> buttonsEmployeeDelink() {
        return elementsPresent(By.xpath("//i[@data-original-title='Delink']"));
    }

    protected WebElement buttonAddComment() {
        return elementPresent(By.xpath("//section[div[span[text()='Comments']]]//i[@data-original-title='Add']"));
    }

    private List<WebElement> listAccountNumber() {
        return elementsPresent(By.xpath("//td[contains(@ng-show,'acctNumber')]"));
    }

    private WebElement inputSearch() {
        return elementPresent(By.xpath("//input[@name='filter_employeeSearchText']"));
    }

    private WebElement buttonCancelSearch() {
        return elementPresent(By.xpath("//span[contains(@class,'input-group-addon')]/i[@class='fa fa-times']"));
    }

    public Employee validateEmployeeViewAndAddComment() {

        sleep(1000);
        List<WebElement> accountNumbers = listAccountNumber();
        String accountNumber = accountNumbers.get(0).getText();

        inputSearch().sendKeys(accountNumber);
        inputSearch().sendKeys(Keys.ENTER);
        sleep(500);

        reporter.createChild("Search Employee")
                .assertChild(softly.assertThat(listAccountNumber().size())
                                .as("Employee List size")
                                .isLessThanOrEqualTo(accountNumbers.size()),
                        "Employee List size")
                .assertChild(softly.assertThat(listAccountNumber().get(0).getText())
                                .as("Correct Account Number is Listed in search result")
                                .isEqualTo(accountNumber),
                        "Correct Account Number is Listed in search result");

        buttonCancelSearch().click();
        sleep(500);

        buttonsEmployeeDetails().get(0).click();

        new CommentModal()
                .withReporter(reporter)
                .withDriver(driver)
                .addComment();

        return this;
    }

    public Employee validateStatementViewLog() {

        sleep(1000);
        buttonsStatementAudit().click();

        new StatementAuditModal()
                .withReporter(reporter)
                .withDriver(driver)
                .viewLog();

        return this;
    }
}
