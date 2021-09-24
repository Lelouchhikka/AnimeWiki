package org.itstep.exam.service;

import org.itstep.exam.model.AnimeModel;
import org.itstep.exam.model.ListOfAnime;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
@Service
public class AnimeServiceImpl implements AnimeService {
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public AnimeModel getAnime(String id) {
        AnimeModel page = restTemplate.getForObject("https://api.jikan.moe/v3/anime/"+id, AnimeModel.class);
        return page;
    }

    @Override
    public ListOfAnime getAllAnime() {
        ListOfAnime listOfAnime = restTemplate.getForObject("https://api.jikan.moe/v3/search/anime?score=8.1&page=1", ListOfAnime.class);
        return listOfAnime;
    }
}
