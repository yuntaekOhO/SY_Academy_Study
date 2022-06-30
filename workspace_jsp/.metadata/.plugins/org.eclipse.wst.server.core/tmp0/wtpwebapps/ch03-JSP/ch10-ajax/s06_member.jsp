<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 관리</title>
<style type="text/css">
	form{
		width: 500px;
		margin: 10px auto;
	}
	ul{
		padding: 0;
		margin: 0;
		list-style: none;
	}
	ul li{
		padding: 0;
		margin: 0 0 10px 0;
	}
	label{
		width: 150px;
		float: left;
	}
	table{
		border: solid 1px gray;
		width: 500px;
		margin: 0 auto;
		border-collapse: collapse;
	}
	td{
		border: solid 1px gray;
	}
</style>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		//목록
		function selectData(){
			//서버와 비동기 통신
			$.ajax({
				url:'getPeopleJSON.jsp',
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(param){
					//table의 내부 내용물 제거 (초기화)
					$('#output').empty();
					
					$(param).each(function(index,item){
						let output = '';
						output += '<tr>';
						output += '<td>' + item.id + '</td>';
						output += '<td>' + item.name + '</td>';
						output += '<td>' + item.job + '</td>';
						output += '<td>' + item.address + '</td>';
						output += '<td>' + item.blood_type + '</td>';
						output += '</tr>';
						
						//id가 output인 table 태그의 자식요소로 새로 생성한 태그를 추가
						$('#output').append(output);
					}); //end of each
				},
				error:function(){ //이 부분이 실행됐을 경우 서버프로그램의 JSON이 잘못됐을 경우가 크다
								  //이 경우 검사 - consol, eclipse - console에 표시되지 않음
					alert('네트워크 오류 발생');
				}
			});
		}
		
		//초기 화면에 목록 표시
		selectData();
	});
</script>
</head>
<body>
<form id="insert_form" method="post">
	<fieldset>
		<legend>데이터 추가</legend>
		<ul>
			<li>
				<label for="id">아이디</label>
				<input type="text" name="id" id="id">
			</li>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name">
			</li>
			<li>
				<label for="job">직업</label>
				<input type="text" name="job" id="job">
			</li>
			<li>
				<label for="address">주소</label>
				<input type="text" name="address" id="address">
			</li>
			<li>
				<label for="blood_type">혈액형</label>
				<input type="text" name="blodd_type" id="blood_type">
			</li>
		</ul>
		<div align="center">
			<input type="submit" value="추가">
		</div>
	</fieldset>
</form>
<table id="output"></table>
</body>
</html>