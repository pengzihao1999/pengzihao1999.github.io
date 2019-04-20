package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test1 {
	// 驱动类名
	public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// 连接数据库地址配置信息
	public static String url = "jdbc:sqlserver://localhost:1433;DataBaseName=student";

	/*
	 * public static final String driver = "com.mysql.jdbc.Driver"; public
	 * static final String url = "jdbc:mysql://127.0.0.1/Demo";
	 */
	/*
	 * public static final String driver = "oracle.jdbc.driver.OracleDriver";
	 * public static final url = "jdbc:oracle:thin:@127.0.0.1:1521:Demo";
	 */
	public static void main(String[] args) throws Exception {
		Connection con = null;
		Statement sta=null;
		PreparedStatement psta;
		try {
			// 第一步：加载驱动类
			Class.forName(driver);
			// 第二步：连接数据库并打开连接通道
			con = DriverManager.getConnection(url, "sa", "pengzihao929");
			System.out.println("con:="+con);
			System.out.println("打开数据库连接");
			// 第三步：通过连接对象创建Statement操作SQL语句
			sta = con.createStatement();	
//		
		//	 第四步：执行SQL语句
		
			ResultSet rs = sta.executeQuery("select * from Table_1");
			//遍历结果集，逐行读取
			while(rs.next()){
				System.out.println("编号："+rs.getString(1));
		
			
			}
			rs.close();
		}
			
//			String sql = "select * from book where bookID=?";
//			psta = con.prepareStatement(sql);
//			psta.setInt(1, 1);
//			ResultSet rs = psta.executeQuery();
//			
//			while(rs.next()){
//				System.out.println("编号："+rs.getInt(1));
//				System.out.println("书名："+rs.getString(2));
//				System.out.println("作者："+rs.getString(3));
//				System.out.println("价格："+rs.getFloat(4));
//				System.out.println("=======================");
//			}
//			rs.close();
////			int i = sta.executeUpdate("insert into book values('java','tom',50)");
////			if (i > 0) {
////				System.out.println("插入成功");
////			}
////			String author = "mike";
////			float price = 90;
////
////			String updateSql = "update book set author='" + author + "',price="
////					+ price + " where bookID=1";
////			i = sta.executeUpdate(updateSql);
////			if (i > 0) {
////				System.out.println("更新成功");
////			}
////			
////			String delSql = "delete book where bookID=2";
////			i = sta.executeUpdate(delSql);
////			if (i > 0) {
////				System.out.println("删除成功");
////			}
//			sta.close();
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		finally {
			// 最后关闭数据库连接通道
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("关闭数据库连接");
		}
	}

}