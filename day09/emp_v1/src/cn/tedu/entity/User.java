package cn.tedu.entity;
/**
 * User实体类
 * @author RandySun
 *	构造器：初始化时候给成员变量赋值
 *	set方法：程序运行中需要给单个属性赋值
 *
 *
 */
public class User {
	private  int id;
	private  String username;
	private  int password;
	private  String name;
	private  String sex;
	
	// 构造方法
	public User(String username,int password, String name, String sex){
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
	}
	public User(String username, int password){
		this.username = username;
		this.password = password;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	

}
