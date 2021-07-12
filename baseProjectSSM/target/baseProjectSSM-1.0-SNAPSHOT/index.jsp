<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
    + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8" />
    <base href="<%=basePath%>" />
</head>
<body>
    <jsp:forward page="WEB-INF/system/index.jsp"></jsp:forward>
</body>
</html>
