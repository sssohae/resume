/**
 *  reviewList.js
 */
 $(function(){
          $('#searchFrm').find('input[name="ctgr"]').val($('#ctgr').val())
          $('#searchFrm').find('input[name="ctgrNum"]').val($('#ctgrNum').val())
          
          
		let row = $('.content').text().split('\n').length
		if(row > 2){
			$('.content').css('white-space', 'pre-wrap')
			  $(".content").moreLess({
			    wordsCount: 40,
			    moreLabel:"..더보기",
			    lessLabel:"..줄이기",
				moreClass:"more-link",
				lessClass:"less-link"
			  });
			
		}else{
			$('.content').css('white-space', 'pre')
		}
		


    $(".pagination a").on("click", function(e){
    	e.preventDefault();
     	$("#searchFrm").find("input[name='pageNum']").val($(this).attr("href"));
    	console.log($("#searchFrm").find("input[name='pageNum']").val())
    	
    	
    	ajaxReiew($('#searchFrm').serialize()) //form안에있는 name이랑 value값을 들고온다.
    	//searchFrm.submit(); //폼태그값을 스트링으로 
    })
    
    $('#sort').on('change', function(){
    	
    	ajaxReiew($('#searchFrm').serialize()) //form안에있는 name이랑 value값을 들고온다.
})

$('#phosort').on('click', function(){

    	ajaxReiew($('#searchFrm').serialize()) //form안에있는 name이랑 value값을 들고온다.
})
    

    
     $('.star-ratings-fill').css('width', starPercent($('#starAvg').text()) + '%')	
     
     $('.star-ratings-fill.sm').each(function(i,e){
    	 $(e).css('width', starPercent($(e).attr("starCnt")) + '%')	
     })

	
     
     
})
    function starPercent(n){ //매개변수에 별점 넣기
        const score = Number(n) * 20;
         // return score  + 1.5;
          return score;
  		}
  
		
       //인써트 버튼 이벤트
	function reviewInsertForm(id){
		//리뷰 작성버튼 체크 ===> 프로미스, then 써보기
    	let ctgrNum = $('#ctgrNum').val()
    	let ctgr = $('#ctgr').val()
    	
    	new Promise((succ, fail)=>{
		
	    	$.ajax({
				url: '/insertChek',
				data: {ctgrNum : ctgrNum,
					   ctgr : ctgr,
				       id : id},
				success: function(res){
					console.log(res)
					succ(res)
					 
				},
				error:function(err){
					fail(err)
				}
			})
		}).then((succ)=>{
			if(succ == 1){
				$.ajax({
					url: '/reviewform',
					data: {ctgrNum: ctgrNum,
						   ctgr : ctgr, 
						   id: id},
				    success: function(res){
				    	$('#reviews').replaceWith(res)
				    }, 
				    error: function(err){
				    	console.log(err)
				    }
					
				})
			}else{
				alert('결제하신 정보가 없습니다.')
			}
		})
    	

	}
    
   
	//수정버튼 이벤트 
	function upFrom(num){
    	let ctgrNum = $('#ctgrNum').val()
    	let ctgr = $('#ctgr').val() 
    	let pageNum = $('a[class="active"]').attr('href')
    	let sort = $('#sort').val()
    	let phosort = '';
    	if($('#phosort').is(":checked")){
			phosort = 'y'
			}else{
			phosort = ''
			}
		$.ajax({
			url: '/reviewUpform',
				data: {revNum: num, 
						pageNum:pageNum,  
						sort: sort, 
						ctgrNum:ctgrNum, 
						ctgr: ctgr, 
						photo: phosort},
		    success: function(res){
		    	$('#reviews').replaceWith(res)
		    }, 
		    error: function(err){
		    	console.log(err)
		    }
			
		})
	}
	
	//삭제버튼 이벤트
	function delReview(num){
		console.log(num)
		$.ajax({
			url:'/reviewDel',
			data:{revNum: num},
		     success: function(res){
		    	console.log(res)
		    	let ctgrNum = $('#ctgrNum').val()
		    	let ctgr = $('#ctgr').val() 
		    	let pageNum = $('a[class="active"]').attr('href')
		    	let sort = $('#sort').val()
		    	let phosort = '';
		    	if($('#phosort').is(":checked")){
					phosort = 'y'
				}else{
					phosort = ''
				}
		    	ajaxReiew({pageNum:pageNum, amount:5, sort: sort, ctgrNum: ctgrNum, ctgr: ctgr, photo: phosort})
		    }, 
		    error: function(err){
		    	console.log(err)
		    }
		})
	}

	