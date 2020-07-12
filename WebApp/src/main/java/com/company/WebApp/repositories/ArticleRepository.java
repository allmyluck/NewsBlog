package com.company.WebApp.repositories;


import com.company.WebApp.models.Article;
import org.springframework.data.repository.CrudRepository;


public interface ArticleRepository extends CrudRepository<Article, Long> {

    Iterable<Article> findAllByOrderByTimeDesc();
}
