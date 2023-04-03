/**
 * review.js
 */
 
 
	
		$(function(){
						
			$('#pd_reviews_tab_02').on('click', function(){
				let ctgrNum = $('#ctgrNum').val()
				let ctgr = $('#ctgr').val()
				console.log(ctgrNum, ctgr)
			     ajaxReiew({pageNum:1, amount:5, sort: 'n', ctgrNum: ctgrNum, ctgr: ctgr})      ////일단 여기서 작가아이디랑 구분값 넘겨주기 (다른 아작스 페이지도 똑같이)
			     
			 window.setTimeout(function(){

				$('.slider-wrap').slick({
				 slide: 'div',        //슬라이드 되어야 할 태그
				 //infinite : true,     //무한 반복 옵션     
				 slidesToShow : 4,        // 한 화면에 보여질 컨텐츠 개수
				 slidesToScroll : 1,        //스크롤 한번에 움직일 컨텐츠 개수
				 speed : 500,     // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
				 arrows : true,         // 옆으로 이동하는 화살표 표시 여부
				 vertical : false,        // 세로 방향 슬라이드 옵션
				 prevArrow : "<button type='button' class='slick-prev'>Previous</button>",
				 nextArrow : "<button type='button' class='slick-next'>Next</button>",
				 responsive: [ // 반응형 웹 구현 옵션
				   {  
				     breakpoint: 960, //화면 사이즈 960px
				     settings: {
				       slidesToShow: 4
				     } 
				   },
				   { 
				     breakpoint: 768, //화면 사이즈 768px
				     settings: {    
				       slidesToShow: 5
				     } 
				   }
				 ]
				
				});
				
				},500)
			})

		})
		
		
		function ajaxReiew(data){
			$.ajax({
				url: '/ajaxCall',
				data: data,
				success: function(res){

					$('#reviews').replaceWith(res)

				}, 
				error: function(err){
					console.log(err)
				}
			})
		}
