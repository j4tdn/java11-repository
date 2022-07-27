

highlightPage('/customer', document.querySelector('.customer-nav'));
highlightPage('/stuff', document.querySelector('.stuff-nav'));

function highlightPage(pageUrl, page) {
	window.location.href.includes(pageUrl) ? page.classList.add('active') : page.classList.remove('active');
}