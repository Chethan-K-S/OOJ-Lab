
class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}


class Father {
    int fatherAge;

    public Father(int fatherAge) throws WrongAge {
        if (fatherAge < 0) {
            throw new WrongAge("Father's age cannot be negative: " + fatherAge);
        }
        this.fatherAge = fatherAge;
        System.out.println("Father's age set to " + this.fatherAge);
    }
}


class Son extends Father {
    int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge);
        
        if (sonAge < 0) {
            throw new WrongAge("Son's age cannot be negative: " + sonAge);
        }

 

        this.sonAge = sonAge;
        System.out.println("Son's age set to " + this.sonAge);
    }
}


public class labexception {
    public static void main(String[] args) {
        try {
            System.out.println("Test case 1:");
            int father1 = 40;
            int son1 = 15;
            int father2 = 40;
            int son2 = -5;
	  
            Son s1 = new Son(father1, son1);
	  Son s2 = new Son(father2, son2);
	  
            
        } catch (WrongAge e) {
            System.out.println("Error: " + e.getMessage());
        }
}
}
      
