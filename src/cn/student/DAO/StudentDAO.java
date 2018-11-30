package cn.student.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.student.DBUtil.Base;
import cn.student.Student.Student;



/**
 * @author ZQ
 * @time
 * @function
 */
public class StudentDAO {

	public void add(Student s) {
		Connection conn = Base.getConnecttion();
		String sql = ""+
					" insert into studentplus"+
					" (Sno,Sname,Ssex,Sdept,Shome,Semail,Stel)"+
					" values("+
					"?,?,?,?,?,?,?)";
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, s.getSno());
			ptmt.setString(2, s.getSname());
			ptmt.setString(3, s.getSsex());
			ptmt.setString(4, s.getSdept());
			ptmt.setString(5, s.getShome());
			ptmt.setString(6, s.getSemail());
			ptmt.setString(7, s.getStel());
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void delete(String Sno) throws SQLException {
		Connection conn = Base.getConnecttion();
		String sql =" "+
					" delete from studentplus"+
					" where Sno = ?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setString(1, Sno);
		ptmt.execute();

	}

	public void update(Student s) {
		Connection conn = Base.getConnecttion();
		String sql =" "+
					" update studentplus "+
					" set Sno=?,Sname=?,Ssex=?,Sdept=?,Shome=?,Semail=?,Stel=? "+
					" where Sno=? ";
		PreparedStatement ptmt;
		try {
			
			ptmt= conn.prepareStatement(sql);
			ptmt.setString(1, s.getSno());
			ptmt.setString(2, s.getSname());
			ptmt.setString(3, s.getSsex());
			ptmt.setString(4, s.getSdept());
			ptmt.setString(5, s.getShome());
			ptmt.setString(6, s.getSemail());
			ptmt.setString(7, s.getStel());
			ptmt.setString(8, s.getSno());
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Student> queryAll() {
		// 将连接的数据库对象拿过来
		Connection conn = Base.getConnecttion();
		// 创建一个 Statement 对象来将 SQL 语句发送到数据库
		 
		 
		List<Student> li=null;
		ResultSet rs=null;
		
		try {
			Statement st = conn.createStatement();
				// 执行语句
			 rs= st.executeQuery("select Sno,Sname,Ssex,Sdept,Shome,Semail,Stel from studentplus");
			li = new ArrayList<Student>();
				
				while (rs.next()) {
					Student stu = new Student();
					stu.setSno(rs.getString("Sno"));
					stu.setSname(rs.getString("Sname"));
					stu.setSsex(rs.getString("Ssex"));
					stu.setSdept(rs.getString("Sdept"));
					stu.setSemail(rs.getString("Semail"));
					stu.setStel(rs.getString("Stel"));
					stu.setShome(rs.getString("Shome"));
					li.add(stu);

}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			return li;
	}
	public List<Student> getSno(String Sno){
		Connection conn = Base.getConnecttion();
		 Student stu=null;
		String sql =" "+
					" select * from studentplus"+
					" where Sno = ?";
		PreparedStatement ptmt;
		ResultSet rs=null;
		List<Student> li=null;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, Sno);
			rs = ptmt.executeQuery();
			li = new ArrayList<Student>();
			while(rs.next()) {
				stu = new Student();
				stu.setSno(rs.getString("Sno"));
				stu.setSname(rs.getString("Sname"));
				stu.setSsex(rs.getString("Ssex"));
				stu.setSdept(rs.getString("Sdept"));
				stu.setSemail(rs.getString("Semail"));
				stu.setStel(rs.getString("Stel"));
				stu.setShome(rs.getString("Shome"));
				li.add(stu);
				
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
		
	}
	public List<Student> getName(String Sname){
		Connection conn = Base.getConnecttion();
		 Student stu=null;
		String sql =" "+
					" select * from studentplus"+
					" where Sname = ?";
		PreparedStatement ptmt;
		ResultSet rs=null;
		List<Student> li=null;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, Sname);
			rs = ptmt.executeQuery();
			li = new ArrayList<Student>();
			while(rs.next()) {
				stu = new Student();
				stu.setSno(rs.getString("Sno"));
				stu.setSname(rs.getString("Sname"));
				stu.setSsex(rs.getString("Ssex"));
				stu.setSdept(rs.getString("Sdept"));
				stu.setSemail(rs.getString("Semail"));
				stu.setStel(rs.getString("Stel"));
				stu.setShome(rs.getString("Shome"));
				li.add(stu);
				
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
		
	}
	public List<Student> getSex(String Ssex){
		Connection conn = Base.getConnecttion();
		 Student stu=null;
		String sql =" "+
					" select * from studentplus"+
					" where Ssex = ?";
		PreparedStatement ptmt;
		ResultSet rs=null;
		List<Student> li=null;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, Ssex);
			rs = ptmt.executeQuery();
			li = new ArrayList<Student>();
			while(rs.next()) {
				stu = new Student();
				stu.setSno(rs.getString("Sno"));
				stu.setSname(rs.getString("Sname"));
				stu.setSsex(rs.getString("Ssex"));
				stu.setSdept(rs.getString("Sdept"));
				stu.setSemail(rs.getString("Semail"));
				stu.setStel(rs.getString("Stel"));
				stu.setShome(rs.getString("Shome"));
				li.add(stu);
				
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
		
	}
	public List<Student> getDept(String Sdept){
		Connection conn = Base.getConnecttion();
		 Student stu=null;
		String sql =" "+
					" select * from studentplus"+
					" where Sdept = ?";
		PreparedStatement ptmt;
		ResultSet rs=null;
		List<Student> li=null;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, Sdept);
			rs = ptmt.executeQuery();
			li = new ArrayList<Student>();
			while(rs.next()) {
				stu = new Student();
				stu.setSno(rs.getString("Sno"));
				stu.setSname(rs.getString("Sname"));
				stu.setSsex(rs.getString("Ssex"));
				stu.setSdept(rs.getString("Sdept"));
				stu.setSemail(rs.getString("Semail"));
				stu.setStel(rs.getString("Stel"));
				stu.setShome(rs.getString("Shome"));
				li.add(stu);
				
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
		
	}
}

