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
	 * ����˽�л�: Ϊ�˱�������ԭʼֵ
	 * ��Ա������ֵ������set����  ������
	 * 
	 * ��Ϊ�������� Ϊ��
	 */
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	 
	private static BasicDataSource dataSourc=null;
	static{
		// �������Զ���
		Properties prop = new Properties();
		// �õ��ļ�������
		InputStream ips = DBUtils1.class.getClassLoader().getResourceAsStream("jdbc1.properties");
		// ���ļ����ص����Զ�����
		try {
			prop.load(ips);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ��ȡ����
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		// ��������Դ����
		dataSourc = new BasicDataSource();
		// �������ݿ�������Ϣ
		dataSourc.setDriverClassName(driver);
		dataSourc.setUrl(url);
		dataSourc.setUsername(user);
		dataSourc.setPassword(password);
		//�������ӳز���
		dataSourc.setInitialSize(3);
		// �����������
		dataSourc.setMaxActive(5);
		// ��ȡ���ӳ��е�����
		 
	}
	// ��ȡ����
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
	  
	 // �ͷ���Դ
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
