package org.itstep.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimeModel {
    private Integer mal_id;
    private String title;
    private String synopsis;
    private String image_url;
    private List<GenreModel> genres;
    private String status;


}
