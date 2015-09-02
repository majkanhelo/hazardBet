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
	<h1>Your bets History:</h1>
	<br>

	<table style="width: 100%">
		<tr>
			<th>Tournament</th>
			<th>Home</th>
			<th>Guest</th>
			<th>Result</th>
			<th>Your Choice</th>
			<th>Invested many</th>
			<th>Won many</th>
		</tr>
		<c:forEach var="bet" items="${betsHistory}">
			<tr>
				<td>${bet.tournament }</td>
				<td>${bet.hostTeam }</td>
				<td>${bet.guestTeam }</td>
				<td>${bet.result }</td>
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
				<c:choose>
					<c:when test="${bet.choice == 1 && bet.winer==1}">
       					<td>${bet.betCash*bet.homeLoad}</td>
    				</c:when>
    				<c:when test="${bet.choice == 1 && bet.winer!=1}">
       					<td>-${bet.betCash*bet.homeLoad}</td>
    				</c:when>
    				<c:when test="${bet.choice == 2 && bet.winer==2}">
       					<td>${bet.betCash*bet.guestLoad}</td>
    				</c:when>
    				<c:when test="${bet.choice == 2 && bet.winer!=2}">
       					<td>-${bet.betCash*bet.guestLoad}</td>
    				</c:when>
    				<c:when test="${bet.choice == 3 && bet.winer==3}">
       					<td>${bet.betCash*bet.drawLoad}</td>
    				</c:when>
					<c:otherwise>
        				<td>-${bet.betCash*bet.drawLoad}</td>
    				</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</table>




</body>
</html>