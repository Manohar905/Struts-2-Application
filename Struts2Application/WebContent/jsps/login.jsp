<%@page import="java.util.Locale"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@  taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Login Page</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js" ></script>
   <script> 
     $(function(){ $("head").load("header.html") });
   </script>
</head>
<body>
<jsp:include page="header.html"/>
<center>
<%
    //Locale.setDefault(Locale.CHINA);
    String locale=Locale.getDefault().toString();
out.println(" Current Locale :: "+locale);
%>
<s:actionerror/>
<s:form action="login">
<%--
<s:i18n name="com.example.struts2.shopcart.model.actions.LoginApplicationResources">
     --%>
    <s:textfield name="userName" key="label.userName"/>
    <s:password name="password" key="label.password"/>
    <%--
    </s:i18n>
     --%>
     <%--This action attrib must be set as name in struts.xml for corresponding action --%>
    <s:submit name="login" key="label.login.submit" action="log"/>
</s:form>
</center>
</body>
</html>