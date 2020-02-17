<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome To Contact Page</h1>
<font color="Green">${message }</font>
<form:form action="save?contactId=${contact.contactId}" method="post" modelAttribute="contact">
<%-- <form:form action="save?cid=${contact.contactId}" method="post" modelAttribute="contact"> --%>
<table>
<tr>
<td>Name : </td> <td><form:input path="contactName"/></td>
</tr>
<tr>
<td>Email : </td> <td><form:input path="contactMail"/></td>
</tr>
<tr>
<td>Phone : </td> <td><form:input path="contactNum"/></td>
</tr>
<tr>
<td><input type="submit" value="Save"/></td>
<td><input type="reset" value="Reset"></td>
</tr>
</table>
</form:form>
  <a href="allContacts">View All Contacts</a>
</body>
</html>