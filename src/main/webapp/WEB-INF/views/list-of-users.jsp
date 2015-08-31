<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>

	<h1>List of users</h1>
	<a href="logout">Wyloguj</a><br />

<table>
	<thead>
		<tr>
			<th>Login</th>
			<th>Hasło</th>
			<th>Rola</th>
			<th>Status</th>
		</tr>
	</thead>
	<tbody>
	
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.login}</td>
				<td>${user.password}</td>
				<td>${user.role.name}</td>
				<td>${user.status}</td>
			</tr>
		</c:forEach>
	
<!-- 		<tr> -->
<%-- 			<td>${users[0].login}</td> --%>
<%-- 			<td>${users[0].password}</td> --%>
<%-- 			<td>${users[0].role.name}</td> --%>
<%-- 			<td>${users[0].status}</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<%-- 			<td>${users[1].login}</td> --%>
<%-- 			<td>${users[1].password}</td> --%>
<%-- 			<td>${users[1].role.name}</td> --%>
<%-- 			<td>${users[1].status}</td> --%>
<!-- 		</tr> -->
	</tbody>
</table>

	<a href="${pageContext.request.contextPath}/user/add">Add user</a><br />
	<a href="${pageContext.request.contextPath}/user/edit">Edit user</a>


</body>
</html>