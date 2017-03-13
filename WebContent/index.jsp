<%@page import="model.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css">
 <link href="https://fonts.googleapis.com/css?family=Bangers|Carter+One" rel="stylesheet"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Info Searcher</title>
</head>
<body>
<header id="header">
	  <h1>Welcome to Movie Info Searcher</h1>
	  <div id="headerBackground"></div>
	</header>
	
	<div id="formContainer">
	<h2>Please enter a movie title into the search box</h2>
	<form action="InfoMovieServlet" method="GET">
		<input id="searchBox" type="text" name="title"  placeholder="Movie title..."><br>
		<button class="button" type="submit" style="vertical-align:middle"><span>Search Info </span></button>
	</form>
	</div>
	
<% if(request.getAttribute("movie") != null){
	Movie movie = (Movie) request.getAttribute("movie");
	if(movie.getResponse()){%>
<table>
	<tr>
	    <th>Poster</th>	
		<th>Title</th>	 
		<th>Year</th>	
		<th>Genre</th>	
		<th>Description</th>
		<th>Director</th>
		<th>Runtime</th>
		<th>Rating</th>	
		
	</tr>
	<tr>
	    <td id="tdPoster" ><img src="<%= movie.getPoster() %>"></td>	
		<td><%= movie.getTitle() %></td>
		<td><%= movie.getYear() %></td>		
		<td><%= movie.getGenre() %></td>
		<td id="tdPlot"><%= movie.getPlot() %></td>	
		<td><%= movie.getDirector() %></td>	
		<td><%= movie.getRunTime() %></td>
		<td><%= movie.getRating() %></td>	
			
	</tr>
</table>
	<%} %>
	<% if(!movie.getResponse()){ %>
		<h2>Movie not found... <br> Be sure you are entering the title correct.</h2>
		<% } %>
<%} %>

</body>
</html>