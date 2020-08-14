package com.company.WebApp.controllers;

import com.company.WebApp.models.Article;
import com.company.WebApp.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class BasePage {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/news")
    public String NewsPage(HttpServletRequest request,
                           Model model,
                           @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        Page<Article> currentNews = articleRepository.findAllByOrderByTimeDesc(PageRequest.of(page, 40));
        model.addAttribute("currentNews",currentNews);
        //model.addAttribute("numbers",IntStream.range(0,currentNews.getTotalPages()).toArray());
        return "BasePage";
    }
}
