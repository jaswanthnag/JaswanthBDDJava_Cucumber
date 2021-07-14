package Jaswanth.Automation.Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class Login 
{
	public static WebDriver driver;
	public static String fileLocation;
	public static String fileLocation1;
	public static int Iterate = 0;
	
	@Parameters({"Browser"})
	@BeforeMethod
	public void beforeTest(String Browser)
	{
		System.out.println(Browser +"Browser is Launched");
		if(Browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("chrome"))
		{
			String path = System.getProperty("user.dir");
			String[] names = path.split("\\\\");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\"+names[2]+"\\.m2\\repository\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		Iterate = Iterate+1;
	}
	
	public static String classNameWithModule(String canonicalName)
	{
		String[] canonicalClassNameSplit = canonicalName.split("\\.");
		return canonicalClassNameSplit[canonicalClassNameSplit.length-2]+"."+canonicalClassNameSplit[canonicalClassNameSplit.length-1];
		
	}
	
	@DataProvider
	public Object[][] readExcelData(Method method) throws Exception
	{
		fileLocation = classNameWithModule(method.getDeclaringClass().getCanonicalName());
		fileLocation1 = System.getProperty("user.dir")+(".src.test.resources.Reports."+ fileLocation).replace(".", File.separator);
		Object[][] testObjArray = ExcelDataProvider.getTableArray(System.getProperty("user.dir")+(".src.test.resources.TestData."+ fileLocation).replace(".", File.separator)+".xlsx", method.getName());
		return (testObjArray);
		
	}
	
	public static void writeExcelData(String[] Value) throws IOException
	{
		ExcelDataProvider EDP = new ExcelDataProvider();
		ExcelDataProvider.setTableArray(System.getProperty("user.dir")+(".src.test.resources.TestData."+ fileLocation).replace(".", File.separator)+".xlsx", Value);
	}

	

}
