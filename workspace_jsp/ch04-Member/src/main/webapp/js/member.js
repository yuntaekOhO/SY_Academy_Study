$(function(){
	//0은 id 중복체크 미실시, id 중복
	//1은 id 미중복
	let count = 0;
	
	//===================== 회원가입 폼 =====================//
	//이벤트 연결
	$('#confirm_id').click(function(){
		if($('#id').val().trim()==''){
			alert('아이디를 입력하세요');
			$('#id').val('').focus();
			return;
		}
		//서버 프로그램과 연동
		$.ajax({
			url:'confirmId.jsp',
			type:'post',
			data:{id:$('#id').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(param){
				if(param.result == 'idDuplicated'){
					count = 0;
					$('#id_signed').text('아이디 중복').css('color','red');
				}else if(param.result == 'idNotFound'){
					count = 1;
					$('#id_signed').text('사용 가능 아이디').css('color','black');
				}else{
					count = 0;
					alert('오류 발생');
				}
			},
			error:function(){
				count = 0;
				alert('네트워크 오류 발생');
			}
		});
	});//end of click
	
	//아이디를 입력하면 입력창 초기화
	$('#register_from #id').keydown(function(){
		count = 0;
		$('#id_signed').text('');
	});//end of keydown
	
	//submit 이벤트 처리
	$('#register_form').submit(function(){
		if($('#id').val().trim()==''){
			alert('아이디를 입력하세요');
			$('#id').val('').focus();
			return false;
		}
		if(count == 0){
			alert('아이디 중복체크 필수');
			return false;
		}
		
		if($('#name').val().trim()==''){
			alert('이름을 입력하세요');
			$('#name').val('').focus();
			return false;
		}
		
		if($('#passwd').val().trim()==''){
			alert('비밀번호을 입력하세요');
			$('#passwd').val('').focus();
			return false;
		}
		
		if($('#email').val().trim()==''){
			alert('이메일을 입력하세요');
			$('#email').val('').focus();
			return false;
		}
	});//end of submit
	
	//===================== 회원 로그인 폼 =====================//
	//submit 이벤트 연결
	$('#login_form').submit(function(){
		if($('#id').val().trim()==''){
			alert('아이디를 입력하세요');
			$('#id').val('').focus();
			return false;
		}
		
		if($('#passwd').val().trim()==''){
			alert('비밀번호를 입력하세요');
			$('#passwd').val('').focus();
			return false;
		}
	});//end of submit
	
	//===================== 회원 수정 =====================//
	//submit 이벤트 처리
	$('#modify_form').submit(function(){
		if($('#name').val().trim()==''){
			alert('이름을 입력하세요');
			$('#name').val('').focus();
			return false;
		}
		
		if($('#passwd').val().trim()==''){
			alert('비밀번호을 입력하세요');
			$('#passwd').val('').focus();
			return false;
		}
		
		if($('#email').val().trim()==''){
			alert('이메일을 입력하세요');
			$('#email').val('').focus();
			return false;
		}
	});//end of submit
	
	//===================== 회원 탈퇴 비밀번호 확인 =====================//
	$('#delete_form').submit(function(){
		if($('#id').val().trim()==''){
			alert('아이디를 입력하세요');
			$('#id').val('').focus();
			return false;
		}
		
		if($('#passwd').val().trim()==''){
			alert('비밀번호를 입력하세요');
			$('#passwd').val('').focus();
			return false;
		}
		
		if($('#cpasswd').val().trim()==''){
			alert('비밀번호 확인을 입력하세요');
			$('#cpasswd').val('').focus();
			return false;
		}
		
		if($('#passwd').val()!=$('#cpasswd').val()){
			alert('비밀번호와 비밀번호 확인이 불일치합니다.');
			$('cpasswd').val('');//데이터 초기화
			$('cpasswd').focus();
			return false;
		}
		
	});//end of submit
	
});