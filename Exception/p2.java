import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class p2{
	public static void main (String args[]){
		String filename="Ma.java";
		try {
		String fileContent = new p2().readFile(filename);
		System.out.println(fileContent);
		}
		catch(FileNotFoundException e) {
		System.out.println("File:" + filename + "is missing, Please check file name" );
		}
		catch (IOException e) {
		System.out.println("File is not having permission to read, please check the permission");
		}
		}
public String readFile(String filename) throws FileNotFoundException,IOException{
	FileInputStream fin;
	int i;
	String s="";
	fin = new FileInputStream(filename);

	do {
	i = fin.read();
	if(i!= -1) s=s+(char) i+"";
	}while(i != -1);
	fin.close();
	return s;
	}
}
