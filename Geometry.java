abstract class Shape{
	int x,y;
	abstract void printarea();
}

class Rectangle extends Shape{
	Rectangle (int l, int b){
		x=l;
		y=b;
	}

@Override 
void printarea(){
	int area = x+y;
	System.out.println("Area of rectangle is " + area);
	}
}

class Triangle extends Shape{
	Triangle (int b, int h){
		x=b;
		y=h;
	}

@Override 
void printarea(){
	double area = 0.5*x*y;
	System.out.println("Area of triangle is " + area);
	}
}

class Circle extends Shape{
	int radius;
	Circle (int radius){
		this.radius=radius;
	}

@Override 
void printarea(){
	double area = 3.14*radius*radius;
	System.out.println("Area of circle is " + area);
	}
}

public class Geometry{
	public static void main (String args[]){
		Shape r=new Rectangle(5,11);
		Shape t=new Triangle(20,9);
		Shape c=new Circle (5);
		r.printarea();
		t.printarea();
		c.printarea();
	}
}