package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {
    private WebDriver driver;
    @Before("@contact-us")
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@contact-us")
    public void tearDown(){
        driver.quit();
    }

    public String generateRandomNumber(int n){
        return RandomStringUtils.randomNumeric(n);
    }

    public String generateRandomString(int n){
        return RandomStringUtils.randomAlphabetic(n);
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("I enter a first name")
    public void i_enter_a_first_name() {
        driver.findElement(By.name("first_name")).sendKeys("AutoFN" + generateRandomNumber(3));
    }
    @When("I enter a last name")
    public void i_enter_a_last_name() {
        driver.findElement(By.name("last_name")).sendKeys("AutoLN" + generateRandomNumber(3));
    }
    @When("I enter an email address")
    public void i_enter_an_email_address() {
        driver.findElement(By.name("email")).sendKeys("brunorcnoberto@hotmail.com");
    }
    @When("I enter a comment")
    public void i_enter_a_comment() {
        driver.findElement(By.name("message")).sendKeys("Training cucumber, java & selenium!" + generateRandomString(5));
    }
    @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.cssSelector("[value='SUBMIT']")).click();
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement msg = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(msg.getText(), "Thank You for your Message!");
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String name) {
        driver.findElement(By.name("first_name")).sendKeys(name);
    }
    @When("I enter a specific last name {string}")
    public void i_enter_a_specific_last_name(String lastName) {
        driver.findElement(By.name("last_name")).sendKeys(lastName);
    }
    @When("I enter a specific email address {string}")
    public void i_enter_a_specific_email_address(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        driver.findElement(By.name("message")).sendKeys(comment);
    }

}
