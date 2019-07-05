package QQDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jms.Session;

import QQdomain.User;

public class QQDao {
	public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// 连接数据库地址配置信息
	public static String url = "jdbc:sqlserver://localhost:1433;DataBaseName=QQdatabase";
	
	public static ArrayList<User> load(String ID) {//找到一个人所有的好友
		Connection con=null;
	    PreparedStatement stm = null;
		ArrayList<User> userlist = new ArrayList<User>();
	    try
	    {
	   	 Class.forName(driver);
	   	 con= DriverManager.getConnection(url,"sa","990820");
	   	 if(con!=null)
	   	 System.out.println("数据库连接已经被打开");
		}
	    catch (Exception e) {
		  e.printStackTrace();
		}
	    String sql = "select FriendsID from Friends where ID = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ID);//找到这个ID的所有朋友
			ResultSet rs = pst.executeQuery();
			//把他所有的朋友进行封装起来

			String sql2 = "select ID,password,username,groupID,IpAddress,port,groupname from Users where ID = ?";
			PreparedStatement pst2 = con.prepareStatement(sql2);
			//resultset索引从1开始
			while(rs.next()){ 
				pst2.setString(1, rs.getString(1).trim());
			    ResultSet rs2 = pst2.executeQuery();
			    User user = new  User();
			    rs2.next();//默认在-1行
			    user.setID(rs2.getString(1).trim());
			    user.setPassword(rs2.getString(2).trim());
			    user.setUsername(rs2.getString(3).trim());
			    user.setGroupID(rs2.getString(4).trim());
			    user.setIpAddress(rs2.getString(5).trim());
			    user.setPort(rs2.getInt(6));
			    user.setGroupname(rs2.getString(7).trim());

			    userlist.add(user);
			}
			//重定向到表单
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
	}

}
