package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO {
    public Login_PO(){
        super();
    }

    private @FindBy(id = "text")
    WebElement userName;

    private @FindBy(id = "password")
    WebElement password;

    private @FindBy(id = "login-button")
    WebElement loginButton;

    public void navigateToLoginPage(){
        navigateTo_URL("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }

    public void setUserName(String user){
        sendKeys(userName, user);
    }

    public void setPassword(String passw){
        sendKeys(password, passw);
    }

    public void clickOnLoginButton(){
        click(loginButton);
    }

}
