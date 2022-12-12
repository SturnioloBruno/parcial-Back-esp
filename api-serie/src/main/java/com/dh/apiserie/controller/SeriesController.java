package com.dh.apiserie.controller;

import com.dh.apiserie.model.Series;
import com.dh.apiserie.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serie")
public class SeriesController {

     private final SeriesService service;

     public SeriesController(SeriesService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Series> addSerie(Series s) {
        return ResponseEntity.ok().body(service.saveSeries(s));
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Series>> getGenre(@PathVariable String genre) {
        return ResponseEntity.ok(service.findByGenre(genre));
    }
}
