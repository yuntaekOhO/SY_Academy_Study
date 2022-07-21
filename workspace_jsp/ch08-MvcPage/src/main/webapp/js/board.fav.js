$(function(){
	let status;
	
	//좋아요 선택 여부와 선택한 총 개수 읽기
	function selectData(board_num){
		
	}
	
	//좋아요 등록
	$('#output_fav').click(function(){
		$.ajax({
			url:'writeFav.do',
			type:'post',
			data:{board_num:$('#board_num').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(param){
				if(param.result=='logout'){
					alert('로그인 후 좋아요를 눌러주세요');
				}else if(param.result=='success'){
					displayFav(param);
				}else{
					alert('등록 오류 발생');
				}
			},
			error:function(){
				alert('네트워크 오류');
			}
		});
	});
	//좋아요 표시
	function displayFav(data){
		
	}
	//초기 데이터 표시
	//selectData($('#board_num').val());
	
});