package com.dh.movie.api.controller;

import com.dh.movie.api.queue.MovieListener;
import com.dh.movie.domain.model.Movie;
import com.dh.movie.api.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {


    private final MovieService movieService;

    private final MovieListener movieListener;


    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(movieService.findByGenre(genre));
    }

    /*
    @PostMapping("/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok().body(movieService.save(movie));
    }*/

    @PostMapping("/salvar")
    public void saveMovie(@RequestBody Movie movie) {
        movieListener.receive(movie);
    }
}
