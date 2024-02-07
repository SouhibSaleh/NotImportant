package MainPacakge;

import java.util.Scanner;

public class Main {
	
	 static void NewLine()
	 {
		 System.out.println();
	 }
	 static String myScan()
	 {
		   try (Scanner scan = new Scanner(System.in)) {
			return scan.nextLine();
		}
	 }
	public static void main(String[]args)
	{
		Handler b = new Handler();
		View v = new View();
        control t = new control(b,v);
           System.out.println("Hello World !");
		while(true) {
           System.out.println("1 : Add User");
		   System.out.println("2 : Check if the user exists");
		   System.out.println("3 : Get All Users");
		   System.out.println("4 : Get the number of Users");
		   try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			   String s1,s2;
			   if(a==1)
			   {
				   System.out.print("username : ");
				   s1 = myScan();
				   System.out.print("password : ");
				   s2 = myScan(); 
				   t.addUser(s1, s2);
			   }
			   else if(a==2)
			   {
				   System.out.print("username : ");
				   s1 = myScan();
				   t.CheckExists(s1);
			   }
			   else if(a==3)
			   {
				   System.out.print("users : ");
				   t.GetData();
			   }
			   else {
				   System.out.print("the number of users is : ");
				   t.Counter();
			   }
		}
	  }  
	}

}
