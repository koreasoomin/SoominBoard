<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 조회</title>
</head>

<body>
	<h2>주문 조회 페이지</h2>
	<table>
		<colgroup>
			<col style="width: 5%;" />
			<col style="width: auto;" />
			<col style="width: 15%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
		</colgroup>

		<thead>
			<tr>
				<th>주문번호</th>
				<th>주문 아이템</th>
				<th>주문 가격</th>
				<th>주문 수량</th>
				<th>테이블 번호</th>
			</tr>
		</thead>

		<tbody>
			<c:choose>
				<c:when test="${empty getOrderList }">
					<tr>
						<td colspan="5" align="center">데이터가 없습니다.</td>
					</tr>
				</c:when>

				<c:when test="${!empty getOrderList}">
					<c:forEach var="/list" items="${getOrderList}">
						<tr>
							<td><c:out value="${list.num}" /></td>
							<td><c:out value="${list.item}" /></td>
							<td><c:out value="${list.price}" /></td>
							<td><c:out value="${list.qty}" /></td>
							<td><c:out value="${list.tn}" /></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</tbody>
	</table>
	<div id="submit">
		<a href="/" class="waves-effect waves-green btn-flat" id="order-CONFIRM-BTN">확인</a> 
	</div>

</body>

</html>