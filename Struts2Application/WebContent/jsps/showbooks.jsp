<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books Page</title>
</head>

<body>
<jsp:include page="header.html"/>
        <h3><s:text name="Current Bill : " /> <s:text name="#session['bill']"/></h3>
               
        

<s:form action="selectedbooks" theme="simple">
<center>
<table border=2><tr><td>Book Name</td><td>Book Price</td></tr>
<s:set var="allBooks" value="bookList" scope="session"/>
<s:iterator value="bookList">
<tr><td><s:checkbox name="selectedBooks" fieldValue="%{bookId}"/>
<s:property value="bookName"/></td>
<td><s:property value="bookPrice"/></td></tr>
</s:iterator>

</table>
<s:submit value="Add To Cart"/>
</center>
</s:form>
</body>
</html>