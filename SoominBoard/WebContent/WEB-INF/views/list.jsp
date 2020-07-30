<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문조회</title>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/materialize.1.0.css">
<link rel="stylesheet" type="text/css" href="/css/twosome.css">
<style type="text/css">
#submit {
	padding-left: 50px;
}
</style>

<script type="text/javascript" src="/js/jquery-3.4.1-min.js"></script>
<script type="text/javascript" src="/js/materialize.js"></script>
<script type="text/javascript" src="/js/ajax.js"></script>
<script type="text/javascript" src="/js/twosome.js"></script>

<!-- <script type="text/javascript">
	// null 을 화면에 표시하지 않기 위한 간단한 함수
	function str(s) {
		return ((s == null || s == "null") ? "" : s);
	}

	// 페이지가 준비되면 초기화
	$(document).ready(function() {
		// 확인 버튼 이벤트 처리
		$("#order-CONFIRM-BTN").on("click", function() {
			getOrder();
		});
	});
</script> -->
</head>

<body>
	<div id="root">
		<header>
			<h1>게시판</h1>
		</header>
		<hr />

		<nav>홈 - 글 작성</nav>
		<hr />

		<h2>주문 조회 페이지</h2>
		<section id="container">
			<form role="form" method="post" action="/neworder">
				<table>
					<tr>
						<th>주문번호</th>
						<th>아이템</th>
						<th>가격</th>
						<th>수량</th>
						<th>테이블번호</th>
					</tr>

					<c:forEach items="${list}" var="list">
						<tr>
							<td><c:out value="${list.num}" /></td>
							<td><c:out value="${list.item}" /></td>
							<td><c:out value="${list.price}" /></td>
							<td><c:out value="${list.qty}" /></td>
							<td><c:out value="${list.tn}" /></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</section>
		<hr/>
	</div>



		<%-- <table>
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
				<th>아이템</th>
				<th>가격</th>
				<th>수량</th>
				<th>테이블번호</th>
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
--%>
		<div id="submit">
			<a href="/" class="waves-effect waves-green btn-flat"
				id="order-CONFIRM-BTN">확인</a>
		</div>
</body>
</html>

