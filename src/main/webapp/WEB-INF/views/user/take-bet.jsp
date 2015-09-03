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
		
		<a>Set your account:</a><input type="number" name="betCash" min=0 max=${maxAccount }
			value=0><br>
		<a>Tour choice</a>
				<select name="choice">
					<option selected="selected">Home win</option>
					<option>Guest win</option>
					<option>Draw</option>
				</select>
				<br>
		<input type="submit" value="Save">
	</form>
</body>
</html>
