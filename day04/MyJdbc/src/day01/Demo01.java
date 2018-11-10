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
	
	@Test // 注解（框架里）
	public void test01(){
		System.out.println("测试test01");
	}
	@Test
	public void test02(){
		System.out.println("测试test02");
	}
	// 测试插入数据库
	// 插入
	@Test
	public void insert() throws Exception{
		// 1 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2  获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_srz", "root", "123456");
		// 3 获取执行sql语句执行对象
		Statement state = conn.createStatement();
		// 4 获取并执行sql语句
		String sql = "insert into t2 values(4,'mart'),(5,'mary'),(6,'awm')";
		int row = state.executeUpdate(sql);
		System.out.println("row: "+row);
		System.out.println("插入成功");
		// 5 关闭资源
		state.close();
		conn.close();
	}
	
	// 删除
	@Test
	public void delete() throws Exception{
		// 1 注册
		Class.forName("com.mysql.jdbc.Driver");
	    // 2 获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_srz", "root", "123456");
		// 3 获取创建对象
		Statement state = conn.createStatement();
		// 4 创建并执行sql
		String sql = "delete from t2 where id = 1";
		int row = state.executeUpdate(sql);

		System.out.println(row);
		System.out.println("删除成功");
		// 5 关闭资源
		state.close();
		conn.close();
				
	}
	
	// 更新
	@Test
	public void update() throws Exception{
		// 注册
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_srz", "root", "123456");
		// 获取sql执行对象
		Statement state = conn.createStatement();
		// 获取并执行sql语句
		String sql = "update t2 set name='rose' where id = 1";
		int row = state.executeUpdate(sql);
		
		System.out.println(row);
		System.out.println("更新成功");
	}
	
	//查询
	@Test
	public void findAll() throws Exception{
		// 1 注册
		Class.forName("com.mysql.jdbc.Driver");
		// 2 获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_srz","root","123456");
		// 3 获取sql对象
		Statement state = conn.createStatement();
		// 4 创建并执行sql
		String sql = "select * from emp";
		
		ResultSet row = state.executeQuery(sql);
		while(row.next()){
			 int id = row.getInt("id");
			 //String name = row.getString("name");
			//int id = row.getInt(1);
			String name = row.getString(2);
			System.out.println("id: "+id+"\tname: "+name);
		}
		
		System.out.println("查询成功");
		state.close();
		conn.close();
	}
	
	@Test
	public void find() throws Exception{
		// 注册
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接duixiang
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_srz", "root", "123456");
		// 获取sql对象
		 Statement state = conn.createStatement();
		 //创建并执行sql
		 String sql = "select name,job from emp";
		 ResultSet row = state.executeQuery(sql);
			while(row.next()){
				String name = row.getString(1);
				String job = row.getString(2);
				System.out.println("name: "+name+"    job: "+job);
			}
	}
	

}
