class MyThread extends Thread {
       public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread");
        }
    }
}

public class p1 {
        public static void main(String args[]) {
        MyThread mt = new MyThread();  
        mt.start();  // Start the child thread
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");  
        }
    }
}
