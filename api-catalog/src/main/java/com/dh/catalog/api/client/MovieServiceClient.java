package com.dh.catalog.api.client;

import com.dh.catalog.domain.models.Movie;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="api-movie")
public interface MovieServiceClient {

	@GetMapping("movies/{genre}")
	List<MovieDto> getMovieByGenre(@PathVariable (value = "genre") String genre);

	@PostMapping("movies/salvar")
	ResponseEntity<Movie> saveMovie(@RequestBody Movie movie);


	@Getter
	@Setter
	class MovieDto{
		private Long id;

		private String name;

		private String genre;

		private String urlStream;
	}

}
