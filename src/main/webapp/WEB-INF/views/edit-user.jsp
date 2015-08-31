<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<a>Enter user info:</a>
	<form action="" method="post">
		<a>Username:</a><input type="text" name="userName" value=${userName }><br>
		<a>Password:</a><input type="password" name="password"
			value=${password }><br>
		<c:choose>
			<c:when test="${role eq 'Admin'}">
				<a>Role</a>
				<select name="role">
					<option selected="selected">Admin</option>
					<option>Player</option>
				</select>
				<br>
			</c:when>
			<c:otherwise>
        		<a>Role</a>
				<select name="role">
					<option>Admin</option>
					<option selected="selected">Player</option>
				</select>
				<br>
    		</c:otherwise>
		</c:choose>

		<input type="submit" value="Save">
	</form>
</body>
</html>
