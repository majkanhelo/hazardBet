<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of users</title>
</head>
<body>

	<h1>List of users</h1>
	<a href="logout">Wyloguj</a><br />

	<c:forEach var="user" items="${users}">
		<a href="/admin/addUser/${user.id}"> ${user.login}</a> <br>
	</c:forEach>


</body>
</html>