package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Contact_Us_PO;

public class Contact_Us_Steps extends Base_PO {
    Contact_Us_PO contactUsPo = new Contact_Us_PO();

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        navigateTo_URL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("I enter a first name")
    public void i_enter_a_first_name() {
        contactUsPo.setFirstName("Generic first name");
    }
    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String name) {
        contactUsPo.setFirstName(name);
    }

    @When("I enter a last name")
    public void i_enter_a_last_name() {
        contactUsPo.setLastName("Generic last name");
    }

    @When("I enter a specific last name {string}")
    public void i_enter_a_specific_last_name(String lastName) {
        contactUsPo.setLastName(lastName);
    }

    @When("I enter an email address")
    public void i_enter_an_email_address() {
        contactUsPo.setEmailAddress("brunorcnoberto@hotmail.com");
    }

    @When("I enter a specific email address {string}")
    public void i_enter_a_specific_email_address(String email) {
        contactUsPo.setEmailAddress(email);
    }

    @When("I enter a comment")
    public void i_enter_a_comment() {
        contactUsPo.setComment("Training cucumber, java & selenium!");
    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        contactUsPo.setComment(comment);
    }

    @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
        contactUsPo.clickOnSubmit();
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        Assert.assertEquals(contactUsPo.validateMsg(), "Thank You for your Message!");
    }

}
