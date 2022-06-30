<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문서</title>
<style type="text/css">
    h2{
    	text-align: center;
    }
	table{
		border-collapse:collapse;
		border:1px solid gray;
		margin:0 auto;
	}
	td{
		border:1px solid gray;
		height:30px;
	}
	td.title{
		text-align: right;
		background-color:ivory;
		font-weight:bold;
		color:#FF6600;
		padding:0 10px;
	}
	input[type="number"]{
		text-align:right;
		width:50px;
		height:19px;
	}
	ul{
		list-style:none;
		padding:0 10px;
		margin:5px;
	}
	ul li{
		display:inline;
	}
</style>
<script type="text/javascript">
	window.onload=function(){
		let myForm = document.getElementById('myForm');
		//이벤트 연결
		myForm.onsubmit=function(){
			let c0 = document.getElementById('c0');
			if(c0.value==''){//0이 아닌 공백인 경우
				alert('짜장면의 수량을 입력하세요!');
				c0.value = 0;
				c0.focus();
				return false;
			}
			
			let c1 = document.getElementById('c1');
			if(c1.value==''){
				alert('짬뽕의 수량을 입력하세요!');
				c1.value = 0;
				c1.focus();
				return false;
			}
			
			let c2 = document.getElementById('c2');
			if(c2.value==''){
				alert('볶음밥의 수량을 입력하세요!');
				c2.value = 0;
				c2.focus();
				return false;
			}
			
			if(c0.value==0 && c1.value==0 && c2.value==0){
				alert('세가지 음식 중 하나는 꼭 주문해야 합니다.');
				return false;
			}
			
		};
	};
</script>
</head>
<body>
<h2>주문서</h2>
<form action="s15_order.jsp" method="post" id="myForm">
	<table>
		<tr>
			<td class="title">식사류</td>
			<td>
				<ul>
					<li>
						<label for="c0">짜장면</label>
						<input type="number" name="food_c0"
						   id="c0" min="0" max="99" value="0">
					</li>
					<li>
						<label for="c1">짬뽕</label>
						<input type="number" name="food_c1"
						   id="c1" min="0" max="99" value="0">
					</li>
					<li>
						<label for="c2">볶음밥</label>
						<input type="number" name="food_c2"
						   id="c2" min="0" max="99" value="0">
					</li>
				</ul>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="전송">
			</td>
		</tr>
	</table>
</form>
</body>
</html>



