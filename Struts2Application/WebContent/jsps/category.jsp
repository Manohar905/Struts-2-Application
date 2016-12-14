<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Page</title>
</head>
<body>
<jsp:include page="header.html"/>
<div class="alert alert-success">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>

  <strong>Welcome <s:property value="#session.user.userName"/> </strong>
</div>


 <%--
 Welcome <s:property value="user.userName"/>  <a href='<s:url action="logout"/>'>LogOut</a>
--%>
<center>
    <table border="2">
        <thead>Select Category</thead>
        <s:form action="showbooks">
            <tr><td>
<s:select name="category" list="#session['categoryList']" listValue="categoryName" 
listKey="categoryId"/>
            </td></tr>
            <s:submit value="Select"/>
        </s:form>
    </table>
</center>
</body>
</html>