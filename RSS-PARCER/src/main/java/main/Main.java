package main;
import authors.authors;
import DatabaseHandler.DBHandler;
import java.net.URL;
import java.util.*;

// сделать простое бд в котором есть авторы и добавлять без внешних ключей
public class Main {
    public static void main(String[] argc) {
        try {
            ArrayList<authors> myAuthors = new ArrayList<>();
            myAuthors.add(new authors("meduza.io/rss/news", new URL("https://meduza.io/rss/news")));
            myAuthors.add(new authors("lenta.ru/rss/news", new URL("https://lenta.ru/rss/news")));
            myAuthors.add(new authors("www.belta.by/rss/news", new URL("https://www.belta.by/rss/news")));
            DBHandler handler = new DBHandler(myAuthors);
            handler.InsertArticle();
        } catch (Exception e) {
            System.out.println("Something do wrong:" + e);
        }
    }
}

