package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * �̳�HttpServlet
 * @author RandyRun
 *
 */
public class HelloServlet extends HttpServlet{
	
	public HelloServlet(){
		System.out.println("HelloServlet");
		
	}
	// ��д
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// ������Ϣͷ
		response.setContentType("text/html");
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		// �����������ص�ǰ��
		out.print("<h1>Hello  Servlet</h1>");
		// �ر���
		out.close();
		
		
	}

}
