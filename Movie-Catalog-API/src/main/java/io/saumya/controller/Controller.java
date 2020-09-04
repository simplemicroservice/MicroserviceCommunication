package io.saumya.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.saumya.model.CatalogItem;
import io.saumya.model.Movie;
import io.saumya.model.UserRating;

@RestController
@RequestMapping("/movieCatalog")
public class Controller {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	//this method getMovieCatalog returning a list of movie with userRating according to UserId
	public List<CatalogItem> getMovieCatalog(@PathVariable("userId") String userId){
		
		//WebClient.Builder builder =WebClient.builder();
		
		List<UserRating> ratings = Arrays.asList(new UserRating("1234", 4),
												 new UserRating("5678",3)
												);
		//step-2  for each movieId call movieAPI and get Details
		return ratings.stream().map(rating->{
			//Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
			Movie movie = webClientBuilder.build()
				.get()
				.uri("http://localhost:8082/movies/"+rating.getMovieId())
				.retrieve()
				.bodyToMono(Movie.class)
				.block();
			
			return new CatalogItem(
					               movie.getName(),
					               "Description: Desc",
					               rating.getRating());}
								  ).collect(Collectors.toList());
		
		//step 3- put all them together
		
	}
	
}
