package io.saumya.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.saumya.Model.ListOfUsersRating;
import io.saumya.Model.UserRating;

@RestController
@RequestMapping("/userrating")
public class UserRatingController {

	@RequestMapping("/{movieId}")
	public UserRating getRating(@PathVariable("movieId") String movieId) {
		return new UserRating(movieId,4);
	}
	
	@RequestMapping("users/{userId}")
	public ListOfUsersRating getUserRating(@PathVariable("userId") String userId) {
		List<UserRating> ratings = Arrays.asList(
				new UserRating("1234", 4),
				new UserRating("5678", 3)
				);
		
		ListOfUsersRating listUserRating = new ListOfUsersRating();
		listUserRating.setListUserRating(ratings);
		return listUserRating;
		
	}
}
