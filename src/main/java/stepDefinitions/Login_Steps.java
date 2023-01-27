package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

public class Login_Steps extends Base_PO {
    private Login_PO loginPo = new Login_PO();

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        loginPo.navigateToLoginPage();
    }

    @Given("I enter a username {word}")
    public void i_enter_a_username(String username) {
        loginPo.setUserName(username);
    }
    @Given("I enter a password {word}")
    public void i_enter_a_password(String password) {
        loginPo.setPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPo.clickOnLoginButton();
    }

    @Then("I should be presented with the message {}")
    public void i_should_be_presented_with_the_message(String expectedMsg) {
        Assert.assertEquals(loginPo.validateAlertText(), expectedMsg);
    }

}
