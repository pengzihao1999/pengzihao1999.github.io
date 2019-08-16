

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DButils {
    /*
        1.获取连接
        2.获取Datasource
        3.归还资源
     */
    private static DataSource ds = null;
    static {//获取连接池对象
        Properties p = new Properties();

        try {
            Properties pr = new Properties();
            p.load(DButils.class.getClassLoader().getResourceAsStream("druid.properties"));
           ds = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void close(Statement st, Connection con, ResultSet rs){
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void  close(Connection con,Statement statement){
        close(statement,con,null);
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static DataSource getDataSource(){
        return ds;
    }

}
