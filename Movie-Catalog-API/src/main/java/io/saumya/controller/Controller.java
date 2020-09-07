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
	
	public ListOfUsersRating getMovieCatalog(@PathVariable("userId") String userId){
		//ListOfUsersRating listOfUserRating = restTemplate.getForObject("http://localhost:8083/userrating/users/"+userId, responseType)
		ListOfUsersRating userRating =  restTemplate.getForObject("http://localhost:8083/userrating/users/"+userId, ListOfUsersRating.class);
		return userRating;
	}
	
}
