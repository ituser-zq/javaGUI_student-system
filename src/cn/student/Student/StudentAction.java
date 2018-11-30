package cn.student.Student;

import java.sql.SQLException;
import java.util.List;

import cn.student.DAO.StudentDAO;
import cn.student.View.WindowView;

public class StudentAction {
	public static String[][] queryAll(){
		StudentDAO st = new StudentDAO();
		List<Student> ls = st.queryAll();
		int col = ls.size();

		String[][] str = new String[col][WindowView.result.length];
		Student stu = new Student();

		for (int i = 0; i < col; i++) {
			stu = ls.get(i);

			str[i][0] = stu.getSno();
			str[i][1] = stu.getSname();
			str[i][2] = stu.getSsex();
			str[i][3] = stu.getSdept();
			str[i][4] = stu.getShome();
			str[i][5] = stu.getSemail();
			str[i][6] = stu.getStel();
		}
		return str;
	}
	public static void Add(String sno,String sname,String ssex,String sdept,String shome,String semail,String stel){
		StudentDAO st = new StudentDAO();
		Student s = new Student();
		s.setSno(sno);
		s.setSname(sname);
		s.setSsex(ssex);
		s.setSdept(sdept);
		s.setShome(shome);
		s.setSemail(semail);
		s.setStel(stel);
		st.add(s);
	}
	public static void delete(String sno){
		StudentDAO st = new StudentDAO();
		try {
			st.delete(sno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String[][] getSno(String sno){
		StudentDAO st = new StudentDAO();
			List<Student> ls = st.getSno(sno);
			int col = ls.size();

			String[][] str = new String[col][WindowView.result.length];
			Student stu = new Student();

			for (int i = 0; i < col; i++) {
				stu = ls.get(i);

				str[i][0] = stu.getSno();
				str[i][1] = stu.getSname();
				str[i][2] = stu.getSsex();
				str[i][3] = stu.getSdept();
				str[i][4] = stu.getShome();
				str[i][5] = stu.getSemail();
				str[i][6] = stu.getStel();
			}
		return str;
	}
	public static String[][] getSname(String sname){
		StudentDAO st = new StudentDAO();
			List<Student> ls = st.getName(sname);
			int col = ls.size();

			String[][] str = new String[col][WindowView.result.length];
			Student stu = new Student();

			for (int i = 0; i < col; i++) {
				stu = ls.get(i);

				str[i][0] = stu.getSno();
				str[i][1] = stu.getSname();
				str[i][2] = stu.getSsex();
				str[i][3] = stu.getSdept();
				str[i][4] = stu.getShome();
				str[i][5] = stu.getSemail();
				str[i][6] = stu.getStel();
			}
		return str;
	}
	public static String[][] getDept(String sdept){
		StudentDAO st = new StudentDAO();
			List<Student> ls = st.getDept(sdept);
			int col = ls.size();

			String[][] str = new String[col][WindowView.result.length];
			Student stu = new Student();

			for (int i = 0; i < col; i++) {
				stu = ls.get(i);

				str[i][0] = stu.getSno();
				str[i][1] = stu.getSname();
				str[i][2] = stu.getSsex();
				str[i][3] = stu.getSdept();
				str[i][4] = stu.getShome();
				str[i][5] = stu.getSemail();
				str[i][6] = stu.getStel();
			}
		return str;
	}
	public static String[][] getSex(String sex){
		StudentDAO st = new StudentDAO();
			List<Student> ls = st.getSex(sex);
			int col = ls.size();

			String[][] str = new String[col][WindowView.result.length];
			Student stu = new Student();

			for (int i = 0; i < col; i++) {
				stu = ls.get(i);

				str[i][0] = stu.getSno();
				str[i][1] = stu.getSname();
				str[i][2] = stu.getSsex();
				str[i][3] = stu.getSdept();
				str[i][4] = stu.getShome();
				str[i][5] = stu.getSemail();
				str[i][6] = stu.getStel();
			}
		return str;
	}
	public static void Update(String sno,String sname,String ssex,String sdept,String shome,String semail,String stel,String Sno){
		StudentDAO st = new StudentDAO();
		Student s=new Student();
		s.setSno(sno);
		s.setSname(sname);
		s.setSsex(ssex);
		s.setSdept(sdept);
		s.setShome(shome);
		s.setSemail(semail);
		s.setStel(stel);
		s.setSno(Sno);
		st.update(s);
	}
}
