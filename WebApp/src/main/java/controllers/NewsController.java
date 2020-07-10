package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {
    @GetMapping("/news.by")
    public String NewsPage() {
        return "BasePage/news";
    }
}

