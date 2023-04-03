/**
 * modal
 */
console.log('모오오오달~~~');


const modal = $(".modalBlacklayer");


$('.row.g-3').on('click', '.col-sm-6.col-lg-3', function() {
	modal.css("display", "block");
});






function isModalOn() {
	return modal.css("display") === "block";
}

function modalOff() {//모달끄는거
	modal.css("display", "none");
	imgIndex = 0;
}

$('.modalCloseButton').on('click', function() {
	modalOff();
});

modal.on("click", function(e) {
	const evTarget = e.target;
	if ($(evTarget).hasClass(".modalBlacklayer")) {
		modalOff();
	}
});

$(window).on("keyup", function(e) {
	if (isModalOn() && e.key === "Escape") {
		modalOff();
	}
});
////////////////////모달실행~~~

//모달메뉴
$('.menuButton').click(function() {
	$('.menuButtonlist').toggle();
});








