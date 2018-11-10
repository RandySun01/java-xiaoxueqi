package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.tedu.entity.Emp;
import cn.tedu.utils.DBUtils;

public class EmpDao {
	 
	// 查询
	public ArrayList<Emp> findAll() throws SQLException{
		// 获取连接
		Connection conn = DBUtils.getConnection();
		// 创建sql
		String sql = "select * from emp";
		// 创建对象
		PreparedStatement ps = conn.prepareStatement(sql);
		// 执行sql
		ResultSet rs = ps.executeQuery();
		// 查询结果
		ArrayList<Emp> emps = new ArrayList<Emp>();
		while(rs.next()){
			Integer id = rs.getInt("id");
			String name = rs.getString("name");
			Integer salary = rs.getInt("salary");
			String job = rs.getString("job");
			Emp emp =new Emp(id, name, salary, job);
			emps.add(emp);
		}
		DBUtils.closle(conn);
		ps.close();
		rs.close();
		return emps;
	}
	
	public void delete(int id) throws SQLException{
		Connection conn = DBUtils.getConnection();
		String sql = "delete from emp where id=?";
		// 创建PreparedStatement,对象，并且预编译
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		// 执行sql
		int row = ps.executeUpdate(); 
		DBUtils.closle(conn);
		ps.close();
	}

}
