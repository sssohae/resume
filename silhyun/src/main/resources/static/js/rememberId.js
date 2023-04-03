/**
 *  rememberId.js
 */
 
 $(function(){
	
	//로컬세션 불러와서 아이디 val값에 넣기
	$('#username').val(localStorage.getItem("username"))

	
	$('#loginBtn').on('click', function(){
		let chk = $('#rememberId').is(':checked')
		let username = $('#username').val() 
		if(chk){
			let idck = localStorage.getItem("username")
	      if(idck != username){
				localStorage.setItem("username", username)
			}else if(idck == username){
				frm.submit();
			}

		}else{
			//체크가 안되었다면 삭제 
			localStorage.removeItem("username")
		}
		
		frm.submit();
	})
})
 