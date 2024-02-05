package ServerPackage;

import java.net.*;
import java.util.ArrayList;
import java.io.*;




public class Server {
  public static void main(String[]args)
  {
      try {
		ServerSocket t = new ServerSocket(9999);
		while(true) {		
		Socket s = t.accept();
		Session test = new Session();
		test.SocArr.add(s);
		test.AddSession(s);
		}  
	  } catch (IOException e) {
   	}
  }
};


class Session implements Runnable{
	Socket AccSocket;
	BufferedReader Read;
	public static ArrayList<Socket>SocArr = new ArrayList<Socket>();
	Session(Socket soc)
	{
		AccSocket = soc;
	}
	Session()
	{
		this.AccSocket = null;
	}
	public void AddSession(Socket temp)
	{
		Session T = new Session(temp);
		Thread th = new Thread(T);
		th.start();
	}
	@Override
	public void run()
	{				
		try {
			
			Read = new BufferedReader(new InputStreamReader(AccSocket.getInputStream()));
		    while(true) {
			    String s = null;
		    	while((s=Read.readLine())!=null)
			     {
			    	 System.out.println(s);
					for(Socket x:SocArr) {
			    	   if(x!=AccSocket) 
			    	   {
						PrintWriter Writer = new PrintWriter(x.getOutputStream(),true);
			    	    Writer.println(s+" "+SocArr.size());
					}
			     }
		       }
		    }
		} catch (IOException e) {
		}
		
	}


}









