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
						<h2>MY PAGE</h2>
						<h3>
							<b>${message }님 안녕하세요</b>
						</h3>
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
						<h5>
							NICK NAME : ${message }
							<c:if test="${not empty cardNumber }">
								<img src="img/diamond.png" alt="">
							</c:if>
							<br> with NAMBA1 : ${message2 }
						</h5>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login__social__links">
						<br> <br>
						<ul>
							<li><a href="./pwCheckForm.do" class=""> 계정관리</a></li>
							<li><details>
									<summary>고객센터</summary>
									<p>0000-****(평일/주말09~08시, 공휴일 휴무)</p>
								</details></li>
							<li><details>
									<summary>이용약관</summary>
									<p>
										<b>제 1장 총칙</b><br> 제 1조(목적)<br> 제 2조[정의]<br> 제
										3조[신원정보등의 제공]<br> <br> <b>제 2장 회원가입...</b><br>
									</p>
								</details></li>
							<li><details>
									<summary>개인정보처리방침</summary>
									<p>
										본 방침은 2023년 1월 1일부터 적용됩니다.<br> 총칙<br> 임당 은(이하 ‘회사’)
										NAMBA1 서비스를 이용하는 회원의 개인정보 보호를 소중하게 생각하고, 회원의 개인정보를 보호하기 위하여 항상
										최선을 다해 노력하고 있습니다.<br> 회사는 개인정보 보호 관련 주요 법률인 개인정보 보호법,
										정보통신망 이용촉진 및 정보보호 등에 관한 법률(이하 “정보통신망법”이라고 합니다)을 비롯한 모든 개인정보
										보호에 관련 법률 규정 및 국가기관 등이 제정한 고시, 훈령, 지침 등을 준수합니다. 본 개인정보처리방침은
										회사의 서비스를 이용하는 회원에 대하여 적용되며, 회원이 제공하는 개인정보가 어떠한 용도와 방식으로 이용되고
										있으며, 개인정보 보호를 위하여 회사가 어떠한 조처를 취하고 있는지 알립니다.
									</p>
									<hr>
									<p>
										개인정보의 수집·이용에 대한 동의 회사는 적법하고 공정한 방법에 의하여 서비스 이용계약의 성립 및 이행에 필요한
										최소한의 개인정보를 수집하며 이용자의 개인 식별이 가능한 개인정보를 수집하기 위하여 회원가입시 개인정보수집·이용
										동의에 대한 내용을 제공하고 회원이 ‘동의’ 버튼을 클릭하면 개인정보 수집·이용에 대해 동의한 것으로 봅니다.
										<br> 개인정보의 수집범위 및 수집방법...
									</p>
								</details></li>

							<li><a href="./emptypage.html" class=""> 회원탈퇴</a></li>
						</ul>
					</div>
				</div>
				<!--      <div class="col-lg-12">
                    <div class="row d-flex justify-content-center">
                        <button type="submit" class="site-btn">Logout</button>
                    </div>
                </div>-->
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
<script type="text/javascript">

</script>

	<!-- Search model end -->

</body>

</html>