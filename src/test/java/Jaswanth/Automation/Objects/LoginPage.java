package Jaswanth.Automation.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id = "Email")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(id = "Password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	
	public void setUserName(String uname) throws InterruptedException {
		Thread.sleep(20000);
		txtEmail.clear();
		txtEmail.sendKeys(uname);

	}

	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void clickLogout() {
		lnkLogout.click();
	}
	

}
