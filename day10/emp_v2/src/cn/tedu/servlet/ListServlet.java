package cn.tedu.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.EmpDao;
import cn.tedu.entity.Emp;

public class ListServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		// 得到一个EmpDao对象
		EmpDao dao = new EmpDao();
		// 调用dao的findAll()方法
		try {
			ArrayList<Emp> emps = dao.findAll();
			//绑定emps集合到request属性上
			request.setAttribute("allEmp", emps);
			// 获得转发器
			RequestDispatcher rd = request.getRequestDispatcher("emplist.jsp");
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
