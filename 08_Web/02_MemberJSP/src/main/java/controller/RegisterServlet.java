package controller;

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
		// 1. (있으면) 폼 값 받아온다.
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		// 2. DAO 호출 - DB 접근 필요시
		MemberDAO dao = new MemberDAO();
		try {
			dao.register(new Member(id, name, pwd, age));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. 결과 페이지
		response.sendRedirect("result.jsp"); // jsp파일 생성후 response.sendRedirect에 호출
		
	}

}
