package phong.feedback.mgm.model;

public class Student {

	public Integer id;
	public String username;
	public String password;
	public String address;
	public String dob;
	public String email;
	public Student(){};
	public Student(Integer id, String username, String password, String address, String dob, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.dob = dob;
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
