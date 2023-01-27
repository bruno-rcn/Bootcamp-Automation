package pageObjects;

import driverFactory.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Base_PO {
    public Base_PO(){
        PageFactory.initElements(getDriver(), this);
    }
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));


    public WebDriver getDriver(){
        return DriverFactory.getDriver();
    }

    public String generateRandomNumber(int n){
        return RandomStringUtils.randomNumeric(n);
    }

    public String generateRandomString(int n){
        return RandomStringUtils.randomAlphabetic(n);
    }

    public void navigateTo_URL(String url){
        getDriver().get(url);
    }

    public void sendKeys(By by, String text){
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
    }

    public void sendKeys(WebElement element, String text){
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void click(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public String validateAlertText(){
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = getDriver().switchTo().alert().getText();
        return alertText;
    }

    public String getText(WebElement element){
        waitFor(element);
        String text = element.getText();
        return text;
    }

    public void waitFor(By by){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitFor(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
