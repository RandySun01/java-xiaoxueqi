package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.tedu.entity.Emp;
import cn.tedu.utils.DBUtils;

public class EmpDao {
	 
	// ��ѯ
	public ArrayList<Emp> findAll() throws SQLException{
		// ��ȡ����
		Connection conn = DBUtils.getConnection();
		// ����sql
		String sql = "select * from emp";
		// ��������
		PreparedStatement ps = conn.prepareStatement(sql);
		// ִ��sql
		ResultSet rs = ps.executeQuery();
		// ��ѯ���
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
		// ����PreparedStatement,���󣬲���Ԥ����
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		// ִ��sql
		int row = ps.executeUpdate(); 
		DBUtils.closle(conn);
		ps.close();
	}

}
