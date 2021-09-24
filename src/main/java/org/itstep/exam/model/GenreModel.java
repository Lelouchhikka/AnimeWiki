package org.itstep.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreModel {
    private Integer mal_id;
    private String type;
    private String name;
}
