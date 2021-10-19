package Jaswanth.Automation.PractiseTests;


import java.util.*;

public class ArraySortedorNot
{
	 public static void main(String[] args) {
	        ArrayList<Double> list = new ArrayList<>();
	        Scanner input = new Scanner(System.in);
	        try{
	            while(input.hasNext()){
	                list.add(input.nextDouble());
	            }
	            if (list.size() < 10)
	                throw new Exception("Make sure your list has at least 10 elements.");
	            System.out.println("Original list: " + list);
	        
	            Double[] listArray = new Double[list.size()];
	            listArray = list.toArray(listArray);
	            Double[] testArray = Arrays.copyOf(
	            listArray, listArray.length);
	            
	            Arrays.sort(testArray);
	            
	            if (Arrays.equals(testArray, listArray)){
	                System.out.println("Looks like jolly good ascending list.");
	            }
	            else{
	                Arrays.sort(testArray, Collections.reverseOrder());
	                if (Arrays.equals(testArray, listArray)){
	                    System.out.println("I see you have a thing for descending lists ;-)");
	                    return;
	                }
	                System.out.println("Meh ... your list is not sorted ...");
	            }
	        }
	        catch(Exception ex){
	            System.out.println("Could not process your input: " + ex.getMessage());
	        }
	    }

}
