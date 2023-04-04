<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
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
	<br>
	<br>
	
<div align="center">
	<div>
		<form id="frm" action="noticeInsert.do" method="post" enctype="multipart/form-data">
			<div>
				<table border="1" class ="notice">
					<tr>
						<th>제 목</th>
						<td colspan="3">
							<input type="text"  size="80" id="noticeTitle" name="noticeTitle" required="required">						</td>
					</tr>	
					<tr>
						<th>내 용</th>
						<td colspan="3">
							<textarea rows="10" cols="80" id="noticeSubject" name="noticeSubject"></textarea>
						</td>
					</tr>				
					<tr>
						<th>첨부파일</th>
						<td colspan="3">
							<input type="file" id="nfile" name="nfile">
						</td>
					</tr>							
				</table>
			</div><br>
			<div>
				<input type="submit" value="등록">&nbsp;&nbsp;
			<input type="reset" value="취소" onclick="location.href='noticeList.do'">&nbsp;&nbsp;
			</div>
		</form>
	</div>
</div>

</body>


<br>
<br>
</body>
</html>