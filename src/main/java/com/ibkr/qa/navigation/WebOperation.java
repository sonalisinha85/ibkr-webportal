package com.ibkr.qa.navigation;

import com.ibkr.qa.reporter.TestReporter;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class WebOperation {

    protected WebDriver driver;
    protected SoftAssertions softly;
    protected TestReporter reporter;
    List<String> tabs;

    //    Returns Web element once its present, with a timeout of 25 seconds
    protected WebElement elementPresent(By by) {
        return new WebDriverWait(driver, 25).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //    Returns Web elements once its present, with a timeout of 25 seconds
    protected List<WebElement> elementsPresent(By by) {
        return new WebDriverWait(driver, 25).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    //    Returns Web element once its visible, with a timeout of 25 seconds
    protected WebElement elementVisible(By by) {
        return new WebDriverWait(driver, 25).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //    Returns Web elements once its visible, with a timeout of 25 seconds
    protected List<WebElement> elementsVisible(By by) {
        return new WebDriverWait(driver, 25).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    //    Returns Web element once its clickable, with a timeout of 25 seconds
    protected WebElement elementClickable(By by) {
        return new WebDriverWait(driver, 25).until(ExpectedConditions.elementToBeClickable(by));
    }

    // Returns WebElement, can be used if we need to check if Web Element is not displayed
    protected WebElement element(By by) {
        return driver.findElement(by);
    }

    // Returns WebElement, can be used if we need to check if Web Element is not displayed
    protected WebElement elementNoLog(By by) {

        WebElement element = null;
        try {
            element = driver.findElement(by);
        } catch (Exception e) {

        }
        return element;
    }

    // Returns WebElements, can be used if we need to check if Web Elements are not displayed
    protected List<WebElement> elements(By by) {
        return driver.findElements(by);
    }

    protected void changeDropdown(WebElement element, String option) {
        new Select(element)
                .selectByVisibleText(option);
    }

    protected Select selectDropDown(WebElement element) {
        return new Select(element);
    }

    protected void switchFrame(String frameName) {
        new WebDriverWait(driver, 25).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
    }

    protected void switchToDefaultContext() {
        driver.switchTo().defaultContent();
    }

    protected void sleep(long ms) {

        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected boolean isNotDisplayed(WebElement element) {

        boolean flag = true;
        try {
            if (element.isDisplayed())
                flag = false;
        } catch (Exception e) {
        }

        return flag;
    }

    protected List<WebElement> random(List<WebElement> list, int count) {

        List<WebElement> returnList = new ArrayList<>();
        Random rand = new Random();

        while (count != 0) {

            if (list.size() == 1)
                returnList.add(list.get(0));
            else
                returnList.add(list.get(rand.nextInt(list.size() - 1)));
            count--;
        }

        return returnList;
    }

    protected void switchTab() {

        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    protected void switchTab(int tabIndex) {

        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
    }

    protected void switchToMainTab() {

        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    protected String getCurrentTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        return sdf.format(new Date());
    }

    protected String getDate() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        return sdf.format(new Date());
    }
}