package Jaswanth.Automation.TestRunner;
//This is my test runner class

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//features//",
		glue="Jaswanth.Automation.StepDefinitions",
		//glue = { "Steps" }, 
		monochrome=true,
		tags= {"@regression99"},
		plugin= {"pretty","html:test-output", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun = false ,
		strict = true		)
public class TestRunner {
 
}
