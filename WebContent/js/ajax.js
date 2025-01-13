function getXmlHttp(){
 
 var xmlRequest;

  try {
    xmlRequest = new XMLHttpRequest();
  } catch (trymicrosoft) {
    try {
      xmlRequest = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (othermicrosoft) {
      try {
        xmlRequest = new ActiveXObject("Microsoft.XMLHTTP");
      } catch (failed) {
        xmlRequest = null;
      }
    }
  
}
  return xmlRequest;
}

function doAjax(clsName,dataTagId,reflashTagId,tagMode){
 
	pageUrl="ajax.jsp";
  var dataValue = document.getElementById(dataTagId).value;
  pageUrl += "?tagMode="+escape(tagMode)+
             "&dataValue="+escape(dataValue)+
             "&clsName="+escape(clsName)+
             "&time="+new Date().getTime();
 
  var httpRequest = getXmlHttp();
 
 if(httpRequest==null) return;
  var reflashObj = document.getElementById(reflashTagId);
  httpRequest.open("GET",pageUrl,true);
  httpRequest.onreadystatechange = function(){
   	if(httpRequest.readyState==4 && httpRequest.status==200){
      if(tagMode=="innerHTML"){
      	reflashObj.innerHTML = httpRequest.responseText;
      } else {
        reflashObj.value = httpRequest.responseText;
      }
    } 
  }
  httpRequest.send(null);
}

function doDraftAjaxRequest(clsName,dataValue,otherValue,reflashTagId,tagMode,callback)
{
	pageUrl="ajax.jsp";
  
  	pageUrl += "?tagMode="+escape(tagMode)+
             "&dataValue="+escape(dataValue)+
             "&clsName="+escape(clsName)+
             "&otherValue="+escape(otherValue)+
             "&time="+new Date().getTime();
             
  	var httpRequest = getXmlHttp();
  	if(httpRequest==null) return;
  	var reflashObj = document.getElementById(reflashTagId);
  	httpRequest.open("GET",pageUrl,true);
  	httpRequest.onreadystatechange = function(){
   		if(httpRequest.readyState==4 && httpRequest.status==200){
      		if(tagMode=="innerHTML"){
      			reflashObj.innerHTML = httpRequest.responseText;
      		} else 
      		if(tagMode=="innerText"){
       			reflashObj.innerText = httpRequest.responseText;
      		} else {
        		reflashObj.value = httpRequest.responseText;
      		}
      		if(callback) {
      			if(typeof callback=="string") {
      				alert(callback);
      			}
      			else if(typeof callback=="function") {
      				callback();
      			}
      		}
      	}
  	}
 	httpRequest.send(null);
}
function doAjaxRequest(clsName,dataTagId,otherValue,reflashTagId,tagMode){ 
	pageUrl="ajax.jsp";
  var dataValue = document.getElementById(dataTagId).value;

  pageUrl += "?tagMode="+escape(tagMode)+
             "&dataValue="+dataValue+
             "&clsName="+escape(clsName)+
             "&otherValue="+escape(otherValue)+
             "&time="+new Date().getTime();
  var httpRequest = getXmlHttp();
  if(httpRequest==null) return;
  var reflashObj = document.getElementById(reflashTagId);
  
  httpRequest.open("POST",pageUrl,true);
  httpRequest.onreadystatechange = function(){
   	if(httpRequest.readyState==4 && httpRequest.status==200){
      if(tagMode=="innerHTML"){
      	reflashObj.innerHTML = httpRequest.responseText;
      } else 
      if(tagMode=="innerText"){
       	reflashObj.innerText = httpRequest.responseText;
      } else {
        reflashObj.value = httpRequest.responseText;
      }
    } 
  }
  httpRequest.send(null);
}



function doPatentCaseAjaxRequest(clsName,dataValue,otherValue,reflashTagId,tagMode)
{
	pageUrl="ajax.jsp";
  
  	pageUrl += "?tagMode="+escape(tagMode)+
             "&dataValue="+escape(dataValue)+
             "&clsName="+escape(clsName)+
             "&otherValue="+escape(otherValue)+
             "&time="+new Date().getTime();
             
  	var httpRequest = getXmlHttp();
  	if(httpRequest==null) return;
  	var reflashObj = document.getElementById(reflashTagId);
  	httpRequest.open("GET",pageUrl,true);
  	httpRequest.onreadystatechange = function(){
   		if(httpRequest.readyState==4 && httpRequest.status==200){
      		if(tagMode=="innerHTML"){
      			reflashObj.innerHTML = httpRequest.responseText;
      		} else 
      		if(tagMode=="innerText"){
       			reflashObj.innerText = httpRequest.responseText;
      		} else {
        		reflashObj.value = httpRequest.responseText;
      		}
      	}
  	}
 	httpRequest.send(null);
}

function doAjaxPostValue(clsName,dataValue,otherValue,reflashTagId,tagMode){ 
	pageUrl="ajax.jsp";
	
 	var data = "tagMode=" + escape(tagMode)+
             "&dataValue=" + dataValue +
             "&clsName=" + escape(clsName)+
             "&otherValue=" + escape(otherValue)+
             "&time=" + new Date().getTime();
             
  	var httpRequest = getXmlHttp();
  	if(httpRequest==null) return;
  	var reflashObj = document.getElementById(reflashTagId);
  	httpRequest.open("POST",pageUrl,true);
  	httpRequest.onreadystatechange = function(){
   		if(httpRequest.readyState==4 && httpRequest.status==200){
      		if(tagMode=="innerHTML"){
      			reflashObj.innerHTML = httpRequest.responseText;
      		} else 
      		if(tagMode=="innerText"){
       			reflashObj.innerText = httpRequest.responseText;
      		} else {
        		reflashObj.value = httpRequest.responseText;
      		}
    	} 
  	}
  	httpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
  	httpRequest.send(data);
}