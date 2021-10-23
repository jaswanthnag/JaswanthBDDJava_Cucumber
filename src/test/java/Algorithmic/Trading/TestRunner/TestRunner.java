package Algorithmic.Trading.TestRunner;
//This is my test runner class

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//features//",
		glue="Algorithmic.Trading.StepDefinitions",
		//glue = { "Steps" }, 
		monochrome=true,
		tags= {"@sanity"},
		plugin= {"pretty","html:test-output", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun = false ,
		strict = true		)
public class TestRunner {
 
}
