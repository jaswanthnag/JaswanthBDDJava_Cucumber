package Jaswanth.Automation.PractiseTests;

public class JavaInterface {

	interface Animal {
        public void eat();
        public void sound();
}

interface Bird {
        int numberOfLegs = 2;
        String outerCovering = "feather";

        public void fly();
}

class Eagle implements Animal, Bird {
        public void eat() {
                System.out.println("Eats reptiles and amphibians.");
        }
        public void sound() {
                System.out.println("Has a high-pitched whistling sound.");
        }
        public void fly() {
                System.out.println("Flies up to 10,000 feet.");
        }
}

class TestEagle {
        public void main(String[] args) {
                Eagle myEagle = new Eagle();

                myEagle.eat();
                myEagle.sound();
                myEagle.fly();

                System.out.println("Number of legs: " + Bird.numberOfLegs);
                System.out.println("Outer covering: " + Bird.outerCovering);
        }
}

/*
 * [Console output of TestEagle] Eats reptiles and amphibians. Has a
 * high-pitched whistling sound. Flies up to 10,000 feet. Number of legs: 2
 * Outer covering: feather
 */



}
