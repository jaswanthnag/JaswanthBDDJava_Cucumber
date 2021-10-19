package Jaswanth.Automation.PractiseTests;

import java.util.HashMap;
import java.util.Map;

public class JavaHashMap {

	public static void main(String[] args) {
		
		 HashMap<Integer,String> map = new HashMap<Integer,String>();//Creating HashMap    
		   map.put(1,"Mango");  //Put elements in Map  
		   map.put(5,"Apple");    // 1 - mango 2 - Apple 3 -bananna
		   map.put(3,"Banana");   
		   map.put(null,"Grapes");  
		   System.out.println("Iterating Hashmap...");  
		   for(Map.Entry m : map.entrySet()){    
		    System.out.println(m.getKey()+" "+m.getValue());    
		   }  

	}
	
}


