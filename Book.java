import java.util.Scanner;
public class Book
{
	private String name;
	private String author;
	private double price;
	private int num_pages;
	
public Book(String name, String author, double price, int num_pages)
{
	this.name=name;
	this.author=author;
	this.price=price;
	this.num_pages=num_pages;
}

public String getName()
{
	return name;
}
public void setName(String name)
{
	this.name=name;
}
public String getAuthor()
{
	return author;
}
public void setAuthor(String author)
{
	this.author=author;
}
public double getPrice()
{
	return price;
}
public void setPrice(double price)
{
	this.price=price;
}
public int getNumPages()
{
	return num_pages;
}
public void setNumPages(int num_pages)
{
	this.num_pages=num_pages;
}
@Override
public String toString()
{
	return "\nName:" + name + "\nAuthor:" + author + "\nPrice:" + price + "\nNumber of pages:" + num_pages;
}

public static void main(String args[])
{
	Scanner input = new Scanner(System.in);
	System.out.print("\n Enter the number of books:");
	int n = input.nextInt();
	input.nextLine();
	Book[] books =new Book[n];
	for(int i=0;i<n;i++)
	{
		System.out.print("\n Enter the name of the book:");
		String name=input.nextLine();
		System.out.print("\n Enter the author name:");
		String author = input.nextLine();
		System.out.print("\n Enter the price of the book:");
		double price = input.nextDouble();
		System.out.print("\n Enter the number of pages:");
		int num_pages = input.nextInt();
		input.nextLine();
		books[i] = new Book (name,author,price,num_pages);
	}
	for (Book book:books)
	{
	System.out.println(book.toString());
	}
	System.out.print("Name: Chethan K S\n USN: 1BM23CS074");
input.close();
}
}








