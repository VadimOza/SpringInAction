<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 14.10.16
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your profile</title>
</head>
<body>
<h1>Your Profile</h1>
<c:out value="${spitter.userName}" /><br/>
<c:out value="${spitter.firstName}" />
<c:out value="${spitter.lastName}" />
</body>
</html>
