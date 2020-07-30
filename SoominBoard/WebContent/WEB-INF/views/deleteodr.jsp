<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 취소</title>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/materialize.1.0.css">
<link rel="stylesheet" type="text/css" href="/css/twosome.css">
<style type="text/css">
	#submit {
				padding-left:50px;
	}
</style>

<script type="text/javascript" src="js/jquery-3.4.1-min.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/twosome.js"></script>

<script type="text/javascript">

// null 을 화면에 표시하지 않기 위한 간단한 함수
function str(s) {
	return ((s==null || s=="null") ? "" : s);
}

// 주문 수
function deleteOrder() {
	var num = $("#num").val();
	var item = $("#item").val();
	var price = $("#price").val();
	var qty = $("#qty").val();
	var tn = $("#tn").val();
	
	
	if(num==null||num==""){
		alert("주문 번호를 입력하세요.");
		return;
	}
	
	var jobj = new Object();
	jobj.num = num;
	jobj.item = item;
	jobj.price = price;
	jobj.qty = qty;
	jobj.tn = tn;
	
	ajaxJson("/order/delete", null, jobj, function(dat){
		/*
			{
			    "result": "success",
			    "message": "{\"result\":\"success\",\"code\":6}"
			}		
		*/
		var json = JSON.parse(dat);
		if("success"==json.result) {
			var message = JSON.parse(json.message);
			if(message.result=="success") {
				alert("주문 취소 성공 : 취소하신 주문번호는 " + message.code + " 입니다.");
				document.location.href="/deletedone";
			} else {
				alert("잘못된 주문 번호 입니다.\n" + message + "를 다시 입력해주시기 바랍니다.");
			}
		} else {			
		}		
	}, function(err){
		alert(err);
	});		
	
}

// 페이지가 준비되면 초기화
$(document).ready(function() {
	// 확인 버튼 이벤트 처리
    $("#order-CONFIRM-BTN").on("click", function() {
    	deleteOrder();
    });
    
});
     
</script>


</head>


<body>
<h2>주문 취소 페이지</h2>

<div class="row">
	<div class="input-field s4">
		<input id="num" type="text" class="validate"><label for="num">주문 번호</label>
	</div>
</div>
 
<div id="submit">
	<a href="#" class="waves-effect waves-green btn-flat" id="order-CONFIRM-BTN">확인</a>
	<a href="/" class="waves-effect waves-red btn-flat" id="order-CANCEL-BTN">취소</a>
</div>

</body>
</html>

