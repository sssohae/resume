<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<title>ACCOUNT MANAGE</title>
</head>
	<script src="js/noticeAjaxFetch.js"></script>
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
	<!-- Normal Breadcrumb End -->

	<!-- Signup Section Begin -->
	<section class="signup spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="login__form">
						<h3>PROFILE</h3>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="blog__item small__item set-bg"
								data-setbg="img/blog/man.png">
								<div class="blog__item__text"></div>
							</div>
						</div>
						<h5 id="dia">
							NICK NAME : ${Nickname }
							<c:if test="${not empty cardNumber }">
								<img src="img/diamond.png" alt="">
							</c:if>
							<br>
							with NAMBA1 : ${joinDate }
						</h5>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login__social__links">
						<div class="col	">


							<form class="amform" action="userUpdateAjax.do" method="post">
								<br> <br>
								<div>
								   <input type="hidden" id="userEmail" name="userEmail" value ="${userEmail }">
								</div>

								<div class="col-8"></div>
								<br>
								<div class="col-8">
								<p id="pwP">현재 비밀번호 : ${userPassword }</p>
									<label for="nPw">새 비밀번호</label> <input id="nPw" name="userPassword" type="password" >
									<button type="submit" id="btnNp" class="change">변경</button>
								</div>
								<br>
								<div class="col-8">
								<p id="telP">현재 전화번호 : ${userTel } </p>
									<label for="nTel">새 전화번호</label> <input id="nTel" name="userTel" type="tel" >
									<button type="submit" id="btnNt" class="change" >변경</button>
								</div>
								<br>
								<div class="col-8">
								<c:if test="${empty cardNumber}">
								<p id="cardP">현재 결제수단 : 없음 </p>
								</c:if>	
								<c:if test="${not empty cardNumber}">
								<p id="cardP">현재 결제수단 : ${cardNumber } </p>
								</c:if>
									<label for="card">새 결제수단</label> <input id="card" name ="cardNumber" type="text" placeholder="0000-0000-0000-0000">
									<button type="submit" id="btnC" class="change">변경</button>
									</div>
									<br>
							</form>
						</div>
						<fieldset>
							<br> <br>
							<div>
								<input type="submit" value="변경완료"
									onclick="location.href='myPage.do'">&nbsp;&nbsp;
							</div>
						</fieldset>

					</div>
				</div>


			</div>
		</div>
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