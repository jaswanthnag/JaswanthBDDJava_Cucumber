package Jaswanth.Automation.PractiseTests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Javaexecutorclassmethds {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","G:\\Selenium BDD Framework\\JaswanthBDDJava_Cucumber\\browser_drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		 // String baseURL = "http://admin-demo.nopcommerce.com/login"; 
		//  driver.get(baseURL);
		 // Thread.sleep(5000); driver.manage().window().maximize();
		  
		  
		  
		  // Page Referesh
		  
			/*
			 * JavascriptExecutor js = (JavascriptExecutor)driver;
			 * js.executeScript("history.go(0)");
			 */
		  
		  
		  
		//  WebElement button = driver.findElement(By.name("btnLogin"));
		  //Login to Guru99 //
		 
		  
		  // Alert creation
		 
			/*
			 * JavascriptExecutor js = (JavascriptExecutor)driver;
			 * js.executeScript("alert('Welcome To Selenium Testing');");
			 */
		  
		  
		  
		  //js.executeScript("document.getElementById('Email').value='SeleniumTesting.com';");
		  
		 // driver.findElement(By.name("uid")).sendKeys("mngr34926"); //
			/*
			 * Robot robot = new Robot(); // Robot class throws AWT Exception
			 * robot.keyPress(KeyEvent.VK_TAB); Thread.sleep(2000);
			 * robot.keyRelease(KeyEvent.VK_TAB); Thread.sleep(2000);
			 */

		 // driver.findElement(By.name("password")).sendKeys("amUpenu");
		  
		  //Perform Click on LOGIN button using JavascriptExecutor	
		  
	      // js.executeScript("arguments[0].click();", button);

		  
		  
		  //Creating the JavascriptExecutor interface object by Type casting
			/*
			 * JavascriptExecutor js = (JavascriptExecutor)driver;
			 * js.executeScript("history.go(0)");
			 * 
			 * String titleText = js.executeScript("return document.title;").toString();
			 * System.out.println(titleText);
			 * 
			 * Thread.sleep(5000);
			 * js.executeScript("window.location = 'https://www.lambdatest.com'");
			 * 
			 * 
			 * String url= js.executeScript("return document.URL;").toString();
			 * System.out.println(url);
			 */
		  
		  //Perform Click on LOGIN button using JavascriptExecutor //
		 // js.executeScript("arguments[0].click();", button);
		  
		  //To generate Alert window using JavascriptExecutor. Display the alert message
		 
			/*
			 * js.executeScript("alert('sucessfully performed java executor methods');");
			 * Thread.sleep(8000);
			 */
		 

	        
		
		  //Scrolling Actions 
		  driver.get("http://moneyboats.com/");
		  Thread.sleep(5000); 
		  driver.manage().window().maximize();
		  
		  Thread.sleep(5000); 
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  
		  
		    //Vertical scroll down by 600 pixels		
	        //js.executeScript("window.scrollBy(0,300)");

		   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		   Thread.sleep(2000);
		   js.executeScript("window.scrollBy(document.body.scrollHeight,0)");



	}

}
