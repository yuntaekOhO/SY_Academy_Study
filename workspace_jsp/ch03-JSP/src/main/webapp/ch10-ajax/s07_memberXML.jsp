<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}
#wrap{
	overflow: hidden;
}
.item{
	margin: 5px;
	padding: 5px;
	width: 300px;
	height: 150px;
	float: left;
	border-width: 3px;
	border-style: solid;
	border-color: gray;
	border-radius: 10px;
}
</style>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		function selectData(){
			$.ajax({
				url:'getDataXML.jsp',
				dataType:'xml',
				cache:false,
				timeout:30000,
				success:function(param){
					//div 초기화
					$('#wrap').empty();
					
					$(param).find('person').each(function(){
						let output = '<div class="item">';
						output += '<p>' + $(this).find('id').text() + '</p>';
						output += '<p>' + $(this).find('name').text() + '</p>';
						output += '<p>' + $(this).find('job').text() + '</p>';
						output += '<p>' + $(this).find('address').text() + '</p>';
						output += '<p>' + $(this).find('blood_type').text() + '</p>';
						output += '</div>'
						
						$('#wrap').append(output);
					});
				},
				error:function(){
					alert('네트워크 오류 발생!');
				}
			});
		}
		
		//초기 데이터 호출
		selectData();
	});
</script>
</head>
<body>
	<div id="wrap"></div>
</body>
</html>