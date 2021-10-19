package Jaswanth.Automation.PractiseTests;
public class MaximumDistanceBetStrings {	 
	public static int SearchLetter(String input1, String input2)
	{	
	if(input1.contains(input2)) {
	int firstIndex = input1.indexOf(input2);
	int lastIndex = input1.lastIndexOf(input2);
	String finalSearchString = input1.substring(firstIndex+1, lastIndex);
	finalSearchString = finalSearchString.replace(" ", "");
	System.out.println(finalSearchString.length());
	return finalSearchString.length();
	}
	else {
		return -1;
		
	}
	}
	public static void main (String[] args)
    {
		SearchLetter("my name is ganar", "a");       
    }

}
