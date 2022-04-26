$(document).ready(function(){

	// form event
	$('.click').on('click', function(){
		let textName = $('.text-name').val();
		alert('textName: ' + textName);
	});

	// window event
	$(window).on('resize', function(){
		let width = $(window).width();
		let height = $(window).height();

		console.log(`w${width}, h${height}`);
	})

	let blockShow = $('.block-show');
	let blockHide = $('.block-hide');
	let blockToggle = $('.block-toggle');

	$('.btn-show').on('click',function(){
		console.log(blockShow.css('display'));
		blockShow.show();
	})

	$('.btn-hide').on('click',function(){
		console.log(blockHide.css('display'));
		blockHide.hide();
	})

	$('.btn-toggle').on('click',function(){
		blockToggle.toggleClass('visible');
	})

	$('.change').on('click', function(){
		$('.first-image').attr('src','images/image03.jpg');

		$('.secone-image').attr('src', $('.first-image').attr('src','images/image03.jpg'));
	})

	$('#fileImage').on('change', function(){
		showImageThumbnail(this);
	})

})

function showImageThumbnail(selectedFile) {
	console.dir(fileImage);
	let file = selectedFile.files[0];

	let reader = new FileReader();
	reader.onload = function (event) {
		// last step
		// event.target = reader
		$('#thumbnail').attr('src', event.target.result);
	}

	if (file) {
		reader.readAsDataURL(file);
	}
}