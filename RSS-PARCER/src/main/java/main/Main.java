package main;
import authors.authors;
import com.sun.syndication.feed.synd.SyndEntry;
import parcer.RssParcer;
import DatabaseHandler.DBHandler;
import java.net.URL;
import java.util.*;

public class Main {
    public static void main(String[] argc) {
        try {
            ArrayList<authors> authors = new ArrayList<>();
            authors.add(new authors("meduza.io", new URL("https://meduza.io/rss/news")));
            authors.add(new authors("lenta.ru", new URL("https://lenta.ru/rss/news")));
            RssParcer parcer = new RssParcer(authors);
            DBHandler dbHandler = new DBHandler();
            dbHandler.GetConnect();
            List<List<Object>> entries = parcer.Parsing();
            /*
            int i = 0;
            for (Object o : entries) {
                List current = entries.get(i);
                Iterator it = current.iterator();
                for(Object c : current) {
                    SyndEntry entry = (SyndEntry) it.next();
                    System.out.println(entry.getTitle());
                    System.out.println(entry.getDescription().getValue());
                    System.out.println(entry.getLink());
                    System.out.println(entry.getPublishedDate());
                }
                i++;
            }

             */
        } catch (Exception e) {
            System.out.println("Something do wrong:" + e);
        }
    }
}

