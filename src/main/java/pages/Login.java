package pages;

import navigation.WebOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reporter.TestReporter;

public class Login extends WebOperation {

    private String userName;
    private String password;
    public Login withDriver(WebDriver driver) {
        super.driver = driver;
        return this;
    }

    //    Method used to set instance of Reporter
    public Login withReporter(TestReporter reporter) {
        super.reporter = reporter;
        super.softly = reporter.softly();
        return this;
    }

    private WebElement textUserName(){
        return elementPresent(By.id("user_name"));
    }

    private WebElement textPassword(){
        return elementPresent(By.id("password"));
    }

    private WebElement buttonLogin(){
        return elementClickable(By.id("submitForm"));
    }

    public Login withUserName(String userName){

        this.userName = userName;
        return this;
    }

    public Login withPassword(String password){

        this.password = password;
        return this;
    }

    public Login login(){

        reporter.createChild("Validate Login");
        textUserName().sendKeys(userName);
        textPassword().sendKeys(password);
        buttonLogin().click();
        sleep(2000);

        return this;
    }
}
