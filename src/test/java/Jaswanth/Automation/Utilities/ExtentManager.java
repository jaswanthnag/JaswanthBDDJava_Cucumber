package Jaswanth.Automation.Utilities;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager 
{
	  private static ExtentReports extent;
	  
	    public synchronized static ExtentReports getReporter() {
	        if (extent == null) {
	            //Set HTML reporting file location
	        	System.out.println("FileName"+ Login.fileLocation1);
	             extent = new ExtentReports(Login.fileLocation1+".html", true);
	        }
	        return extent;
	    }

}
