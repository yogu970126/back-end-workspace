package servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 인코딩! -> 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		String[] menuList = request.getParameterValues("menu"); // 리스트여서 values
		
		// fs 전송 후 해당 요청 값들 받아서 응답 결과 출력
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>정보를 출력합니다..</h1>");
		pw.println("<p>아이디 : " + id + "</p>");
		pw.println("<p>비밀번호 : " + pwd + "</p>");
		
		String genderResult = gender.charAt(0) == 'M' ? "남자" : "여자";
		pw.println("<p>당신의 성별은 " + genderResult + "</p>");
		
		pw.println("<ul>");
		for(String menu : menuList) {
			pw.println("<li>" + menu + "</li>");
		}
		pw.println("</ul>");
		
		pw.println("</body></html>");
		pw.close();
	}

}
