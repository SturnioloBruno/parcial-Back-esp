package com.dh.apiserie;

import com.dh.apiserie.model.Chapter;
import com.dh.apiserie.model.Season;
import com.dh.apiserie.model.Series;
import com.dh.apiserie.repository.SerieRepositoryMongo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.dh.apiserie.repository")
public class ApiSerieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSerieApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(SerieRepositoryMongo repository) {
		return (args) -> {
			if (!repository.findAll().isEmpty()) {
				return;
			}
			Chapter chapter1Season1 = new Chapter(null, "Primero", 1, "www.netflix.com");
			Chapter chapter2Season1 = new Chapter(null, "Segundo", 2, "www.netflix.com");
			Chapter chapter1Season2 = new Chapter(null, "Tercero", 1, "www.netflix.com");
			Chapter chapter2Season2 = new Chapter(null, "Cuarto", 2, "www.netflix.com");
			List<Chapter> chapterList = null;
			chapterList.add(chapter1Season1);
			chapterList.add(chapter2Season1);
			Season season1 = new Season(null, 1, chapterList);
			chapterList.remove(0);
			chapterList.remove(1);
			chapterList.add(chapter1Season2);
			chapterList.add(chapter2Season2);
			Season season2 = new Season(null, 2, chapterList);
			List<Season> seasonList = null;
			seasonList.add(season1);
			seasonList.add(season2);
			repository.save(new Series(null, "Serie 1", "Terror", seasonList));
			repository.save(new Series(null, "Serie 2", "Terror", seasonList));
			repository.save(new Series(null, "Serie 3", "Comedia", seasonList));
			repository.save(new Series(null, "Serie 4", "Fantasia", seasonList));
		};
	}

}
