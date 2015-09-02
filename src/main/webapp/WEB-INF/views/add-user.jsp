<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add user</title>
</head>

<body>
	<a>Enter user info:</a>
	<form action="" method="post">

		<a>Username:</a><input type="text" name="userName"><br> 
		<a>Password:</a><input type="password" name="password"><br>
		<a>Role</a><select name="role">
			<option>Admin</option>
			<option>Player</option>
		</select><br>
		<input type="submit" value="Save">

	</form>
</body>
</html>