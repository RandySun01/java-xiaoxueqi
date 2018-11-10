package cn.tedu.test;
/**
 * @author RandySun
 */
import java.sql.SQLException;

import org.junit.Test;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

public class testDao {
	// ²âÊÔ×¢²ádao²ã´úÂë
	@Test
	public void test01() throws SQLException{
		UserDao dao = new UserDao();
		User user = new User("admin1",1234,"sunrongzhi","man");
		dao.save(user);
		
		
		
	}

}
