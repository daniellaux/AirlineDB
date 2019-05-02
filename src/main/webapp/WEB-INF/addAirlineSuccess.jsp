<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="tables.Airline, java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Added Airline</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="./">Airline Database</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarText" aria-controls="navbarText"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarText">

		<ul class="navbar-nav mr-auto">

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">Added Record</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="/soloProject/GetAirline">Get an
						Airline</a> <a class="dropdown-item"
						href="/soloProject/RemoveAirlinesSearch">Remove an Airline</a> <a
						class="dropdown-item" href="/soloProject/UpdateAirlinesGet">Update an Airline</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="/soloProject/AddAirline">Add an
						Airline</a> <a class="dropdown-item" href="/soloProject/GetAirlines">View
						all Airlines</a>
				</div></li>
			<li>
				<form class="form-inline my-2 my-lg-0" action="GetAirline"
					method="post">
					<input class="form-control mr-sm-2" type="text" name="name"
						placeholder="Enter Keyword(s)">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search
						Airlines</button>
				</form>
			</li>

		</ul>

		<span class="navbar-text" style="color: #E0FFFF; margin-right: 250px">
			"Your record has been successfully added." </span>
		<button class="btn btn-danger navbar-btn" onclick="history.go(-1)">Go
			Back</button>
	</div>
	</nav>
	<br/><br/>
	<blockquote class="blockquote text-center">
		<p class="mb-0">
			<c:out value="${airline.name}" />
		</p>
		<footer class="blockquote-footer">Successfully added to the <cite
			title="Source Title">Airline Table</cite></footer>
	</blockquote>
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Alias</th>
			<th>IATA Code</th>
			<th>ICAO Code</th>
			<th>Callsign</th>
			<th>Country</th>
			<th>Op Status</th>
		</tr>

		<tr>
			<td><c:out value="${airline.id}" /></td>
			<td><c:out value="${airline.name}" /></td>
			<td><c:out value="${airline.alias}" /></td>
			<td><c:out value="${airline.iataCode}" /></td>
			<td><c:out value="${airline.icaoCode}" /></td>
			<td><c:out value="${airline.callsign}" /></td>
			<td><c:out value="${airline.country}" /></td>
			<td><c:out value="${airline.operationalStatus}" /></td>
		</tr>


	</table>
	<div class="text-center">
		<a href="/soloProject/AddAirline">Add Another Airline</a> <a
			href="/soloProject/GetAirlines">Get All Airlines</a>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>