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
		} //end of selectData
		
		//submit 이벤트 연결
		$('#insert_form').submit(function(event){
			//입력 양식의 내용을 요청 매개변수 문자열로 만듬
			//(파라미터네임과 value의 쌍, 인코딩 처리)
			let input_data = $(this).serialize();
			
			$.ajax({
				url:'insertPerson.jsp',
				type:'post',
				data:input_data,
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(param){
					if(param.result=='success'){
						alert('회원가입 완료!');
						//form에 입력된 내용 초기화
						$('#insert_form input[type="text"]').val('');
						
						//목록 호출
						selectData();
					}else{ //result==failure
						alert('회원가입 오류 발생!');
					}
				},
				error:function(){
					//형식에 맞지않는 데이터 수신
					alert('네트워크 오류 발생!');
				}
			});//end of ajax in insert submit
			
			//기본 이벤트 제거 : submit으로 페이지 이동하는게 아닌 현재 페이지에서 데이터 전송,반영 하기 때문
			//preventDefault()의 동작은 return false; 처럼 기본이벤트를 삭제하는 기능인데
			//return false의 경우 해당 명령을 실행하는 즉시 이벤트 핸들러에서 탈출해서 다음라인이 동작하지 않지만
			//preventDefault는 기본이벤트를 제거하고 다음 행이 있다면 다음 행을 실행한다.
			event.preventDefault();
		});
		
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
				<input type="text" name="blood_type" id="blood_type">
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