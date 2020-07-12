package com.company.WebApp.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "news", schema = "SimpleNewsFormat")
public class Article {
    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "PUBDATE")
    private String pubDate;

    @Column(name = "link")
    private String link;

    @Id
    @Column(name = "time")
    private Long time;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getLink() {
        return link;
    }
}
