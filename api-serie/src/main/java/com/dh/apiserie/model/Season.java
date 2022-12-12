package com.dh.apiserie.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Document
public class Season {
    @Id
    private String id;
    private int seasonNumber;
    private List<Chapter> chapters;
}
