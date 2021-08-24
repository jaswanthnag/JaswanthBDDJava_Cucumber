package Jaswanth.Automation.PractiseTests;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandles 
{
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","G:\\Selenium BDD Framework\\JaswanthBDDJava_Cucumber\\browser_drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	    driver.get("http://demo.guru99.com/test/guru99home/"); 
	       // navigates to the page consisting an iframe
	    Thread.sleep(5000);
		  
        driver.manage().window().maximize();
        Thread.sleep(5000);
        
      //By finding all the web elements using iframe tag
      List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
      System.out.println("The total number of iframes are " + iframeElements.size());
      System.out.println("The total number of iframes are " + iframeElements.get(0));
      System.out.println("The total number of iframes are " + iframeElements.get(1));

        
        
	       driver.switchTo().frame(""); //switching the frame by ID

			System.out.println("********We are switch to the iframe*******");
     		driver.findElement(By.xpath("html/body/a/img")).click();
  		    //Clicks the iframe
       
  			System.out.println("*********We are done***************");
  			
  			driver.switchTo().defaultContent();
      }


}
