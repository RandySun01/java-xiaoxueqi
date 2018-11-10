package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

/**
 * ִ��sql��䣺 Statement PreparedStatement
 * PreparedStatement�̳���Statement
 * PreparedStatement����Ԥ����Ĺ���
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
		// ��ȡִ��sql���Ķ���
		// ��sql������Ԥ����
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("name"));
		}
		
	}
	
}
