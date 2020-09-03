package io.saumya.Model;

public class UserRating {

	String movieId;
	int rating;
	
	
	public UserRating(String movieId, int rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}
	public UserRating() {
		super();
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	

}
