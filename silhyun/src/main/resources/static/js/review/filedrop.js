/**
 * filedrop.js
 */
 
 
function fileUpAction(){
	document.getElementById('fileBtn').click()
}

    var attZone = document.getElementById('attZone');
    var btnAtt = document.getElementById('fileBtn')
    var selFiles = new Array();
    

    
    // 이미지와 체크 박스를 감싸고 있는 div 속성
    var divStyle = 'display:inline-block;position:relative;'
                  + 'width:150px;height:120px;margin:5px;z-index:1';
    // 미리보기 이미지 속성
    var imgStyle = 'width:100%;height:100%;z-index:none';
    // 이미지안에 표시되는 체크박스의 속성
    var chkStyle = 'width:30px;height:30px;position:absolute;font-size:10px;border:none;'
                  + 'right:0px;bottom:0px;z-index:999;background-color:rgba(051,051,051,0.3);color:#f00';
  
    btnAtt.onchange = function(e){

      var files = e.target.files;
      var fileArr = Array.prototype.slice.call(files)
		
      for(f of fileArr){
        imageLoader(f);
      }
      if(selFiles.length > 6){   
      
		alert("6장 이하의 파일만 업로드 됩니다.")
		
	}
	  selFiles.splice(6)
    console.log("최종 배열길이 "+selFiles.length)

    }  
    
    	//뒤로가기 
	backBtn.onclick= function(){
		let ctgr = document.getElementById('revctgr').value
		let ctgrNum = document.getElementById('revctgrNum').value
		ajaxReiew({pageNum:1, amount:5, sort: 'n', ctgrNum: ctgrNum, ctgr: ctgr})
		
	}
    
    /*첨부된 이미리즐을 배열에 넣고 미리보기 */
    imageLoader = function(file){
      selFiles.push(file);
      console.log(selFiles)
      console.log(selFiles.length)
      if(selFiles.length < 7){
	      var reader = new FileReader();
	      reader.onload = function(ee){
	        let img = document.createElement('img')
	        img.setAttribute('style', imgStyle)
	        img.src = ee.target.result;
	        attZone.appendChild(makeDiv(img, file));
	      }
	
	      reader.readAsDataURL(file);
}
	      
     
}

/*첨부된 파일이 있는 경우 checkbox와 함께 attZone에 추가할 div를 만들어 반환 */
makeDiv = function(img, file){
  var div = document.createElement('div')
  div.setAttribute('style', divStyle)
  
  var btn = document.createElement('input')
  btn.setAttribute('type', 'button')
  btn.setAttribute('value', 'x')
  btn.setAttribute('delFile', file.name);
  btn.setAttribute('style', chkStyle);
  btn.onclick = function(ev){
    var ele = ev.srcElement;
    var delFile = ele.getAttribute('delFile');
    for(var i=0 ;i<selFiles.length; i++){
      if(delFile== selFiles[i].name){
        selFiles.splice(i, 1);      
      }
    }
    
    dt = new DataTransfer();
    for(f in selFiles) {
      var file = selFiles[f];
      dt.items.add(file);
    }
    btnAtt.files = dt.files;
    var p = ele.parentNode;
    attZone.removeChild(p)
  }
  div.appendChild(img)
  div.appendChild(btn)
  return div
}

document.getElementById('ordList').onchange = function(e){
	console.log(e.target.value)
	let ctgr = document.getElementById('revctgr').value
	let ctgrNum = document.getElementById('revctgrNum').value
	let id = document.getElementById('userid').value
	fetch("/ordInfoAtt?ordNum="+e.target.value+"&ctgr="+ctgr+"&ctgrNum="+ctgrNum+"&id="+id)
	.then (res => res.json())
	.then(data=>{
		console.log(data)
		data.forEach(function(e){
			console.log(e)
			let div = document.getElementById('ordInfoZone')
			if(e.findOp != null){
				div.innerHTML = `
				<div style="border: solid 1px #D8D8D8;">
					<span><img class="rounded-3" style="width:100px; height:100px;" src="${e.profile}">
					(${e.name})${e.findOp}</span>
				</div>
				`
				
			}else{
				div.innerHTML = `
				<div style="border: solid 1px #D8D8D8;">
					<span><img class="rounded-3" style="width:100px; height:100px;" src="${e.thni}">
					(${e.ptgId})${e.claTtl}</span>
				</div>
				`
			}
		})
	})
}
    
function insertReview(){
	let ordInfo = $('#ordList').val()
	console.log(ordInfo)
	if(ordInfo == ''){
		alert('리뷰를 입력할 결제정보를 선택해 주세요')
	}else{
		
		///차라리전부 아작스로 보내고 seccess 부분에서 location.href로 하기
		var formData = new FormData($('#myform')[0])  //이거 나중에 자바스크립트로 바꾸기(아작스도패치로)
		for(let i=0; i<selFiles.length; i++){
			formData.append("files", selFiles[i])
			}
			
			
		$.ajax({
			url: "/silhyun/review",
			type:"post",
			data: formData,
			contentType: false,
			processData: false, 
			success: function(res){
				console.log(res.revNum)  
				//location.href = "/silhyun/reviewList";
				ajaxReiew({pageNum:1, amount:5, sort: 'n', ctgrNum: res.ctgrNum, ctgr: res.ctgr})
				
			},
			error: function(err){
				console.log(err)
			}
			
		})
	}
	
	return false;
	
}

