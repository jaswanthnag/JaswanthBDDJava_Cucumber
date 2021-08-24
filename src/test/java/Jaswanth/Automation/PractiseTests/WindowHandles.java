package Jaswanth.Automation.PractiseTests;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","G:\\Selenium BDD Framework\\JaswanthBDDJava_Cucumber\\browser_drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

        //Launching the site.				
        driver.get("http://demo.guru99.com/popup.php");
        
       // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        Thread.sleep(5000);
        
        String MainWindow = driver.getWindowHandle();
        System.out.println("MainWindow " + MainWindow);	
        
      
        
       // s1 = 0,1,2,3
        // To handle all new opened window.				
        Set < String > s1 = driver.getWindowHandles();
        Iterator < String > i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

                
                try
                {
                	System.out.println("ChildWindow " + ChildWindow);	
                	// Switching to Child window
                    driver.switchTo().window(ChildWindow);
                    
                    //explicit wait
                   WebDriverWait wait = new WebDriverWait(driver, 20);
                   WebElement seleniumlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "xxxx")));
                   
        
                   
                   
                   // WebElement mailid = driver.findElement(By.name("emailid"));
                    System.out.println("ChildWindow " + ChildWindow);	
                   // mailid.sendKeys("gaurav.3n@gmail.com");
                    driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
                    driver.findElement(By.name("btnLogin")).click();
                 // Closing the Child Window.
                    driver.close();
                	
                }catch(Exception e){
                	// Closing the Child Window.
                    driver.close();
                }

                
            }
        }
        // Switching to the Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);

		

	}

}
