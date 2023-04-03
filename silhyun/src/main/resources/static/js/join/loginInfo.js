/**
 * loginInfo.js
 */
 
 
$(function(){
	
		//이메일 뒷 주소
	$('#domain').append(
		$('<option>',{
			value: 'naver.com', text: 'naver.com'
		}),
		$('<option>',{
			value: 'google.com', text: 'google.com'
		}),
		$('<option>',{
			value:'hanmail.net', text: 'hanmail.net'
		}),
		$('<option>',{
			value: 'nate.com', text: 'nate.com'
		}),
		$('<option>',{
			value: 'kakao.com', text: 'kakao.com'
		})		
	)
	
	$('#pDomain').append(
		$('<option>',{
			value: 'naver.com', text: 'naver.com'
		}),
		$('<option>',{
			value: 'google.com', text: 'google.com'
		}),
		$('<option>',{
			value:'hanmail.net', text: 'hanmail.net'
		}),
		$('<option>',{
			value: 'nate.com', text: 'nate.com'
		}),
		$('<option>',{
			value: 'kakao.com', text: 'kakao.com'
		})		
	)
	
	//이메일 선택시 비활성화
	$('#domain').on('change', function(e){
		if(e.target.value != ''){	
			$('#emailDomain').val($(e.target).val())
			$('#emailDomain').attr('disabled', true);
		}else{
			$('#emailDomain').val('')
			$('#emailDomain').attr('disabled', false);
		}
	}) 
		//이메일 선택시 비활성화
	$('#pDomain').on('change', function(e){
		if(e.target.value != ''){	
			$('#pEmailDomain').val($(e.target).val())
			$('#pEmailDomain').attr('disabled', true);
		}else{
			$('#pEmailDomain').val('')
			$('#pEmailDomain').attr('disabled', false);
		}
	})
	
	
	//아이디 출력
	$('#idInfoBtn').on('click', function(){
		$('#email').val($('#emailId').val()+'@'+$('#emailDomain').val())
		//아이디 찾기 
		$.ajax({
			url: "/findId",
			type: 'post',
			data: $('#idFrm').serialize(),
			success: function(res){
				console.log(res)
				if(res != ''){
					let div = ` <br><br><br>
						        <div class="form-group mb-3" style="text-align:center;">
						            <span>아이디: ${res}</span>
						        </div>
						        <br><br><br>
							    <div class="form-group text-center">
							        <button type="button" class="btn btn-secondary w-100" onclick="location.href='/login'">
							            로그인하기
							        </button><br>
								</div>
								`
					$('#idInfo').empty().append(div)
				}else{
					alert("아이디가 없습니다.")
				}
			},
			error: function(err){
				console.log(err)
			}
		})
	})
	
	
	//비번출력
	$('#pwdBtn').on('click', function(){
		$('#pEmail').val($('#pEmailId').val()+'@'+$('#pEmailDomain').val())
		console.log($('#pEmail').val())
		$.ajax({
			url: "/findPwd",
			type: 'post',
			data: $('#pwdFrm').serialize(),
			success: function(res){
				console.log(res)
				alert(res+" 아이디와 이메일을 다시 확인해 주세요")
			},
			error: function(err){
				console.log(err)
				alert(res)
			}
		})		
	})
	
	
})
