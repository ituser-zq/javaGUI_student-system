package cn.student.Audio;

public class Audio {
	private String id;
	private String password;
	
	public Audio() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Audio [id=" + id + ", password=" + password + "]";
	}
	
}
