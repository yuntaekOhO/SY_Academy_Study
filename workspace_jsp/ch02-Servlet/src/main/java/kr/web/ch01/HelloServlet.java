package kr.web.ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//s01
//원래 HelloServlet를 호출하면 /servlet/kr.web.ch01.HelloServlet 주소를 사용하게 되는데
//보안문제로 톰캣이 경로를 막았기 때문에 URL을 어노테이션으로 새롭게 지정
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	//HttpServlet의 메서드를 재정의
	@Override
	public void doGet(HttpServletRequest request, 
						HttpServletResponse response)throws ServletException,IOException{
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		//HTML 출력을 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Hello Servlet</title></head>");
		out.println("<body>");
		out.println("처음 작성하는 servlet 입니다.");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
