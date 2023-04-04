<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Normal Breadcrumb Begin -->
	<section class="normal-breadcrumb set-bg" data-setbg="img/ticket.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="normal__breadcrumb__text">
						<h2>공지사항</h2>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Normal Breadcrumb End -->
	<br>
	<br>
	<div>
		<table border="1" class="notice" align="center">
			<thead>
				<tr>
					<th width="70" align="center">번호</th>
					<th width="500" align="center">제 목</th>
					<th width="150" align="center">작성일자</th>
					<th width="70" align="center">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty notices }">
					<tr>
						<td colspan="4" align="center">게시글이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${not empty notices }">
					<c:forEach items="${notices }" var="n">
						<tr onclick="noticeSelect('${n.noticeId}')">
							<td align="center">${n.noticeId }</td>
							<td align="center">${n.noticeTitle }
							<c:if test="${not empty n.noticeFile }">
							<img src = "img/attach.png" alt="">
							</c:if>
							</td>
							<td align="center">${n.noticeDate }</td>
							<td align="center">${n.noticeHit }</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	<br>
	<div align="center">
		<form id="frm" action="noticeSelect.do" method="post">
	<c:if test="${userAuthor eq 'ADMIN' }">
				<input type="button" value="작성" onclick="location.href='noticeInsertForm.do'">
	</c:if>
			<input type="hidden" id="noticeId" name="noticeId">
		</form>
	</div>
	<br>
	<br>
	


	<!-- Search model Begin -->
	<div class="search-model">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-switch">
				<i class="icon_close"></i>
			</div>
			<form class="search-model-form">
				<input type="text" id="search-input" placeholder="Search here.....">
			</form>
		</div>
	</div>

	<!-- Search model end -->

	<script type="text/javascript">
		function noticeSelect(id) { //선택글 상세보기
			document.getElementById("noticeId").value = id;
			frm.submit();
		}
	</script>
</body>

</html>