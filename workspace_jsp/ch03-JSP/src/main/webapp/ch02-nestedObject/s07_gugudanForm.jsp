<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 입력</title>
<script type="text/javascript">
	window.onload=function(){
		let myForm = document.getElementById('myForm');
		myForm.onsubmit=function(){
			let dan = document.getElementById('dan');
			//1번 조건 체크 공백,데이터 입력x인 경우
			if(dan.value.trim()==''){
				alert('단을 입력하세요');
				dan.focus();
				dan.value = '';
				return false;
			}
			//2번 조건체크, 숫자인지 체크
			if(isNaN(dan.value)){
				alert('숫자만 입력하세요');
				dan.focus();
				dan.value = '';
				return false;
			}
			//3번 조건체크, 2~9
			if(dan.value<2 || dan.value>9){
				alert('2~9단을 입력하세요');
				dan.focus();
				dan.value = '';
				return false;
			}
		}
	}
</script>
</head>
<body>
<!-- 
[실습]
단을 입력한 후 전송하면 입력한 단을 표시하고 구구단을 출력하는 프로그램
자바스크립트를 이용한 조건체크
1.공백 체크, 입력안한 경우 '단을 입력하세요'
2.문자인지 숫자인지 체크 문자이면 '숫자만 입력하세요'
3. 2~9가 아니면 '2~9단을 입력하세요'
 -->
<form id="myForm" action="s08_gugudan.jsp">
	단 <input type="text" name="dan" id="dan"><br>
	<input type="submit" value="전송">
</form>
</body>
</html>