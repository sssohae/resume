/**
 * around.js
 */
console.log('around.js열리나요');


$(document).ready(function() {

	//사진 정렬할 때 ul내리는 것
	$('.dropdown').click(function() {
		$('.toggleMenu').toggle();
	});


	// input창에 태그 리스트를 동적으로 생성
	$('#aroundTagSearch').on('input', function() {
		var inputText = $(this).val();
		if (inputText.length > 0) {
			$.ajax({
				type: 'GET',
				url: '/silhyun/searchTags',
				data: { tag: inputText },
				success: function(result) {
					var tags = result.tags;
					var tagList = [];
					for (var i = 0; i < tags.length; i++) {
						if (i >= 5) {
							tagList.push('<li id="moree">...</li>');
							break;
						}
						tagList.push(`<li><i class="bi-hash">${tags[i]}</i></li>`);
					}
					$('#aroundTagList').html(tagList.join(''));
					$('#moree').click(function() {
						$(this).remove(); // ... 제거 안되노...
						for (var i = 5; i < tags.length; i++) {
							tagList.push(`<li>${tags[i]}</li>`);
						}
						$('#aroundTagList').html(tagList.join(''));
					});
				}
			});
		} else {
			$('#aroundTagList').html('');
		}
	});

	//태그리스트 선택하면 해당 태그 적힌 포트폴리오 리스트 출력
	$('#aroundTagList').on('click', 'li', function() {
		var selectedTag = $(this).text();	
		var inputText = $('#aroundTagSearch').val();
		if (inputText.length > 0) {
			var newText = inputText.substring(0, inputText.length -1) + selectedTag;
			$('#aroundTagSearch').val(newText);
		}
		$('#aroundTagList').html('');
		
		$.ajax({
			type: 'GET',
			url: "/silhyun/aroundTagList",
			data: { tagCntn: selectedTag },
			success: function(result) {
				$("div#rowg-3").children().remove();
				StandLine(result);
				recentStand(result);
				likeStand(result);
			}
		});
	});





});//윈도우어쩌구