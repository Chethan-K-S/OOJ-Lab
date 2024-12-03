class Message1 extends Thread {
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("BMS College of Engineering");
        }
    }
}

class Message2 extends Thread {
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("CSE");
        }
    }
}

public class labthread {
    public static void main(String[] args) {
        Message1 thread1 = new Message1();
        Message2 thread2 = new Message2();
        
        thread1.start(); 
        thread2.start(); 
    }
}
