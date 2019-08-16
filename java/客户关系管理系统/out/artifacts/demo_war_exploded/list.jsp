<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function delseleted() {
            var seleteds = document.getElementsByName("uid");
            var flag = false;
            for (var i = 0; i < seleteds.length; i++) {
                if (seleteds[i].checked) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                document.getElementById("delform").submit();
            }
        }
    </script>
    <script>
        window.onload = function () {
            document.getElementById("firstbox").onclick = function () {

                var seleteds = document.getElementsByName("uid");
                for(var i=0;i<seleteds.length;i++){
                    seleteds[i].checked = this.checked;
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <form class="form-inline" method="post" action="${pageContext.request.contextPath}/fingPageByUserServlet">
        <div class="form-group">
            <label for="exampleInputName2">姓名</label>
            <input type="text" name="name" value="${requestScope.condition.name[0]}" class="form-control" id="exampleInputName2" >
        </div>
        <div class="form-group">
            <label for="exampleInputadress2">籍贯</label>
            <input type="text" name="address" value="${requestScope.condition.address[0]}" class="form-control" id="exampleInputadress2" >
        </div>
        <div class="form-group">
            <label for="exampleInputEmail2">邮箱</label>
            <input type="text" name="email" value="${requestScope.condition.email[0]}" class="form-control" id="exampleInputEmail2" >
        </div>
        <button type="submit" class="btn btn-default">查询</button>
    </form>
    <div style="float: right">
        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="add.jsp">添加联系人</a></td>
        </tr>
        <tr>
            <td colspan="8" align="center"><a id="delselected" class="btn btn-primary" onclick="delseleted()">删除选中</a></td>
        </tr>
    </div>
    <form action="${pageContext.request.contextPath}/DelSelServlet" id="delform">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstbox"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pg.pagelist}" var="user" varStatus="s">
        <tr>
            <td><input type="checkbox" name="uid" value="${user.id}"></td>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.qq}</td>
            <td>${user.email}</td>
            <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findServlet?id=${user.id}">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/deleteServlet?id=${user.id}">删除</a></td>
        </tr>
        </c:forEach>

    </table>
        </form>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <c:if test="${pg.currentpage>1}">
                <a href="${pageContext.request.contextPath}/fingPageByUserServlet?currentpage=${pg.currentpage-1}&rows=5&name=${requestScope.condition.name[0]}&email=${requestScope.condition.email[0]}&address=${requestScope.condition.address[0]}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
                </c:if>
                <c:if test="${pg.currentpage<1}">
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </c:if>

            </li>
            <c:forEach begin="1" end='${pg.pagecount}' var="i">
            <li><a href="${pageContext.request.contextPath}/fingPageByUserServlet?currentpage=${i}&rows=5&name=${requestScope.condition.name[0]}&email=${requestScope.condition.email[0]}&address=${requestScope.condition.address[0]}">${i}</a></li>
            </c:forEach>
            <li>
                <c:if test="${pg.currentpage<pg.pagecount}">
                    <a href="${pageContext.request.contextPath}/fingPageByUserServlet?currentpage=${pg.currentpage+1}&rows=5&name=${requestScope.condition.name[0]}&email=${requestScope.condition.email[0]}&address=${requestScope.condition.address[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </c:if>
                <c:if test="${pg.currentpage==pg.pagecount}">
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </c:if>
            </li>
        </ul>
    </nav>
    <span>当前是第${pg.currentpage}页，共有${pg.totalcount}条数据</span>
</div>
</body>
</html>
