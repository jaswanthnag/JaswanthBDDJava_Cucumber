package Jaswanth.Automation.PractiseTests;

import java.util.ArrayList;
import java.util.HashSet;

public class SortStrings {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub

		   String str1 = "Hello";
				String   str2 = "lloHe";

				/*
				 * for(int i = 0;i< str1.length();i++) { System.out.println(str1.charAt(i));
				 * char h = str1.charAt(i);
				 * 
				 * 
				 * 
				 * }
				 */

				  //HashSet<String> hs = new HashSet<String>();
				  ArrayList<String> al  = new ArrayList<String>(); 
				  al.add(str1);
				  al.sort(null);
				  
				  System.out.println(al);
				  
				  

	}

}
