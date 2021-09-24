package org.itstep.exam.controller;

import org.itstep.exam.model.AnimeModel;
import org.itstep.exam.service.AnimeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static java.lang.Integer.parseInt;

@Controller
public class AnimeController {
    private final AnimeService service;

    public AnimeController(AnimeService service) {
        this.service = service;
    }


    @GetMapping(value = "/")
    public String indexAnime(Model model) {
         model.addAttribute("animes", service.getAllAnime());
        return "anime";
    }
    @GetMapping(value = "/{id}")
    public String detailAnime(Model model,@PathVariable String id) {
           model.addAttribute("anime", service.getAnime(id));
        return "animedetails";
    }



}
