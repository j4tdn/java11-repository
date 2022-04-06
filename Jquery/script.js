$(document).ready(function() {

	// form event
	$('.click').on('click', function() {
		let textName = $('.text-name').val();
		alert('textName: ' + textName);
	})

	// window event
	$(window).on('resize', function() {
		let width = $(window).width();
		let height = $(window).height();
		console.log(`w${width}, h${height}`);
	})

	let blockShow = $('.block-show');
	let blockHide = $('.block-hide');
	let blockToggle = $('.block-toggle');

	// hiden, show, toggle
	$('.btn-show').on('click', function(){
		blockShow.show();
	})

	$('.btn-hide').on('click', function(){
		blockHide.hide();
	})

	// $('.btn-toggle').on('click', function(){
	// 	blockToggle.toggle();
	// })

	$('.btn-toggle').click(() => {
		// blockToggle.toggle();
		blockToggle.toggleClass('visible');
	})

	$('.change').on('click', function() {
		$('.first').attr('src', 'images/3nd.png');

		$('.second').attr('src', $('.first').attr('src'))
	})

	$('#fileImage').on('change', function() {
		showImageThumbnail(this);
	})

})

function showImageThumbnail(selectedFile) {
	console.dir(selectedFile);
	let file = selectedFile.files[0];

	let reader = new FileReader();
	reader.onload = function() {
		// last step
		// event.target = reader;
		$('#thumbnail').attr('src', event.target.result);
	}

	if (file) {
		reader.readAsDataURL(file);
	}


}