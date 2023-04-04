<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<title>MY PAGE</title>
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
						<h2>계정관리</h2>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Normal Breadcrumb Begin -->
	<section>
		<br> <br> <br> <br>	<br> <br> <br> <br>

		<form action="pwCheck.do" method="post" class="amform">
			<div>
				<input type="hidden" id="userEmail" name="userEmail"
					value="${userEmail }">
			</div>
			<div>
				<label for="userPassword">비밀번호 확인</label> <input type="password"
					id="userPassword" name="userPassword" required="required"
					placeholder="비밀번호를 입력하세요">
					<br>
			</div>
			<br><br>
			<div>
				<input type="submit" value="확인">&nbsp;&nbsp; <input
					type="reset" onclick="location.href='myPage.do'" value="취소">
			</div>

		</form>
		<br> <br> <br> <br>	<br> <br> <br> <br>
	</section>
	<!-- Signup Section End -->

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

</body>

</html>