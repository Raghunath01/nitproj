<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
 function confirmDelete(){
	 return confirm("Are You Sure you want to delete this contact from this table..");
 }
</script>
</head>
<body>
<h2>All Contacts Page</h2>
<a href="contactPage">+Add New Contact</a>
<table border="1">
  <thead>
  <tr>
  <th>CONTACT_NAME</th>
  <th>CONTACT_MAIL</th>
  <th>CONTACT_NUM</th>
  <th>ACTION</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${contacts}" var="ob">
  <tr>
  <td>${ob.contactName }</td>
  <td>${ob.contactMail }</td>
  <td>${ob.contactNum }</td>
  <td>
  	<a href="edit?id=${ob.contactId}">EDIT</a> &nbsp;	<a href="delete?id=${ob.contactId}" onclick="return confirmDelete()">DELETE</a>
  </td>
  </tr>	
  </c:forEach>
  </tbody>
  <tfoot><tr><td colspan="4">@CopyRight by RNP</td></tr></tfoot>
</table>
<font color="red">${msg}</font>

</body>
</html>