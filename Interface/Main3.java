import java.util.Scanner;

interface Polygon {
    double getPerimeter();
    double getArea();
}

class Square implements Polygon {
    private double side;

    Square(double side) {
        this.side = side;
    }

    double getPerimeter() {
        return 4 * side;
    }

    double getArea() {
        return side * side;
    }
}

class Triangle implements Polygon {
    private double side;

    Triangle(double side) {
        this.side = side;
    }

    double getPerimeter() {
        return 3 * side;
    }

    double getArea() {
        return (Math.sqrt(3) / 4) * Math.pow(side, 2);
    }
}

public class Main3 {
    public static void main(String[] args) {
        double s, t;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of side of square: ");
        s = sc.nextDouble();  
 
        System.out.print("Enter the length of side of triangle: ");
        t = sc.nextDouble();

        Square square = new Square(s);
        System.out.println("Square Perimeter: " + square.getPerimeter());
        System.out.println("Square Area: " + square.getArea());

        Triangle tri = new Triangle(t);
        System.out.println("Triangle Perimeter: " + tri.getPerimeter());
        System.out.println("Triangle Area: " + tri.getArea());

    
        sc.close();
    }
}
