package com.dh.catalog.domain.repository;

import com.dh.catalog.domain.models.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SerieRepositoryMongo extends MongoRepository<Serie, String> {
}
