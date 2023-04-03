/**
 * joinCheck.js
 */
 $(function(){
	//체크박스 처리
	//전체 체크 클릭
	$('#chkAll').on('click', function(e){
		let ckOk = $(e.target).is(":checked")
		if(ckOk){
			$('.chk').attr("checked", true)
			$('#agree').val('true')
		}else{
			$('.chk').attr("checked", false)
			$('#agree').val('false')
		}
	})
	
	$('.chk').on('click', function(){
	   console.log($('input[class="chk"]:checked').length)
	   //체크개별항목 체크 클릭
	   if($('input[class="chk"]:checked').length >= 4){
			$('#chkAll').attr("checked", true)
			$('#agree').val('true')
		}else{
			$('#chkAll').attr("checked", false)
			$('#agree').val('false')
		}
		//필수체크항목
		let chk1 = $('#chk1').is(":checked")
		let chk2 = $('#chk2').is(":checked")
		if(chk1 && chk2){
			$('#agree').val('true')
			console.log($('#agree').val())
		}else{
			$('#agree').val('false')
			console.log($('#agree').val())
		}
	})
	
	//아이디 체크
	$('#id').blur(function(){
		var id = $('#id').val()
		var idType = /^[a-zA-Z0-9]*$/;	
		//길이 공백 특수문자 체크 
	   //아이디 필수입력
		if(id == "" || id == null){
			$('#idMsg').text("아이디를 입력해주세요.")
			           .css("color", "red")
			$('#idCk').val("false")
		}else if(id.search(/\s/) != -1){
			//빈칸 입력 안됨
			$('#idMsg').text("아이디에 빈칸이 있습니다.")
			           .css("color", "red")
			$('#idCk').val("false")
		}else if (id.Length>10) {
			$('#idMsg').text("아이디는 1~10자 입력 가능합니다.")
			           .css("color", "red")
			$('#idCk').val("false")
        } else if (!idType.test(id)) {
	     //아이디 한글 특수문자 포함 안됨   
			$('#idMsg').text("아이디는 한글과 특수문자를 사용하실수 없습니다.")
			           .css("color", "red")
			$('#idCk').val("false")
		}else{
			//중복체크
			$.ajax({
				url:"/silhyun/idCk?id="+ id,
				type: "post",
				success : function(res){
					console.log(res)
					if(res){
						$('#idMsg').text("사용가능한 아이디입니다.")
			           				.css("color", "green")
			           	$('#idCk').val("true")
					}else{
						$('#idMsg').text("중복된 아이디입니다..")
			           				.css("color", "red")
			           	$('#idCk').val("false")						
					}
				},
				error : function(err){
					console.log(err)
				}
			})
		}
	})
	
	
	//비번길이 조홥 체크
	$('#pwd').blur(function(){
		var special = /[~!@\#$%<>^&*]/;
		var num = /[0-9]/;
		var eng = /[a-zA-Z]/;
		let pwd = $('#pwd').val()
		if(pwd == "" || pwd == null){
			$('#pwdLengtMsg').text('비밀번호를 입력해 주세요')
			                 .css("color", "red")
	        $('#pwLength').val("false")
		}else if(pwd.length < 8 || pwd.length > 15){
			$('#pwdLengtMsg').text('비밀번호를 8자 ~ 15자 사이로 설정해주세요')
                 .css("color", "red")
	        $('#pwLength').val("false")
		}else if(!special.test(pwd)||!num.test(pwd)||!eng.test(pwd)){
			$('#pwdLengtMsg').text('영문, 숫자, 특수기호로 구성되어야 합니다.')
			                 .css("color", "red")
	        $('#pwLength').val("false")			
		}else{
			$('#pwdLengtMsg').text('사용가능한 비밀번호 입니다.')
                 .css("color", "green")
	        $('#pwLength').val("true")			
		}
	})
	
	//비번 확인 체크
	$('#pwdck').blur(function(){
		if($('#pwdck').val()  == "" ){
			$('#pwdMgs').text('비밀번호 확인란을 입력해 주세요.')
                 .css("color", "red")
	        $('#pwCk').val("false")			
		}else if($('#pwdck').val() == $('#pwd').val()){
			$('#pwdMgs').text('비밀번호가 일치합니다.')
                 .css("color", "green")
	        $('#pwCk').val("true")					
		}else{
			$('#pwdMgs').text('비밀번호가 일치하지 않습니다.')
                 .css("color", "red")
	        $('#pwCk').val("false")				
		}
	})
	
	//필수입력칸 입력
	$('#name').blur(function(){
		if($('#name').val() == ''){
			$('#nameMgs').text('이름을 입력해 주세요')
                 		.css("color", "red")
	        $('#nameck').val("false")	
		}else{
			$('#nameMgs').text('')
	        $('#nameck').val("true")				
		}
	})
	
	//연락처 입력
	$('#emailId').on("focus", function(){
		if($('#telf').val() == '' || $('#tels').val() == '' || $('#telt').val() == ''){
			$('#telMgs').text("연락처를 입력해주세요")
				        .css("color","red")
	        $('#tel').val('false')
		}else{
			$('#telMgs').text("")
	        $('#tel').val('true')			
		}
	})
   

    //이메일 인증
    $('#chkBtn').click(function(){
							
		$('#emailCkMgs').text('해당 이메일로 인증번호 발송이 완료되었습니다. 인증번호가 오지 않았으면 이메일 주소를 다시 확인해주세요.')
		let email = $('#emailId').val()+"@"+$('#emailDomain').val()
		console.log(email)
		$.ajax({
			url: "/silhyun/emailCk?email="+email,
			type: "get",
			success: function(res){
				console.log(res)
				if(res == 'err'){
				$('#emailCkMgs').text("이메일 주소가 올바르지 않습니다. 유효한 이메일 주소를 입력해주세요.")
				                .css("color","red")
				$('#emailCk').val('false')
				$("#emailId").focus()			
				}else{

					$('#emailchk').blur(function(){
						
						if($('#emailchk').val() == res){
							$('#emailCkMgs').text('인증완료 되었습니다.')
							                .css("color","green")
							$('#emailCk').val('true')
							$('#chkBtn').attr("disabled",true)
						}else{
							$('#emailCkMgs').text('인증번호가 틀렸습니다.다시 확인해 주세요.')
							                .css("color","red")
							$('#emailCk').val('false')						
						}
						
						
					})
					}
				
			},
			error: function(err){
				console.log(err)
					$('#emailCkMgs').text('이메일 주소가 올바르지 않습니다.')
	                .css("color","red")
						$('#emailCk').val('false')	
			}
		})
		
	})
    
	
	
})
    //최종 로그인 보내기 
    function goJoin(){

	///////////E####################일단 이메일 인증은 true로함 마지막발표전에는 이거 없애고 체크필요**********************
	$('#emailCk').val('true')
	
	//회원정보란 체크
	let ckeck = true;
	$('.joinOk').each(function(i,e){
		if($(e).val()=='false'){
			ckeck=false
			return
		}
	})
	if(!ckeck){
		alert("회원가입 정보를 다시 확인해 주세요")
		return false
	}
	
	//동의칸 체크
	if($('#agree').val() =="false"){
		alert("필수동의칸에 동의해주세요")
		return false
	}
	
	$('input[name="tel"]').val($('#telf').val()+'-'+$('#tels').val()+'-'+$('#telt').val())
	$('input[name="email"]').val($('#emailId').val()+'@'+$('#emailDomain').val())
	if($('#year').val() != ''){	
	$('#birthDate').val($('#year').val()+'-'+$('#month').val()+'-'+$('#day').val())
	}
	console.log($('#birthDate').val())
	if($('#rcomr').val() != ''){
		$.ajax({
				url:"/silhyun/idCk?id="+ $('#rcomr').val(),
				type: "post",
				success : function(res){
					console.log(res)
					if(res){
						alert("입력하신 추천아이디는 없는 아이디 입니다.")						
					}else{
						alert("추천인"+$('#rcomr').val()+"님과 함께 1000포인트 증정되었습니다.")
					
					}
				},
				error : function(err){
					console.log(err)
				}
			})
		
	
	}
	joinFrm.submit()
	
	
	}
	
	
	
	