<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
ul#menu li {
	display: inline;
	margin: 10px;
}

ul#menu {
	text-align: center;
}
</style>

<title>Home</title>
</head>

<body>

	<sec:authorize access="hasRole('Admin')">
		<ul id="menu">
			<li><a href="/admin/addUser">Add user</a></li>
			<li><a href="/admin/userList">Edit user</a></li>
			<li><a href="logout">Logout</a></li>
		</ul>
	</sec:authorize>
	
	<sec:authorize access="hasRole('Player')">
		<ul id="menu">
			<li><a href="/user/editAccount">Edit account</a></li>
			<li><a href="/user/betsHistory">Bets history</a></li>
			<li><a href="logout">Logout</a></li>
		</ul>
	</sec:authorize>

</body>
</html>