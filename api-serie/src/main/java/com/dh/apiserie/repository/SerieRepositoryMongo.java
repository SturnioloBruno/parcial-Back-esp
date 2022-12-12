package com.dh.apiserie.repository;

import com.dh.apiserie.model.Series;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepositoryMongo extends MongoRepository<Series,String> {

    List<Series> findByGenre(String genre);
}
