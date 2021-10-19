package Jaswanth.Automation.PractiseTests;

import java.util.ArrayList;
import java.util.Iterator;

public class JavaArrayList {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		ArrayList<String> list = new ArrayList<String>();//Creating arraylist  
		list.add("Ajay");  
		list.add("Ravi");//Adding object in arraylist  
		list.add("Vijay");  
		list.add("Ravi");  
		
		//Traversing list through Iterator  
		Iterator itr = list.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}  


	}

}
