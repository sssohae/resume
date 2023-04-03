/**
 * join.js
 */
 
 $(function(){
	// 휴대폰 앞자리
	let phone = $('#phone').find('select')
	console.log(phone)
	phone.append(
		$('<option>',{
			value: '010', text: '010'
		}).attr('selected', 'selected'),
		$('<option>',{
			value: '011', text: '011'
		}),
		$('<option>',{
			value:'017', text: '017'
		}),
		$('<option>',{
			value: '018', text: '018'
		}),
		$('<option>',{
			value: '019', text: '019'
		})

	)
	
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
	
	//생년
	let date = new Date();
	let year = date.getFullYear();
	
	for(let y = (year); y >= (year - 100); y--){		
		$('#year').append("<option value='"+ y +"'>"+ y +"</option>");
	}
	
	//월
    for(var m = 1; m <= 12; m++){
		if(m<10){
        	$("#month").append("<option value='"+ '0'+m +"'>"+ m +"</option>");
		}else{
			$("#month").append("<option value='"+ m +"'>"+ m +"</option>");
		}
    }
    //일
    for(var d = 1; d <= 31; d++){
	if(d<10){
	    $("#day").append("<option value='"+ '0'+d +"'>"+ d +"</option>");		
	}else{		
	    $("#day").append("<option value='"+ d +"'>"+ d +"</option>");
	}
    }
	
	
	
})
