package Jaswanth.Automation.PractiseTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsclasMethds 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","G:\\Selenium BDD Framework\\JaswanthBDDJava_Cucumber\\browser_drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/*
		 * driver.get("https://www.browserstack.com/"); Thread.sleep(5000);
		 * driver.manage().window().maximize(); Thread.sleep(6000);
		 * driver.findElement(By.
		 * xpath("//button[@aria-label='Accept all the policies and terms']")).click();
		 * Thread.sleep(6000);
		 */
        
		/*
		 * //Click Actions action = new Actions(driver); WebElement element =
		 * driver.findElement(By.xpath("//a[text()='Get started free']"));
		 * Thread.sleep(6000); action.moveToElement(element).click();
		 * action.build().perform();
		 */
		
		/*
		 * //Mouse Hover Actions ac = new Actions(driver); WebElement live =
		 * driver.findElement(By.
		 * cssSelector("div.product-cards-wrapper--click a[title='Live']"));
		 * ac.moveToElement(live).build().perform(); Thread.sleep(3000); WebElement
		 * automate= driver.findElement(By.
		 * cssSelector("div.product-cards-wrapper--click a[title='App Automate']"));
		 * automate.click(); Thread.sleep(2000);
		 */

		/*
		 * //Double click Actions a = new Actions(driver); WebElement trialaction =
		 * driver.findElement(By.xpath("//a[@id='free-trial-link-anchor']"));
		 * a.doubleClick(trialaction).build().perform();
		 */
        
        driver.get("http://demo.guru99.com/test/drag_drop.html");					
        Thread.sleep(5000);
		 driver.manage().window().maximize(); 
		 Thread.sleep(6000);
		 
		//Element which needs to drag.    		
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
        
         //Element on which need to drop.		
         WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));	
         
         //Using Action class for drag and drop.		
         Actions act=new Actions(driver);	
         
	    //Dragged and dropped.		
         act.dragAndDrop(From, To).build().perform();


	}

}
