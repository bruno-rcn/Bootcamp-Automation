package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static driverFactory.DriverFactory.getDriver;

public class Login_Steps {
    private WebDriver driver = getDriver();

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }

    @Given("I enter a username {word}")
    public void i_enter_a_username(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
    }
    @Given("I enter a password {word}")
    public void i_enter_a_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be presented with the message {}")
    public void i_should_be_presented_with_the_message(String expectedMsg) {
        String msg = driver.switchTo().alert().getText();
        Assert.assertEquals(msg, expectedMsg);
    }

}
