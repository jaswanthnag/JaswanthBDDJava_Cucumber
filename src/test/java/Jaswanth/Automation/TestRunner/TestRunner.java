package Jaswanth.Automation.TestRunner;
//This is my test runner class

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//features//",
		glue="Jaswanth.Automation.StepDefinitions",
		monochrome=true,
		tags= {"@regression"},
		plugin= {"pretty","html:test-output"}
		)
public class TestRunner {
 
}
