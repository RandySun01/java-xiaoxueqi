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
	// 注册
	public void save(User user) throws SQLException{
		// 获取连接
		Connection conn = db.getConnection();
		// 创建 语句      
		String sql = "insert into user values(null,?,?,?,?)";
		 // 预编译
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setInt(2, user.getPassword());
		ps.setString(3, user.getName());
		ps.setString(4, user.getSex());
		// 执行  row执行的条数  
		int row = ps.executeUpdate();
		db.closle(conn);
		ps.close();
	}
	
	
	
	public ArrayList<User> findAll() throws ClassNotFoundException, SQLException{
		//1 获取连接对象
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
		// 获取对象
		Connection con = db.getConnection();
		// 创建sql语句
		String sql = "select username,password　from user";
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
