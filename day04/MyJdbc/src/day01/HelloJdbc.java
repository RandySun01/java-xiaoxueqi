package day01;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
 

/**
 * 测试连接数据库
 * @author RandySun
 *
 */
public class HelloJdbc {
	
	public static void main(String[] args) throws Exception {
		// 1 注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_srz", "root", "123456");
		// 3获取执行sql对象
		Statement state =  conn.createStatement();
		// 4创建并执行sql
		//String sql = "drop table t2";
		String sql = "create table t2(id int,name varchar(10))";
		state.execute(sql); // 执行sql
		System.out.println("执行成功");
		
		// 5关闭资源
		 conn.close();
		 state.close();
		
		
		
	}

}
