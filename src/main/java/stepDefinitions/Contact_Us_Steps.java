package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Base_PO;

public class Contact_Us_Steps extends Base_PO {
    private WebDriver driver = getDriver();


    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        navigateTo_URL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("I enter a first name")
    public void i_enter_a_first_name() {
        sendKeys(By.name("first_name"), "AutoFN" + generateRandomNumber(3));
    }
    @When("I enter a last name")
    public void i_enter_a_last_name() {
        sendKeys(By.name("last_name"), "AutoLN" + generateRandomNumber(3));
    }
    @When("I enter an email address")
    public void i_enter_an_email_address() {
        sendKeys(By.name("email"), "brunorcnoberto@hotmail.com");
    }
    @When("I enter a comment")
    public void i_enter_a_comment() {
        sendKeys(By.name("message"), "Training cucumber, java & selenium!" + generateRandomString(5));
    }
    @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
        click(By.cssSelector("[value='SUBMIT']"));
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement msg = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(msg.getText(), "Thank You for your Message!");
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String name) {
        sendKeys(By.name("first_name"), name);
    }
    @When("I enter a specific last name {string}")
    public void i_enter_a_specific_last_name(String lastName) {
        sendKeys(By.name("last_name"), lastName);
    }
    @When("I enter a specific email address {string}")
    public void i_enter_a_specific_email_address(String email) {
        sendKeys(By.name("email"), email);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        sendKeys(By.name("message"), comment);
    }

}
