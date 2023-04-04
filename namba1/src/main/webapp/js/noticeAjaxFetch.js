/**
 * noticeAjaxFetch.js fetch api활용 
 */

console.log('noticeAjaxFetch start.')


document.addEventListener('DOMContentLoaded', function () {

	window.onload=function(){

	document.getElementById('btnNp').addEventListener('click', chgPasswordFnc);
	document.getElementById('btnNt').addEventListener('click', chgTelFnc);
	document.getElementById('btnC').addEventListener('click', cardFnc);
	}
})



	function chgPasswordFnc(e){
		e.preventDefault();
		
		let userEmail = document.querySelector('input[name="userEmail"]').value;
		let userPassword = document.querySelector('#nPw').value;
		
		console.log(userPassword);
		fetch('userUpdateAjax.do', {
			method: 'post',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: 'userEmail='+userEmail + '&userPassword=' + userPassword
		})
		.then(result => result.json())
		.then(result => {
			console.log(result) 
			document.querySelector('#btnNp').style.backgroundColor="orange"
			document.querySelector('#btnNp').innerText= '변경됨'
			document.querySelector('#pwP').innerHTML='현재 비밀번호 : ' +userPassword
		})
		.catch(err => console.log(err))
}

function chgTelFnc(e) {
	e.preventDefault();

	let userEmail = document.querySelector('input[name="userEmail"]').value;
	let userTel = document.querySelector('#nTel').value;

	console.log(userTel);
	fetch('userUpdateAjax.do', {
			method: 'post',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: 'userEmail='+userEmail + '&userTel=' + userTel
		})
		.then(result => result.json())
		.then(result => {
			console.log(result) 
			document.querySelector('#btnNt').style.backgroundColor="orange"
			document.querySelector('#btnNt').innerText= '변경됨'
			document.querySelector('#telP').innerHTML='현재 전화번호 : ' +userTel
		})
		.catch(err => console.log(err))
}

function cardFnc(e){
	e.preventDefault();

	let userEmail = document.querySelector('input[name="userEmail"]').value;
	let cardNumber = document.querySelector('#card').value;

	console.log(cardNumber);
	fetch('userUpdateAjax.do', {
			method: 'post',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: 'userEmail='+userEmail + '&cardNumber=' + cardNumber
		})
		.then(result => result.json())
		.then(result => {
			console.log(result) 
			document.querySelector('#btnC').style.backgroundColor="orange"
			document.querySelector('#btnC').innerText= '등록됨'
			document.querySelector('#cardP').innerHTML='현재 결제수단 : ' +cardNumber
		})
		.catch(err => console.log(err))
}
