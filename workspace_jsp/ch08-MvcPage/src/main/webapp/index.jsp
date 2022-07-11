<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.sendRedirect(request.getContextPath()+"/main/main.do");
%>
<%-- 
스크립틀릿에서 컨텍스트 경로 : request.getContextPath()
JSP에서 EL로 컨텍스트 경로 : ${pageContext.request.contextPath}
 --%>