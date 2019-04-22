import java.io.*;
import java.net.*;

public class Client
{
	public static void main(String[] args) throws Exception
	{
		Socket sock= new Socket("localhost",8888);
		
		
			
			ReceivedThread receive=new ReceivedThread(sock);
			Thread thread1=new Thread(receive);
			thread1.start();
			SendThread send=new SendThread(sock);
			Thread thread2=new Thread(send);
			thread2.start();
		
	}
}

class ReceivedThread implements Runnable
{
	Socket sock=null;
	BufferedReader bb=null;
	public ReceivedThread(Socket sock)
	{
		this.sock=sock;
	}
	public void run()
	{
		try
		{
			bb=new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
			String str1=null;
			while((str1=bb.readLine())!=null)
			{
				System.out.println("From Client "+str1);
				System.out.println("Send somenthing to server .......");
			}
		}
		catch(Exception e){ System.out.println(e.getMessage());}
	
	}
	
}
class SendThread implements Runnable
{
	Socket sock=null;
	PrintWriter pp=null;
	BufferedReader bb=null;
	public SendThread(Socket sock)
	{
		this.sock=sock;
	}
	public void run()
	{
		try
		{
			if(sock.isConnected())
			{
				System.out.println("Client conneceted to "+sock.getInetAddress()+"Port  "+sock.getPort());
				
				pp=new PrintWriter(new OutputStreamWriter(this.sock.getOutputStream()));
					while(true)
					{
						System.out.println("Send something to Server otherwise EXIT");
					bb=new BufferedReader(new InputStreamReader(System.in));
					String str2=null;
					str2=bb.readLine();
					pp.println(str2);
					pp.flush();
					
					if(str2.equals("EXIT"))
						break;
					}
					sock.close();
			}
			
		}
		catch(Exception e){ System.out.println(e.getMessage());}
	}
}