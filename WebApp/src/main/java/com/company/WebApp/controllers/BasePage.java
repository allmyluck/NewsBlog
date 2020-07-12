package com.company.WebApp.controllers;

import com.company.WebApp.models.Article;
import com.company.WebApp.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BasePage {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/news.by")
    public String NewsPage( Model model) {
        Iterable<Article> currentNews = articleRepository.findAllByOrderByTimeDesc();
        model.addAttribute("currentNews",currentNews);
        return "BasePage";
    }
}
