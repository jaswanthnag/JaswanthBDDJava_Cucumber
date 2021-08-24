package Jaswanth.Automation.PractiseTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdownsSelect {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","G:\\Selenium BDD Framework\\JaswanthBDDJava_Cucumber\\browser_drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		 String baseURL = "http://demo.guru99.com/test/newtours/register.php";
		 driver.get(baseURL);
		 Thread.sleep(5000);
	        driver.manage().window().maximize();

			Select drpCountry = new Select(driver.findElement(By.name("country")));
			//drpCountry.selectByVisibleText("ANTARCTICA");
			drpCountry.selectByIndex(3);
			Thread.sleep(5000);
			
			//Selecting Items in a Multiple SELECT elements
			
			/*
			 * driver.get("http://jsbin.com/osebed/2"); Thread.sleep(5000); Select fruits =
			 * new Select(driver.findElement(By.id("fruits")));
			 * fruits.selectByVisibleText("Banana"); fruits.selectByIndex(3);
			 */
			 


	}

}
