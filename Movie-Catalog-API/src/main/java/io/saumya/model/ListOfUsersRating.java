package io.saumya.model;

import java.util.List;

//As i cannot pass List of ratings in response, so i created this class ListOfUsersRating
//to hold the List of ratings

public class ListOfUsersRating {

	private List<UserRating> listUserRating;
	

	public ListOfUsersRating() {
	
	}

	public List<UserRating> getListUserRating() {
		return listUserRating;
	}

	public void setListUserRating(List<UserRating> listUserRating) {
		this.listUserRating = listUserRating;
	}
	
	
	
}
