package com.kethan.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kethan.model.CatalogItems;
import com.kethan.model.Movie;
import com.kethan.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItems> getCatalog(@PathVariable("userId") String userId ) {
		MovieCatalogResource movieCatalogResource = new MovieCatalogResource();
		movieCatalogResource.setUserId("Jeevani");

		UserRating userRating = restTemplate.getForObject(
				"http://ratings-data-service/ratingsData/users/" + movieCatalogResource.getUserId(), UserRating.class);

		return userRating.getUserRatings().stream().map(r -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + r.getMovieId(), Movie.class);
			return new CatalogItems(movie.getName(), movie.getOverview(), r.getRating());
		}).collect(Collectors.toList());

	}

}
