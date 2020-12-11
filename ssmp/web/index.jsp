<%--
  Created by IntelliJ IDEA.
  User: 聂本鑫
  Date: 2020/11/26
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<div id="test1"></div>
<script>
    laypage.render({
        elem: 'test1', //注意，这里的 test1 是 ID，不用加 # 号
        curr:${page.current},
        limit: 10,
        count: ${page.total}, //数据总数，从服务端得到
        jump: function (obj) {
            "wwww/" + obj.curr + "/"+this.limit+"/"
        }
    });
</script>
</body>
</html>
