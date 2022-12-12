package com.dh.movie.api.service;


import com.dh.movie.domain.model.Movie;
import com.dh.movie.domain.repository.MovieRepository;
import com.dh.movie.shared.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService extends GenericServiceImpl<Movie, Long> implements ImovieService{


    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }
}
