import java.io.*;
import java.util.Scanner;

class bully
{
	static int n;
	static int priorty[]=new int[100];
	static int status[]=new int[100];
	static int coordinator;
	public static void main(String[] args)throws IOException
	{
		Scanner cin=new Scanner(System.in);
		System.out.println("Enter the the number of processes");
		n=cin.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.print("Priority of Process P"+(i+1)+"   :   ");
			priorty[i]=cin.nextInt();
			System.out.print("\nStatus of process P"+(i+1)+"   :   ");
			status[i]=cin.nextInt();
			System.out.print("\n");
		}
		System.out.println("Enter the Process to start Election");
		int starter=cin.nextInt();
		election(starter);
		System.out.println("\n \n New Coordinator  : "+coordinator);
	}
	static void election(int starter)
	{
		starter=starter-1;
		coordinator=starter+1;
		for(int i=0;i<n;i++)
		{
			if(priorty[starter]<priorty[i])
			{
				System.out.println("Process P"+(starter+1)+" Send election message to Process P"+(i+1));
				if(status[i]==1)
					election(i+1);
			}
		}
	}
}