package day02;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 
 * @author RandySun
 * 
 * 数据库连接池DBCP
 * database connection pool
 * 为什么使用连接池
 * 如果没有连接池，每一次业务都需要和数据库服务器建立一次连接业务
 * 处理完还需要断开连接，
 * 如果有上万次业务请求则会有上万次的开关连接
 * 频繁的进行开关连接非常的浪费资源
 * 使用数据库连接池可以重复使用连接池
 * 从而提高了网站的响应能力
 * JDBC:每次java需要和数据库交互的时候，连接一次jdbc，使用jdbc就是创建一次连接
 *
 */
public class DBCPDemo {
	public static void main(String[] args) throws Exception {
		// 创建数据源对象
		BasicDataSource dataSource = new BasicDataSource();
		// 设置数据库连接信息
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db_srz");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		//设置连接池参数（初始，最大连接数量）
		   // 初始连接数量
		dataSource.setInitialSize(3);
		   // 最大连接数据
		dataSource.setMaxActive(5);
		// 获取连接池中的连接
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		
	}
}
