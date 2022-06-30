package kr.web.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request,
						HttpServletResponse response)throws ServletException,IOException{
		/*
		 * [실습]
		 * 클라이언트로부터 이름,제목,내용을 전송 받아서 출력하시오.
		 * [출력예시]
		 * 이름 : 홍길동
		 * 제목 : 장마의 시작
		 * 내용 : 비가 너무 많이 와요!
		 */
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>게시판</title></head>");
		out.println("<body>");
		out.println("이름 : " + name + "<br>");
		out.println("제목 : " + title + "<br>");
		out.println("내용 : " + content + "<br>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
