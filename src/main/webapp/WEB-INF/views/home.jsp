<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1><s:message code="spittr.wellcome"/></h1>
<a href="<c:url value="/spittles" />">Spittles</a> |
<a href="<s:url value="/spitter/register" />">Register</a>
</body>
</html>