<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>
<style type="text/css">
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
		width: 100px;
		float: left;
	}
</style>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		//아이디 중복 체크 결과 -> 0 : 아이디 중복체크 미실시, 아이디 중복
		//				    -> 1 : 아이디 미중복
		let count = 0;
		
		//중복체크 버튼 이벤트 연결
		$('#confirmId').click(function(){
			if($('#id').val().trim()==''){ //공백만 입력 경우
				alert('아이디를 입력하세요!');
				$('#id').val(''); 		   //공백 제거
				$('#id').focus();
				return;
			}
			
			//서버와 비동기 통신 ajax - JSON
			$.ajax({
				url:'confirmId.jsp',      //요청 URL
				type:'post', 			  //데이터 전송 방식
				data:{id:$('#id').val()}, //서버로 보낼 데이터
				dataType:'json', 		  //서버로부터 전송되어지는 데이터의 타입
				cache:false,			  //캐시 미사용, 낮은 버전의 브라우저는 원격지에서 캐시가 공개되는 경우가 있음
				timeout:30000,			  //30초 지나도록 표시 되지않을시 에러
				success:function(param){
					if(param.result == 'idDuplicated'){
						//아이디 중복
						count = 0;
						$('#id_signed').text('이미 등록된 아아디').css('color','red');
					}else if(param.result == 'idNotFound'){
						//아이디 미중복
						count = 1;
						$('#id_signed').text('사용 가능한 아이디').css('color','green');
					}else{ //오류 failure
						count = 0;
						alert('아이디 중복 체크 오류!');
					}
				},
				error:function(){
					count = 0;
					alert('네트워크 오류 발생!');
				}
			});
		}); //end of click
		
		//최초에 아이디 중복 체크에 성공한 후 식별자가 #id인 text의 내용 변경 후 
		//중복체크를 하지않고 submit 누르는 상황 방지
		//식별자가 #id인 text의 내용 변경될시 span을 지워버림
		$('#insert_form #id').keydown(function(){
			$('#id_signed').text('');
			count = 0;
		}); //end of keydown
		
		$('#insert_form').submit(function(){
			if($('#id').val().trim()==''){
				alert('아이디를 입력하세요');
				$('#id').val('').focus();
				return false;
			}
			
			if(count==0){
				alert('아이디 중복 체크 필수');
				return false;
			}
		}); //end of submit
		
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
				<input type="button" id="confirmId" value="아이디 중복체크">
				<span id="id_signed"></span>
			</li>
			<li>
				<input type="submit" value="전송">
			</li>
		</ul>
	</fieldset>
</form>
</body>
</html>