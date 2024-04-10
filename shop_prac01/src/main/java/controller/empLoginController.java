package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.empDAO;
import model.empVO;

@WebServlet("/empLogin.do")
public class empLoginController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		String empPw = request.getParameter("empPw");
		
		//디버깅
		System.out.println("[empLoginController] request-param empId : " + empId);
		System.out.println("[empLoginController] request-param empPw : " + empPw);
		
		empVO vo = new empVO();
		vo.setEmpId(empId);
		vo.setEmpPw(empPw);
		empDAO dao = new empDAO();
		empVO user = dao.empLogin(vo);
		System.out.println("[empLoginController] userId : " + user.getEmpId());
		if (user.getEmpId() != null && !user.getEmpId().equals("")) {
			System.out.println("[empLoginController] 로그인 성공");
			// 세션 정보 설정
			HttpSession session = request.getSession();
			Map<String, Object> loginEmp = new HashMap<String, Object>();
			loginEmp.put("empId", user.getEmpId());
			loginEmp.put("empName", user.getEmpName());
			loginEmp.put("grade", user.getGrade());
			session.setAttribute("loginEmp", loginEmp);
			
			response.sendRedirect("/shop_prac01/empList.do");
		} else {
			System.out.println("[empLoginController] 로그인 실패");
			String errMsg = URLEncoder.encode("아이디와 비밀번호가 잘못되었습니다.", "utf-8");
			response.sendRedirect("empLoginForm.jsp?errMsg=" + errMsg);
		}
	}
}
