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
		// // �������Զ���
		Properties prop = new Properties();
		// �õ��ļ�������
		InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//���ļ��������Զ�����
		try {
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�õ�����(��ȡ����)
		
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		
	}
	
	// ��ȡ����
	public  static Connection  getConnection(){
		try {
			// ע��
			Class.forName(driver);
			// ��ȡ����
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
	// �ر�����
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
