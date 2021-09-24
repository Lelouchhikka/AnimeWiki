package org.itstep.exam.service;

import org.itstep.exam.model.AnimeModel;
import org.itstep.exam.model.ListOfAnime;

import java.util.List;

public interface AnimeService {

    AnimeModel getAnime(String id);

    ListOfAnime getAllAnime();


}
