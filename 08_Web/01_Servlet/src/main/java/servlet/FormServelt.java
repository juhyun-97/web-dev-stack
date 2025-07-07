package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/form")
public class FormServelt extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String id = request.getParameter("userId");
		System.out.println(id);

		String pwd = request.getParameter("userPwd");
		System.out.println(pwd);

		String gender = request.getParameter("gender");
		System.out.println(gender);

		String[] menu = request.getParameterValues("menu");
		System.out.println(menu);

		gender = gender.equals("M") ? "남자" : "여자";

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>아이디 : " + id + "</h1>");
		out.println("<h1>비밀번호 : " + pwd + "</h1>");
		out.println("<h1>성별  : " + gender + "</h1>");
		// out.println("<h1>menu : " + String.join(",", menu) + "</h1>");

		if (menu != null) {
			out.println("<h1>좋아하는 메뉴</h1>");
			out.println("<ul>");
			for (String m : menu) {
				out.println("<li>" + m + "</li>");
			}
			out.println("</ul>");
		}

		out.println("</body></html>");

		out.close();

	}

}
