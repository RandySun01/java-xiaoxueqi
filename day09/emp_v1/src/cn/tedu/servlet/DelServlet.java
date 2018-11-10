package cn.tedu.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.EmpDao;

public class DelServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// service方法先获取参数
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		Integer id1 = Integer.parseInt(id);
		EmpDao dao = new EmpDao();
		try {
			dao.delete(id1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 重定向		
		response.sendRedirect("list");
		// System.out.println(id);
		
	}

}
