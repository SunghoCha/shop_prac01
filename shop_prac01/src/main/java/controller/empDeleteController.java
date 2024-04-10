package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.empDAO;

@WebServlet("/empDelete.do")
public class empDeleteController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		
		empDAO dao = new empDAO();
		int cnt = dao.removeEmpOne(empNo);
		if (cnt > 0) {
			System.out.println("[empDeleteController] emp delete 성공");
			response.sendRedirect("/shop_prac01/empList.do");
		} else {
			throw new ServletException("not delete");
		}
	}
}
