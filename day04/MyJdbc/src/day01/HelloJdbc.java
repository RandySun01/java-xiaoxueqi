package day01;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
 

/**
 * �����������ݿ�
 * @author RandySun
 *
 */
public class HelloJdbc {
	
	public static void main(String[] args) throws Exception {
		// 1 ע������
		Class.forName("com.mysql.jdbc.Driver");
		// 2��ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_srz", "root", "123456");
		// 3��ȡִ��sql����
		Statement state =  conn.createStatement();
		// 4������ִ��sql
		//String sql = "drop table t2";
		String sql = "create table t2(id int,name varchar(10))";
		state.execute(sql); // ִ��sql
		System.out.println("ִ�гɹ�");
		
		// 5�ر���Դ
		 conn.close();
		 state.close();
		
		
		
	}

}
