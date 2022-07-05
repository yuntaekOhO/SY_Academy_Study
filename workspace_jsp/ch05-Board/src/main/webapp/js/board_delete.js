window.onload=function(){
	//============== 삭제 폼 ============== 
	let delete_form = document.getElementById('delete_form');
	//이벤트 연결
	delete_form.onsubmit=function(){
		let passwd = document.getElementById('passwd');
		if(passwd.value.trim()==''){
			alert('비밀번호를 입력하세요');
			passwd.value = '';
			passwd.focus();
			return false;
		}
	};
};