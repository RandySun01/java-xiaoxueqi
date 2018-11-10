package day02;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 
 * @author RandySun
 * 
 * ���ݿ����ӳ�DBCP
 * database connection pool
 * Ϊʲôʹ�����ӳ�
 * ���û�����ӳأ�ÿһ��ҵ����Ҫ�����ݿ����������һ������ҵ��
 * �����껹��Ҫ�Ͽ����ӣ�
 * ����������ҵ���������������εĿ�������
 * Ƶ���Ľ��п������ӷǳ����˷���Դ
 * ʹ�����ݿ����ӳؿ����ظ�ʹ�����ӳ�
 * �Ӷ��������վ����Ӧ����
 * JDBC:ÿ��java��Ҫ�����ݿ⽻����ʱ������һ��jdbc��ʹ��jdbc���Ǵ���һ������
 *
 */
public class DBCPDemo {
	public static void main(String[] args) throws Exception {
		// ��������Դ����
		BasicDataSource dataSource = new BasicDataSource();
		// �������ݿ�������Ϣ
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db_srz");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		//�������ӳز�������ʼ���������������
		   // ��ʼ��������
		dataSource.setInitialSize(3);
		   // �����������
		dataSource.setMaxActive(5);
		// ��ȡ���ӳ��е�����
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		
	}
}
