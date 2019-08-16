<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Vendor</title>
</head>
<body>

<form action="updateV" method="post">
<pre>
ID: <input type="text" name="id" value="${vendor.id}" readonly/>
Code: <input type="text" name="code" value="${vendor.code}"/>
Name: <input type="text" name="name" value="${vendor.name}"/>
Type: <select name="type">
	<option ${vendor.type=='Regular'?'selected':''}>Regular</option>
	<option ${vendor.type=='Contract'?'selected':''}>Contract</option>
</select>
E-mail: <input type="text" name="email" value="${vendor.email}"/>
Phone: <input type="text" name="phone"  value="${vendor.phone}"/>
Address: <textarea rows="3" cols="40" name="address" ><c:out value="${vendor.address}"/></textarea>
<input type="submit" value="save"/>
</pre>
</form>
</body>
</html>