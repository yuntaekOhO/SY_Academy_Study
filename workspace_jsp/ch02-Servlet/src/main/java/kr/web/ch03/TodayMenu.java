package kr.web.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todayMenu")
public class TodayMenu extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		//html 출력을 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Lunch Menu</title></head>");
		out.println("<body>");
		out.println("<h3>오늘 점심은</h3>");
		//전송된 데이터 반환
		String[] values = request.getParameterValues("lunch");
		if(values != null) {
			for(int i=0;i<values.length;i++) {
				out.println(values[i] + "<br>");
			}
		}else {
			out.println("선택한 점심 메뉴가 없습니다.");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
