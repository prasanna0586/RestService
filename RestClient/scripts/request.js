function makeServiceCall () {
	var xmlhttp = new XMLHttpRequest();
	
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("message").innerHTML=xmlhttp.responseText;
		}
	}
	
	xmlhttp.open("GET","http://192.168.7.53:81/RestSampleApplication/rest/message",true);
	xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
	xmlhttp.setRequestHeader("Content-Type","text/html");
	xmlhttp.send();	
}