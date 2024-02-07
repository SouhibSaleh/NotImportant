package MainPacakge;

import java.io.IOException;
import java.util.Scanner;

public class View {
	View()
	{
		
	}

	public void Response(String s)
	{
	  System.out.println(s);
	  try {
			Thread.currentThread().sleep(3000);
		      Runtime.getRuntime().exec("cls");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
