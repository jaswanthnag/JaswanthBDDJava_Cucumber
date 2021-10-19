package Jaswanth.Automation.PractiseTests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksinWebPage 
{
	/*
	 * Collect all the links in the web page based on <a> tag. 
	 * Send HTTP request for the link and read HTTP response code. 
	 * Find out whether the link is valid or
	 * broken based on HTTP response code. 
	 * Repeat this for all the links captured
	 */
	
	 public static void main(String[] args) {
		    System.setProperty("webdriver.chrome.driver","G:\\Selenium BDD Framework\\JaswanthBDDJava_Cucumber\\browser_drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://demoqa.com/broken");

	        //Storing the links in a list and traversing through the links
	        List<WebElement> links = driver.findElements(By.tagName("a"));

	        // This line will print the number of links and the count of links.
	        System.out.println("No of links are "+ links.size());  
	      
	        //checking the links fetched.
	        for(int i=0;i<links.size();i++)
	        {
	            WebElement E1= links.get(i);
	            String url= E1.getAttribute("href");
	            verifyLinks(url);
	        }
	        
	        driver.quit();
	    }
	    
	    
	    public static void verifyLinks(String linkUrl)
	    {
	        try
	        {
	            URL url = new URL(linkUrl);

	            //Now we will be creating url connection and getting the response code
	            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	            httpURLConnect.setConnectTimeout(5000);
	            httpURLConnect.connect();
	            if(httpURLConnect.getResponseCode()>=400)
	            {
	                    System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
	            }    
	       
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	            }
	        }catch (Exception e) {
	      }
	   }

}
