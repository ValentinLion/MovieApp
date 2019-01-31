<!DOCTYPE HTML>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		
		<title>Pug's Movies v1 | Films</title>
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
		
		<script>
			var tableauIdPoster = [];
			var tableauNomFilm = [];
			var tableauIdResume = [];
		</script>

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
							<li class="menu-item"><a href="index.html">Accueil</a></li>
							<li class="menu-item current-menu-item"><a href="./liste">Trouver un film</a></li>
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
							<a href="./liste">Home</a>
							<span>Liste des films</span>
						</div>
						<form action="./search" method="POST" class="search-form">
							<input name="query" type="text" value="" placeholder="Rechercher un film ...">
							<button type="submit"><i class="fa fa-search"></i></button>
						</form>
						</br>
						<div class="movie-list">
							<c:forEach items="${listeFilms}" var="film">

								<div class="movie">
									<figure class="movie-poster"><a href="./film?id=${film.idData}"><img id="poster${film.idData}" src="dummy/not-available.jpg" alt="#"></a></figure>
									<div class="movie-title"> 
										<a href="./film?id=${film.idData}"><c:out value="${film.movieTitle}" /></a>
									</div>
									<script>
										
										var urlPoster = "${film.urlPosterMovie}";
	
										if( urlPoster != "" ){
											document.getElementById("poster${film.idData}").src=urlPoster;
										}
										else{
											tableauIdPoster.push("poster${film.idData}");
											tableauNomFilm.push("${film.movieTitle}");
										}
										tableauIdResume.push("resume${film.idData}");
									</script>
									<ul class="movie-meta">
										<li><strong>Note Imdb : </strong> ${film.imdbScore} / 10</li>
										<li><strong>Durée :</strong> ${film.duration} minutes</li>
										<li><strong>Date de sortie :</strong> ${film.titleYear}</li>
									</ul>
									<p id="resume${film.idData}"></p>
								</div>
							
							</c:forEach>
							<c:if test="${empty listeFilms}">
								<br>
								<p>Aucun film ne correspond à votre recherche</p>
							</c:if>
							
						</div> <!-- .movie-list -->

						<div class="pagination">
							<a href="./liste?page=${page-1}" class="page-number prev"><i class="fa fa-angle-left"></i></a>
							<span class="page-number current">${page}</span>
							<a href="./liste?page=${page+1}" class="page-number"><span class="page-number current">${page+1}</span></a>
							<a href="./liste?page=${page+2}" class="page-number"><span class="page-number current">${page+2}</span></a>
							<a href="./liste?page=${page+3}" class="page-number"><span class="page-number current">${page+3}</span></a>
							<a href="./liste?page=${page+4}" class="page-number"><span class="page-number current">${page+4}</span></a>
							<a href="./liste?page=${page+5}" class="page-number"><span class="page-number current">${page+5}</span></a>
							<a href="./liste?page=${page+6}" class="page-number"><span class="page-number current">${page+6}</span></a>
							<a href="./liste?page=${page+7}" class="page-number"><span class="page-number current">${page+7}</span></a>
							<a href="./liste?page=${page+8}" class="page-number"><span class="page-number current">${page+8}</span></a>
							<a href="./liste?page=${page+1}" class="page-number next"><i class="fa fa-angle-right"></i></a>
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
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quia tempore vitae mollitia nesciunt saepe cupiditate</p>
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
		
		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/plugins.js"></script>
		<script src="js/app.js"></script>
		
		<script>
						tableauIdPoster.forEach(function(item, index, array) {					
						
								var xhttp = new XMLHttpRequest();
											xhttp.onreadystatechange = function() {
											    if (this.readyState == 4 && this.status == 200) {
											        var response = xhttp.responseText;		        
											        obj = JSON.parse(response);
											        document.getElementById(tableauIdPoster[index]).src=obj.Poster;
											        document.getElementById(tableauIdResume[index]).innerHTML=obj.Plot;
											        
											    }
											};
																					
											xhttp.open("GET", "http://www.omdbapi.com/?t="+tableauNomFilm[index]+"&apikey=7e3e8f28", true);
											
											xhttp.send();
							
							});											
		</script>
	</body>

</html>