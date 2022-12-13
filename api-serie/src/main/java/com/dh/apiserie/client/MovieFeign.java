package com.dh.apiserie.client;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-movie")
public interface MovieFeign {

    @GetMapping("/movies/{id}")
    Movie getById(PathVariable Long id);

    @Getter
    @Setter
    class Movie {
        private Long id;

        private String name;

        private String genre;

        private String urlStream;
    }


}
