package Jaswanth.Automation.PractiseTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","G:\\Selenium BDD Framework\\JaswanthBDDJava_Cucumber\\browser_drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		 //String baseURL = "http://demo.guru99.com/test/newtours/register.php";
		//System.out.println("URL:" + baseURL);
		 
		driver.get("http://admin-demo.nopcommerce.com/login");	
		 
		//driver.navigate().to("https://javatpoint.com/selenium-tutorial");
		//Launching the site.				
        
        driver.manage().window().maximize();
        Thread.sleep(5000);
       
        
       driver.findElement(By.className("email valid")).sendKeys("admin@yourstore.com");

      
       
			 
			// String value = driver.findElement(By.xpath("//label[text()='Email:']")).getText();
			// System.out.println("Text value:" + value);
			 
			// driver.findElement(By.id("Email")).clear();
			// driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
			// driver.findElement(By.id("Password")).sendKeys("admin");
			 
			 
			// driver.navigate().refresh();
			 //driver.findElement(By.xpath("//button[@type='submit']")).click();
			// Thread.sleep(6000);
			 
				
				
			 
			 
		 
		

	}

}
