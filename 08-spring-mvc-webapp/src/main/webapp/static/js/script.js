

highlightPage('/customer', document.querySelector('.customer-nav'));
highlightPage('/stuff', document.querySelector('.stuff-nav'));

function highlightPage(pageUrl, page) {
	window.location.href.includes(pageUrl) ? page.classList.add('active') : page.classList.remove('active');
}

let messageInfo = document.querySelector('.info-message');
if (messageInfo) {
	let counter = 5;
	let interval = setInterval(function() {
		counter --;
		console.log(counter);
		if (counter === 0) {
			messageInfo.style.display = 'none';
			clearInterval(interval);
		}
	}, 1000);
}
