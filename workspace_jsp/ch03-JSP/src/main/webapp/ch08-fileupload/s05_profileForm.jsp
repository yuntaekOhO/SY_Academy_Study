<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 사진 업로드 폼</title>
<script type="text/javascript">
	window.onload=function(){
		//미리보기 이미지
		let image = document.getElementById('image');
		//submit 버튼
		let submit_btn = document.getElementById('submit_btn');
		//파일을 선택할 때
		let file = document.getElementById("file");
		
		//이벤트 연결
		file.onchange=function(){
			//파일 선택창에서 파일을 선택하지않고 취소한 경우
			if(!file.files[0]){
				image.src = '/ch03-JSP/images/face.png';
				submit_btn.style.display = 'none';
				return;
			}
			
			let reader = new FileReader();
			reader.readAsDataURL(file.files[0]);
			//FileReader가 선택된 파일을 다 읽으면 onload 발생
			reader.onload=function(){
				//미리보기 이미지 처리
				image.src = reader.result;
				//submit 버튼 노출
				submit_btn.style.display = '';
			};
		};
	};
</script>
</head>
<body>
<h2>프로필 사진 업로드하기</h2>
<img id="image" src="/ch03-JSP/images/face.png" width="200" height="200">
<form action="s06_profile.jsp" method="post" enctype="multipart/form-data">
	<input type="file" name="file" id="file" accept="image/png,image/jpeg,image/gif">
	<input type="submit" value="전송" style="display:none;" id="submit_btn">
</form>
</body>
</html>