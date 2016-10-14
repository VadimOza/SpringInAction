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
    <title>RegistrForm</title>
</head>
<body>
form id="spitter" action="/spitter/spitter/register" method="POST">
First Name:
<input id="firstName"
       name="firstName" type="text" value="J"/><br/>
Last Name:
<input id="lastName"
       name="lastName" type="text" value="B"/><br/>
Email:
<input id="email"
       name="email" type="text" value="jack"/><br/>172
C HAPTER 6
Rendering web views
Username:
<input id="username"
       name="username" type="text" value="jack"/><br/>
Password:
<input id="password"
       name="password" type="password" value=""/><br/>
<input type="submit" value="Register" />
</form>
</body>
</html>
