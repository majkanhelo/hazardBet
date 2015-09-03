<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of tournaments</title>
</head>

<body>
	<h1>List of teams in ${tournament }:</h1>
	<br>

	<c:forEach var="team" items="${teams}">
		<form action="/admin/tournament/${tournamentId }/deleteTeam" method="post">
			<a>${team.name}</a><input type="number" value="${team.id }"
				name="teamId" style="display:none"> <input type="submit"
				value="Delete" /></a>
		</form>
		<br>
	</c:forEach>

	<br>
	<br>
	<c:if test="${not empty notInTeams }">
		<form action="/admin/tournament/${tournamentId }/addTeam" method="post">
			<a>Add new team:</a> <select name="newTeam">
				<c:forEach var="team" items="${notInTeams}">
					<option selected="selected" value="${team.id }">${team.name}</option>
				</c:forEach>
			</select> <input type="submit" value="Save">
		</form>
	</c:if>
	<br>
	<a href="/admin/tournaments"><input type="submit"
		value="Go Back To Tournaments" /></a>

</body>
</html>

