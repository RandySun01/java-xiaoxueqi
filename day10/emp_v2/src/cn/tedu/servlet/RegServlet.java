package cn.tedu.servlet;
/**
 *  @author RandySun
 */
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

public class RegServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse respon) throws IOException{
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");	
		Integer pwd = Integer.parseInt(password);
		String sex = request.getParameter("sex");
		
		User user = new User(username, pwd, name, sex);
		UserDao dao = new UserDao();
		try {
			dao.save(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ÷ÿ∂®œÚ		
		respon.sendRedirect("login.html");
		
	}

}
