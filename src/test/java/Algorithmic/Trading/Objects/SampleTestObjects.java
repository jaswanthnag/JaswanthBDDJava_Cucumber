package Jaswanth.Automation.Objects;

public enum SampleTestObjects 
{
	
	UserNameInput_XPATH("//input[@id='UserName']"),
	PasswordInput_XPATH("//input[@id='Password']"),
	LoginButton_XPATH("//input[@type='submit']"),
	GoogleInput_XPATH("//input[@name='q']"),
	
	
	
	
	
	;
	private final String enumValue;
	
	private SampleTestObjects (String s)
	{
		enumValue = s;
	}
	
	public String getValue()
	{
		return enumValue;
	}
	
	public String toString()
	{
		return getValue();
	}
	

}
