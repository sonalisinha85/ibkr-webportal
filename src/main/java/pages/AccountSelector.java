package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.tabs.Groups;
import reporter.TestReporter;

import java.util.List;

public class AccountSelector extends Groups {

    public AccountSelector withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    public AccountSelector withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement labelAccounts() {
        return elementNoLog(By.xpath("//li[@class='active']/a[text()='Accounts']"));
    }

    private List<WebElement> radioButtonsPicker() {
        return elementsPresent(By.xpath("//i[@class='fa fa-lg fa-circle-thin']"));
    }

    private WebElement buttonAction(Action action) {
        return elementPresent(By.xpath("//am-button[@btn-text='" + action.toString() + "']/a"));
    }

    public AccountSelector selectAccount() {

        if (!isNotDisplayed(labelAccounts())) {

            random(radioButtonsPicker(), 1).get(0).click();
            buttonAction(Action.Continue).click();
            sleep(1000);
        }

        return this;
    }

    private enum Action {Reset, Continue}
}
