package Jaswanth.Automation.PractiseTests;

public class javaconstructor 
{
	  int num;
	  javaconstructor(){
	      num = 3;
	      System.out.println("Constructor invoked. num: " + num);
	   }
	  
	   public void init(){
	      num = 5;
	      System.out.println("Method invoked. num: " + num);
	   }
	   
	   public static void main(String args[]) {
		   javaconstructor tester = new javaconstructor();
	      tester.init();
	   

	   }
}
