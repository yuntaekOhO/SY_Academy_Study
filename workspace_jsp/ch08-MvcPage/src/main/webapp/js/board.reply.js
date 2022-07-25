$(function(){
	let currentPage;
	let count;
	let rowCount;
	
	//댓글 목록
	function selectList(pageNum){
		
	}
	
	//페이지 처리 이벤트 연결(다음 댓글 보기 버튼 클릭시 데이터 추가)
	$('.paging-button input').click(function(){
		selectList(currentPage + 1);
	});
	
	//댓글 등록
	$('#re_form').submit(function(event){
		if($('#re_content').val().trim()==''){
			alert('내용을 입력하세요');
			$('#re_content').val('').focus();
			return false;
		}
		//form 이하의 태그에 입력한 데이터를 모두 읽어옴 : key, value 형태로
		let form_data = $(this).serialize();
		//댓글 등록을 위한 서버 프로그램 연동
		$.ajax({
			url:'writeReply.do',
			type:'post',
			data:form_data,
			datatype:'json',
			cache:false,
			timeout:30000,
			success:function(param){
				if(param.result=='logout'){
					alert('로그인해야 작성할 수 있습니다');
				}else if(param.result=='success'){
					//폼 초기화
					initForm();
					//댓글 작성이 성공하면 새로 삽입한 글을 포함해서 첫번째 페이지의 게시글을 다시 호출함
					selectList(1);
				}
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});
		
		//기본 이벤트 제거
		event.preventDefault();
	});
	
	//댓글 작성 폼 초기화
	function initForm(){
		$('textarea').val('');
		$('#re_first .letter-count').text('300/300');
	}
	
	//textarea에 내용 입력시 글자 수 체크
	$(document).on('keyup','textarea',function(){
		//입력한 글자수 구함
		let inputLength = $(this).val().length;
		if(inputLength > 300){//300자 넘음        0~299
			$(this).val($(this).val().substring(0,300));
		}else{//300자 이내
			let remain = 300 - inputLength;
			remain += '/300';
			if($(this).attr('id')=='re_content'){//등록
				//등록폼 글자수 처리
				$('#re_first .letter-count').text(remain);
			}else{//수정 mre_content
				//수정폼 글자수 처리
				$('#mre_first .letter-count').text(remian);
			}
		}
	});
	
	//댓글 수정 버튼 클릭시 수정폼 노출
	$(document).on('click','.modify-btn',function(){
		
	});
	
	//수정폼에서 취소 버튼 클릭시 수정폼 초기화
	$(document).on('click','.re-reset',function(){
		initModifyForm();
	});
	
	//댓글 수정 폼 초기화
	function initModifyForm(){
		
	}
	
	//댓글 수정
	$(document).on('submit','#mre_form',function(event){
		
	});
	
	//댓글 삭제
	$(document).on('click','.delete-btn',function(){
		
	});
	
	//초기 데이터(목록) 호출
	selectList(1);
	
});