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
    
    <title>My JSP 'index.jsp' starting page</title>
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
   <c:out value="dadaf"></c:out>
   <c:set var="aa" value="AA" scope="request"></c:set>  
   <c:out value="${aa}" escapeXml="false"></c:out>
   
   <c:url value="/"></c:url><br/>
   <c:url value="/" var="a" scope="request"></c:url>
   <c:url value="/a.jsp">
   <c:param name="name" value="张三"></c:param>
   </c:url><br/>
   <a href="<c:url value='/index.jsp'/>">点击这里回到主页</a><br/>
   <c:if test="${not empty aa}">//当test为真时，执行标签体语句
    <c:out value="${aa}"></c:out>
   </c:if>
   <c:if test="${empty param.name}">
   <c:out value="你没有给出名称为name的参数"></c:out><br>
   </c:if>
   <c:choose> 
   <c:when test="${empty param.age}">
             你没有给出age的值</c:when>
   <c:otherwise>
     <c:out value="${param.age}"></c:out>
   </c:otherwise> 
   </c:choose>
   <c:forEach var="i" begin="1" end="10" step="2">
    ${i}
    </c:forEach>
    <%
      String [] s ={"now","da"};
    request.setAttribute("str",s );
    %>
    <c:forEach items="${str}" var="st">
    ${st}
    </c:forEach>
  </body> 
</html>
