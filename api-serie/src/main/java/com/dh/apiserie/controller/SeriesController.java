package com.dh.apiserie.controller;

import com.dh.apiserie.model.Series;
import com.dh.apiserie.repository.SerieRepositoryMongo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serie")
public class SeriesController {

     private final SerieRepositoryMongo serieRepositoryMongo;


    public SeriesController(SerieRepositoryMongo serieRepositoryMongo) {
        this.serieRepositoryMongo = serieRepositoryMongo;
    }

    @PostMapping("/save")
    public ResponseEntity<Series> addSerie(Series s) {
        return ResponseEntity.ok().body(serieRepositoryMongo.insert(s));
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Series>> getGenre(@PathVariable String genre) {
        return ResponseEntity.ok(serieRepositoryMongo.findByGenre(genre));
    }
}