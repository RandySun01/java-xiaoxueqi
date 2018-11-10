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
		 * ��ʾ��ǰʱ��
		 */
		// ������Ϣͷ
		response.setContentType("text/html");
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		// ��ȡ������ǰʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		out.print(sdf.format(date));
		out.close();
	}

}
