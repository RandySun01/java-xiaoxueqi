package day02;

/**
 * 
 * 
 * 文件连接
 * 
 * @author RandySun
 * 
 *
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesDemo {
	public static void main(String []args){
		// 创建对象
		Properties prop = new Properties();
		// 获取文件的输入流
		InputStream ips = PropertiesDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
		// 把文件加载到属性对象中
		
			try {
				prop.load(ips);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		// 获取数据
		/**
		 *  jdbc.properties里面value值
		 *  读取出来的全部是String类型
		 *  
		 */
		String id = prop.getProperty("id");
		String name = prop.getProperty("name");
		String age = prop.getProperty("age");
		String job = prop.getProperty("job");
		System.out.println("id: "+id);
		System.out.println("name: "+name);
		System.out.println("age: "+age);
		System.out.println("job: "+job);
		
		
	}

}
