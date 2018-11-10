package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet{
	public DateServlet() {
		 System.out.println("DateServlet");
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		/**
		 * 显示当前时间
		 */
		// 设置消息头
		response.setContentType("text/html");
		// 获取输出流
		PrintWriter out = response.getWriter();
		// 获取本机当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		out.print(sdf.format(date));
		out.close();
	}

}
