package Jaswanth.Automation.PractiseTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandles
{
	
	//Sample class for practise
		public static void main(String[] args) throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver","G:\\Selenium BDD Framework\\JaswanthBDDJava_Cucumber\\browser_drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
		     // Alert Message handling                    		
	        driver.get("http://demo.guru99.com/test/delete_customer.php");
	        Thread.sleep(5000);
	  
	        driver.manage().window().maximize();
	        driver.findElement(By.name("cusid")).sendKeys("53920");	
	        driver.findElement(By.name("submit")).submit();				           	
	        		
	        // Switching to Alert        
	        Alert alert = driver.switchTo().alert();	
	        Thread.sleep(5000);
	        
	       // driver.switchTo().alert().accept();
	        		
	        // Capturing alert message.    
	        String alertMessage = driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println("alertMessage " + alertMessage);	
	        Thread.sleep(5000);
	        		
	        // Accepting alert		
	        driver.switchTo().alert().accept();	
			
		}
		

}
