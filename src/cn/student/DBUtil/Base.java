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
	  private static String dbUrl="jdbc:mysql://localhost:3306/stu?useSSL=false";//我的驱动包版本相当于数据库版本较低，需要对该连接时进行说明?useSSL=false
	  private static String jdbcName ="com.mysql.jdbc.Driver";
	  private static String dbUserName ="root";
	  private static String dbPassword ="1234";
	  static {
		try {
			// 加载驱动
			Class.forName(jdbcName);

			// 2.建立连接
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
