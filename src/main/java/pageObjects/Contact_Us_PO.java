package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Contact_Us_PO extends Base_PO {
    public Contact_Us_PO(){
        super();
    }
    private @FindBy(name = "first_name")
    WebElement firstName;
    private @FindBy(name = "last_name")
    WebElement lastName;
    private @FindBy(name = "email")
    WebElement emailAddress;
    private @FindBy(name = "message")
    WebElement commentField;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement successfulMsg;

    public void setFirstName(String text){
        sendKeys(firstName, text + generateRandomNumber(3));
    }

    public void setLastName(String text){
        sendKeys(lastName, text + generateRandomNumber(3));
    }

    public void setEmailAddress(String text){
        sendKeys(emailAddress, text);
    }

    public void setComment(String text){
        sendKeys(commentField, text);
    }

    public void clickOnSubmit(){
        click(By.cssSelector("[value='SUBMIT']"));
    }

    public String validateMsg(){
        return getText(successfulMsg);
    }

}
