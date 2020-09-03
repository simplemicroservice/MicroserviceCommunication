package io.saumya.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.saumya.model.CatalogItem;

@RestController
@RequestMapping("/movieCatalog")
public class Controller {
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getMovieCatalog(@PathVariable("userId") String userId){
		return Collections.singletonList(
				new CatalogItem("name:Titanic","Desc:Romantic",5)
				);
	}
	
}
