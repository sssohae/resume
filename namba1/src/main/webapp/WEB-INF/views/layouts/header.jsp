<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="header">
	<div class="container">
		<div class="row">
			<div class="col-lg-2">
				<div class="header__logo">
					<a href="./main.do"> <img src="img/logo.png" alt="">
					</a>
				</div>
			</div>
			<div class="col-lg-8">
				<div class="header__nav">
					<nav class="header__menu mobile-menu">
						<ul>
							<li class="active"><a href="./main.do">메인 홈</a></li>
							<li><a href="./categories.do">카테고리</a></li>
							<li><a href="./jjim.do">찜</a></li>
							<li><a href="./newMovie.do">새로운영화</a></li>
							<li><a href="./noticeList.do">공지사항</a></li>
							<li class="on"><c:if test="${not empty userEmail }">
									<b>ON</b>
								</c:if></li>
						</ul>
					</nav>
				</div>
			</div>
			<div class="col-lg-2">
				<div class="header__right">
					<a href="#" class="search-switch"><img src="img/search.png"
						alt=""></a>
					<c:if test="${not empty userEmail }">
						<a href="./myPage.do"><img src="img/member.png" alt=""></a>
					</c:if>
					<!--로그인한경우 exit 아이콘 클릭하면 바로 로그아웃 / 안한경우 로그인페이지-->
					<c:if test="${empty userEmail }">
						<a href="./userLoginForm.do"><img src="img/exit.png" alt="">
						</a>
					</c:if>
					<c:if test="${not empty userEmail }">
						<a href="./userLogout.do" onclick="return controlLogout();"><img
							src="img/exit.png" alt=""></a>
					</c:if>
				</div>
			</div>
		</div>
		<div id="mobile-menu-wrap"></div>
	</div>
</header>