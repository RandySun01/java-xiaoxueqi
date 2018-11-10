package cn.tedu.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.EmpDao;
import cn.tedu.entity.Emp;

public class UpdateServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Integer salary = Integer.parseInt(request.getParameter("salary"));
		String job = request.getParameter("job");
		EmpDao dao = new EmpDao();
		Emp emps = new Emp(id, name, salary, job);
		try {
			dao.update(emps);
			response.sendRedirect("list");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
