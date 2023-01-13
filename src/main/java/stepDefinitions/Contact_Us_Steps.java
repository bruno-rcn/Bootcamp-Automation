package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("I enter a first name")
    public void i_enter_a_first_name() {
        driver.findElement(By.name("first_name")).sendKeys("Bruno");
    }
    @When("I enter a last name")
    public void i_enter_a_last_name() {
        driver.findElement(By.name("last_name")).sendKeys("Noberto");
    }
    @When("I enter an email address")
    public void i_enter_an_email_address() {
        driver.findElement(By.name("email")).sendKeys("brunorcnoberto@hotmail.com");
    }
    @When("I enter a comment")
    public void i_enter_a_comment() {
        driver.findElement(By.name("message")).sendKeys("Training cucumber, java & selenium!");
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

}
