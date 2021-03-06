package kr.web.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/travel")
public class TravelServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		/*
		 * [실습]
		 * 전송되는 이름과 여행지를 출력하시오.
		 * [출력예시]
		 * 여행지 선택
		 * 이름 : 홍길동
		 * 선택한 여행지 : 뉴욕, 파리
		 */
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Lunch Menu</title></head>");
		out.println("<body>");
		out.println("<h3>여행지 선택</h3>");
		
		String name = request.getParameter("name");
		
		out.println("이름 : " + name +"<br>");
		out.println("선택한 여행지 : ");

		//전송된 데이터 반환
		String[] values = request.getParameterValues("city");
		if(values != null) {
			for(int i=0;i<values.length;i++) {
				//if(i>0) out.println(",");
				out.println(values[i]);
				if(i<values.length-1) out.println(",");
			}
		}else {
			out.println("선택한 여행지가 없습니다.");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
