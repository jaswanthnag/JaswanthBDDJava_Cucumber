package Jaswanth.Automation.PractiseTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestNGAssertions {
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","G:\\Selenium BDD Framework\\JaswanthBDDJava_Cucumber\\browser_drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	
		
		
			
			  driver.get("http://demo.guru99.com/test/simple_context_menu.html");
			  Thread.sleep(5000); 
			  driver.manage().window().maximize(); 
			  Thread.sleep(6000);
			  String textverify;
			  try
			  {
				  
			  textverify = driver.findElement(By.xpath("(//*[@title='home'])[2]")).getText();
			 
			  }catch(NoSuchElementException e)
			  {
				  
				  textverify = driver.findElement(By.xpath("(//*[@title='Home'])[2]")).getText();
				  
			  }
			  //textverify = "Demo Site"
			// Boolean selenium = textverify.equalsIgnoreCase("Demo");
			 // System.out.println("Boolean value: "+ verifyTitle);
			  //Assert.assertTrue(verifyTitle);
			 // Assert.assertFalse(verifyTitle);
			  //Assert.assertEquals(textverify,"Demo");
			 // Assert.assertNotEquals(textverify,"Demo");

			 
	}

}
