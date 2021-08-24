package Jaswanth.Automation.PractiseTests;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandles
{
	
	//Sample class for practise
		public static void main(String[] args) throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver","G:\\Selenium BDD Framework\\JaswanthBDDJava_Cucumber\\browser_drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
		     // Alert Message handling                    		
	        driver.get("http://demo.guru99.com/test/delete_customer.php");
	        //Thread.sleep(6000);
	        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	        
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cusid")));

	
	        Wait < WebDriver > wait1 = new FluentWait < WebDriver > (driver)
	        	    .withTimeout(30, TimeUnit.SECONDS)
	        	    .pollingEvery(5, TimeUnit.SECONDS)
	        	    .ignoring(NoSuchElementException.class);
	        	WebElement clickseleniumlink = wait1.until(new Function < WebDriver, WebElement > () {

	        	    public WebElement apply(WebDriver driver) {
	        	        return driver.findElement(By.name("cusid"));
	        	    }
	        	});

	        driver.manage().window().maximize();
	        driver.findElement(By.name("cusid")).sendKeys("53920");	
	        driver.findElement(By.name("submit")).click();				           	
	        		
	        // Switching to Alert        
	       // Alert alert = driver.switchTo().alert();	
	        Thread.sleep(5000);
	        
	        
	        driver.switchTo().alert().accept();
	        
	        System.out.println("alertMessage " );
	        
	       // driver.switchTo().alert().dismiss();
	        		
	        // Capturing alert message.    
	       // String alertMessage = driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	       // System.out.println("alertMessage " + alertMessage);	
	        //Thread.sleep(5000);
	        		
	        // Accepting alert		
	       // driver.switchTo().alert().accept();	
			
		}
		

}
