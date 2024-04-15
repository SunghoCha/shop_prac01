package util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBHelper {
	
	public static Connection getConnect() {
		Connection conn = null;
		String URL = "jdbc:mysql://localhost:3306/shop?characterEncoding=UTF-8&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			FileReader fr = new FileReader("C:\\Users\\tjdgh\\mariadb.properties");
			Properties prop = new Properties();
			prop.load(fr);
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			conn = DriverManager.getConnection(URL, user, password);
			System.out.println("[DBHelper] DB 연결 성공");
		} catch (Exception e) {
			System.out.println("[DBHelper] DB 연결 실패");
			e.printStackTrace();
		} 
		return conn;
	}
	
	public static void dbClose(Connection conn, PreparedStatement psmt, ResultSet rs) {
		try {
			if (rs != null) {rs.close();}
			if (psmt != null) {psmt.close();}
			if (conn != null) {conn.close();}
			System.out.println("[DBHelper] DB 연결 해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
