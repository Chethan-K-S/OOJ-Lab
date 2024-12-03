public class MyThreads extends Thread
{
public void run()
{
System.out.println("r1 ");
try {
Thread.sleep(500);
}
catch(InterruptedException ie){ }
System.out.println("r2 ");
}
public static void main(String[] args)
{
MyThread t1=new MyThread();
MyThread t2=new MyThread();
t1.start();
t2.start();
}
}