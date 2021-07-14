package Jaswanth.Automation.Utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Page extends Login
{
	
	public static boolean debugOn = false;
	public static String PageState = null;
	public static double waitAdjustment = 1.00;
	public static String MFO2_WINDOW_HANDLE;
	public static Actions action = new Actions(driver);
	
	public static String currentTime()
	{
		return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
	}
	
	private static void debug(String buffer)
	{
		if (!debugOn)
		{
			return;
		}
		
		System.out.println(currentTime() +":"+ buffer);
	}
	
	private static void debug(Throwable e)
	{
		if (!debugOn)
		{
			return;
		}
		
		System.out.println(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + ": exception raised: " + e.getClass().getName() + " - " + e.getMessage());
		e.printStackTrace();
	}
	
	public static void sleep(long baseWait) throws InterruptedException
	{
		Thread.sleep(Math.round(waitAdjustment*baseWait));
	}
	
	public static void waitUntilPageLoad(int seconds) throws Exception
	{
		int Wait=0;
		do
		{
			PageState = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
			if (!PageState.equalsIgnoreCase("Complete") && PageState != null)
			{
				sleep(1000);
				Wait++;
			}
			else if(PageState.equalsIgnoreCase("complete")) break;
			
		}while(Wait<seconds);
	}
	
	public static void holdMouseWithParamsWhenAvailable(String xpathlocator, int duration, int sleep, int timeout, Object...args) throws Exception
	{
		Actions builder = new Actions(driver);
		int i;
		
		debug("trying to press" +xpathlocator+"for"+duration);
		
		for (i=1;;i++)
		{
			try
			{
				builder.clickAndHold(driver.findElement(By.xpath(String.format(xpathlocator, args)))).pause(duration).release().build().perform();
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed: ");
				debug(e);
				if (i == timeout)
				{
					debug("it was the last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void setChkBoxWithParamsWhenAvailable(String xpathlocator, String state, int sleep, int timeout, Object...args) throws Exception
	{
		int i;
		String checked;
		
		debug("Trying to set checkbox " + String.format(xpathlocator,  args) + " to " + state + "sleep" + sleep + "timeout" + timeout);
		
		WebElement we;
		
		for (i=1;;i++)
		{
			debug("Checking if Checked " + Integer.toString(i));
			try
			{
				we = driver.findElement(By.xpath(String.format(xpathlocator, args)));
				checked = we.isSelected() ? "Y" : "N";
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed: ");
				debug(e);
				if(i == timeout)
				{
					debug("it was the last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
		}
		
		if (checked.equals(state))
		{
			return;
		}
		
		for (;;i++)
		{
			debug("clicking to change it " + Integer.toString(i));
			try
			{
				we.click();
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed: ");
				debug(e);
				if (i == timeout)
				{
					debug("it was the last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void setChkBoxWhenAvailable(Object locator, String state, int sleep, int timeout) throws Exception
	{
		setChkBoxWithParamsWhenAvailable(locator.toString(),state,sleep,timeout);
	}
	
	public static void clickWhenAvailable(Object locator, int sleep, int timeout, String[] style) throws Exception
	{
		int i;
		debug("Trying to click on " + ((Enum) locator).name() + "sleep" + sleep + "timeout" + timeout + "style" +(style.length > 0 ? style[0] : ""));
		
		for (i=1;;i++)
		{
			debug("Try " + Integer.toString(i));
			try
			{
				driver.findElement(By.xpath(locator.toString())).click();
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed: ");
				debug(e);
				if (i == timeout)
				{
					debug("it was the last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void clickWhenAvailable(WebElement el, int sleep, int timeout, String[] style) throws Exception
	{
		int i;
		
		debug("Trying to click on element" + el + "sleep" + sleep + "timeout" + timeout + "style" + (style.length > 0 ? style[0] : ""));
		
		for (i=1;;i++)
		{
			debug("Try" + Integer.toString(i));
			try
			{
				JavascriptExecutor js  = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();",el);
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed: ");
				debug(e);
				if (i == timeout)
				{
					debug("it was the last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void doubleclickWhenAvailable(Object locator, int sleep, int timeout, String[] style) throws Exception
	{
		int i;
		debug("Trying to doubleclick on " + ((Enum) locator).name() + "sleep" + sleep + "timeout" + timeout + "style" +(style.length > 0 ? style[0] : ""));
		
		for (i=1;;i++)
		{
			debug("Try " + Integer.toString(i));
			try
			{
				WebElement elementLocator = driver.findElement(By.xpath(locator.toString()));
				action.doubleClick(elementLocator).perform();
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed :");
				debug(e);
				if (i == timeout)
				{
					debug("it was the last last try, retuning");
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void clickAndClearWhenAvailable(Object locator, int sleep, int timeout, String[] style) throws Exception
	{
		int i;
		debug("Trying to click on " + ((Enum<?>) locator).name() + "sleep" + sleep + "timeout" + timeout + "style" + (style.length > 0 ? style[0] : ""));
		
		for (i=1;;i++)
		{
			debug("Try " + Integer.toString(i));
			try
			{
				driver.findElement(By.xpath(locator.toString())).click();
				driver.findElement(By.xpath(locator.toString())).clear();
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed :");
				debug(e);
				if (i == timeout)
				{
					debug("it was the last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void clickAndClearWithParamsWhenAvailable(String xpathlocator, int sleep, int timeout, Object...args) throws Exception
	{
		int i;
		debug("Trying to click and clear on " + xpathlocator + "sleep" + sleep + "timeout" + timeout);
		
		for (i=1;;i++)
		{
			debug("Tey " + Integer.toString(i));
			try
			{
				driver.findElement(By.xpath(String.format(xpathlocator, args))).click();
				driver.findElement(By.xpath(String.format(xpathlocator, args))).clear();
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed: ");
				debug(e);
				if (i == timeout)
				{
					debug("it was the last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void clickAndClearWhenAvailable(Object locator, int sleep, int timeout) throws Exception
	{
		clickAndClearWhenAvailable(locator,sleep,timeout,new String[]{});
	}
	
	public static void clickWhenAvailable(Object locator, int sleep, int timeout) throws Exception
	{
		clickWhenAvailable(locator,sleep,timeout,new String[]{});
	}
	
	public static void clickWithParamsWhenAvailable(String xpathlocator, int sleep, int timeout, Object...args) throws Exception
	{
		int i;
		
		debug("Trying to click on " + xpathlocator + "sleep" +sleep + "timeout" +timeout);
		
		for (i=1;;i++)
		{
			debug("Try" + Integer.toString(i));
			try
			{
				driver.findElement(By.xpath(String.format(xpathlocator, args))).click();
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed: ");
				debug(e);
				if (i == timeout)
				{
					debug("It was the last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void forceClickWithParamsWhenAvailable(String xpathlocator, int sleep, int timeout, Object...args) throws Exception
	{
		int i;
		debug("Trying to doubleclick on " + xpathlocator + "sleep" + sleep + "timeout" + timeout);
		for(i=1;;i++)
		{
			debug("Try " + Integer.toString(i));
			try
			{
				
				action.click(driver.findElement(By.xpath(String.format(xpathlocator, args)))).perform();
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed: ");
				debug(e);
				if(i == timeout)
				{
					debug("ti was the last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	
	public static void doubleClickWithParamsWhenAvailable(String xpathlocator, int sleep, int timeout, Object...args) throws Exception
	{
		int i;
		debug("Trying to doubleclick on" + xpathlocator + "sleep" + sleep + "timeout" + timeout);
		for (i=1;;i++)
		{
			debug("Try " + Integer.toString(i));
			try
			{
		
				action.doubleClick(driver.findElement(By.xpath(String.format(xpathlocator, args)))).perform();
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("Failed: ");
				debug(e);
				if (i == timeout)
				{
					debug("it was the last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
		}
	}

	public static void enterValueWithParamsWhenAvailable(String xpathlocator, String value, int sleep, int timeout, Object...args) throws Exception	
	{
		int i;
		debug("Trying to click on "+ xpathlocator + "sleep" + sleep + "timeout" + timeout);
		for (i=1;;i++)
		{
			debug("Try" + Integer.toString(i));
			try
			{
				driver.findElement(By.xpath(String.format(xpathlocator, args))).sendKeys(value);
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed: ");
				debug(e);
				if (i == timeout)
				{
					debug("it was the last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void selectByTextWithParamsWhenAvailable(String xpathlocator, String text, int sleep, int timeout, Object...args)throws Exception
	{
		int i;
		debug("Trying to select " + text + "from" + xpathlocator + "sleep" + sleep + "timeout" + timeout);
		for (i=1;;i++)
		{
			debug("Try " + Integer.toString(i));
			try
			{
				Select select = new Select(driver.findElement(By.xpath(String.format(xpathlocator, args))));
				select.selectByVisibleText(text);
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed: ");
				debug(e);
				if (i == timeout)
				{
					debug("it was last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void scrollToWhenAvailable(WebElement el, int sleep, int timeout) throws InterruptedException
	{
		int i;
		debug("Trying to scroll to " + el + "sleep" + sleep + "timeout" + timeout);
		for (i=1;;i++)
		{
			debug("Try " + Integer.toString(i));
			try
			{
				action.moveToElement(el,1,1).build().perform();
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed: ");
				debug(e);
				if (i == timeout)
				{
					debug("it was last last try, returning");
					//throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void scrollDivWithParamsWhenAvailable(WebElement div, WebElement element, int sleep, int timeout)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop=arguments[1].offsetTop", div,element);
		
	}
	
	public static void scrollToWithParamsWhenAvailable(String xpathlocator, int sleep, int timeout, Object...args) throws Exception
	{
		scrollToWithParamsWhenAvailable(xpathlocator, sleep,timeout,1,1,args);
	}
	
	
	public static void scrollToTopOfThePage(int sleep, int timeout, int offsetX, int offsetY) throws Exception
	{
		int i;
		debug("Trying to scroll to top of the page" + "sleep" + sleep + "timeout" + timeout);
		for (i=1;;i++)
		{
			debug ("Try" + Integer.toString(i));
			try
			{
				action.moveToElement(driver.findElement(By.xpath("html/body")), offsetX, offsetY).build().perform();
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed: ");
				debug(e);
				if (i == timeout)
				{
					debug("It was the last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
			
		} 
		
	}
	
	public static void scrollToWithParamsWhenAvailable(String xpathlocator, int sleep, int timeout, int offsetX, int offsetY, Object...args) throws Exception
	{
		int i;
		Actions builder = new Actions(driver);
		debug("Trying to scroll to " + xpathlocator + "sleep" + sleep + "timeout" + timeout);
		for (i=1;;i++)
		{
			debug("Try "+ Integer.toString(i));
			try
			{
				builder.moveToElement(driver.findElement(By.xpath(String.format(xpathlocator, args))),offsetX,offsetY).build().perform();
				System.out.println("CC");
				debug("success");
				break;
			} catch (Exception e)
			{
				debug("failed: ");
				debug(e);
				if (i== timeout)
				{
					debug("it wwas last last try, returning");
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static String getTextWhenAvailable(Object locator, int sleep, int timeout) throws Exception
	{
		int i;
		String value;
		for (i=1;;i++)
		{
			try
			{
				value = driver.findElement(By.xpath(locator.toString())).getText();
				return value;
			} catch (Exception e)
			{
				if (i == timeout)
				{
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static String getAttributeWhenAvailable(Object locator, int sleep, int timeout, String attribute) throws Exception
	{
		int i;
		String value;
		for (i=1;;i++)
		{
			try
			{
				value = driver.findElement(By.xpath(locator.toString())).getAttribute(attribute);
				return value;
			} catch (Exception e)
			{
				if (i == timeout)
				{
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	
	public static String getInnerHTMLWhenAvailable(Object locator, int sleep, int timeout) throws Exception
	{
		int i;
		String value;
		for (i=1;;i++)
		{
			try
			{
				value = driver.findElement(By.xpath(locator.toString())).getAttribute("innerHTML");
				return value;
			} catch (Exception e)
			{
				if (i == timeout)
				{
					throw e;
				}
				sleep(sleep);
			}
		}
	}

	
	public static String getAttributeWithParamsWhenAvailable(String xpathlocator, int sleep, int timeout, String attribute, Object...args) throws Exception
	{
		int i;
		String value;
		for (i=1;;i++)
		{
			try
			{
				value = driver.findElement(By.xpath(String.format(xpathlocator, args))).getAttribute(attribute);
				return value;
			} catch (Exception e)
			{
				if (i == timeout)
				{
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static String getTextWithParamsWhenAvailable(String xpathlocator, int sleep, int timeout, Object...args) throws Exception
	{
		int i;
		String value;
		for(i=1;;i++)
		{
			try
			{
				value = driver.findElement(By.xpath(String.format(xpathlocator, args))).getText();
				return value;
			} catch (Exception e)
			{
				if (i == timeout)
				{
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void enterValueWhenAvailable(Object locator, String value, int sleep, int timeout) throws Exception
	{
		int i;
		for(i=1;;i++)
		{
			try
			{
				driver.findElement(By.xpath(locator.toString())).sendKeys(value);
				break;
			} catch (Exception e)
			{
				if (i == timeout)
				{
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void enterValueLikeAHumanWhenAvailable(Object locator, String value, int sleep, int timeout,int delays) throws Exception
	{
		int i;
		
		for (i=1;;i++)
		{
			try
			{
				driver.findElement(By.xpath(locator.toString())).click();
				driver.findElement(By.xpath(locator.toString())).clear();
				
				for(int j=0;j<value.length(); j++)
				{
					
					driver.findElement(By.xpath(locator.toString())).sendKeys(value.substring(j, j+1));
					sleep(delays);
				}
				break;
			} catch (Exception e)
			{
				if (i == timeout)
				{
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void hoverWhenAvailable(Object locator, int sleep, int timeout) throws Exception
	{
		int i;
		
		for (i=1;;i++)
		{
			try
			{
				WebElement w1 = driver.findElement(By.xpath(locator.toString()));
				action.moveToElement(w1).build().perform();
				break;
			} catch (Exception e)
			{
				if (i == timeout)
				{
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void hoverWithParamsWhenAvailable(String xpathlocator, int sleep, int timeout, Object...args) throws Exception
	{
		int i;
		for(i=1;;i++)
		{
			try
			{
				WebElement w1 = driver.findElement(By.xpath(String.format(xpathlocator, args)));
				action.moveToElement(w1).build().perform();
				break;
			} catch (Exception e)
			{
				if (i == timeout)
				{
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	public static void tabfn() throws Exception
	{
		Robot a = new Robot();
		a.keyPress(KeyEvent.VK_TAB);
		a.keyRelease(KeyEvent.VK_TAB);
		sleep(1000);
	}
	
	public static void down() throws Exception
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		sleep(1000);
	}
	
	public static void up() throws Exception
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		sleep(1000);
	}
	
	public static void enterfn() throws Exception
	{
		Robot a = new Robot();
		a.keyPress(KeyEvent.VK_ENTER);
		a.keyRelease(KeyEvent.VK_ENTER);
		sleep(1000);
	}
	
	
	public static void escapeFn() throws Exception
	{
		Robot a = new Robot();
		a.keyPress(KeyEvent.VK_ESCAPE);
		a.keyRelease(KeyEvent.VK_ESCAPE);
		sleep(1000);
	}
	
	
	public static void switchToWindow(String title) throws Exception
	{
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		String handle;
		String currentTitle;
		
		while(itr.hasNext())
		{
			handle = itr.next();
			debug("Now looking at window " + handle);
			driver.switchTo().window(handle);
			debug("Switched to it");
			currentTitle = driver.getTitle();
			debug("title: " + currentTitle);
			
			if (title.endsWith("%"))
			{
				if (currentTitle.startsWith(title.substring(0,title.length()-1)))
				{
					debug("THis is the one we want");
					return;
				}
			}
			else
			{
				if (currentTitle.equals(title))
				{
					debug("This is the one we want");
					return;
				}
			}
		}
		
		debug("window not found :");
		throw new Exception("Searched title not found:");
	}
	
	public static void switchToWindowWhenAvailable(String title, int sleep, int timeout) throws Exception
	{
		String currentTitle = driver.getTitle();
		if (currentTitle.contains(title))
		{
			return;
		}
		
		for ( int i=1;;i++)
		{
			try
			{
				switchToWindow(title);
				break;
			} catch (Exception e)
			{
				if (i == timeout)
				{
					throw e;
				}
				sleep(sleep);
			}
		}
	}
	
	
	public static void switchToNewWindow() throws Exception
	{
		MFO2_WINDOW_HANDLE = driver.getWindowHandle();
		String newChildWindow = "";
		Set<String> windowList = driver.getWindowHandles();
		for(String string : windowList)
		{
			newChildWindow = string;
		}
		driver.switchTo().window(newChildWindow);
		System.out.println(driver.getTitle());
	}
	
	public static void switchToParentWindow() throws Exception
	{
		System.out.println("Switching to " +MFO2_WINDOW_HANDLE);
		driver.switchTo().window(MFO2_WINDOW_HANDLE);
	}
	
	public static void closeAllOtherOpenWindows() throws Exception
	{
		String newChildWindow = "";
		Set<String> windowList = driver.getWindowHandles();
		for (String string : windowList)
		{
			if (!string.equals(MFO2_WINDOW_HANDLE))
			{
				newChildWindow = string;
				driver.switchTo().window(newChildWindow);
				System.out.println("Closing Window: " +driver.getTitle());
				Page.closeActiveWindow();
			}
		}
		Page.switchToParentWindow();
	}
	
	public static void closeActiveWindow()
	{
		Set<String> handleSet = driver.getWindowHandles();
		List<String> handlesList = new ArrayList<String>(handleSet);
		driver.switchTo().window(handlesList.get(1));
		driver.close();
		driver.switchTo().window(handlesList.get(0));
	}
	
	
	public static void switchToFrameWhenAvailable(String xpathlocator, int sleep, int timeout) throws InterruptedException
	{
		int i;
		
		for (i=1;;i++)
		{
			try
			{
				driver.switchTo().frame(driver.findElement(By.xpath(xpathlocator)));
				break;
			} catch (Exception e)
			{
				if (i == timeout)
				{
					//throw e;
				}
				sleep(sleep);
			}
		}
	}
	
}

