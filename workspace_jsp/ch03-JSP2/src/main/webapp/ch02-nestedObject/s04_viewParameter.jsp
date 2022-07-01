<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터 출력</title>
</head>
<body>
<h3>request.getParameter()메서드 사용</h3>
name 파라미터 = <%= request.getParameter("name") %><br>
address 파라미터 = <%= request.getParameter("address") %><br>

<h3>request.getParameterValues()메서드 사용</h3>
<%
	String[] values = request.getParameterValues("pet");
	
	//GET방식 : checkbox를 선택하지 않으면 에러 발생하기 때문에 조건체크
	//valuse의 값이 쿼리에 전달되지 않음 = 배열은 객체 = 객체의 부재는 null
	//아래와 같은 조건체크하면 쿼리에 input type=text인 값만 쿼리에 표기된다
	if(values!=null){
		for(int i=0;i<values.length;i++){
%>
		<%= values[i] %>
<%		
		}
	}
%>
</body>
</html>