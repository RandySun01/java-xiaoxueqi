package day01;
/**
 *  连接数据库
 *  @author RandySun
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	
	public Connection getConn()  {
		Connection conn = null;
		
		try {
			// 注册
			Class.forName("com.mysql.jdbc.Drivate");
			// 获取对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_srz useUnicode=true&characterEncoding=utf-8", "root", "123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 return conn;
	}
	
	
	public static void  close(Connection con, Statement state,ResultSet result){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(state != null){
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(result != null){
			try {
				result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
