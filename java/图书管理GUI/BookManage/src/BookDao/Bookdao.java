package BookDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BookDomain.Book;

public class Bookdao {

	// 驱动类名
	public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// 连接数据库地址配置信息
	public static String url = "jdbc:sqlserver://localhost:1433;DataBaseName=javabook";
	
	public Connection connection=null;
	public PreparedStatement statement=null;
	public synchronized void  add(Book b) {
		//新增图书 
		String BookID = b.getBookID().trim();
		String BookName = b.getBookName().trim();
		String BookPublish = b.getBookPublish().trim();
		String BookAuthor = b.getBookAuthor().trim();
		String BookNumber =b.getBookNumber().trim();
		 try
		    {
		   	 Class.forName(driver);
		   	 connection=DriverManager.getConnection(url,"sa","990820");
		   	 if(connection!=null)
		   	 System.out.println("数据库连接已经被打开");
			}
		    catch (Exception e) {
			  e.printStackTrace();
			}
	
		 try {
			String sql = "insert into BookTable values (?,?,?,?,?) ";
			PreparedStatement prs = connection.prepareStatement(sql);
			prs.setString(1, BookID);
			prs.setString(2, BookName);
			prs.setString(3, BookPublish);
			prs.setString(4, BookAuthor);
			prs.setString(5, BookNumber);
			int a = prs.executeUpdate();
			if(a>0){
				System.out.println("插入成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public synchronized void update(Book b) {
		//更新图书
		String BookID = b.getBookID().trim();
		String BookName = b.getBookName().trim();
		String BookPublish = b.getBookPublish().trim();
		String BookAuthor = b.getBookAuthor().trim();
		String BookNumber =b.getBookNumber().trim();
		 try
		    {
		   	 Class.forName(driver);
		   	 connection=DriverManager.getConnection(url,"sa","990820");
		   	 if(connection!=null)
		   	 System.out.println("数据库连接已经被打开");
			}
		    catch (Exception e) {
			  e.printStackTrace();
			}
		 try {

				String sql = "update BookTable set BookName=?,BookPublish=?,BookAuthor=?,BookNumber=? where BookID=?";
				PreparedStatement prs = connection.prepareStatement(sql);
				prs.setString(1, BookName);
				prs.setString(2, BookPublish);
				prs.setString(3, BookAuthor);
				prs.setString(4, BookNumber);
				prs.setString(5, BookID);
				int a = prs.executeUpdate();
				if(a>0){
					System.out.println("修改成功");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public synchronized void delete(Book b) {
		//删除图书
		String BookID = b.getBookID().trim();
		 try
		    {
		   	 Class.forName(driver);
		   	 connection=DriverManager.getConnection(url,"sa","990820");
		   	 if(connection!=null)
		   	 System.out.println("数据库连接已经被打开");
			}
		    catch (Exception e) {
			  e.printStackTrace();
			}
		 try {

				String sql = "delete from BookTable  where BookID=?";
				PreparedStatement prs = connection.prepareStatement(sql);
				prs.setString(1, b.getBookID());
				prs.execute();
				System.out.println("删除成功");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public synchronized void lend(Book b) {
		//借书
		String BookID = b.getBookID().trim();
		String BookNumber =b.getBookNumber().trim();
		String BookIDR  =  String.valueOf(Integer.valueOf(BookNumber)-1);
		if(Integer.valueOf(BookIDR)<=0){
			System.out.println("借书失败");
		}
		try
		    {
		   	 Class.forName(driver);
		   	 connection=DriverManager.getConnection(url,"sa","990820");
		   	 if(connection!=null)
		   	 System.out.println("数据库连接已经被打开");
			}
		    catch (Exception e) {
			  e.printStackTrace();
			}
		 try {
			 	
				String sql = "update BookTable set BookNumber=? where BookID=?";
				PreparedStatement prs = connection.prepareStatement(sql);
				prs.setString(1, BookIDR);
				prs.setString(2, BookID);
				int a = prs.executeUpdate();
				if(a>0){
					System.out.println("借书成功");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public synchronized void returnBook(Book b) {
		//还书
		String BookID = b.getBookID().trim();
		String BookNumber =b.getBookNumber().trim();
		String BookIDR  =  String.valueOf(Integer.valueOf(BookNumber)+1);
		 try
		    {
		   	 Class.forName(driver);
		   	 connection=DriverManager.getConnection(url,"sa","990820");
		   	 if(connection!=null)
		   	 System.out.println("数据库连接已经被打开");
			}
		    catch (Exception e) {
			  e.printStackTrace();
			}
		 try {
			 	
				String sql = "update BookTable set BookNumber=? where BookID=?";
				PreparedStatement prs = connection.prepareStatement(sql);
				prs.setString(1, BookIDR);
				prs.setString(2, BookID);
				int a = prs.executeUpdate();
				if(a>0){
					System.out.println("还书成功");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public List queryAll() {
		List<Book> booklist = new ArrayList<Book>();
		 try
		    {
		   	 Class.forName(driver);
		   	 connection=DriverManager.getConnection(url,"sa","990820");
		   	 if(connection!=null)
		   	 System.out.println("数据库连接已经被打开");
			}
		    catch (Exception e) {
			  e.printStackTrace();
			}
		 try {
				
				String sql = "select * from BookTable";
				PreparedStatement prs = connection.prepareStatement(sql);
				ResultSet rs = prs.executeQuery();
				while(rs.next()){
					Book b = new Book();
					b.setBookID(rs.getString(1).trim());
					b.setBookName(rs.getString(2).trim());
					b.setBookPublish(rs.getString(3).trim());
					b.setBookAuthor(rs.getString(4).trim());
					b.setBookNumber(rs.getString(5).trim());
					booklist.add(b);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
		System.out.println(booklist.toString());
		return booklist;
	}

	public void lend(String str1, String str2) throws BookException {
		String BookID = str2.trim();
		String UserID = str1.trim();
		System.out.println(BookID+" "+UserID);
	
		try
		    {
		   	 Class.forName(driver);
		   	 connection=DriverManager.getConnection(url,"sa","990820");
		   	 if(connection!=null)
		   	 System.out.println("数据库连接已经被打开");
			}
		    catch (Exception e) {
			  e.printStackTrace();
			}
		 try {
			 	String sql2 = "select BookNumber from BookTable where BookID = ?";
			 	PreparedStatement prs2= connection.prepareStatement(sql2);
			 	prs2.setString(1, BookID);
			 	ResultSet rss = prs2.executeQuery();
			 
			 	rss.next();
			 		 String BookNumber = rss.getString(1).trim();
			 		 
			 		 
			 	if(Integer.valueOf(BookNumber)-1<0){
			 		throw new BookException("借书失败");
			 	}
			 	String BookIDR  =  String.valueOf(Integer.valueOf(BookNumber)-1);
			 	
				String sql = "update BookTable set BookNumber=? where BookID=?";
				PreparedStatement prs = connection.prepareStatement(sql);
				prs.setString(1, BookIDR);
				prs.setString(2, BookID);
				int a = prs.executeUpdate();
				if(a>0){
					System.out.println("借书成功");
				}
//				"insert into BookTable values (?,?,?,?,?) ";
				String sql3 = "insert into lendTable values (?,?)";
				PreparedStatement prs3 = connection.prepareStatement(sql3);
				prs3.setString(1, UserID.trim());
			   	prs3.setString(2, BookID.trim());
				int ff= prs3.executeUpdate();
				System.out.println(ff);
				System.out.println("借书成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public void returnBook(String str1, String str2) {
		String BookID = str2;
		String UserID = str1;
		
	
		try
		    {
		   	 Class.forName(driver);
		   	 connection=DriverManager.getConnection(url,"sa","990820");
		   	 if(connection!=null)
		   	 System.out.println("数据库连接已经被打开");
			}
		    catch (Exception e) {
			  e.printStackTrace();
			}
		 try {
			 	String sql2 = "select BookNumber from BookTable where BookID = ?";
			 	PreparedStatement prs2= connection.prepareStatement(sql2);
			 	prs2.setString(1, BookID);
			 	ResultSet rss = prs2.executeQuery();
			 	rss.next();
			 	String BookNumber = rss.getString(1).trim();
			 	String BookIDR  =  String.valueOf(Integer.valueOf(BookNumber)+1);
			 
				String sql = "update BookTable set BookNumber=? where BookID=?";
				PreparedStatement prs = connection.prepareStatement(sql);
				prs.setString(1, BookIDR);
				prs.setString(2, BookID);
				int a = prs.executeUpdate();
				if(a>0){
					System.out.println("还书成功");
				}
				String sql3 = "delete from lendTable where BookID = ? and UserID = ?";
				PreparedStatement prs3 = connection.prepareStatement(sql3);
				prs3.setString(1, BookID);
			   	prs3.setString(2,UserID);
			   	int ff= prs3.executeUpdate();
				System.out.println(ff);
				System.out.println("还书成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
	}

}
