package kr.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/dispatcher")
//Controller
public class DispatcherServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException,IOException {
		requestPro(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException,IOException{
		requestPro(request, response);
	}
	
	private void requestPro(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException,IOException{
		Action com = null;
		String view = null; //jsp 경로
		
		//클라이언트가 요청한 주소를 URI형식으로 반환
		String command = request.getRequestURI();
		
		if(command.indexOf(request.getContextPath())==0) {
			command = command.substring(request.getContextPath().length());
		}
				
		
		if(command.equals("/list.do")) {
			com = new ListAction();
		}else if(command.equals("/write.do")) {
			com = new WriteAction();
		}else if(command.equals("/detail.do")) {
			com = new DetailAction();
		}else if(command.equals("/update.do")) {
			com = new UpdateAction();
		}else if(command.equals("/delete.do")) {
			com = new DeleteAction();
		}
		
		try {
			//모델클래스의 execute() 메서드를 호출해서 jsp 경로 반환 & request,response 공유
			view = com.execute(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//forward 방식으로 view(jsp) 호출
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
