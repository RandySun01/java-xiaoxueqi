package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BMIServlet extends HttpServlet{
	
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// ������Ϣͷ
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		// ��ȡBMIֵ
		double bim = 62 /(1.78 * 1.78);
		if(bim < 19){
			out.print("����");
		}else if(bim > 25){
			out.print("����");
		}else{
			out.print("����");
		}
		out.close();
		
	}

}
