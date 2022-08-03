$(function(){
	//==========상품 등록 유효성 체크===========//
	$('#write_form').submit(function(){
		if($('input[type=radio]:checked').length < 1){
			alert('상품표시여부를 지정하세요');
			return false;
		}
		if($('#name').val()==''){
			alert('상품명을 입력하세요');
			$('#name').focus();
			return false;
		}
		if($('#price').val()==''){
			alert('가격을 입력하세요');
			$('#price').focus();
			return false;
		}
		if($('#quantity').val()==''){
			alert('수량을 입력하세요');
			$('#quantity').focus();
			return false;
		}
		if($('#photo1').val()==''){
			alert('상품사진1을 입력하세요');
			$('#photo1').focus();
			return false;
		}
		if($('#photo2').val()==''){
			alert('상품사진2을 입력하세요');
			$('#photo2').focus();
			return false;
		}
		if($('#detail').val().trim()==''){
			alert('상품설명을 입력하세요');
			$('#detail').val('').focus();
			return false;
		}
	});
	
	//==========상품관리 검색 유효성 체크===========//
	$('#search_form').on('submit',function(){
		if($('#keyword').val().trim()==''){
			alert('검색어를 입력하세요');
			$('#keyword').val('').focus();
			return false;
		}
	});
	
});



