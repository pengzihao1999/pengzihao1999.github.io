package test;

import java.lang.reflect.Constructor;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mytest {
	// 驱动类名
		public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// 连接数据库地址配置信息
		public static String url = "jdbc:sqlserver://localhost:1433;DataBaseName=student";
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
     Connection connection=null;
     Statement statement=null;
     try
     {
    	 Class.forName(driver);
    	 connection=DriverManager.getConnection(url,"sa","990820");
    	 if(connection!=null)
    	 System.out.println("数据库连接已经被打开啦");
    	 statement=connection.createStatement();
    	 //插入操作
//    	 String insert="insert into student values('jinxiangui','1750300084',21)";
//    	 if(statement.executeUpdate(insert)>0)
//    		 System.out.println("插入成功");
    	 //查询操作
//    	 String query="select * from student";
//    	 ResultSet rs=statement.executeQuery(query);
//    	 while(rs.next())
//    	 {
//    		 System.out.println(rs.getString(1));
//    		 System.out.println(rs.getString(2));
//    		 System.out.println(rs.getInt(3));
//    	 }
    	
//    	 String update="update student set name='luodan' where sno='1750300084'";
//    	 int i=statement.executeUpdate(update);
//         if(i>0)
//        	 System.out.println("更新成功");
    	 String delete="delete student where sno='1750300084'";
    	 int i=statement.executeUpdate(delete);
    	 if(i>0)
    	 {
    		 System.out.println("删除成功");
    	 }
     }
     finally
     {
    	 connection.close();
    	 System.out.println("数据库连接已经被关闭啦");
     }
		 System.out.println();
		 
 }
}

