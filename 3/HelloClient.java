import java.util.Properties;

import org.omg.CORBA.*;
import org.omg.CostNaming.*;
import org.omg.CostNaming.NamingContextPackage.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA.*;

public class HelloClient
{
	static Hello helloImpl;
	public static void main(String[] args)
	{
		try
		{
			ORB orb=ORB.init();
			
			orb.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
			NamingContextExt ncRef=NamingContextExtHelper.narrow(objRef);
			
			String name="Hello";
			helloImpl=HelloHelper.narrow(ncRef.resolve_str(name));
			
			System.out.println("Obtained a handle on server object: " + helloImpl);
			System.out.println(helloImpl.sayHello());
			System.out.println(helloImpl.shutdown());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}