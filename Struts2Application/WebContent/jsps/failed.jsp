<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Failed Page</title>
</head>
<body>
<jsp:include page="header.html"/>

<h2>Invalid USERNAME OR PASSWORD</h2>
<a href="http://localhost:8085/Struts2Application/jsps/category.jsp" <s:url action="gotologin"/>>Re-Login</a>
</body>
</html>