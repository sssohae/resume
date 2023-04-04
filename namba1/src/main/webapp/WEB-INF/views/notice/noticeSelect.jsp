<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NOTICE INSERT</title>
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
		<table border="1" class="notice" width="820" align="center">
			<tr>
				<th>제 목</th>
				<td colspan="3">${notice.noticeTitle }</td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td colspan="3">${notice.noticeDate}</td>
			</tr>
			
			<c:if test="${not empty notice.noticeFile}">
			<tr>
			<th></th>
			<td><div align="center">
							<img src="namba1Img/${notice.noticeFile}" alt="">   							
						<!--  
							<c:if test="${notice.noticeFile}.substring(-2) eq pg and eg and ng">
							<video src="namba1Img/${notice.noticeFile}" width="600px" controls></video>
							</c:if>
							저장할때 칼럼 확장자만 저장하던가 
						-->
			</div>			
			</td>
			</tr>
			</c:if>
			
			<tr>
				<th>내 용</th>
				<td colspan="3">
				<textarea rows="10" cols="80">${notice.noticeSubject }</textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="3">
				${notice.noticeFile }
				</td>
			</tr>
		</table>
	</div>
	<br>
	<div align="center">
		<form id="frm" method="post">
			<c:if test="${userAuthor eq 'ADMIN' }">
			<button type="button" onclick="noticeEdit('E')">글수정</button>
			<button type="button" onclick="noticeEdit('D')">글삭제</button>
			</c:if>
			<input type="button" value="목록"
				onclick="location.href='noticeList.do'"> <input
				type="hidden" name="noticeId" value="${notice.noticeId }">
		</form>
	</div>
	<br>
	<br>
	<script type="text/javascript">
		function noticeEdit(str) {
			if (str == 'E') {
				frm.action = "noticeEditForm.do";
			} else {
				let yn = confirm("정말 삭제하시겠습니까?");
				if (yn) {
					frm.action = "noticeDelete.do";
				} else {
					return false;
				}
			}

			frm.submit();
		}
	</script>
</body>
</html>