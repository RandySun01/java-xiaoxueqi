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
		// �õ�һ��EmpDao����
		EmpDao dao = new EmpDao();
		// ����dao��findAll()����
		try {
			ArrayList<Emp> emps = dao.findAll();
			//��emps���ϵ�request������
			request.setAttribute("allEmp", emps);
			// ���ת����
			RequestDispatcher rd = request.getRequestDispatcher("emplist.jsp");
			// ת��
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
