package com.dh.movie.domain.data;

import com.dh.movie.domain.model.Movie;
import com.dh.movie.domain.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        movieRepository.save(new Movie(null, "Pelicula 1", "Terror", "www.netflix.com"));
        movieRepository.save(new Movie(null, "Pelicula 2", "Terror", "www.netflix.com"));
        movieRepository.save(new Movie(null, "Pelicula 3", "Comedia", "www.netflix.com"));
        movieRepository.save(new Movie(null, "Pelicula 4", "Ficcion", "www.netflix.com"));
        movieRepository.save(new Movie(1L, "filme", "terror", "what"));
        movieRepository.save(new Movie(2L, "borboleta", "terror", "what"));
        movieRepository.save(new Movie(3L, "adedonha", "terror", "what"));
        movieRepository.save(new Movie(4L, "pajero", "terror", "what"));
        movieRepository.save(new Movie(5L, "dakar", "acción", "what"));
        movieRepository.save(new Movie(6L, "shadow", "acción", "what"));
        movieRepository.save(new Movie(7L, "boné", "romance", "what"));
        movieRepository.save(new Movie(8L, "xícara", "romance", "what"));
    }
}
