package com.dh.apiserie.service;

import com.dh.apiserie.model.Series;
import com.dh.apiserie.repository.SerieRepositoryMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {

    private final SerieRepositoryMongo serieRepositoryMongo;

    @Autowired
    public SeriesService(SerieRepositoryMongo serieRepositoryMongo) {
        this.serieRepositoryMongo = serieRepositoryMongo;
    }

    public Series findById(Long id) {
        return serieRepositoryMongo.findById(id)
                .orElse(null);
    }

    public List<Series> findAll() {return serieRepositoryMongo.findAll();}
    public Series saveSeries(Series series) { return serieRepositoryMongo.save(series);}

    public List<Series> findByGenre(String genre) {return serieRepositoryMongo.findByGenre(genre);}
}
