package cn.tedu.utils;
/**
 * @author RandySun
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
	private static  String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static{
		// // 创建属性对象
		Properties prop = new Properties();
		// 得到文件输入流
		InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//把文件加载属性对象中
		try {
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//得到属性(获取数据)
		
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		
	}
	
	// 获取链接
	public  static Connection  getConnection(){
		try {
			// 注册
			Class.forName(driver);
			// 获取连接
			Connection con = DriverManager.getConnection(url,user,password);
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// 关闭连接
	public  static void closle(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
