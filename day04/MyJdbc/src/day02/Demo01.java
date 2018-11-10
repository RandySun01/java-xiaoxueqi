package day02;
/**
 * public: 所有的类
 * 默认的：同包类，子类，父类
 * protected：子类
 * private：本类
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
	// 构造器
	public Demo01(){ // 无参构造器
		id = 1;
		name="java";
		sal=100;
	}
	public Demo01(int id,String name, int sal, String job){
		/**
		 * this:指代当前对象
		 */
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.job = job;
	}
	// set方法
	public void setId(int id){
		// 就近原则 id = id,id 都是参数; 
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
}
