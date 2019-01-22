package com.esir.projet_dlc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name = "Film.findByMovieTitle", query = "SELECT p FROM Film p WHERE LOWER(p.movieTitle) LIKE CONCAT('%',LOWER(:title),'%')"),
@NamedQuery(name = "Film.findByActor", query = "SELECT p FROM Film p WHERE LOWER(p.actor1Name) LIKE CONCAT('%',LOWER(:name),'%') OR LOWER(p.actor3Name) LIKE CONCAT('%',LOWER(:name),'%') OR LOWER(p.actor2Name) LIKE CONCAT('%',LOWER(:name),'%')"),
@NamedQuery(name = "Film.findByDirector", query = "SELECT p FROM Film p WHERE LOWER(p.directorName) LIKE CONCAT('%',LOWER(:name),'%')")

})
@Table(name = "data")
public class Film implements Serializable {
	
	@Id
	@Column(name = "id_data")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idData;
	
	@Column(name = "director_name")
    private String directorName;

	@Column(name = "num_critic_for_reviews")
    private String numCriticForReviews;

	@Column(name = "plot_keywords")
    private String plotKeywords;
	
	@Column(name = "num_user_for_reviews")
    private String numUserForReviews;
	
	@Column(name = "imdb_score")
    private Float imdbScore;
	
	@Column(name = "title_year")
    private String titleYear;
	
	@Column(name = "budget")
    private String budget;
	
	@Column(name = "content_rating")
    private String contentRating;
	
	@Column(name = "country")
    private String country;
	
	@Column(name = "language")
    private String language;
	
	@Column(name = "movie_imdb_link")
    private String movieImdbLink;
	
	@Column(name = "duration")
    private String duration;
	
	@Column(name = "actor_3_name")
    private String actor3Name;
	
	@Column(name = "num_voted_users")
    private String numVotedUsers;
	
	@Column(name = "movie_title")
    private String movieTitle;

	
	@Column(name = "actor_1_name")
    private String actor1Name;
	
	@Column(name = "genres")
    private String genres;
	
	@Column(name = "gross")
    private String gross;
	
	@Column(name = "actor_2_name")
    private String actor2Name;

	public Long getIdData() {
		return idData;
	}

	public void setIdData(Long idData) {
		this.idData = idData;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getNumCriticForReviews() {
		return numCriticForReviews;
	}

	public void setNumCriticForReviews(String numCriticForReviews) {
		this.numCriticForReviews = numCriticForReviews;
	}

	public String getPlotKeywords() {
		return plotKeywords;
	}

	public void setPlotKeywords(String plotKeywords) {
		this.plotKeywords = plotKeywords;
	}

	public String getNumUserForReviews() {
		return numUserForReviews;
	}

	public void setNumUserForReviews(String numUserForReviews) {
		this.numUserForReviews = numUserForReviews;
	}

	public Float getImdbScore() {
		return imdbScore;
	}

	public void setImdbScore(Float imdbScore) {
		this.imdbScore = imdbScore;
	}

	public String getTitleYear() {
		return titleYear;
	}

	public void setTitleYear(String titleYear) {
		this.titleYear = titleYear;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getContentRating() {
		return contentRating;
	}

	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMovieImdbLink() {
		return movieImdbLink;
	}

	public void setMovieImdbLink(String movieImdbLink) {
		this.movieImdbLink = movieImdbLink;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getActor3Name() {
		return actor3Name;
	}

	public void setActor3Name(String actor3Name) {
		this.actor3Name = actor3Name;
	}

	public String getNumVotedUsers() {
		return numVotedUsers;
	}

	public void setNumVotedUsers(String numVotedUsers) {
		this.numVotedUsers = numVotedUsers;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getActor1Name() {
		return actor1Name;
	}

	public void setActor1Name(String actor1Name) {
		this.actor1Name = actor1Name;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getGross() {
		return gross;
	}

	public void setGross(String gross) {
		this.gross = gross;
	}

	public String getActor2Name() {
		return actor2Name;
	}

	public void setActor2Name(String actor2Name) {
		this.actor2Name = actor2Name;
	}

}
