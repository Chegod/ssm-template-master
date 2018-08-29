<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jstl和el测试</title>
</head>
<body>

<%--
${empty userTest?"是null为true，没有取到值":"不为null为false，取到了[userTest.username]"}
--%>
${pageContext.request.contextPath}

<h1>1）遍历strList的值</h1>
<c:forEach items="${strList}" var="str">
    ${str}<br/>
</c:forEach>

<h1>2）遍历userList的值</h1>
<c:forEach items="${userList}" var="user">
    ${user.username}<br>
    ${user.sex}<br>
    ${user.address}<br>

</c:forEach>

<h1>3）遍历strtwoMap的值</h1>
<c:forEach items="${strtwoMap}" var="entry">
   String: ${entry.key}---String:${entry.value}<br>
</c:forEach>

<h1>4）遍历struserMap的值</h1>
<c:forEach items="${struserMap}" var="entry">
    String:${entry.key}---User:${entry.value.username},${entry.value.sex},${entry.value.address}<br>
</c:forEach>

<h1>5）遍历usermapMap的值</h1>
<c:forEach items="${usermapMap}" var="entryOut">
    User:${entryOut.key.username},${entryOut.key.sex},${entryOut.key.address}<br>
    Map:
    <c:forEach items="${entryOut.value}" var="entryIn">
    String:${entryIn.key}<br>
    User:${entryIn.value.username},${entryIn.value.sex},${entryIn.value.address}<br>
    </c:forEach>
</c:forEach>

</body>

</html>