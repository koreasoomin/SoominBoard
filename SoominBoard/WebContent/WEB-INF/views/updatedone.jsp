<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>주문 수정 완료</title>
</head>
<body>
	<p>
		주문번호 ${order.num} 주문을 정상적으로 수정하였습니다.<br>
		수정하신 주문내역은 다음과 같습니다.<br>
		아이템 : ${order.item}<br>
		수량 : ${order.qty}<br>
		테이블번호 : ${order.tn}<br>
		가격 : ${order.price}<br>
	</p>

	<div id="submit">
		<a href="/" >HOME</a> 
		<a href="/neworder">주문하기</a>
		<a href="/order/reupdate/${order.num}">${order.num}번 주문 수정하기</a>
		<a href="/deleteodr">주문 취소하기</a>
		
<%-- 		<a href="/order/redelete/${order.num}">${order.num}번 주문 취소하기</a>--%>	</div>


</body>
</html>