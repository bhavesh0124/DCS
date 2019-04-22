import java.io.*;
import java.util.Scanner;
class ring{
	static int n,i,e,c,j;
	static int sta[]=new int[100];
	static int prid[]=new int[100];
    
    static int getmax()
    {
    	int max=-1,ind=-1;
    	for(i=0;i<n;i++)
    	{
    		if(prid[i]>max &&sta[i]==1)
    		{
    			max=prid[i];
    			ind=i;
    		}
    	}
      return ind;
    }
    
    static void sort()
    {
    	for(i=0;i<n-1;i++)
    	{
         for(j=i+1;j<n;j++)
         {
         	if(prid[i]>prid[j])
         	{
         		int temp=prid[i];
         		prid[i]=prid[j];
         		prid[j]=temp;

         		temp=sta[i];
         		sta[i]=sta[j];
         		sta[j]=temp;
         	}
         }
    	}
    }
    
    static void elect(int e)
	{  
		int senderIndex=0;
		for(int i=0;i<n;i++)
		{
			if(e==prid[i])
			{
				senderIndex=i;
				break;
			}
		}
        for(int recvIndex=senderIndex+1;prid[recvIndex]!=e;recvIndex=(recvIndex+1)%n)
        {
        	if(sta[recvIndex]==1)
        	{
             System.out.println("message sent from"+prid[senderIndex]+"to"+prid[recvIndex]);
             senderIndex=recvIndex;
        	}
        }
        }
    
    public static void main(String[] args) throws IOException
	{
      System.out.println("Enter the number of proceses\n");
      Scanner in=new Scanner(System.in);
      n=in.nextInt();
      for(i=0;i<n;i++)
      {
       sta[i]=1;
       System.out.println("Enter the process id "+i+"\n");
       prid[i]=in.nextInt();
       //System.out.println("Enter the process "+ i +" status\n");
       //sta[i] = in.nextInt()
      }
      sort();
      for(i=0;i<n;i++)
      {
      	System.out.print("\nProcess id"+prid[i]+" status ");
      	if(sta[i]==1)
      	{
      		System.out.print("TRUE");
      	}
      	else
      	{
      		System.out.print("FALSE");
      	}

      }
      System.out.println("\nProcess id"+prid[getmax()]+"failed");
      sta[getmax()]=0;

      
      System.out.println("Enter the process which will start election\n");
      e=in.nextInt();
      elect(e);
      System.out.println("Coordinator is"+prid[getmax()]);
      }



   
}
