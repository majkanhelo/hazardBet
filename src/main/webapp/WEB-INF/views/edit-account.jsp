<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit account</title>
</head> 

<body>

	<form action="" method="post">
		<a>Change password:</a><input type="password" name="password"
			value=${password }><br>
		<a>Set your account:</a><input type="number" name="password"
			value=${account }><br>

		<input type="submit" value="Save">
	</form>
</body>
</html>
