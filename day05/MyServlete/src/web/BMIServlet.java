package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BMIServlet extends HttpServlet{
	
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 设置消息头
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		// 获取输出流
		PrintWriter out = response.getWriter();
		// 获取BMI值
		double bim = 62 /(1.78 * 1.78);
		if(bim < 19){
			out.print("过轻");
		}else if(bim > 25){
			out.print("过重");
		}else{
			out.print("正常");
		}
		out.close();
		
	}

}
