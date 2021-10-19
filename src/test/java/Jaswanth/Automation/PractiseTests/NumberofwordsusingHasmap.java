package Jaswanth.Automation.PractiseTests;

import java.util.HashMap;

public class NumberofwordsusingHasmap {
	 public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        String str = "This this is is done by Selenium Selenium is";
	        String[] split = str.split(" ");
	        String str1 = "Selenium";
	        char[] ch = str1.toCharArray();
	        HashMap<Character,Integer> map1 = new HashMap<Character,Integer>();
	        for(char c: ch)
	        {
                if (map1.containsKey(c)) {
	            	
	                int count = map1.get(c); // (is,1) map.get(is) (is,2) //count = 1
	                map1.put(c, count+1);//(is,2)
	            }
	            else {
	                map1.put(c, 1);//(This,1) (this,1) (is,1)
	            }
	        }
	        
	        System.out.println("Map1:"+ map1);
	        }
			/*
			 * split[0] = This 
			 * split[1] = this
			 */
	         
	        HashMap<String,Integer> map = new HashMap<String,Integer>();
	        
			/*
			 * for (int i=0; i<split.length; i++) {
			 * 
			 * if (map.containsKey(split[i])) {
			 * 
			 * int count = map.get(split[i]); // (is,1) map.get(is) (is,2) //count = 1
			 * map.put(split[i], count+1);//(is,2) } else { map.put(split[i], 1);//(This,1)
			 * (this,1) (is,1) } }
			 * 
			 * System.out.println(map); }
			 */


}
