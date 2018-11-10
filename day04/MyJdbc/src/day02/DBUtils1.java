package day02;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 
 * @author Administrator
 *
 */
public class DBUtils1 {
	
	/**
	 * 属性私有化: 为了保护属性原始值
	 * 成员变量赋值方法：set方法  构造器
	 * 
	 * 行为公开化： 为了
	 */
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	 
	private static BasicDataSource dataSourc=null;
	static{
		// 创建属性对象
		Properties prop = new Properties();
		// 得到文件输入流
		InputStream ips = DBUtils1.class.getClassLoader().getResourceAsStream("jdbc1.properties");
		// 把文件加载到属性对象中
		try {
			prop.load(ips);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 读取数据
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		// 创建数据源对象
		dataSourc = new BasicDataSource();
		// 设置数据库连接信息
		dataSourc.setDriverClassName(driver);
		dataSourc.setUrl(url);
		dataSourc.setUsername(user);
		dataSourc.setPassword(password);
		//设置连接池参数
		dataSourc.setInitialSize(3);
		// 最大连接数据
		dataSourc.setMaxActive(5);
		// 获取连接池中的连接
		 
	}
	// 获取连接
	public static Connection getCon(){
		 
		try {
			Connection conn = dataSourc.getConnection();
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	  
	 // 释放资源
	public static void close(Connection con, Statement state, ResultSet rs){
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
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
