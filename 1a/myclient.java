import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class myclient 
{
	public static void main(String[] args) throws Exception
	{
		
		BufferedReader bb=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the First String");
		String str1=bb.readLine();
		System.out.println("Enter the Second String");
		String str2=bb.readLine();
		Registry rr =LocateRegistry.getRegistry("localhost",1111);
		
		myinterface m=(myinterface)rr.lookup("abc");
		String str3= m.input(str1, str2);
		
		// Print Concatenated String 
		System.out.println(str3);

	}
}