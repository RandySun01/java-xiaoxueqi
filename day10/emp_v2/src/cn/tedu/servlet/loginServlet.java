package cn.tedu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

public class loginServlet extends HttpServlet{
	
	
	
	public void service( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("name");
    	String password=request.getParameter("pwd");
    	UserDao dao=new UserDao();
    	try {
			ArrayList<User> users=dao.findAll();
			for(int i=0;i<users.size();i++){
				User user=users.get(i);
				String username1=user.getUsername();
				String password1=user.getPassword()+"";
				if(username.equals(username1)&& password.equals(password1)){
					request.setAttribute("username", username);
					RequestDispatcher rd=request.getRequestDispatcher("list");
					rd.forward(request, response);
				}
			}
				
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
    	
	}
	
	/*
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("name");
		String password = request.getParameter("pwd");
		UserDao dao = new UserDao();
		try {
			ArrayList<User> users = dao.fainAll();
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);
				 String username1 = user.getUsername();
				 String password1 = user.getPassword()+"";
				if(username.equals(username1) && password.equals(password1)){
					
					// 绑定数据 
					request.setAttribute("username", username);
					//获得转发器
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					// 转发
					rd.forward(request, response);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	*/
}
