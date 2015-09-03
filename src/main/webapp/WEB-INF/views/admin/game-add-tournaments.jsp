<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of tournaments to game</title>
</head>

<body>
	<h1>Select tournament:</h1><br>  
	
	<c:forEach var="tournament" items="${tournaments}">
		<a href="/admin/game/tournament/${tournament.id}"> ${tournament.name}</a> <br>
	</c:forEach>

	<br>
	<br>
	
	<a href="/"><input type="submit" value="Back Home" /></a>
	
</body>
</html>

