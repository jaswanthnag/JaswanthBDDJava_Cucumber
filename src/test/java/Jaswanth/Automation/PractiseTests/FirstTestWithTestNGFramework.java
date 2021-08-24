package Jaswanth.Automation.PractiseTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestWithTestNGFramework
{
	WebDriver driver;

	@BeforeClass
	public void testSetup()
	{
	System.setProperty("webdriver.chrome.driver", "G:\\\\Selenium BDD Framework\\\\JaswanthBDDJava_Cucumber\\\\browser_drivers\\\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	System.out.println("Before class");

	}

	@BeforeMethod
	public void openBrowser()
	{
		FirstTestWithTestNGFramework selej = new FirstTestWithTestNGFramework();
		selej.testSetup();
	driver.get("https://www.browserstack.com/");
	driver.findElement(By.id("signupModalButton")).click();
	System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
	System.out.println("Before Method");
	//Boolean verifyTitle = driver.getCurrentUrl().equalsIgnoreCase("https://www.browserstack.com/users/sign_up");
	String current_url = driver.getCurrentUrl();
	//System.out.println("Boolean:" + verifyTitle);
	//Assert.assertTrue(verifyTitle);
	try
	{
		driver.findElement(By.id("signupModalBut")).click();
	}catch(Exception e)
	{
		//e.printStackTrace();
		e.getMessage();
	}
	}

	
	
	@Test(description="This method validates the sign up functionality")
	public void signUp()
	{
	driver.findElement(By.id("user_full_name")).sendKeys("Sadhvi Singh");
	driver.findElement(By.id("user_email_login")).sendKeys("sadhvisingh9049+1@gmail.com");
	driver.findElement(By.id("user_password")).sendKeys("BrowserStack123*");
	//driver.findElement(By.xpath("//input[@name='terms_and_conditions']")).click();
	//driver.findElement(By.id("user_submit")).click();
	System.out.println("@Test");

	}
	
	

	

	@AfterMethod
	public void postSignUp()
	{
	System.out.println(driver.getCurrentUrl());
	System.out.println("After method");

	}

	@AfterClass
	public void afterClass()
	{
	driver.quit();
	System.out.println("After class");
	}


}
