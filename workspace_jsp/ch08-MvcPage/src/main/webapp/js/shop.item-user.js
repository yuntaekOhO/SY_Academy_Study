$(function(){
	//======상품 상세 - 주문 수량 변경=======//
	$('#order_quantity').on('keyup mouseup',function(){
		if($('#order_quantity').val()==''){
			$('#item_total_txt').text('총주문 금액 : 0원');
			return;
		}
		if(isNaN($('#order_quantity').val())){
			$('#order_quantity').val('');
			return;
		}
		if($('#order_quantity').val()<=0){
			$('#order_quantity').val('');
			return;
		}
		if(Number($('#item_quantity').val()) < $('#order_quantity').val()){
			alert('수량이 부족합니다.');
			$('#order_quantity').val('');
			$('#item_total_txt').text('총주문 금액 : 0원');
			return;
		}
		
		let total = $('#item_price').val() * $('#order_quantity').val();
		$('#item_total_txt').text('총주문 금액 : '+ $.number(total) + '원');
	});
	
	//======상품 상세 - 장바구니에 상품 담기=======//
	$('#item_cart').submit(function(event){
		if($('#order_quantity').val()==''){
			alert('수량을 입력하세요');
			$('#order_quantity').focus();
			return false;
		}
		
		let form_data = $(this).serialize();
		
		$.ajax({
			url:'../cart/write.do',
			type:'post',
			data:form_data,
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(param){
				if(param.result=='logout'){
					alert('로그인 후 사용하세요');
				}else if(param.result=='success'){
					alert('장바구니에 담았습니다');
					location.href='../cart/list.do';
				}else if(param.result=='overquantity'){
					alert('기존에 주문한 상품입니다. 개수를 추가하면 재고가 부족합니다');
				}
				
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});
		//기본이벤트 제거
		event.preventDefault();
	});
});