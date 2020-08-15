package com.company.WebApp.controllers;

import com.company.WebApp.models.Article;
import com.company.WebApp.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BasePage {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/news")
    public String NewsPage(Model model,
                           @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        /*
        int amount = (int) articleRepository.count();
        double size = Math.ceil(((double)amount / 21));
        Page<Article> currentNews = articleRepository.findAllByOrderByTimeDesc(PageRequest.of(page, (int)size));
        */
        Page<Article> currentNews = articleRepository.findAllByOrderByTimeDesc(PageRequest.of(page,40));
        model.addAttribute("currentNews",currentNews);
        return "BasePage";
    }
}
