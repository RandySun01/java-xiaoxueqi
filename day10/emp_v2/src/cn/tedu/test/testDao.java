package cn.tedu.test;
/**
 * @author RandySun
 */
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import cn.tedu.dao.EmpDao;
import cn.tedu.dao.UserDao;
import cn.tedu.entity.Emp;
import cn.tedu.entity.User;

public class testDao {
	// ²âÊÔ×¢²ádao²ã´úÂë
	@Test
	public void test01() throws SQLException{
		UserDao dao = new UserDao();
		User user = new User("admin1",1234,"sunrongzhi","man");
		dao.save(user);
	}
	
	@Test
	public void test02() throws SQLException{
		EmpDao dao = new EmpDao();
		ArrayList<Emp> emps = dao.findAll();
		for (int i = 0; i < emps.size(); i++) {
			Emp emp = emps.get(i);
			System.out.println(emp.getName());
		}
	}
	
	@Test
	public  void test03() throws SQLException{
		EmpDao dao = new EmpDao();
		Emp emp = dao.findById(2);
		System.out.println(emp.getName());
		System.out.println(emp.getSalary());
		System.out.println(emp.getJob());
	}
	@Test
	public void test05() throws SQLException{
		EmpDao dao = new EmpDao();
		Emp emp = new Emp(2,"rousi", 100, "worker");
		dao.update(emp);
		System.out.println("²âÊÔ");
	}

}
