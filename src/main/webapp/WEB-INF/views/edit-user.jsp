<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	
	<h1>Edit user</h1>
 
	
	<form action="" method="post">
		Login: <input type="text" name="userName" value="${user.login}"><br> 
		Hasło: <input type="text" name="userPassword" value="${user.password}"><br> 
		Rola: <input type="text" name="roleName" value="${user.role.name}"><br> 
		Status: <input type="text" name="userStatus" value="${user.status}"><br> 
		<input type="submit" value="Zapisz">
	</form>
	
	
	<a href="${pageContext.request.contextPath}/">List of users</a>


</body>
</html>
