package cn.tedu.entity;
/**
 * 员工信息表
 * @author RandySun
 * emp
 */
public class Emp {
	private Integer id;
	private String name;
	private Integer salary;
	private String job;
	
	
	public Emp(Integer id, String name, Integer salary, String job){
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.job = job;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	

}
