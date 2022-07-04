<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.ResultSet"%>
<%@ include file="dbInfo.jspf"%>
<?xml version="1.0" encoding="UTF-8"?>
<people>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	try{
		//JDBC 수행 1단계 : 드라이버 로드
		Class.forName(driverName);
		
		//JDBC 수행 2단계 : Connection 객체 생성
		conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);
		
		//SQL문 작성
		sql = "SELECT * FROM people ORDER BY id ASC";
		
		//JDBC 수행 3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		
		//JDBC 수행 4단계 : SQL문 실행해서 결과행을 ResultSet에 담음
		rs = pstmt.executeQuery();
		while(rs.next()){
%>
	<person>
		<id><%=rs.getString("id") %></id>
		<name><%=rs.getString("name") %></name>
		<job><%=rs.getString("job") %></job>
		<address><%=rs.getString("address") %></address>
		<blood_type><%=rs.getString("blood_type") %></blood_type>
	</person>
<%
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		//자원정리
		if(rs!=null)try{rs.close();}catch(SQLException e){};
		if(pstmt!=null)try{pstmt.close();}catch(SQLException e){};
		if(conn!=null)try{conn.close();}catch(SQLException e){};
	}
%>
</people>