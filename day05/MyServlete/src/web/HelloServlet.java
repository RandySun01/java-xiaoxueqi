package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 继承HttpServlet
 * @author RandyRun
 *
 */
public class HelloServlet extends HttpServlet{
	
	public HelloServlet(){
		System.out.println("HelloServlet");
		
	}
	// 重写
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 设置消息头
		response.setContentType("text/html");
		// 获取输出流
		PrintWriter out = response.getWriter();
		// 将处理结果返回到前端
		out.print("<h1>Hello  Servlet</h1>");
		// 关闭流
		out.close();
		
		
	}

}
