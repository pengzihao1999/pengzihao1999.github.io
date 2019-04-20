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
    
    <title>My JSP 'add.jsp' starting page</title>
    
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
    <h1>欢迎来到新增界面</h1>
    ${msg}
<form action="<c:url value='/AddServlet'/>" method="post">

    请输入书的ID号：     <input type="text" name="bookID" value="${book.bookID}"> ${wrong.bookID}<br/>
    请输入书的名称:     <input type="text" name="bookname" value="${book.bookname}">${wrong.bookname}<br/>
    请输入书的作者:     <input type="text" name="author" value="${book.author}">${wrong.author}<br/>
    请输入书出版社：     <input type="text" name="pulishedlocation" value="${book.pulishedlocation}">${wrong.pulishedlocation}<br/>
    请输入书的价格：     <input type="text" name="price" value="请输入一个整数" > ${wrong.price}<br/>
   验证码:<input type="text" name="verifycode"  size="3"/>
    <img id="vCode" src="<c:url value='/VerifyCodeServlet'/>" />${msgs}<br/>
    <input type="submit" value="点击这里新增图书到数据库">

    </form>
       </div>
  
  </body>
</html>
