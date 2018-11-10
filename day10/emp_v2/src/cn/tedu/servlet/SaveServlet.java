package cn.tedu.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.tedu.dao.EmpDao;
import cn.tedu.entity.Emp;
import cn.tedu.utils.DBUtils;

public class SaveServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int salary = Integer.parseInt(request.getParameter("salary"));
		String job = request.getParameter("job");
		EmpDao dao = new EmpDao();
		Emp emps = new Emp(name, salary, job);
		try {
			dao.save(emps);
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
