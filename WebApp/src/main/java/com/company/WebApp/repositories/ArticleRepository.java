package com.company.WebApp.repositories;


import com.company.WebApp.models.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ArticleRepository extends CrudRepository<Article, Long> {
    Page<Article> findAllByOrderByTimeDesc(Pageable pageable);
}
