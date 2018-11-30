package cn.student.Audio;

import java.util.List;

import cn.student.DAO.AudioDAO;

public class AudioAction {
	public static String[][] QueueArray(String name){
		AudioDAO audd = new AudioDAO();
		List<Audio> li = audd.Queue(name);
		int col  =li.size();
		String[][] str = new String[col][2];
		Audio aud = new Audio();
		for(int i =0;i<col;i++){
			aud=li.get(i);
			str[i][0]=aud.getId();
			str[i][0]=aud.getPassword();
		}
		return str;
	}
	public static void Add(String id,String password){
		AudioDAO aud = new AudioDAO();
		Audio a = new Audio();
		a.setId(id);
		a.setPassword(password);
		aud.add(a);
	}
}
