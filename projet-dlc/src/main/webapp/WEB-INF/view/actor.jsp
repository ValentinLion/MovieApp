<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		
		<title>Fiche acteur</title>

		<!-- Loading third party fonts -->
		<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">

			<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
    	<script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    	<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>

		<!-- Loading third party fonts -->
		<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">

		<!-- Loading main css file -->		
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
		
		<script type="text/javascript" src="/resources/js/app.js"></script>
		<script type="text/javascript" src="/resources/js/plugins.js"></script>

	</head>

	<body>
		
		<div id="site-content">
			<header class="site-header">
				<div class="container">
					<a href="./liste" id="branding">
						<img src="images/logo.png" alt="" class="logo">
						<div class="logo-copy">
							<h1 class="site-title">Pug's Movies</h1>
							<small class="site-description"></small>
						</div>
					</a> <!-- #branding -->

					<div class="main-navigation">
						<button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
						<ul class="menu">
							<li class="menu-item"><a href="./liste">Home</a></li>
							<li class="menu-item"><a href="./liste">Trouver un film</a></li>
							<li class="menu-item"><a href="./addMovie">Ajouter un film</a></li>
						</ul> <!-- .menu -->
					</div> <!-- .main-navigation -->

					<div class="mobile-navigation"></div>
				</div>
			</header>
			<main class="main-content">
				<div class="container">
					<div class="page">
						<div class="breadcrumbs">
							<a href="./liste">Liste des films</a>
							<a href="">Fiche acteur</a>
							<span>${name}</span>
						</div>

						<div class="content">
							<div class="row">
								<div class="col-md-6">
									<figure class="movie-poster"><img id="imgPoster" src="dummy/not-available.jpg" alt="#"></figure>
								</div>
								<div class="col-md-6">
									<h2 class="movie-title"><c:out value="${name}" /></h2>
									
									<strong>Liste des films de l'acteur : </strong>
									<br/><br/>
									<ul style="height:200px;overflow:hidden; overflow-y:scroll;" class="movie-meta">
										<c:forEach items="${listeFilmsActeur}" var="film">
											<li><a href="/film?id=${film.idData}">${film.movieTitle}</a></li>
										</c:forEach>
									</ul>

								</div>
							</div> <!-- .row -->
							
						</div>
					</div>
				</div> <!-- .container -->
			</main>
			<footer class="site-footer">
				<div class="container">
					<div class="row">
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">About Us</h3>
							</div>
						</div>
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">Recent Review</h3>
								<ul class="no-bullet">
									<li>Lorem ipsum dolor</li>
									<li>Sit amet consecture</li>
									<li>Dolorem respequem</li>
									<li>Invenore veritae</li>
								</ul>
							</div>
						</div>
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">Help Center</h3>
								<ul class="no-bullet">
									<li>Lorem ipsum dolor</li>
									<li>Sit amet consecture</li>
									<li>Dolorem respequem</li>
									<li>Invenore veritae</li>
								</ul>
							</div>
						</div>
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">Join Us</h3>
								<ul class="no-bullet">
									<li>Lorem ipsum dolor</li>
									<li>Sit amet consecture</li>
									<li>Dolorem respequem</li>
									<li>Invenore veritae</li>
								</ul>
							</div>
						</div>
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">Social Media</h3>
								<ul class="no-bullet">
									<li>Facebook</li>
									<li>Twitter</li>
									<li>Google+</li>
									<li>Pinterest</li>
								</ul>
							</div>
						</div>
						<div class="col-md-2">
							<div class="widget">
								<h3 class="widget-title">Newsletter</h3>
								<form action="#" class="subscribe-form">
									<input type="text" placeholder="Email Address">
								</form>
							</div>
						</div>
					</div> <!-- .row -->

					<div class="colophon">Copyright 2018 Pug's Movies, Designed by Themezy. All rights reserved</div>
				</div> <!-- .container -->

			</footer>
		</div>
		<!-- Default snippet for navigation -->
	</body>

	<script>
	
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		        var response = xhttp.responseText;		        
		        obj = JSON.parse(response);		        
		        document.getElementById("imgPoster").src="http://image.tmdb.org/t/p/w342//"+obj.results[0].profile_path;
		    }
		};
		xhttp.open("GET", "https://api.themoviedb.org/3/search/person?api_key=e7796847c8b89942497c94d7e26bbe4a&language=en-US&query=${name}", true);
		
		xhttp.send();
		
	</script>

</html>
