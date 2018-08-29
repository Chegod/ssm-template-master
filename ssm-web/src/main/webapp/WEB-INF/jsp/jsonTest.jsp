<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
    <title>接收和发送json数据</title>
    <script type="text/javascript">
        var params = '{"id": 1, "name": "测试商品", "price": 99.9, "detail": "测试商品描述", "pic": "123456.jpg"}';

        $(function () {
            $("#tijiao1").click(function () {
                var content = "";
                $.post("${pageContext.request.contextPath}/jsonpost",params,function (data) {
                    alert(data.name)
                    content+="<li>post提交键值对</li>"+"<li>"+data.id+"</li>"+"<li>"+data.name+"</li>"+"<li>"+data.price+"</li>"+"<li>"+data.detail+"</li>";
                    //将拼接好的li放置到ul中
                    $("#itemInfo1").html(content);
                },"json");
            });
            $("#tijiao2").click(function () {
                var content = "";
                $.ajax({
                    url: "${pageContext.request.contextPath }/jsonajax",
                    data: params,
                    contentType: "application/json;charset=UTF-8",//发送数据的格式
                    type: "post",
                    dataType: "json",//回调
                    success: function (data) {
                        alert(data.name);
                        content+="<li>ajax提交json</li>"+"<li>"+data.id+"</li>"+"<li>"+data.name+"</li>"+"<li>"+data.price+"</li>"+"<li>"+data.detail+"</li>";
                        //将拼接好的li放置到ul中
                        $("#itemInfo2").html(content);
                    }
                });
            });
        });
    </script>
</head>

<body>
<h1>Json测试</h1>
<ul id="itemInfo1"></ul>
<ul id="itemInfo2"></ul>
<input type="button" id="tijiao1" value="post提交键值对">
<input type="button" id="tijiao2" value="ajax提交json">
</body>
</html>

