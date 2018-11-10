package day02;

 

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestDBUtils {
	
	@Test
	public void finAll() throws SQLException{
		Connection con = DBUtils.getConn();
		Statement state = con.createStatement();
		
		String sql="select * from t1";
		ResultSet rs = state.executeQuery(sql);
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println("id: "+id+" name:"+name);
		}
		//DBUtils.getConn(con,state,rs);
	}
	
	@Test
	public void modify() throws Exception{
		Connection con = DBUtils.getConn();
		Statement state = con.createStatement();
		
		String sql="update t1 set name='tom' where name='rose'";
		int row = state.executeUpdate(sql);
		System.out.println(row);
		System.out.println("更新成功");
		
		 
	}
	@Test 
	public void modify1() throws Exception{
		// 把rose改成tom
		// 获取连接
		Connection con = DBUtils1.getCon();
		// 创建并执行sql
		Statement state = con.createStatement();
		String sql = "update t1 set name='tom' where name ='rose'";
		int row = state.executeUpdate(sql);
		System.out.println(row);
		System.out.println("更改成功");
	}

}
