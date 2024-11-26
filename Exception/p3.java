

import java.util.Scanner;

public class p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your age - numeric value ;");
        int age = sc.nextInt();
	   if (age > 18 ){
			System.out.println("you are authorized to view this page");
		}
	   else{
			System.out.println("you are not authorized to view this page");

		}
    }
}