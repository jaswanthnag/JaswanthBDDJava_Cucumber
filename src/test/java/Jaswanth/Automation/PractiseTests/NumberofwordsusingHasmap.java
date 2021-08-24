package Jaswanth.Automation.PractiseTests;

import java.util.HashMap;

public class NumberofwordsusingHasmap {
	 public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        String str = "This this is is done by Selenium Selenium is";
	        String[] split = str.split(" ");
	        
			/*
			 * split[0] = This 
			 * split[1] = this
			 */
	         
	        HashMap<String,Integer> map = new HashMap<String,Integer>();
	        
	        for (int i=0; i<split.length; i++) {
	        	
	            if (map.containsKey(split[i])) {
	            	
	                int count = map.get(split[i]); // (is,1) map.get(is) (is,2)
	                map.put(split[i], count+1);
	            }
	            else {
	                map.put(split[i], 1);
	            }
	        }
	        
	        System.out.println(map);
	    }


}
