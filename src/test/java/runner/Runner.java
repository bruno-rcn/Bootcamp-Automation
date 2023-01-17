package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"classpath:features"},
        glue = {"stepDefinitions"},
        tags = "@login",
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
