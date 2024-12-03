public  class p2
{public static void main(String args[])
{
Thread t=Thread.currentThread();
System.out.println("Current thread: "+t);
System.out.println("Name is: "+t.getName());
}
}