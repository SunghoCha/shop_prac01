package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.empDAO;

@WebServlet("/empIdCheck.do")
public class empIdCheckController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		System.out.println("[empIdCheckController] request-param empId : " + empId);
		
		empDAO dao = new empDAO();
		boolean isDuplicated = dao.checkEmpId(empId);
		response.getWriter().print(isDuplicated);
	}
}
