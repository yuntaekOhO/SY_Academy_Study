window.onload=function(){
	//============== 등록,수정 폼 ============== 
	let form = document.getElementById('write_form');
	//이벤트 연결
	form.onsubmit=function(){
		let title = document.getElementById('title');
		if(title.value.trim()==''){
			alert('제목을 입력하세요');
			title.value = '';
			title.focus();
			return false;
		}

		let name = document.getElementById('name');
		if(name.value.trim()==''){
			alert('이름을 입력하세요');
			name.value = '';
			name.focus();
			return false;
		}

		let passwd = document.getElementById('passwd');
		if(passwd.value.trim()==''){
			alert('비밀번호를 입력하세요');
			passwd.value = '';
			passwd.focus();
			return false;
		}

		let content = document.getElementById('content');
		if(content.value.trim()==''){
			alert('내용을 입력하세요');
			content.value = '';
			content.focus();
			return false;
		}
	};
};