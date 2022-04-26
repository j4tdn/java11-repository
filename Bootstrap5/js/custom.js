window.onresize = window.onresize = function() {
    let windowWidth = window.innerWidth;
    document.querySelector('#width').textContent = window.innerWidth;
    
    let brpVal = '';
    
    if (windowWidth < 576) {
        brpVal = 'xs';
    } else if ( windowWidth < 768) {
        brpVal = 'sm';
    } else if ( windowWidth < 992) {
        brpVal = 'md';
    } else if ( windowWidth < 1200) {
        brpVal = 'lg';
    } else if ( windowWidth < 1400) {
        brpVal = 'xl';
    } else {
        brpVal = 'xxl';
    }
    document.querySelector('#breakpoint').textContent = brpVal;
}