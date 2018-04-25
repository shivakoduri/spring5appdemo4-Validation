package com.myprojects.spring5.examples.controller;

import com.myprojects.spring5.examples.domain.Category;
import com.myprojects.spring5.examples.domain.UnitOfMeasure;
import com.myprojects.spring5.examples.repositories.CategoryRepository;
import com.myprojects.spring5.examples.repositories.UnitOfMeasureRepository;
import com.myprojects.spring5.examples.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting Index page");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
