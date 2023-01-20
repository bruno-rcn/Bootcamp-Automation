package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;

public class Login_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        navigateTo_URL("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }

    @Given("I enter a username {word}")
    public void i_enter_a_username(String username) {
        sendKeys(By.id("text"), username);
    }
    @Given("I enter a password {word}")
    public void i_enter_a_password(String password) {
        sendKeys(By.id("password"), password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        click(By.id("login-button"));
    }

    @Then("I should be presented with the message {}")
    public void i_should_be_presented_with_the_message(String expectedMsg) {
        String msg = driver.switchTo().alert().getText();
        Assert.assertEquals(msg, expectedMsg);
    }

}
