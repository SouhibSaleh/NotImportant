package MyPackage;

import java.util.*;

import java.io.*;
import java.net.*;

public class Main  {
     public static String Name;
	public static void main(String[]args)
     {
		System.out.print("Give me your name please : ");
		Scanner scan = new Scanner(System.in);
		Name = scan.nextLine();
	  	
	  try {
		Socket ClientSocket = new Socket("localhost",9999);
		
		SendMessage temp1 = new SendMessage();
		temp1.SetSocket(ClientSocket);
		GetMessage temp2 = new GetMessage();
		temp2.SetSocket(ClientSocket);
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	  
  }

}

//////////////////////////////////////////////////////////////////////////////
class SendMessage implements Runnable{
	Socket ToAll;
	SendMessage()
	{
		this.ToAll = null;
	}
	SendMessage(Socket temp)
	{
		this.ToAll = temp;
	}
	public void SetSocket(Socket temp)
	{
		SendMessage T = new SendMessage(temp);
		Thread tt = new Thread(T);
		tt.start();
	}
	@Override
	public void run()
	{
       PrintWriter Writer = null;		
	
		try {
			Writer = new PrintWriter(ToAll.getOutputStream(),true);
		    while(true) {	
			    Scanner scan = new Scanner(System.in);
			    String s = scan.nextLine();
			    Writer.println(Main.Name+" : "+s);
			  }
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	  
	}
	
}


//////////////////////////////////////////////////////////////////////////////
class GetMessage implements Runnable{
	Socket ToMe;
	BufferedReader Read;

    GetMessage()
    {
    	this.ToMe = null;
    	this.Read =null;
    }
    GetMessage(Socket temp)
    {
    	ToMe = temp;
    }
    void SetSocket(Socket temp)
    {	 

    	GetMessage T = new GetMessage(temp);
    	Thread tt = new Thread(T);
    	tt.start();
    }
    
    @Override
    public void run()
    {
    	
      	try {
				Read = new BufferedReader(new InputStreamReader(ToMe.getInputStream()));
				while(true) {
	        	String s = null;
	 			//Read = new BufferedReader(new InputStreamReader(ToMe.getInputStream()));       
				while((s=Read.readLine())!=null)
	     		{
					System.out.println(s);
		    	}
			}	
		} 
      	catch (IOException e) {
			e.printStackTrace();
		}

    }
    
	
}








