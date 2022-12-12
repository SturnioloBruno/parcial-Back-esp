package com.dh.apiserie;

import com.dh.apiserie.model.Chapter;
import com.dh.apiserie.model.Season;
import com.dh.apiserie.model.Series;
import com.dh.apiserie.repository.SerieRepositoryMongo;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableRabbit
@EnableMongoRepositories(basePackages = "com.dh.apiserie.repository")
public class ApiSerieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSerieApplication.class, args);
	}



}
