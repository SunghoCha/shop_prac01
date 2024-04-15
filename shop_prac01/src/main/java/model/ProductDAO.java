package model;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public int addProduct(ProductVO vo) {
		getConnect();
		String sql = "insert into product (product_name, price, category_no) valeus (?, ?, ?)";
		int cnt = -1;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProductName());
			psmt.setInt(2, vo.getPrice());
			psmt.setInt(3, vo.getCategoryNo());
			System.out.println("[productDAO] addProduct query : " + psmt);
			cnt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	private void getConnect() {
		String URL = "jdbc:mysql://localhost:3306/shop?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(URL, user, password);
		System.out.println("[productDAO] DB 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dbClose() {
		try {
			if (rs != null) {rs.close();}
			if (psmt != null) {psmt.close();}
			if (conn != null) {conn.close();}
			System.out.println("[productDAO] DB 연결 해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
