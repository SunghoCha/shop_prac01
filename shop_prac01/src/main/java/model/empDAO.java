package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class empDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public List<empVO> getEmpList() {
		getConnect();
		String sql = "select * from emp";
		List<empVO> list = new ArrayList<empVO>();
		
		try {
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
			while (rs.next()) {
				int empNo = Integer.parseInt(rs.getString("emp_no"));
				String empId = rs.getString("emp_id");
				String empPw = rs.getString("emp_pw");
				int grade = Integer.parseInt(rs.getString("grade"));
				String empName = rs.getString("emp_name");
				String empJob = rs.getString("emp_job");
				String hireDate = rs.getString("hire_date");
				String updateDate = rs.getString("update_date");
				String createDate = rs.getString("create_date");
				String active = rs.getString("active");
				
				empVO vo = new empVO(empNo, empId, empPw, grade, empName, empJob, 
										hireDate, updateDate, createDate, active);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	private void getConnect() {
		String URL = "jdbc:mysql://localhost:3306/shop?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dbClose() {
		try {
			if (rs != null) {rs.close();}
			if (psmt != null) {psmt.close();}
			if (conn != null) {conn.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
