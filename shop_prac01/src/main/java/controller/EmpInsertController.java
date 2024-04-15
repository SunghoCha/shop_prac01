package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmpDAO;
import model.EmpVO;

@WebServlet("/empInsert.do")
public class EmpInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 받기
		request.setCharacterEncoding("utf-8");
		String empId = request.getParameter("empId");
		String empPw = request.getParameter("empPw");
		int grade = Integer.parseInt(request.getParameter("grade"));
		String empName = request.getParameter("empName");
		String empJob = request.getParameter("empJob");
		String hireDate = request.getParameter("hireDate");
		String active = request.getParameter("active");
		//디버깅
		System.out.println("[empInsertController] request param empId : " + empId);
		System.out.println("[empInsertController] request param empPw : " + empPw);
		System.out.println("[empInsertController] request param grade : " + grade);
		System.out.println("[empInsertController] request param empName : " + empName);
		System.out.println("[empInsertController] request param empJob : " + empJob);
		System.out.println("[empInsertController] request param hireDate : " + hireDate);
		System.out.println("[empInsertController] request param active : " + active);
		// dto 만들어서 db에 전달하고 결과 받기
		EmpVO vo = new EmpVO(empId, empPw, grade, empName, empJob, hireDate, active);
		EmpDAO dao = new EmpDAO();
		int cnt = dao.addEmpOne(vo);
		if (cnt > 0) {
			System.out.println("[empInsertController] emp insert 성공");
			response.sendRedirect("/shop_prac01/empList.do");
		}else {
		    // 가입실패-> 예외객체를 만들어서 WAS에 던짐
		    throw new ServletException("not insert");	    	
		}
	}
}
