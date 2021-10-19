package Jaswanth.Automation.PractiseTests;
import java.io.*;

import java.util.*;

public class sample {
	

	 
	public static int SearchLetter(String input1, String input2)
	{	
	if(input1.contains(input2)) {
	int firstIndex = input1.indexOf(input2);
	System.out.println("firstindex"+" "+firstIndex);
	int lastIndex = input1.lastIndexOf(input2);
	System.out.println("lastindex"+" "+lastIndex);
	String finalSearchString = input1.substring(firstIndex+1, lastIndex);
	System.out.println("final"+" "+finalSearchString);
	 
	finalSearchString = finalSearchString.replace(" ", "");
	
	
	System.out.println("final"+" "+finalSearchString);
	  
	 System.out.println("String length"+" "+finalSearchString.length());
	return finalSearchString.length();
	}
	else {
		System.out.println("00");
		return -1;
		
	}
	}
	

	public static void main (String[] args)

    {

       

		SearchLetter("kaahjj", "a");

       

    }

}
