package productController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.productDAO;
import model.productVO;

@WebServlet("/productInsert.do")
public class productInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		int price = Integer.parseInt(request.getParameter("price"));
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		productVO vo =  new productVO(productName, price, categoryNo);
		productDAO dao = new productDAO();
		int cnt = dao.addProduct(vo);
		if (cnt > 0) {
			System.out.println("[productInsertController] product insert 성공");
			response.sendRedirect("/shop_prac01/productList.do");
		} else {
			throw new ServletException("not insert");	
		}
	}
}
