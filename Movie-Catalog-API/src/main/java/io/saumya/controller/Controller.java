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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.saumya.model.CatalogItem;
import io.saumya.model.ListOfUsersRating;
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
	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<CatalogItem> getMovieCatalog(@PathVariable("userId") String userId) {
		// ListOfUsersRating listOfUserRating =
		// restTemplate.getForObject("http://localhost:8083/userrating/users/"+userId,
		// responseType)
		// ListOfUsersRating userRating =
		// restTemplate.getForObject("http://localhost:8083/userrating/users/"+userId,
		// ListOfUsersRating.class);
		// return userRating;

		ListOfUsersRating ratings = restTemplate.getForObject("http://user-api/userrating/users/" + userId,
				ListOfUsersRating.class);
		return ratings.getListUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-api/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
		}).collect(Collectors.toList());
	}

	public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId) {
		return Arrays.asList(new CatalogItem("No Movie", "", 0));
	}
}
