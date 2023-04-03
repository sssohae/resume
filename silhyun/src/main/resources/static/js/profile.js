/**
 * 
 */

function profileImageUpload(pageUserId, principalId) {
	
	
	if(pageUserId != principalId){
		alert("프로필 사진을 수정할 수 없는 유저입니다.");
		return;
	}
	
	$("#userProfileImageInput").click();

	$("#userProfileImageInput").on("change", (e) => {
		let f = e.target.files[0];

		if (!f.type.match("image.*")) {
			alert("이미지를 등록해야 합니다.");
			return;
		}
		
		// 서버에 이미지를 전송
		let profileImageForm = $("#userProfileImageForm")[0];

		
		// FormData 객체를 이용하면 form 태그의 필드와 그 값을 나타내는 일련의 key/value 쌍을 담을 수 있다.
		let formData = new FormData(profileImageForm);
		
		$.ajax({
			type: "put",
			url: `/api/user/profileImage/${principalId}`,
			data: formData,
			contentType: false, // 필수 : x-www-form-urlencoded로 파싱되는 것을 방지
			processData: false,  // 필수: contentType을 false로 줬을 때 QueryString 자동 설정됨. 해제
			enctype: "multipart/form-data",
			dataType: "text"
		}).done(res=>{
			alert(res);
			location.href = `/user/profile/${principalId}`;
		}).fail(error=>{
			alert(error.responseText);
		});


	});
}