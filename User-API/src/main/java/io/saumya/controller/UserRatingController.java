package io.saumya.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.saumya.Model.UserRating;

@RestController
@RequestMapping("/userrating")
public class UserRatingController {

	@RequestMapping("/{movieId}")
	public UserRating getRating(@PathVariable("movieId") String movieId) {
		return new UserRating(movieId,4);
	}
}
