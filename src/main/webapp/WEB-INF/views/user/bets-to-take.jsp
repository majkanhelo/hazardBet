<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your bets History</title>
</head>

<body>
	<h1>Available bets:</h1>
	<br>

	<table style="width: 100%">
		<tr>
			<th>Tournament</th>
			<th>Home</th>
			<th>Guest</th>
			<th>HomeLoad</th>
			<th>GuestLoad</th>
			<th>DrawLoad</th>
			<th>Term</th>
			<th></th>
		</tr>
		<c:forEach var="bet" items="${betsToTake}">
			<tr>
				<td>${bet.tournament }</td>
				<td>${bet.hostTeam }</td>
				<td>${bet.guestTeam }</td>
				<td>${bet.homeLoad }</td>
				<td>${bet.guestLoad }</td>
				<td>${bet.drawLoad }</td>
				<td>${bet.gameDate }</td>
				<td><a href="/user/betsToTake/${bet.gameId }">Take bet</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="/"><input type="submit" value="Back Home" /></a>



</body>
</html>