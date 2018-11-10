package web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response){
		
		// 2 porstÇëÇó
		response.setCharacterEncoding("UTF-8"); // ½â°ü±àÂë
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		System.out.println("sex:"+sex);
		
		
		
	}

}
