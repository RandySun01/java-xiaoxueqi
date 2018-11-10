package day02;

/**
 * 
 * 
 * �ļ�����
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
		// ��������
		Properties prop = new Properties();
		// ��ȡ�ļ���������
		InputStream ips = PropertiesDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
		// ���ļ����ص����Զ�����
		
			try {
				prop.load(ips);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		// ��ȡ����
		/**
		 *  jdbc.properties����valueֵ
		 *  ��ȡ������ȫ����String����
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
