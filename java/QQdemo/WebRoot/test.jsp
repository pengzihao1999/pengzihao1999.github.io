<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
	var url="ws://localhost:8080/QQdemo/chatSocket";
	
	window.onload=connect();
	function connect(){
		 if ('WebSocket' in window) {
           ws = new WebSocket(url);
       } else if ('MozWebSocket' in window) {
           ws = new MozWebSocket(url);
       } else {
           alert('WebSocket is not supported by this browser.');
           return;
       }
	}
</script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
