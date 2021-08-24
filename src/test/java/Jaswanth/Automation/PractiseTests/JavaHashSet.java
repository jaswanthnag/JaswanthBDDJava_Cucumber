package Jaswanth.Automation.PractiseTests;

import java.util.HashSet;
import java.util.Iterator;

public class JavaHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating HashSet and adding elements  
		HashSet<String> set=new HashSet<String>();  
		set.add("Ravi");  
		set.add("Vijay");  
		set.add("Ravi");  
		set.add("Ajay");  
		//Traversing elements  
		Iterator<String> itr=set.iterator();  
		
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}  


	}

}
