package cn.student.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.student.Audio.Audio;
import cn.student.DBUtil.Base;

public class AudioDAO {
	public List<Audio> Queue(String id) {
		Connection conn = Base.getConnecttion();
		Audio aud = null;
		String sql = " " + " select * from Audio" + " where id = ?";
		PreparedStatement ptmt;
		ResultSet rs = null;
		List<Audio> li = null;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			rs = ptmt.executeQuery();
			li = new ArrayList<Audio>();
			while (rs.next()) {
				aud = new Audio();
				aud.setId(rs.getString("id"));
				aud.setPassword(rs.getString("password"));
				li.add(aud);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return li;
	}
	public void add(Audio a) {
		Connection conn = Base.getConnecttion();
		String sql = ""+
					" insert into Audio"+
					" (id,password)"+
					" values("+
					"?,?)";
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, a.getId());
			ptmt.setString(2, a.getPassword());
			
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
