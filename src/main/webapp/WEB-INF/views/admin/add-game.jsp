<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add game</title>
</head>

<script type="text/javascript">

function myFunction() {
	var hs = document.getElementById("homeSelect");
	var hsv = hs.options[hs.selectedIndex].value;
	
	var gs = document.getElementById("guestSelect");
	var gsv = gs.options[gs.selectedIndex].value;
	
	if(gsv==hsv) {
		 alert("You have selected the same team!");
	}
	
}
</script>
<body>
	<h1>Add new game in ${tournament }:</h1>
	<br>

	<form action="/admin/game/tournament/${tournamentId}" method="post">
			<a>Add home team:</a> <select name="homeTeam" id="homeSelect" onchange="myFunction()">
				<c:forEach var="team" items="${teams}">
					<option value="${team.id }">${team.name}</option>
				</c:forEach>
			</select>
			<br>
			<br>
			<a>Add guest team:</a> <select name="guestTeam" id="guestSelect" onchange="myFunction()">
				<c:forEach var="team" items="${teams}">
					<c:if test="${team.id != homeTeam.id }">
						<option selected="selected" value="${team.id }">${team.name}</option>
					</c:if>
				</c:forEach>
			</select> 
			<br>
			<br>
			<a>Game date:</a><input type="date" name="gameDate"><br><br>
			<a>Home load:</a><input type="number" step=0.01  name="homeLoad"><br><br>
			<a>Guest load</a><input type="number" step=0.01  name="guestLoad"><br><br>
			<a>Draw load:</a><input type="number" step=0.01  name="drawLoad"><br><br>
			<input type="submit" value="Save">
	</form>

	<a href="/admin/game/"><input type="submit"
		value="Go Back" /></a>

</body>
</html>

