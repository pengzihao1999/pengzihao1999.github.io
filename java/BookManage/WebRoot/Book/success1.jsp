<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <style type="text/css">
 #ID{color:red;}
 #bk{color:blue;}
 #at{color:red;}
 #pl{color:blue;}
 #pr{color:red;}
 </style>
  </head>
  
  <body>
    <div style="width:100%;text-align:center">
   <h1 >查询成功</h1>
    书名ID：<div id="ID">${success1.bookID}</div>
    书名：<div id="bk">${success1.bookname}</div>
    作者：<div id="at">${success1.author}</div>
   出版社: <div id="pl">${success1.pulishedlocation}</div>
    价格： <div id="pr">${success1.price}</div>
     <a href="<c:url value='/Book/weclome.jsp'/>">点击这里回到主页</a>
    </div>
  </body>
</html>
