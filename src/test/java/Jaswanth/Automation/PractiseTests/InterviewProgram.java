package Jaswanth.Automation.PractiseTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InterviewProgram {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"G:\\Selenium BDD Framework\\JaswanthBDDJava_Cucumber\\browser_drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Thread.sleep(6000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement seleniumlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xxxx")));

		driver.findElement(By.id("user_full_name")).sendKeys("Sadhvi Singh");
		driver.findElement(By.id("user_email_login")).sendKeys("sadhvisingh9049+1@gmail.com");
		
		Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByVisibleText("ANTARCTICA");
		
		//Scroll to bottom
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    //Vertical scroll down by 600 pixels		
        //js.executeScript("window.scrollBy(0,300)");
	   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	   Thread.sleep(2000);

		String Actual_Title = driver.getTitle();
		Assert.assertEquals("Swag labs", Actual_Title);

		Boolean value = driver.findElement(By.xpath("//*[text()='+input_Iem +']")).isDisplayed();
		Assert.assertTrue(value);

	}
}
