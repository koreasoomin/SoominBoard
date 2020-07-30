<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<%
// 만약 다음과 같이 EL 구문을 문자열 그대로 출력하고 싶다면 어떻게 해야 할까요? 
//page 디렉티브의 isELIgnored값을 true로 지정해줄수도 있겠지만 이경우 반대로 EL이 적용되지 않는 문제가 있습니다.
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문완료</title>
</head>
<body>
	<p>
		주문번호 ${order.num} 주문이 완료되었습니다.<br>
		주문내역은 다음과 같습니다.<br>
		아이템 : ${order.item}<br>
		수량 : ${order.qty}<br>
		테이블번호 : ${order.tn}<br>
		가격 : ${order.price}<br>
	</p>

	<div id="submit">
		<a href="/" >HOME</a> 
		<a href="/neworder">주문하기</a>
		<a href="/order/reupdate/${order.num}">${order.num}번 주문 수정하기</a>
		<a href="/order/redelete/${order.num}">${order.num}번 주문 취소하기</a>
	</div>


</body>
</html>