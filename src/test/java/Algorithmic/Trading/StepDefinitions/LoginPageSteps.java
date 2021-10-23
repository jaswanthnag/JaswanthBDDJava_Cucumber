package Algorithmic.Trading.StepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;


import Algorithmic.Trading.Objects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps 
{
	
	public LoginPage lp;
	public static Logger logger;
	public Properties configProp;


	
	
	
	public static String randomestring(){
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	
	//Login steps....................
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		lp=new LoginPage(BaseClass.driver);
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) throws InterruptedException {
	BaseClass.driver.get(url);
	 BaseClass.driver.manage().window().maximize();
	 Thread.sleep(5000);
	
	}

	

	@Then("close browser")
	public void close_browser() {
	   BaseClass.driver.quit();
	}
	
	

	
	
	
}
