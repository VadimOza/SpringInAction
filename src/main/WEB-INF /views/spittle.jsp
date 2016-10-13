<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
</head>
<body>
<div class="spittleView">
    <div class="spittleMessage"><c:out value="${spittle.message}" /></div>
    <div>
        <span class="spittleTime"><c:out value="${spittle.time}" /></span>
    </div>
</div>
</div>