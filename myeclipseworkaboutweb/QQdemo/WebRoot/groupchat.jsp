<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'groupchat.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <script type="text/javascript">
  
  	 var  ws;
	var url="ws://localhost:8080/QQdemo/chat?ID=${requestScope.ID}";
	var eventdata;
	window.onload=connect;
	function connect(){
		 if ('WebSocket' in window) {
           ws = new WebSocket(url);
       } else if ('MozWebSocket' in window) {
           ws = new MozWebSocket(url);
       } else {
           alert('WebSocket is not supported by this browser.');
           return;
       }
		 ws.onmessage=function(event){
			  eventdata = JSON.parse(event.data);
			
			creatdiv();
			creatdiv2();
			};
	}
				
			
	function creatdiv(){
		var div = document.createElement('div');
		div.innerHTML = eventdata.from+" "+eventdata.date+":  "+"<br/>message:   "+eventdata.sendMsg; 
		div.style.background = "white";
		var fatherdiv = document.getElementById("content"); 
		fatherdiv.insertBefore(div,fatherdiv.lastChild);
		}
	function creatdiv2(){
		var div = document.createElement('div');
		div.innerHTML = ""+eventdata.from
		div.style.background = "white";
		var fatherdiv2 = document.getElementById("userList"); 
		fatherdiv2.insertBefore(div,fatherdiv2.lastChild);
		}
	
	
	
	
	
	
	  function send(){
		var value= document.getElementById("msg").value;
		ws.send(value);
		document.getElementById("msg").value ="";
	}
</script>
</head>
<body>

<h3 >Weclome TO ZIHAO ChatROOM!!</h3>

<div  id="content"  style="
	border: 1px solid black; width: 400px; height: 300px;
	float: left;
"  >
<div></div>
</div>
<div  id="userList"  style="
	border: 1px solid black; width: 100px; height: 300px;
	float:left;
"  >
<div></div>
</div>

<div  style="clear: both;" >
	<input id="msg"  /><button  onclick="send();"  >send</button>
</div>


</body>
</html>