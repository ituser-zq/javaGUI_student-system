package cn.student.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ZQ
 * @time
 * @function
 */
public class Base {
	  private static Connection conn = null;
	  private static String dbUrl="jdbc:mysql://localhost:3306/stu?useSSL=false";//�ҵ��������汾�൱�����ݿ�汾�ϵͣ���Ҫ�Ը�����ʱ����˵��?useSSL=false
	  private static String jdbcName ="com.mysql.jdbc.Driver";
	  private static String dbUserName ="root";
	  private static String dbPassword ="1234";
	  static {
		try {
			// ��������
			Class.forName(jdbcName);

			// 2.��������
			conn = DriverManager.getConnection(dbUrl,dbUserName , dbPassword);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static Connection getConnecttion() {
		return conn;
	}
	
	
}
