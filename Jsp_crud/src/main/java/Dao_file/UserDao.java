package Dao_file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean_file.User;

public class UserDao {

public static Connection getConnection()
{
		Connection con=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
}

public static int save(User u)
{
	int status=0;
	
	
	try {
		Connection con=UserDao.getConnection();
		PreparedStatement pr=con.prepareStatement("insert into usertbl (Name,Sex,Password,Email,Country)values(?,?,?,?,?) ");
	
		pr.setString(1, u.getName());
		pr.setString(2,u.getSex());
		pr.setString(3, u.getPassword());
		pr.setString(4, u.getEmail());
		pr.setString(5, u.getCountry());

          status=pr.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return status;
}


public static int update(User u)
{
      int status=0;
      
	try {
	    Connection con=UserDao.getConnection();
	    PreparedStatement pr = con.prepareStatement("update usertbl set Name=?,Sex=?,Password=?,Email=?,Country=? where id=?");
	
	    pr.setString(1,u.getName());
	    pr.setString(2,u.getSex());
	    pr.setString(3,u.getPassword());
	    pr.setString(4,u.getEmail());
	    pr.setString(5,u.getCountry());
	    pr.setInt(6, u.getId());
	    
	    status=pr.executeUpdate();
	    
	    System.out.println(status);
	    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return status;
}


public static int delete(User u)
{
	 int status=0;
	 
	 
	try {
		Connection con=UserDao.getConnection();
		PreparedStatement pr = con.prepareStatement("delete from usertbl where id=?");
	
		pr.setInt(1, u.getId());
		
		
		status =pr.executeUpdate();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}return status;
}

public static List<User> getAllrecord()
{
	List<User> list=new ArrayList<User>();

      
      
	try {
		Connection con=UserDao.getConnection();
		PreparedStatement  pr = con.prepareStatement("select * from usertbl");
		
		ResultSet rs=pr.executeQuery();
		
	      while(rs.next())
	      {
	    	  User u=new User();
	    	  
	    	  u.setId(rs.getInt("id"));
	    	  u.setName(rs.getString("name"));
	    	  u.setSex(rs.getString("sex"));
	    	  u.setPassword(rs.getString("password"));
	    	  u.setEmail(rs.getString("email"));
	    	  u.setCountry(rs.getString("country"));
	    	  
	    	  list.add(u);
	    	
	      }

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
  return list;     
}

public static User getRecordByid(int id)
{
		User u=null;
try {
	Connection con=UserDao.getConnection();
	PreparedStatement  pr = con.prepareStatement("select * from usertbl where id=?");
	pr.setInt(1, id);
	
	ResultSet rs=pr.executeQuery();
      while(rs.next())
      {
    	   u=new User();
    	  
    	   u.setId(rs.getInt("id"));
	    	  u.setName(rs.getString("name"));
	    	  u.setSex(rs.getString("sex"));
	    	  u.setPassword(rs.getString("password"));
	    	  u.setEmail(rs.getString("email"));
	    	  u.setCountry(rs.getString("country"));
    	
      }

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
return u;     
}
}
