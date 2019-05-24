
var requete;

function envoi(formEnvoi){
	msg = document.formEnvoi.message.value;
	if (msg){
		msg = document.formEnvoi.message.value;
		document.getElementById("messageArea").value="";
		etatChat();
		pseudo = document.formEnvoi.pseudo.value;
		var url ="Servlet?op=newMsg&pseudo="+pseudo+"&message="+msg;
		requete = new XMLHttpRequest();
		requete.open("GET",url,true);
		requete.onreadystatechange = callbackEnvoi;
		requete.send(null);		
	}
}

function callbackEnvoi(){

	if (requete.readyState == 4) {
		if (requete.status == 200) {
			mdiv = document.getElementById("chatArea");
			mdiv.innerHTML += requete.responseText;
		} 
		else {
			alert('Une erreur est survenue lors de l envoi du message');
		}
		
	}
	
}



//function refresh
function refresh(ind){
	var url ="Servlet?op=refresh&ind="+ind;
	requete = new XMLHttpRequest();
	requete.open("GET",url,true);
	requete.onreadystatechange = majChat;
	requete.send(null);
}

function majChat(){

	if (requete.readyState == 4) {
		if (requete.status == 200) {
			mdiv = document.getElementById("chatArea");
			mdiv.innerHTML += requete.responseText;
			
		} 
		else {
			alert('Une erreur est survenue lors de la mise à jour de la page');
		}
		
	}
	
}

function nbElement(){
	nb = document.getElementsByName("messageName").length;
	return nb
	
}

function etatChat(){
	var url ="Servlet?op=nbMessage";
	requete = new XMLHttpRequest();
	requete.open("GET",url,true);
	requete.onreadystatechange = callbacketatChat;
	requete.send(null);
}

function callbacketatChat(){

	if (requete.readyState == 4) {
 		if (requete.status == 200) {
			nb = nbElement();
			if(requete.responseText>nb){
				refresh(nb);			
			}	 
		} 
		else {
			alert('Une erreur est survenue du compte des messages');
		}
	
	}
}

setInterval(etatChat,100)



