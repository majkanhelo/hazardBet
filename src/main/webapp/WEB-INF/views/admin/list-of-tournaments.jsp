<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of users</title>
</head>

<body>
	<h1>List of registered tournaments:</h1><br>  
	
	<c:forEach var="tournament" items="${tournaments}">
		<a href="/admin/tournament/${tournament.id}"> ${tournament.name}</a> <br>
	</c:forEach>

	<br>
	<br>
	<a href="/admin/addTournament"><input type="submit" value="Add new Tournament" /></a>
	<a href="/"><input type="submit" value="Back Home" /></a>
	
</body>
</html>

