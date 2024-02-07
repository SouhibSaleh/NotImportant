package MainPacakge;
import java.sql.*;
import java.util.ArrayList;


public class Handler {
	String DataBaseURL;
	String DBclass;
	Connection con;
	Statement stat;
	Handler() 
	{
	   DataBaseURL="jdbc:mysql://localhost:3306/shy0214532";
	   DBclass = "com.mysql.jdbc.Driver";
       try {
		//Class.forName(DBclass).newInstance();
         con = DriverManager.getConnection(DataBaseURL,"root","shays123_4??");
        stat = con.createStatement(); 
        
	  } catch (SQLException e) {
		e.printStackTrace();
		
	  }
	}
	
	public void Disconnect()
	{
		try {
			con.close();
		}
		catch(Exception ex)
		{
		    ex.printStackTrace();
		}
	}
	
	public boolean Exists(String s)
	{
		try {
			ResultSet rs = stat.executeQuery("select UserName from myset where UserName = \""+s+"\"");
			boolean b = false;
			while(rs.next())
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	public int Count()
	{
		int b = 0;
		try {
			ResultSet rs = stat.executeQuery("select UserName from myset");
			while(rs.next())
			{
				b++;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return b;
	}
	public ArrayList<String> getAll()
	{
		int b = 0;
		ArrayList<String>arr = new ArrayList<String>();
		try {
			ResultSet rs = stat.executeQuery("select * from myset");
			while(rs.next())
			{
				arr.add(rs.getObject(1).toString()+"\n");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return arr;
	}
	public void addData(String name,String pass)
	{
		try {
		 stat.executeUpdate("insert into myset values (\""+name+"\",\""+pass+"\")");
		 
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
		}
	}
	
	

}
















