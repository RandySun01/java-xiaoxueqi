package day01;
/**
 * @author RandySun
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class Demo01 {
	
	@Test // ע�⣨����
	public void test01(){
		System.out.println("����test01");
	}
	@Test
	public void test02(){
		System.out.println("����test02");
	}
	// ���Բ������ݿ�
	// ����
	@Test
	public void insert() throws Exception{
		// 1 ��������
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2  ��ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_srz", "root", "123456");
		// 3 ��ȡִ��sql���ִ�ж���
		Statement state = conn.createStatement();
		// 4 ��ȡ��ִ��sql���
		String sql = "insert into t2 values(4,'mart'),(5,'mary'),(6,'awm')";
		int row = state.executeUpdate(sql);
		System.out.println("row: "+row);
		System.out.println("����ɹ�");
		// 5 �ر���Դ
		state.close();
		conn.close();
	}
	
	// ɾ��
	@Test
	public void delete() throws Exception{
		// 1 ע��
		Class.forName("com.mysql.jdbc.Driver");
	    // 2 ��ȡ����
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_srz", "root", "123456");
		// 3 ��ȡ��������
		Statement state = conn.createStatement();
		// 4 ������ִ��sql
		String sql = "delete from t2 where id = 1";
		int row = state.executeUpdate(sql);

		System.out.println(row);
		System.out.println("ɾ���ɹ�");
		// 5 �ر���Դ
		state.close();
		conn.close();
				
	}
	
	// ����
	@Test
	public void update() throws Exception{
		// ע��
		Class.forName("com.mysql.jdbc.Driver");
		// ��ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_srz", "root", "123456");
		// ��ȡsqlִ�ж���
		Statement state = conn.createStatement();
		// ��ȡ��ִ��sql���
		String sql = "update t2 set name='rose' where id = 1";
		int row = state.executeUpdate(sql);
		
		System.out.println(row);
		System.out.println("���³ɹ�");
	}
	
	//��ѯ
	@Test
	public void findAll() throws Exception{
		// 1 ע��
		Class.forName("com.mysql.jdbc.Driver");
		// 2 ��ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_srz","root","123456");
		// 3 ��ȡsql����
		Statement state = conn.createStatement();
		// 4 ������ִ��sql
		String sql = "select * from emp";
		
		ResultSet row = state.executeQuery(sql);
		while(row.next()){
			 int id = row.getInt("id");
			 //String name = row.getString("name");
			//int id = row.getInt(1);
			String name = row.getString(2);
			System.out.println("id: "+id+"\tname: "+name);
		}
		
		System.out.println("��ѯ�ɹ�");
		state.close();
		conn.close();
	}
	
	@Test
	public void find() throws Exception{
		// ע��
		Class.forName("com.mysql.jdbc.Driver");
		// ��ȡ����duixiang
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_srz", "root", "123456");
		// ��ȡsql����
		 Statement state = conn.createStatement();
		 //������ִ��sql
		 String sql = "select name,job from emp";
		 ResultSet row = state.executeQuery(sql);
			while(row.next()){
				String name = row.getString(1);
				String job = row.getString(2);
				System.out.println("name: "+name+"    job: "+job);
			}
	}
	

}
