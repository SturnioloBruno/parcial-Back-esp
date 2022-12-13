package com.dh.catalog.domain.repository;

import com.dh.catalog.domain.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepositoryMongo extends MongoRepository<Movie, Long> {
}
