function makeServiceCall () {
	var xmlhttp = new XMLHttpRequest();
	
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("message").innerHTML=xmlhttp.responseText;
		}
	}
	
	xmlhttp.open("GET","http://localhost:8080/RestSampleApplication/rest/message",true);
	xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
	xmlhttp.setRequestHeader("Content-Type","text/plain");
	xmlhttp.send();	
}