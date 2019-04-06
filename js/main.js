/**
 * 
 */

(function() {
	var video = document.getElementById("webcam");
	var canvas = document.getElementById("canevas");
	var img = document.getElementById("image");
	var context = canvas.getContext('2d');
	var constraints = {video:true,audio:false};
	var url = "ws://localhost:8080/stream-player/stream";
		
		
	var socket = new WebSocket(url);
	socket.onopen=OnOpen;
	
	function OnOpen(event) {
		
	}
	/*
	 * 
	 */
	
	navigator.mediaDevices.getUserMedia(constraints).then(function(stream) {
		video.srcObject=stream;
		video.play();
	}).catch(function(err) {
		
	});
	
	setInterval(main, 3000);
	
	function main() {
		drawCanvas();
		readCanvas();
		
	}
	function drawCanvas() {
		
		context.drawImage(video,0,0,canvas.width,canvas.height);
		
	}
	

	function readCanvas() {
		
		var canvasData = canvas.toDataURL('image/jpeg',1);
		var decodeAstring = atob(canvasData.split(',')[1]);
		
		var charTab = [];
		
		for (var i = 0; i < decodeAstring.length; i++) {
			charTab.push(decodeAstring.charCodeAt(i));
			
		}
		
		socket.send(new Blob([new Uint8Array(charTab)],{
			type : 'image/jpeg'
		}));
		
		socket.addEventListener('message', function(event) {
			img.src=window.URL.createObjectURL(event.data);
		});
	}
})();