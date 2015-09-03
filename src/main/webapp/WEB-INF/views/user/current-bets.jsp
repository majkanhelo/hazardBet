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
<title>Your current bets</title>
</head>

<body>
	<h1>Your current bets:</h1>
	<br>

	<table style="width: 100%">
		<tr>
			<th>Tournament</th>
			<th>Home</th>
			<th>Guest</th>
			<th>Home Load</th>
			<th>Guest Load</th>
			<th>Draw Load</th>
			<th>Your Choice</th>
			<th>Invested many</th>
		
		</tr>
		<c:forEach var="bet" items="${currentBets}">
			<tr>
				<td>${bet.tournament }</td>
				<td>${bet.hostTeam }</td>
				<td>${bet.guestTeam }</td>
				<td>${bet.homeLoad }</td>
				<td>${bet.guestLoad }</td>
				<td>${bet.drawLoad }</td>
				<c:choose>
					<c:when test="${bet.choice == 1}">
       					<td>Home win</td>
    				</c:when>
					<c:when test="${bet.choice == 2}">
        				<td>Guest win</td>
   	 				</c:when>
					<c:otherwise>
        				<td>Draw</td>
    				</c:otherwise>
				</c:choose>
				<td>${bet.betCash}</td>
			</tr>
		</c:forEach>
	</table>




</body>
</html>