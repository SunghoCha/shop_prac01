package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmpDAO;
import model.EmpVO;

@WebServlet("/empList.do")
public class EmpListController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체 페이지 수 계산
		//임시, pageSize는 param.으로 받을수도 있음
		int pageSize = 10;
		int blockPage = 5;
		// dao로 totalCount 가져와서 totalPage 계산
		EmpDAO dao = new EmpDAO();
		int totalCount = dao.getTotalCount();
		int totalPage = (int)Math.ceil((double)totalCount / pageSize);
		// 현재 페이지 확인
		int pageNum = 1;
		String pageNumStr = request.getParameter("pageNum");
		System.out.println("[EmpListController] request-param pageNum : " + pageNumStr);
		if (pageNumStr != null && !pageNumStr.equals("")) {
			pageNum = Integer.parseInt(pageNumStr);
		}
		int start = (pageNum - 1) * pageSize;
		int end = pageNum * pageSize - 1;
		//pageNum,과 pageSize의 값만으로 확정되는 값인데 이걸 로그찍는경우는 식 자체가 문제인지 점검할 때만 유의미
		//System.out.println("[EmpListController] param start : " + start); 
		//System.out.println("[EmpListController] param end : " + end);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		List<EmpVO> empList = dao.getEmpListPage(map);
		request.setAttribute("empList", empList);
		RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
	}
}
