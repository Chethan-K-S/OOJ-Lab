import java.util.Scanner;

public class quad {
    public static void main(String[] args) {
    int a,b,c;
    float disc;
Scanner input = new Scanner(System.in);
System.out.println("Enter co-efficient of x square");
a= input.nextInt();
System.out.println("Enter co-efficient of x ");
b= input.nextInt();
System.out.println("Enter the constant");
c=input.nextInt();
disc = b*b-4*a*c;
if(disc<0){
System.out.println("No real root exists");
}

else if(disc>0){
double root1=(-b+Math.sqrt(disc))/(2*a);
double root2=(-b-Math.sqrt(disc))/(2*a);
System.out.println("The roots are" +root1+"and"+root2);
}

else{
double root1 = (-b)/(2*a);
System.out.println(" The roots are equal " + root1);
}
System.out.println("CHETHAN K S\n1BM23CSO74");
input.close();

}}