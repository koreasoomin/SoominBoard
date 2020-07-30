<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 수정</title>

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
function getUpdateNum() {
	var num = $("#num").val();
	
	if(num==null||num==""){
		alert("주문 번호를 입력하세요.");
		return;
	}
	
	var jobj = new Object();
	jobj.num = num;
	
	ajaxJson("/order/get_updatenum", null, jobj, function(dat){
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
				alert("수정하실 주문번호는 " + message.code + " 입니다.");
				document.location.href="/order/updateodr/"+message.code;
			} else {
				alert("존재하지 않는 주문번호 입니다.\n" + message + "를 다시 입력해주시기 바랍니다.");
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
    	getUpdateNum();
    });
    
});
     
</script>
</head>


<body>
<h2>주문 수정 페이지</h2>

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

