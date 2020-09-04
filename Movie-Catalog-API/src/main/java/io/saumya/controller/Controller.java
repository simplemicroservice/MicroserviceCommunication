package io.saumya.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.saumya.model.CatalogItem;
import io.saumya.model.Movie;
import io.saumya.model.UserRating;

@RestController
@RequestMapping("/movieCatalog")
public class Controller {
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getMovieCatalog(@PathVariable("userId") String userId){
		
		RestTemplate restTemplate = new RestTemplate();
		//Movie movie=restTemplate.getForObject("localhost:8082/movies/matrix", Movie.class);
		//step-1  get all rated movieId
			/*For now i am going to hardcode the rating and movieId from Uer-API
			 * so i copy the model UserRating from the User-API*/
		List<UserRating> ratings = Arrays.asList(new UserRating("1234", 4),
												 new UserRating("5678",3)
												);
		//step-2  for each movieId call movieAPI and get Details
		return ratings.stream().map(rating->{
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(),"Description: Desc",rating.getRating());
		}).collect(Collectors.toList());
		
		//step 3- put all them together
		//take from 11 video starting 12
		
		
		
		//return Collections.singletonList(
			//	new CatalogItem("name:Titanic","Desc:Romantic",5)
			//	);
	}
	
}
