import java.util.InputMismatchException;
import java.util.Scanner;


class InvalidUserInputException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	InvalidUserInputException(){
	 super();
	}

	InvalidUserInputException(String msg){
	 super();
	}

	InvalidUserInputException(Throwable throwable){
	 super(throwable);
	}

	InvalidUserInputException(String msg, Throwable throwable){
	 super(msg, throwable);
	}
	}



public class p5{
	public static void main (String chethan[]) {
	System.out.println("Type an integer on the console");
	try{
		System.out.println("You typed : " +readFromConsole());
	}
	catch(InvalidUserInputException ex){
		System.out.println("Exception is of type:" +ex);
		System.out.println("Original  caught exception is of type "+ex.getCause());
		}
	}

public static int readFromConsole(){
	Scanner sc = new Scanner(System.in);
	int i=0;
	try{
	 i=sc.nextInt();
	}catch(InputMismatchException ex){
	System.out.println("Wrapping exception and throwing ");
	System.out.println();
	throw new InvalidUserInputException("Invalid integer value entered",ex);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return i;
	}
}		













