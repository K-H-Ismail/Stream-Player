$(window).on('load', function () {
    $('#m3u8-placeholder')[0].value = localStorage.getItem('m3u8-link') || '';
    $('#watch-btn').on('click', function () {
    	document.getElementById('m3u8-placeholder').style.display = "block";
    	document.getElementById('go-btn').style.display = "block";
    });
    $('#go-btn').on('click', function () {
        localStorage.setItem('m3u8-link', $('#m3u8-placeholder')[0].value);
        window.location.href = './player' + '#' + $('#m3u8-placeholder')[0].value;
    });
    
    $('#stream-btn').on('click', function () {
        localStorage.setItem('m3u8-link', $('#m3u8-placeholder')[0].value);
        window.location.href = './streamer';
    });
});
