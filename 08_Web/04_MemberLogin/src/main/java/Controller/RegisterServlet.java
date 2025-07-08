package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;

import dao.MemberDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		Member member = new Member(id, pwd);
		
		boolean check = true;
		
		MemberDAO dao = new MemberDAO();
		try {
			dao.register(new Member(id, pwd));
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		request.setAttribute("check", check);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	
		}
	}
