package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * 
 * @author RandySun
 *
 */
public class LoginServlet extends HttpServlet{
	 
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//admin 123456
		if("admin".equals(name) && "123456".equals(password)){
			// ������ 
			request.setAttribute("name", name);
			// ���ת����
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			// ת��
			rd.forward(request, response);
		}
	}

}
