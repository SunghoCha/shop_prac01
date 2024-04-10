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
		System.out.println("[empDAO] getEmpList query : " + psmt);
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
	
	public int addEmpOne(empVO vo) {
		getConnect();
		String sql = "insert into emp (emp_id, emp_pw, grade, emp_name, emp_job, hire_date,"
				+ " update_date, create_date, active) values (?, ?, ?, ?, ?, ?, NOW(), NOW(), ?)";
		int cnt = -1;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getEmpId());
			psmt.setString(2, vo.getEmpPw());
			psmt.setInt(3, vo.getGrade());
			psmt.setString(4, vo.getEmpName());
			psmt.setString(5, vo.getEmpJob());
			psmt.setString(6, vo.getHireDate());
			psmt.setString(7, vo.getActive());
			System.out.println("[empDAO] addEmpOne query : " + psmt);
			cnt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	public int removeEmpOne(int empNo) {
		getConnect();
		String sql = "delete from emp where emp_no = ?";
		int cnt = -1;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empNo);
			System.out.println("[empDAO] removeEmpOne query : " + psmt);
			cnt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		} return cnt;
	}
	
	private void getConnect() {
		String URL = "jdbc:mysql://localhost:3306/shop?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
			System.out.println("[empDAO] DB 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dbClose() {
		try {
			if (rs != null) {rs.close();}
			if (psmt != null) {psmt.close();}
			if (conn != null) {conn.close();}
			System.out.println("[empDAO] DB 연결 해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public empVO empLogin(empVO vo) {
		getConnect();
		String sql = "select emp_id, emp_name, grade from emp where emp_id = ? and emp_pw = ?";
		empVO user = new empVO();
		try {
			System.out.println("[empDAO] empId : " + vo.getEmpId());
			System.out.println("[empDAO] empPw : " + vo.getEmpPw());
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getEmpId());
			psmt.setString(2, vo.getEmpPw());
			System.out.println("[empDAO] empLogin query : " + psmt);
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println("[empDAO] empId 조회 성공");
				user.setEmpId(rs.getString("emp_id"));
				user.setEmpName(rs.getString("emp_name"));
				user.setGrade(Integer.parseInt(rs.getString("grade")));
			} else {
				System.out.println("[empDAO] empId 조회 결과 없음");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return user;
	}
}
