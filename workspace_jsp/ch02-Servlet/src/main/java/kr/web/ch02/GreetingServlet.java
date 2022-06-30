package kr.web.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greetingName")
public class GreetingServlet extends HttpServlet {
	/*
	 * 데이터 전송 방식이 get 방식일 때 doGet 구현
	 * 데이터 전송 방식이 post 방식일 때 doPost 구현
	 */
	@Override
	public void doPost(HttpServletRequest request,
						HttpServletResponse response)throws ServletException,IOException{
		//Post 방식 일 때
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//클라이언트가 전송한 데이터 반환
		String name = request.getParameter("name");
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		//HTML 출력을 위한 출력스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Greeting</title></head>");
		out.println("<body>");
		out.println(name + "님의 방문을 환영합니다.");
		out.println("</body>");
		out.println("</html>");
	}
}
