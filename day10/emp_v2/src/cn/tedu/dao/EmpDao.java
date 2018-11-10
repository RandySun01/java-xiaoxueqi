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
	
	// ����idɾ��
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
	// ����id��ѯ
	public Emp findById(int id) throws SQLException{
		
		Connection conn = DBUtils.getConnection();
		String sql = "select * from emp where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Emp emp = null;
		while(rs.next()){
			int id1 = rs.getInt("id");
			String name = rs.getString("name");
			int salary = rs.getInt("salary");
			String job = rs.getString("job");
			emp = new Emp(id1,name, salary, job);
			
		}
		DBUtils.closle(conn);
		ps.close();
		rs.close();
		return emp;
		
	}
	
	public void update(Emp emp) throws SQLException{
		Connection conn = DBUtils.getConnection();
		String sql = "update emp set name=?, salary=?,job=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getSalary());
		ps.setString(3, emp.getJob());
		ps.setInt(4, emp.getId());
		int row = ps.executeUpdate();
		DBUtils.closle(conn);
		ps.close();
		
	}
	public void save(Emp emp) throws SQLException{
		Connection conn = DBUtils.getConnection();
		String sql = "insert into emp values(null,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,emp.getName());
		ps.setInt(2, emp.getSalary());
		ps.setString(3, emp.getJob());
		ps.executeUpdate();
		DBUtils.closle(conn);
		ps.close();
	}
	
//  �������ֲ�ѯ
	public ArrayList<Emp> findByName(String name) throws SQLException{
		Connection conn = DBUtils.getConnection();
		String sql = "select * from emp where name like ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%"+name+"%");
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Emp> emps = new ArrayList<Emp>();
		while(rs.next()){
			int id = rs.getInt("id");
			String name1 = rs.getString("name");
			int salary = rs.getInt("salary");
			String job = rs.getString("job");
			Emp emp = new Emp(id,name1,salary,job);
			emps.add(emp);
		}
		ps.close();
		DBUtils.closle(conn);
		return emps;
		
	}

}
