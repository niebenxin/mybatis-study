<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 聂本鑫
  Date: 2020/11/17
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>主页面</title>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
    a {
        text-decoration: none;
    }
</style>
<body onload="cen()">
<div class="container">
    <div class="col-md-12 column">
        <div class="page-header">
            <h1>
                学生信息管理系统 <small>学生列表</small>
            </h1>
        </div>
    </div>

    <!-- 添加弹出层 -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加学生信息</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="/student/save" enctype="multipart/form-data" method="post">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">学生姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="name" name="name">
                            </div>
                        </div>
                        <div class="radio" style="margin-left: 100px;">
                            <label>
                                <input type="radio" name="sex" id="sex1" value="M" checked>
                                男
                            </label>
                            <label>
                                <input type="radio" name="sex" id="sex2" value="F">
                                女
                            </label>
                        </div>
                        <div class="form-group" style="margin-top: 25px;">
                            <label for="mgr" class="col-sm-2 control-label">班主任名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="mgr" name="mgr">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="classno" class="col-sm-2 control-label">所在班级</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="classno" name="classno"></select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="bdate" class="col-sm-2 control-label">Time</label>
                            <div class="col-sm-10">
                                <input type="date" id="bdate" name="bdate">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="filename" class="col-sm-2 control-label">File input</label>
                            <div class="col-sm-10">
                                <input type="file" id="filename" name="filename">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-primary">添加</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <%--修改弹出层--%>
    <div class="modal fade" id="updatemodel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="updatemodel1">修改学生信息</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="/student/update" enctype="multipart/form-data" method="post">
                        <input type="hidden" name="img" id="imgg">
                        <input type="hidden" name="id" id="idd">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">学生姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="name1" name="name">
                            </div>
                        </div>
                        <div class="radio" style="margin-left: 100px;">
                            <label>
                                <input type="radio" name="sex" id="sex3" value="M">
                                男
                            </label>
                            <label>
                                <input type="radio" name="sex" id="sex4" value="F">
                                女
                            </label>
                        </div>
                        <div class="form-group" style="margin-top: 25px;">
                            <label for="mgr" class="col-sm-2 control-label">班主任名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="mgr1" name="mgr">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="classno" class="col-sm-2 control-label">所在班级</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="classno1" name="classno"></select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="bdate" class="col-sm-2 control-label">Time</label>
                            <div class="col-sm-10">
                                <input type="date" id="bdate1" name="bdate">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="filename" class="col-sm-2 control-label">修改图片</label>
                            <div class="col-sm-10">
                                <input type="file" id="filename1" name="filename">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="filename" class="col-sm-2 control-label">已存图片</label>
                            <div class="col-sm-10">
                                <img src="" alt="Responsive image" class="img-rounded" id="img" name="img"
                                     style='width:467px ;height:170px'>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-primary">修改</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div style="position: absolute;margin-left: 369px;margin-top: 5px;">
        <form class="form-inline" action="/student/queryAll" method="post">
            <div class="form-group">
                <label class="sr-only" for="stuname"></label>
                <input type="text" class="form-control" id="stuname" name="name" placeholder="学生姓名">
            </div>
            <button type="submit" class="btn btn-primary">Query</button>
            <button type="button" class="btn btn-default"><a href="/student/queryAll">重置</a></button>
        </form>
    </div>

    <button type="button" class="btn btn-primary btn-lg active" data-toggle="modal" data-target="#myModal">添加学生信息
    </button>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form action="/student/deletes" method="post">
                <input class="btn btn-primary btn-lg active" id="deletes" type="submit" value="删除已选"
                       style="position: absolute; top: -46px;left: 160px"/>
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th class="active"><input type="checkbox" onclick="selectAll(this.checked)"/></th>
                        <th class="info">学生编号</th>
                        <th class="success">学生姓名</th>
                        <th class="warning">学生性别</th>
                        <th class="danger">所在班级</th>
                        <th class="info">班主任名称</th>
                        <th class="success">入学时间</th>
                        <th class="warning">个人照片</th>
                        <th class="active">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="student" items="${list}" varStatus="number">
                        <tr>
                            <td class="active"><input type='checkbox' name='ids' id='ids' value='${student.id}'></td>
                            <td class="info">${number.index+1}</td>
                            <td class="success">${student.name}</td>
                            <td class="warning">${student.sex=='M'?'男':'女'}</td>
                            <td class="danger">${student.classes.classname}</td>
                            <td class="info">${student.mgr}</td>
                            <td class="success">${student.bdate}</td>
                            <td class="warning"><img style='width:200px ;height:30px' src='/upload/${student.img}'/>
                            </td>
                            <td class="active">
                                <button type="button" class="btn btn-warning" data-toggle="modal"
                                        data-target="#updatemodel" onclick='update("${student.id}")'>
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                </button>
                                <button type="button" class="btn btn-danger" onclick='delete_1("${student.id}")'>
                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    // 重写方法，自定义格式化日期
    Date.prototype.toLocaleString = function () {
        function addZero(num) {
            if (num < 10)
                return "0" + num;
            return num;
        }

        // 按自定义拼接格式返回
        return this.getFullYear() + "-" + addZero(this.getMonth() + 1) + "-" + addZero(this.getDate());
    };


    function cen() {
        $("td,th,tr").addClass("text-center");
    }

    $.ajax({
        type: "post",
        url: "${pageContext.request.contextPath}/classes/queryAll",
        success: function (list) {
            var opt = "";
            if (null != list) {
                opt = " <option value='0'>请选择部门</option>";
                for (var i = 0; i < list.length; i++) {
                    opt += ("<option value='" + list[i].classno + "'>" + list[i].classname + "</option>");
                }
                $("#classno").html(opt);
            }
        },
        error: function () {
            alert("数据响应错误");
        }
    });

    $.ajax({
        type: "post",
        url: "${pageContext.request.contextPath}/classes/queryAll",
        success: function (list) {
            var opt = "";
            if (null != list) {
                opt = " <option value='0'>--请选择部门--</option>";
                for (var i = 0; i < list.length; i++) {
                    opt += ("<option value='" + list[i].classno + "'>" + list[i].classname + "</option>");
                }
                $("#stusel").html(opt);
            }
        },
        error: function () {
            alert("数据响应错误");
        }
    });

    function update(id) {
        $.ajax({
            type: "post"
            , url: "${pageContext.request.contextPath}/student/queryById/" + id
            , success: function (data) {
                $('#idd').val(data.id);
                $('#imgg').val(data.img);
                $('#name1').val(data.name);
                if (data.sex == 'M') {
                    $("#sex3").prop("checked", true);
                } else {
                    $("#sex4").prop("checked", true);
                }
                $('#mgr1').val(data.mgr);
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/classes/queryAll",
                    success: function (list) {
                        var opt = "";
                        if (null != list) {
                            opt = " <option value='0'>请选择部门</option>";
                            for (var i = 0; i < list.length; i++) {
                                if (list[i].classno == data.classno) {
                                    opt += ("<option value='" + list[i].classno + "' selected>" + list[i].classname + "</option>");
                                } else {
                                    opt += ("<option value='" + list[i].classno + "'>" + list[i].classname + "</option>");
                                }
                            }
                            $("#classno1").html(opt);
                        }
                    },
                    error: function () {
                        alert("数据响应错误");
                    }
                });
                // 根据毫秒数构建 Date 对象
                var date = new Date(data.bdate);
                // 按重写的自定义格式，格式化日期
                dateTime = date.toLocaleString();
                $('#bdate1').val(dateTime);
                $("#img").attr("src", "/upload/" + data.img);
            }
        });

    }

    function delete_1(id) {
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/student/delete/" + id,
            success: function (data) {
                location.reload();
            },
            error: function () {
                alert("数据响应错误");
            }
        });
    }

    function selectAll(flag) {
        $('input[name=ids]').each(
            function () {
                $(this).prop('checked', flag);
            }
        )
    }
</script>
</html>
