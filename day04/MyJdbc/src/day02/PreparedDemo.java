package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

/**
 * 执行sql语句： Statement PreparedStatement
 * PreparedStatement继承于Statement
 * PreparedStatement具有预编译的功能
 * Statement state con.createStatement();
 * PreparedStatement ps = con.PreparedStatement();
 * @author Administrator
 *
 */
public class PreparedDemo {
	
	@Test
	public void findAll() throws Exception{
		Connection conn = DBUtils1.getCon();
		
		String sql = "select * from t1";
		// 获取执行sql语句的对象
		// 对sql语句进行预编译
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("name"));
		}
		
	}
	
}
