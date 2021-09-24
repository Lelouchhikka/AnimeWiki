package org.itstep.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimesModel {
    private List<AnimeModel> recommendations;
}
