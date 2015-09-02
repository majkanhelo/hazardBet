<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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

<title>Login</title>
</head>

<body>

	<h1>Enter your credentials</h1>
	
	<form action="j_spring_security_check" method="POST">
		<table>
			<tr>
				<td>Login:</td>
				<td><input type="text" name="j_username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="j_password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
	
	<font color="red">
		<span>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
	</font>

</body>
</html>