<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'form.jsp' starting page</title>
    
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
  <script type="text/javascript">
	function _change()
	{   
		var imgEle=document.getElementById("img");		
		imgEle.src="/webdemo1/ImageServlet?a="+new Date().getTime();
	}
	
	</script>
  <%
  String mes="";
    String message=(String)request.getAttribute("msg");
    if(message!=null)
    {
    	mes=message; 
    }
   String uname="";
   Cookie[] cookies=request.getCookies();
   if(cookies!=null)
   {
     for(Cookie c: cookies)
     {
	   if("uname".equals(c.getName()))
       {
		    uname=c.getValue();   
       }
     }
   }
  %>
  <h1 ><font> 登陆页面</font></h1>
 <font  color="red"><%=mes %></font>
  <form action="/webdemo1/LoginSevlet" method="post">
  用户名<input type="text" name="username" value="<%=uname%>"><br/>
   密码<input type="password" name="password"/><br/>
  验证码 <input type="text"  name="code" size="3"/>
  <img id="img" src="/webdemo1/ImageServlet"><br/>
  <a href="javascript:_change()">看不清换一张</a><br/>
  <input type="submit" name="登陆"/>
  </form>  
  </body>
</html>
