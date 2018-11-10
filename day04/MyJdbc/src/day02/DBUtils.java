package day02;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.resource.cci.ResultSet;

/**
 * 
 * @author Administrator
 *
 */
public class DBUtils {
	
	private static String driver;
	private static String url;
	private static String root;
	private static String password;
	
	/**
	 * 代码块： 加载资源
	 * 静态代码块：加载一些固定资源 
	 */
	
	static{
		// 创建属性对象
		Properties prop = new Properties();
		// 得到文件输入流
		InputStream isp = DBUtils.class.getClassLoader().getResourceAsStream("jdbc1.properties");
		
		//把文件加载属性对象中
		try {
			prop.load(isp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//得到属性(获取数据)
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		root = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	
	// 获取连接
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(url, root, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	// 关闭方法
	public static void closle(Connection conn, Statement state, ResultSet rs){
		if(conn != null){
			try {
				conn.close();
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
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		//System.out.println(url);
	}

}
