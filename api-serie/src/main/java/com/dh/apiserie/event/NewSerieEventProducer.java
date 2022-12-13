package com.dh.apiserie.event;

import com.dh.apiserie.config.RabbitMQConfig;
import com.dh.apiserie.model.Chapter;
import com.dh.apiserie.model.Season;
import com.dh.apiserie.model.Series;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewSerieEventProducer {
    private final RabbitTemplate rabbitTemplate;

    public NewSerieEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void execute(Series series) {
        NewSerieEventProducer.Data data = new NewSerieEventProducer.Data();
        BeanUtils.copyProperties(series, data.getSeries());
        if (data.getSeries().getSeassons() != null) {
            BeanUtils.copyProperties(data.getSeries(),data.getSeries().getSeassons());
        }
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.TOPIC_NEW_SERIE, data);
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;
        private SeriesDto series = new SeriesDto();

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class SeriesDto implements Serializable {

            @Serial
            private static final long serialVersionUID = 1L;
            private String seriesId;
            private String name;
            private String genre;
            private List<SeasonDto> seassons = new ArrayList<>();

            @Getter
            @Setter
            @NoArgsConstructor
            @AllArgsConstructor
            public static class SeasonDto implements Serializable {

                @Serial
                private static final long serialVersionUID = 1L;
                private String seasonId;
                private List<ChapterDto> chaptersDto;
            }
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class ChapterDto implements Serializable {

            @Serial
            private static final long serialVersionUID = 1L;

            @Id
            private String idChapter;
            private String name;
            private int number;
            private String urlStream;
        }

    }
}
