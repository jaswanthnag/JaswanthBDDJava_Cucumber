package Jaswanth.Automation.StepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Jaswanth.Automation.Objects.LoginPage;
import Jaswanth.Automation.Objects.AddcustomerPage;
import Jaswanth.Automation.Objects.SearchCustomerPageObjects;


public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddcustomerPage addCust;
	public SearchCustomerPageObjects searchCust;
	public static Logger logger;
	public Properties configProp;
	
	//Created for generating random string for Unique email
	public static String randomestring(){
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	
	
	
}
