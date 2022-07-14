$(function(){
	let idChecked = 0; //0:사용불가한 아이디, 1:사용가능한 아이디
	
	//================= 회원가입 =================//
	//id 중복체크 버튼 이벤트 연결
	$('#id_check').click(function(){
		if($('#id').val().trim()==''){
			alert('아이디를 입력하세요');
			$('#id').val('').focus();
			return;
		}
		
		//메세지 초기화 - 중복 메시지 span
		$('#message_id').text('');
		
		//서버와 데이터 통신
		$.ajax({
			url:'checkDuplicatedId.do',
			type:'post',
			data:{id:$('#id').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(param){
				if(param.result == 'idNotFound'){
					idChecked = 1;
					$('#message_id').css('color','#000000').text('등록 가능 ID');
				}else if(param.result == 'idDuplicated'){
					idChecked = 0;
					$('#message_id').css('color','red').text('중복된 ID');
					$('#id').val('').focus();
				}else{
					idChecked = 0;
					alert('아이디 중복체크 오류!!');
				}
			},
			error:function(){
				idChecked = 0;
				alert('네트워크 오류!!');
			}
		});//end of ajax
		
	});//end of click
	
	//아이디 중복 안내 메시지 초기화 및 아이디 중복 값 초기화
	$('#register_form #id').keydown(function(){
		idChecked = 0;
		$('#message_id').text('');
	});
	
	//회원 정보 등록 유효성 체크
	$('#register_form').submit(function(){
		if($('#id').val().trim()==''){
			alert('아이디를 입력하세요');
			$('#id').val('').focus();
			return false;
		}
		if(idChecked==0){
			alert('아이디 중복 체크 필수');
			return false;
		}
		if($('#name').val().trim()==''){
			alert('이름을 입력하세요');
			$('#name').val('').focus();
			return false;
		}
		if($('#passwd').val().trim()==''){
			alert('비밀번호를 입력하세요');
			$('#passwd').val('').focus();
			return false;
		}
		if($('#phone').val().trim()==''){
			alert('전화번호를 입력하세요');
			$('#phone').val('').focus();
			return false;
		}
		if($('#email').val().trim()==''){
			alert('이메일을 입력하세요');
			$('#email').val('').focus();
			return false;
		}
		if($('#zipcode').val().trim()==''){
			alert('우편번호를 입력하세요');
			$('#zipcode').val('').focus();
			return false;
		}
		if($('#address1').val().trim()==''){
			alert('주소를 입력하세요');
			$('#address1').val('').focus();
			return false;
		}
		if($('#address2').val().trim()==''){
			alert('나머지주소를 입력하세요');
			$('#address2').val('').focus();
			return false;
		}
	});//end of submit
	
	//================= 로그인 =================//
	//로그인 이벤트 연결
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
	
	//================= 프로필 사진 업데이트 =================//
	//프로필 사진 업데이트 이벤트 연결
	$('#photo_btn').click(function(){
		$('#photo_choice').show();//수정 버튼 누르면 display:none 설정해놨던 div 보이게 설정
		$(this).hide();//수정버튼 감추기
	});
	
	//이미지 미리보기
	//처음 화면에 보여지는(기본 혹은 이전에 설정한) 이미지 읽기
	let photo_path = $('.my-photo').attr('src');
	let my_photo;
	$('#photo').change(function(){
		my_photo = this.files[0];
		//이미지 선택 취소한 경우 (기본 또는 이전)이미지로 다시 설정
		if(!my_photo){
			//초기화 작업
			$('.my-photo').attr('src',photo_path);
			return;
		}
		
		//용량제한
		if(my_photo.size > 1024*1024){
			alert(Math.round(my_photo.size/1024) + 'kbytes(1024kbytes까지만 업로드 가능)');
			//초기화 작업
			$('.my-photo').attr('src',photo_path);
			$(this).val('');
			return;
		}
		
		//input file에서 선택한 이미지 미리보기 처리
		var reader = new FileReader();
		//my_photo(선택한 이미지 파일)을 base64 인코딩처리해서 읽어들임 : FileReader가 파일을 읽는 것
		//base64는 8비트 이진데이터를 아스키코드로 읽을 수 있음 ; 이미지,동영상 등 바이너리 파일 => 아스키코드로 변환
		reader.readAsDataURL(my_photo);
		reader.onload=function(){     //FileReader가 읽은 결과를 이미지 속성 src의 값으로 설정 
			$('.my-photo').attr('src',reader.result);
		};
		
	});//end of change
	
	//이미지 전송
	$('#photo_submit').click(function(){
		if($('#photo').val()==''){
			alert('파일을 선택하세요');
			$('#photo').focus();
			return;
		}
		
		//ajax로 파일 전송
		//FormData란 ajax로 폼 전송을하게 해주는 객체이다 : 요약)페이지 전환없이 폼 데이터 보낼때 사용 = 비동기
		//JSON 구조로 key-value 구조로 데이터 전송
		//주의사항 : 같은 key가 있어도 추가됨(덮어씌우지않음), 값은 문자열로 자동 변환
		let form_data = new FormData();
		//append : FormData에 키,값 추가하는 메서드 
				   //파라미터명(키), 값(file로 선택한 이미지파일)
		form_data.append('photo', my_photo);
		$.ajax({
			url:'updateMyPhoto.do',
			type:'post',
			data:form_data,
			dataType:'json',
			//default는 값을 문자열로 변환하기 때문에 속성을 지정해 줌
			contentType:false,//데이터 객체를 문자열로 바꿀지에 대한 값. true면 일반문자, false면 파일
			processData:false,//해당 속성이 true면 일반 text로 구분
			enctype:'multipart/form-data',//파일업로드할 경우 명시
			success:function(param){
				if(param.result == 'logout'){
					alert('로그인 후 사용하세요');
					//로그인 폼으로 리다이렉트
					//location.replace('loginForm.do');
				}else if(param.result == 'success'){
					alert('프로필 사진이 수정되었습니다');
					photo_path = $('.my-photo').attr('src');
					//수정버튼 누르기 전으로 초기화
					$('#photo').val('');
					$('#photo_choice').hide();
					$('#photo_btn').show();
				}else{
					alert('파일 전송 오류 발생');
				}
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});
	});//end of click
	
	//이미지 미리보기 취소
	$('#photo_reset').click(function(){
		//이미지 미리보기 전 원래 이미지로 되돌리기
		$('.my-photo').attr('src',photo_path);
		$('#photo').val('');
		$('#photo_choice').hide();
		$('#photo_btn').show();//수정 버튼 노출
	});//end of click
	
	
	//================= 회원정보수정 =================//
	$('#modify_form').submit(function(){
		if($('#name').val().trim()==''){
			alert('이름을 입력하세요');
			$('#name').val('').focus();
			return false;
		}
		if($('#phone').val().trim()==''){
			alert('전화번호를 입력하세요');
			$('#phone').val('').focus();
			return false;
		}
		if($('#email').val().trim()==''){
			alert('이메일을 입력하세요');
			$('#email').val('').focus();
			return false;
		}
		if($('#zipcode').val().trim()==''){
			alert('우편번호를 입력하세요');
			$('#zipcode').val('').focus();
			return false;
		}
		if($('#address1').val().trim()==''){
			alert('주소를 입력하세요');
			$('#address1').val('').focus();
			return false;
		}
		if($('#address2').val().trim()==''){
			alert('나머지 주소를 입력하세요');
			$('#address2').val('').focus();
			return false;
		}
	});
	
	//================= 비밀번호수정 =================//
	$('#password_form').submit(function(){
		if($('#id').val().trim()==''){
			alert('아이디를 입력하세요');
			$('#id').val('').focus();
			return false;
		}
		if($('#origin_passwd').val().trim()==''){
			alert('현재 비밀번호를 입력하세요');
			$('#origin_passwd').val('').focus();
			return false;
		}
		if($('#passwd').val().trim()==''){
			alert('새 비밀번호를 입력하세요');
			$('#passwd').val('').focus();
			return false;
		}
		if($('#cpasswd').val().trim()==''){
			alert('새 비밀번호 확인을 입력하세요');
			$('#cpasswd').val('').focus();
			return false;
		}
		//"새 비밀번호"와 "새 비밀번호 확인"이 서로 불일치
		if($('#passwd').val() != $('#cpasswd').val()){
			alert('새 비밀번호와 새 비밀번호 확인 불일치');
			$('#passwd').val('').focus();
			$('#cpasswd').val('');
			return false;
		}
	});//end of submit
	
	//새비밀번호 확인까지 한 후 다시 새비밀번호를 수정하면 새비밀번호 확인 및
	//메시지 초기화
	$('#passwd').keyup(function(){
		$('#cpasswd').val('');
		$('#message_cpasswd').text('');
	});
	
	//새 비밀번호와 새 비밀번호 확인 일치시 메시지 처리
	$('#cpasswd').keyup(function(){
		if($('#passwd').val() == $('#cpasswd').val()){
			$('#message_cpasswd').text('새 비밀번호 일치');
		}else{
			$('#message_cpasswd').text('');
		}
	});//end of keyup
	
	
	//================= 회원탈퇴 =================//
	$('#delete_form').submit(function(){
		if($('#id').val().trim()==''){
			alert('아이디를 입력하세요');
			$('#id').val('').focus();
			return false;
		}
		if($('#email').val().trim()==''){
			alert('이메일을 입력하세요');
			$('#email').val('').focus();
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
			alert('비밀번호와 비밀번호 확인 불일치');
			$('#passwd').val('').focus();
			$('#cpasswd').val('');
			return false;
		}
	});//end of submit
	
	//비밀번호 확인까지 한 후 다시 비밀번호를 수정하면 비밀번호 확인 및
	//메시지 초기화
	$('#passwd').keyup(function(){
		$('#cpasswd').val('');
		$('#message_id').text('');
	});
	
	//비밀번호와 비밀번호 확인 일치 여부 체크
	$('cpasswd').keyup(function(){
		if($('#passwd').val()==$('#cpasswd').val()){
			$('#message_id').text('비밀번호 일치');
		}else{
			$('#message_id').text('');
		}
	});
	
});

















