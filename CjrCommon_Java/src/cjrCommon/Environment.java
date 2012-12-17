package cjrCommon;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Environment { 
 

		public static String WorkingDirectory(){
			String currentdir = System.getProperty("user.dir");
			return currentdir;
		} 
		
	/*	public static String CurrentApplication()
		{
			return System.getProperty("");
		}
		*/

		public static String User() {
			return System.getProperty("user.name");
		}
		
		public static String MachineName() throws UnknownHostException
		{
			InetAddress host = InetAddress.getLocalHost();
			return host.getHostName();
		}
}
