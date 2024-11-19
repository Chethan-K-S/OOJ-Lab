interface Vehicle {
	void start();
}

interface Car extends Vehicle {
	void drive();
}

class Sedan implements Car{
public void start(){
	System.out.println("Sedan is starting");
	}

public void drive(){
	System.out.println("Sedan is driving");
	}
}

public class Main1 {
	public static void main (String args[]){
		Car myCar = new Sedan();
		myCar.start();
		myCar.drive();
	}
}