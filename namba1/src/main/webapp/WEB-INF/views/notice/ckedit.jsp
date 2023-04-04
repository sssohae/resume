<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Page Preloder -->
<div id="preloder">
	<div class="loader"></div>
</div>

<!-- Normal Breadcrumb Begin -->
<section class="normal-breadcrumb set-bg" data-setbg="img/ticket.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="normal__breadcrumb__text">
					<h2>공지사항 등록</h2>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Normal Breadcrumb End -->

<script src="//cdn.ckeditor.com/4.20.1/standard/ckeditor.js"></script>
<script src="ckeditor/ckeditor.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-8" align="center">
				<br>
				<br>
				<form action="insertText.do" method="post">

					<label class="ckLabel">제목</label>&nbsp;&nbsp; <input type="text" id="subject"
						name="subject"> <br>
					<br>

					<textarea id="content" name="content"></textarea>
					<br>
					<br>
					
					
					<!--  
					<button type="submit" class="btn btn-primary" style="float: right">등록</button>
					
					-->
				
				
							<div>
				<input type="submit" value="등록" class="btn btn-primary" style="float: right">&nbsp;&nbsp;
				<input type="reset" value="취소"class="btn btn-primary" style="float: right">
			</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		window.onload = function() {
			CKEDITOR.replace('content', {
								height : 500, 
								filebrowserUploadUrl : '${pageContext.request.contextPath}/fileupload.do'
							});
		}
	</script>

</body>
</html>