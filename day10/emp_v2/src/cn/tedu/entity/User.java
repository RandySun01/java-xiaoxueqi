package cn.tedu.entity;
/**
 * Userʵ����
 * @author RandySun
 *	����������ʼ��ʱ�����Ա������ֵ
 *	set������������������Ҫ���������Ը�ֵ
 *
 *
 */
public class User {
	private  int id;
	private  String username;
	private  int password;
	private  String name;
	private  String sex;
	
	// ���췽��
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
