package day02;
/**
 * public: ���е���
 * Ĭ�ϵģ�ͬ���࣬���࣬����
 * protected������
 * private������
 * 
 * 
 * 
 * @author RandySun
 *
 */
public class Demo01 {
	private int id;
	private String name;
	private int sal;
	private String job;
	// ������
	public Demo01(){ // �޲ι�����
		id = 1;
		name="java";
		sal=100;
	}
	public Demo01(int id,String name, int sal, String job){
		/**
		 * this:ָ����ǰ����
		 */
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.job = job;
	}
	// set����
	public void setId(int id){
		// �ͽ�ԭ�� id = id,id ���ǲ���; 
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
}
