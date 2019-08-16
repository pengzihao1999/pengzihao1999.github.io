package test.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import test.book.domain.Book;

public class BookDao {
	   // 驱动类名
		public static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// 连接数据库地址配置信息
		public static final String url = "jdbc:sqlserver://localhost:1433;DataBaseName=bookmanage";
		public static final String sqlquery="select * from book";
	   public Book findBookByBookID(String  ID)
	  {  
		Connection con = null;
		Statement sta=null;
		Book book=new Book();
			try {
				Class.forName(driver);
			// 第二步：连接数据库并打开连接通道
			con = DriverManager.getConnection(url, "sa", "990820");
			System.out.println("con:="+con);
			System.out.println("查找方法打开数据库连接");
			// 第三步：通过连接对象创建Statement操作SQL语句
			sta = con.createStatement();
			//完成准备工作步骤 开始通过ID号在数据库中查找
			ResultSet rs=sta.executeQuery(sqlquery);
			while(rs.next())
			{
			    if(rs.getString(1).trim().equals(ID))
			    {    	
			    	book.setBookID(rs.getString(1));
			    	book.setBookname(rs.getString(2));
			    	book.setAuthor(rs.getString(3));
			    	book.setPulishedlocation(rs.getString(4));
			    	book.setPrice(rs.getInt(5));
			    	break;
			    }
			}
			if(book.getBookID()==null)
			{
				return null;
			}	
			}
	    	catch (Exception e) {
			e.printStackTrace();
		   }
			finally {
				// 最后关闭数据库连接通道
				try {
					if (con != null && !con.isClosed()) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("关闭数据库连接");
			}
			return book;
	  }
	  public Book Add(Book book)
	  {   int i=0;
		  Connection con = null;
			Statement sta=null;
		  try {  
			Class.forName(driver);
		// 第二步：连接数据库并打开连接通道
		con = DriverManager.getConnection(url, "sa", "990820");
		System.out.println("con:="+con);
		System.out.println("新增方法打开数据库连接");
		// 第三步：通过连接对象创建Statement操作SQL语句
		sta = con.createStatement();
		//insert into book values('java','tom',50)
		String insert= " insert into book  values( '"+book.getBookID()+"','"+book.getBookname()+
				"','"+book.getAuthor()+"','"+book.getPulishedlocation()+"','"+book.getPrice()+"')";
		  i=sta.executeUpdate(insert);
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  finally {
				// 最后关闭数据库连接通道
				try {
					if (con != null && !con.isClosed()) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("关闭数据库连接");
			}	  
	     if(i>0) return book;
	     else throw new RuntimeException("插入失败");
	  }
	  public void deletebook(String bookID)
	  {	   int i=0;
		  Connection con = null;
			Statement sta=null;
		    try {
			    Class.forName(driver);
				// 第二步：连接数据库并打开连接通道
				con = DriverManager.getConnection(url, "sa", "990820");
				System.out.println("con:="+con);
				System.out.println("删除方法打开数据库连接");
				// 第三步：通过连接对象创建Statement操作SQL语句
				sta = con.createStatement();
				//完成准备工作步骤 开始通过ID号在数据库中查找
				String delectsql="delete book where bookID='"+bookID+"'";
				 i=sta.executeUpdate(delectsql);		
				}
		    	catch (Exception e) {
				e.printStackTrace();
			   }
				finally {
					// 最后关闭数据库连接通道
					try {						
						if (con != null && !con.isClosed()) {
							con.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					System.out.println("关闭数据库连接");
			        }	   		
	  }
}
