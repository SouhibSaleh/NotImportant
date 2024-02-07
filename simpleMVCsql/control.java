package MainPacakge;

import java.util.ArrayList;

public class control{
	private Handler hand;
	private View view;
	control(Handler a,View v)
	{
		this.hand = a;
		this.view = v;
	}
	public void addUser(String username,String password)
	{
		hand.addData(username, password);
		view.Response("Data added successfully");
	}
	public void CheckExists(String username) {
		
		if(hand.Exists(username))
		{
			view.Response("The user exists");
		}
		else view.Response("The user DOESN'T exists");
	}
	public void GetData()
	{
		view.Response(hand.getAll().toString());
	}
	public void Counter()
	{
		view.Response(""+hand.Count());
	}
}
