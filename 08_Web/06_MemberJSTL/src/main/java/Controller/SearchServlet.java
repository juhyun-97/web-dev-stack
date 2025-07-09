package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;

import dao.MemberDAO;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		
		try {
			Member member = dao.search(id);
			
			request.setAttribute("member", member); // request.setAttribute 때는 getRequestDispatcher로 값 받기
			
			request.getRequestDispatcher("/views/result.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

}
