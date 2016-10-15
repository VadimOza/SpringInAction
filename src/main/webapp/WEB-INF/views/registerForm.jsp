<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 13.10.16
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>Spittr</title>
        <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
    </head>
</head>
<body>
<h1>Test</h1>
<sf:form method="POST" commandName="spitter">

    <sf:errors element="div" path="*" cssClass="error"/>

    <sf:label path="firstName" cssErrorClass="error"> First Name: </sf:label>
    <sf:input path="firstName"/>
    <sf:label path="lastName" cssErrorClass="error"> Last Name: </sf:label>
    <sf:input path="lastName"/>
    <sf:label path="email" cssErrorClass="error"> Email: </sf:label>
    <sf:input path="email"/>
    <sf:label path="userName" cssErrorClass="error"> Username: </sf:label>
     <sf:input path="userName"/>
    <sf:label path="password" cssErrorClass="error"> Password: </sf:label>
    <sf:password path="password"/>


    <input type="submit" value="Register"/>
</sf:form>
</body>
</html>
