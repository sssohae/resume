<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<title>signUp</title>
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
						<h2>Sign Up</h2>
						<p>Welcome to the official Anime blog.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	iafter
	<!-- Normal Breadcrumb End -->

	<!-- Signup Section Begin -->
	<section class="signup spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="row d-flex justify-content-center">
						<div class="signup__form">
							<h3>Sign Up</h3>
						 <form action="userJoin.do" onsubmit="return formCheck()">
								<div class="input__item">
									<input type="text" id="userEmail" name="userEmail" placeholder="Email address" required="required"> 
									<span class="icon_mail"></span>
									<button type="submit" class="site-btn" onclick="idChk()" id="btnId" value="No">Email address 중복체크</button>	
								</div>
								<div class="input__item">
									<input type="text" id="userNickname" name="userNickname" placeholder="Nick Name" required="required"> <span
										class="icon_profile"></span>
								</div>
								<div class="input__item">
									<input type="password" id="userPassword" name="userPassword" placeholder="Password" required="required"> <span
										class="icon_lock"></span>
								</div>
								<div class="input__item">
									<input type="password" id="passwordChk" placeholder="Check Password" required="required"> <span
										class="icon_lock"></span>
								</div>
								<button type="submit" class="site-btn">complete</button>
							</form>
						</div>
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

<script type="text/javascript">
	function formCheck() { // 유저 아이디 중복체크 및 패스워드 종일성 확인
		let pass1 = document.getElementById("userPassword").value;
		let pass2 = document.getElementById("passwordChk").value; 
		let checkId = document.getElementById("btnId").value;
		
		if(checkId == "No"){
			alert("이메일 중복체크를 하세요!");
			return false;
		}
		
		
		if(pass1 != pass2){
			alert("패스워드가 일치하지 않습니다!");
			document.getElementById("userPassword").value="";
			document.getElementById("passwordChk").value="";
			document.getElementById("userPassword").focus();
			return false;
		}
		
		return true;
	}
	
	function idChk() {  //아이디 중복체크 Ajax로 비교 
		let id = document.getElementById("userEmail").value;
		let url = 'ajaxuserIdCheck.do?userEmail='+userEmail;
		fetch(url).then((response)=>response.text())
		.then((data)=>idCheck(data));
	}
	
	function idCheck(str) {
		if(str == '1'){
			alert("사용할 수 있는 이메일 입니다.");
			document.getElementById("btnId").value = 'Yes';
			document.getElementById("btnId").disabled = true; //버튼 비활성화
		}else{
			alert("이미 사용하고 있는 이메일 입니다. 다시 입력하세요.");
			document.getElementById("userEmail").value="";
			document.getElementById("userEmail").focus();
		}
	}
</script>

</body>

</html>