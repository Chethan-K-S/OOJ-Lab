interface Animal{
	void sound();
	void eat();
}

class Dog implements Animal{
	public void sound(){
		System.out.println("Dog barks");
	}

	public void eat() {
		System.out.println("Dog eats bones");
	}
}

public class Main{
	public static void main(String args[]){
		Animal myDog = new Dog();
		myDog.sound();
		myDog.eat();
	}
}