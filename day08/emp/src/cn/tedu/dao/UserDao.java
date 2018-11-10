package cn.tedu.dao;
/**
 * @author RandySun
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.tedu.entity.User;
import cn.tedu.utils.DBUtils;



public class UserDao {
	DBUtils db = new DBUtils();
	// ע��
	public void save(User user) throws SQLException{
		// ��ȡ����
		Connection conn = db.getConnection();
		// ���� ���      
		String sql = "insert into user values(null,?,?,?,?)";
		 // Ԥ����
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setInt(2, user.getPassword());
		ps.setString(3, user.getName());
		ps.setString(4, user.getSex());
		// ִ��  rowִ�е�����  
		int row = ps.executeUpdate();
		db.closle(conn);
		ps.close();
	}
	
	
	
	public ArrayList<User> findAll() throws ClassNotFoundException, SQLException{
		//1 ��ȡ���Ӷ���
		Connection conn =db.getConnection();
		String sql = "select username,password from user";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
		ArrayList<User> users=new ArrayList<User>();
		while(rs.next()){
			 String username=rs.getString("username");
			 int password=rs.getInt("password");
			 
			 User user=new User(username,password);
		     users.add(user);
			
		}
		db.closle(conn);;
		rs.close();
		ps.close();
		return users;
		
	}
	
	/*
	public ArrayList<User> fainAll() throws SQLException{
		// ��ȡ����
		Connection con = db.getConnection();
		// ����sql���
		String sql = "select username,password��from user";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<User> users = new ArrayList<User>();
		while(rs.next()){
			String username = rs.getString("username");
			int password = rs.getInt("password");
			User user = new User(username, password);
			users.add(user);
		}
		db.closle(con);
		rs.close();
		ps.close();
		return users;		
	}
	*/

}
