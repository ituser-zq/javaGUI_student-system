package cn.student.Student;



/**
 * @author ZQ
 * @time
 * @function
 */
public class Student {
	private String Sno;
	private String Sname;
	private String Ssex;
	private String Sdept;
	private String Shome;
	private String Semail;
	private String Stel;
	/**
	 * 
	 */
	
	public Student() {
		super();
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSsex() {
		return Ssex;
	}
	public void setSsex(String ssex) {
		Ssex = ssex;
	}
	public String getSdept() {
		return Sdept;
	}
	public void setSdept(String sdept) {
		Sdept = sdept;
	}
	public String getShome() {
		return Shome;
	}
	public void setShome(String shome) {
		Shome = shome;
	}
	public String getSemail() {
		return Semail;
	}
	public void setSemail(String semail) {
		Semail = semail;
	}
	public String getStel() {
		return Stel;
	}
	public void setStel(String stel) {
		Stel = stel;
	}
	@Override
	public String toString() {
		return "student [Sno=" + Sno + ", Sname=" + Sname + ", Ssex=" + Ssex + ", Sdept=" + Sdept + ", Shome=" + Shome
				+ ", Semail=" + Semail + ", Stel=" + Stel + "]";
	}
	

}

