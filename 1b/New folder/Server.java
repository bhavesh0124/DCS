import java.io.*;
import java.net.*;

public class Server
{
	public static void main(String[] args) throws Exception
	{
		final int port=8888;
		System.out.println("Server wating on port"+port);
		
		ServerSocket ss=new ServerSocket(port);
		while(true)
		{
			Socket clientSocket=ss.accept();
			System.out.println("Receiver connection "+clientSocket.getInetAddress()+"on port"+clientSocket.getPort());
			
			
			ReceivedFromClientThread receive=new ReceivedFromClientThread(clientSocket);
			Thread thread1=new Thread(receive);
			thread1.start();
			SendToClientThread send=new SendToClientThread(clientSocket);
			Thread thread2=new Thread(send);
			thread2.start();
		}
		
	}
}

class ReceivedFromClientThread implements Runnable
{
	Socket sock=null;
	BufferedReader bb=null;
	public ReceivedFromClientThread(Socket sock)
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
				if(str1.equals("EXIT"))
					break;
				System.out.println("From Client "+str1);
				System.out.println("Send somenthing to client .......");
			}
			this.sock.close();
			System.exit(0);
		}
		catch(Exception e){ System.out.println(e.getMessage());}
	
	}
	
}
class SendToClientThread implements Runnable
{
	Socket sock=null;
	PrintWriter pp=null;
	BufferedReader bb=null;
	public SendToClientThread(Socket sock)
	{
		this.sock=sock;
	}
	public void run()
	{
		try
		{
			pp=new PrintWriter(new OutputStreamWriter(this.sock.getOutputStream()));
			while(true)
			{
			bb=new BufferedReader(new InputStreamReader(System.in));
			String str2=null;
			str2=bb.readLine();
			pp.println(str2);
			pp.flush();
			System.out.println("Send something to client");
			}
			
		}
		catch(Exception e){ System.out.println(e.getMessage());}
	}
}