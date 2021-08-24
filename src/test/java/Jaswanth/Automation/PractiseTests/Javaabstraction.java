package Jaswanth.Automation.PractiseTests;

public class Javaabstraction 
{
	abstract class Animal {
        // abstract methods
        abstract void move();
        abstract void eat();

        // concrete method
        void label() {
                System.out.println("Animal's data:");
        }
    }

	
	
class Bird extends Animal {

void move() {
                 System.out.println("Moves by flying.");
     }
        void eat() {
                 System.out.println("Eats birdfood.");
}         
}

class Fish extends Animal {
                 void move() {
                         System.out.println("Moves by swimming.");
             }
                 void eat() {
                         System.out.println("Eats seafood.");
                 }
}


        public void main(String[] args) {
                Animal myBird = new Bird();

                myBird.label();
                myBird.move();
                myBird.eat();
        
}
        
    



  class TestFish 
  { 
	  
	  
	  public void main(String[] args) { 
		  Animal myFish = new Fish();
  myFish.label(); 
  myFish.move(); 
  myFish.eat(); 
  } }
 



//Create a Main class

/*
 * int x; // Create a class attribute
 * 
 * // Create a class constructor for the Main class
 * 
 * public Javaabstraction() { x = 10; // Set the initial value for the
 * classattribute x }
 * 
 * 
 * public static void main(String[] args) { Javaabstraction myObj = new
 * Javaabstraction(); // Create an object of class Main (This will call the
 * constructor) System.out.println(myObj.x); // Print the value of x }
 * 
 * public String j() { String str = "J"; return str; }
 */
}












