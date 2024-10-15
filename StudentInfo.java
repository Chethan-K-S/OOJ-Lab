import java.util.Scanner;

class Student {
    String name;
    String usn;
    int[] credits;
    int[] marks;
    int numberOfSubjects;

    void takeDetails() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = input.nextLine();
        System.out.print("Enter your USN: ");
        usn = input.nextLine();
        System.out.print("Enter number of subjects: ");
        numberOfSubjects = input.nextInt();
        
        credits = new int[numberOfSubjects];
        marks = new int[numberOfSubjects];
        
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter the number of credits for subject " + (i + 1) + ": ");
            credits[i] = input.nextInt();
            System.out.print("Enter the marks for subject " + (i + 1) + ": ");
            marks[i] = input.nextInt();
        }
    }

    int gradePoints(int i) {
        if (marks[i] >= 90) return 10;
        else if (marks[i] >= 80) return 9;
        else if (marks[i] >= 70) return 8;
        else if (marks[i] >= 60) return 7;
        else if (marks[i] >= 50) return 6;
        else if (marks[i] >= 40) return 5;
        else return 0;
    }

    double calculateSGPA() {
        int totalGradePoints = 0;
        int totalCredits = 0;
        
        for (int i = 0; i < numberOfSubjects; i++) {
            totalCredits += credits[i];
            totalGradePoints += credits[i] * gradePoints(i);
        }

      return totalGradePoints/totalCredits;
    }
}

public class StudentInfo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	System.out.print("Enter no of students ");
	int no=input.nextInt();
	for(int i = 0; i < no; i++)
	{
	
        		Student student = new Student();
       		student.takeDetails();
        		System.out.println("Your total SGPA is: " + student.calculateSGPA());
	}
	 System.out.print("Name: Chethan K S USN: 1BM23CS074");
    }
}
