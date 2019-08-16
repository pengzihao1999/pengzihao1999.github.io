<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	var ws;//一个对象相当于一个管道
	var target = "ws://localhost:8080/QQdemo/echo"
	function subOpen(){
		if('WebSocket' in window){
			ws = new WebSocket(target);
		}else{
			alert("WebSocket is not supported");
			return;
		}
		//在open时就注册一个时间
		ws.onmessage = function(event){
			var dv = document.getElementById("dv");
			dv.innerHTML+=event.data;
		}
	}
	function subSend(){
		var msg = document.getElementById("mssg").value;
		ws.send(msg);
		msg = "";
	}
	
	</script>
  </head>
  <div id="dv"></div>
  <body>
    <button onclick="subOpen();">open</button>
    <input id="mssg"/>
    <button  onclick="subSend();">send</button>
  </body>
</html>
