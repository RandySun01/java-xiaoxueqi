package cn.tedu.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.EmpDao;
import cn.tedu.entity.Emp;

public class LoadServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		Integer id1 = Integer.parseInt(id);
		EmpDao dao = new EmpDao();
		try {
			Emp emp = dao.findById(id1);
			// 绑定数据
			request.setAttribute("emp", emp);
			// 获得转发器
			RequestDispatcher rd = request.getRequestDispatcher("updateEmp.jsp");
			// 转发
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
