package web;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String telephone = request.getParameter("telephone");
		if(username == "" || password == "" ){
			// �ض���ʧ��
			response.sendRedirect("fail.html");
		}else{
			// �ض��򵽳ɹ�
			response.sendRedirect("success");
		}
		
		
		
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		System.out.println("telephone:"+telephone);
		
	}
}
