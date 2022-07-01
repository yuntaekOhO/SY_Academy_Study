window.onload=function(){
	let myForm = document.getElementById('myForm');
	//이벤트 연결
	myForm.onsubmit=function(){
		let name = document.getElementById('name');
		if(name.value.trim()==''){
			alert('이름을 입력하세요!');
			name.value = ''; //공백이 있으면 공백 제거
			name.focus();
			return false;
		}
		
		let title = document.getElementById('title');
		if(title.value.trim()==''){
			alert('제목을 입력하세요!');
			title.value = ''; //공백이 있으면 공백 제거
			title.focus();
			return false;
		}
		
		let passwd = document.getElementById('passwd');
		if(passwd.value.trim()==''){
			alert('비밀번호를 입력하세요!');
			passwd.value = ''; //공백이 있으면 공백 제거
			passwd.focus();
			return false;
		}
		
		let content = document.getElementById('content');
		if(content.value.trim()==''){
			alert('내용을 입력하세요!');
			content.value = ''; //공백이 있으면 공백 제거
			content.focus();
			return false;
		}
	};
};