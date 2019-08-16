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
    
    <title>My JSP 'query.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div style="width:100%;text-align:center">
  <h1>欢迎来到查询界面</h1>
  <h4> ${msg}</h4>
  <form action="<c:url value='/QueryServlet'/>" method="post">

   请输入你要查询的书籍ID号<input type="text" name="bookID" value="${book.bookID}"> ${er}<br/>
   请输入你要查询的书籍名称<input type="text" name="bookname" value="可以填也可以不填"><br/>
    
    <input type="submit" value="点击这里进行查询图书">
  </form>
  </div>
  </body>
</html>
