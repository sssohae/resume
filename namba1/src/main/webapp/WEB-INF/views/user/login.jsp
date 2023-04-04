<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<title>login</title>
<meta name ="google-signin-client_id" content="939067639835-vhj0d6shfe5c8pjh7hldbo0feujcsnlp.apps.googleusercontent.com">
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Normal Breadcrumb Begin -->
	<section class="normal-breadcrumb set-bg"
		data-setbg="img/normal-breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="normal__breadcrumb__text">
						<h2>Login</h2>
						<p>Welcome to the NAMBA1 MOVIE.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Normal Breadcrumb End -->

	<!-- Login Section Begin -->
	<section class="login spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="login__form">
						<h3>Login</h3>
                        <form id="frm" action="userLogin.do" method="post">
                        
							<div class="input__item">
								<input type="text" id="userEmail" name="userEmail" required="required" placeholder="Email address"> <span
									class="icon_mail"></span>
							</div>
							<div class="input__item">
                                <input type="password" id="userPassword" name="userPassword" required="required" placeholder="Password">
								<span class="icon_lock"></span>
							</div>
							<button type="submit" class="site-btn">Login Now</button>
						</form>
						<a href="findPw.do" class="forget_pass">Forgot Your Password?</a>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login__register">
						<h3>Dont’t Have An Account?</h3>
						<a href="userJoinForm.do" class="primary-btn">Register Now</a>
					</div>
				</div>
			</div>
			<div class="login__social">
				<div class="row d-flex justify-content-center">
					<div class="col-lg-6">
						<div class="login__social__links">
							<span>or</span>
							<ul>
								<li><a href="#" class="facebook"><i
										class="fa fa-facebook"></i> Sign in With Facebook</a></li>
								<li id="GgCustomLogin">
								<a href="javascript:void(0)" class="google"><i 
								class="fa fa-google"></i> Sign in With Google</a></li>
								<li><a href="#" class="twitter"><i
										class="fa fa-twitter"></i> Sign in With Twitter</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Login Section End -->

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
function init() {
	gapi.load('auth2', function() {
		gapi.auth2.init();
		options = new gapi.auth2.SigninOptionsBuilder();
		options.setPrompt('select_account');
        // 추가는 Oauth 승인 권한 추가 후 띄어쓰기 기준으로 추가
		options.setScope('email profile openid https://www.googleapis.com/auth/user.birthday.read');
        // 인스턴스의 함수 호출 - element에 로그인 기능 추가
        // GgCustomLogin은 li태그안에 있는 ID, 위에 설정한 options와 아래 성공,실패시 실행하는 함수들
		gapi.auth2.getAuthInstance().attachClickHandler('GgCustomLogin', options, onSignIn, onSignInFailure);
	})
}

function onSignIn(googleUser) {
	var access_token = googleUser.getAuthResponse().access_token
	$.ajax({
    	// people api를 이용하여 프로필 및 생년월일에 대한 선택동의후 가져온다.
		url: 'https://people.googleapis.com/v1/people/me'
        // key에 자신의 API 키를 넣습니다.
		, data: {personFields:'birthdays', key:'AIzaSyCP30LkzwjzIVtMiS1SdCuBgit_HQSUNsU', 'access_token': access_token}
		, method:'GET'
	})
	.done(function(e){
        // 프로필을 가져온다.
		var profile = googleUser.getBasicProfile();
		console.log(profile)
	})
	.fail(function(e){
		console.log(e);
	})
}

function onSignInFailure(t){		
	console.log(t);
}
</script>

<!-- 구글 api 사용을 위한 스크립트  -->
<script src="https://apis.google.com/js/platform.js?onload=init" async defer type="text/javascript"></script>
</body>

</html>