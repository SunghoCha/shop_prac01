package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.DBHelper;

public class EmpDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public List<EmpVO> getEmpList() {
		conn = DBHelper.getConnect();
		
		String sql = "select * from emp";
		List<EmpVO> list = new ArrayList<EmpVO>();
		
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
				
				EmpVO vo = new EmpVO(empNo, empId, empPw, grade, empName, empJob, 
										hireDate, updateDate, createDate, active);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.dbClose(conn, psmt, rs);
		}
		return list;
	}
	
	public List<EmpVO> getEmpListPage(Map<String, Object> map) {
		conn = DBHelper.getConnect();
		String sql = "select * from emp limit ?,?";
		List<EmpVO> list = new ArrayList<EmpVO>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, (int) map.get("start"));
			psmt.setInt(2, (int) map.get("end"));
			System.out.println("[empDAO] getEmpListPage query : " + psmt);
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
				
				EmpVO vo = new EmpVO(empNo, empId, empPw, grade, empName, empJob,
										hireDate, updateDate, createDate, active);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.dbClose(conn, psmt, rs);
		}
		return list;
	}
	
	public int addEmpOne(EmpVO vo) {
		conn = DBHelper.getConnect();
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
			DBHelper.dbClose(conn, psmt, rs);
		}
		return cnt;
	}
	
	public int removeEmpOne(int empNo) {
		conn = DBHelper.getConnect();
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
			DBHelper.dbClose(conn, psmt, rs);
		} return cnt;
	}

	public EmpVO empLogin(EmpVO vo) {
		conn = DBHelper.getConnect();
		String sql = "select emp_id, emp_name, grade from emp where emp_id = ? and emp_pw = ?";
		EmpVO user = new EmpVO();
		try {
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
			DBHelper.dbClose(conn, psmt, rs);
		}
		return user;
	}

	public boolean checkEmpId(String empId) {
		conn = DBHelper.getConnect();
		String sql = "select emp_id from emp where emp_id = ?";
		boolean isDuplicated = true;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,empId);
			System.out.println("[empDAO] checkEmpId query : " + psmt);
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println("[empDAO] empId 중복");
			} else {
				System.out.println("[empDAO] empId 중복 아님");
				isDuplicated = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.dbClose(conn, psmt, rs);
		}
		return isDuplicated;
	}

	public int getTotalCount() {
		conn = DBHelper.getConnect();
		int totalCount = -1;
		String sql = "select COUNT(*) as totalCount from emp";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				totalCount = rs.getInt("totalCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.dbClose(conn, psmt, rs);
		}
		return totalCount;
	}
}
