package main;
import authors.authors;
import  parcer.RssParcer;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] argc) {
        try {
            URL url = new URL("https://lenta.ru/rss/news");
            ArrayList<authors> authors = new ArrayList<>();
            authors.add(new authors("meduza.io", new URL("https://meduza.io/rss/news")));
            authors.add(new authors("lenta.ru", new URL("https://lenta.ru/rss/news")));
            // for( ArrayList < author> ) {
            // List<item> = pars(...)
            // finalList.addAll(List);

            // }
            // List entries =
            //for (Object o : entries) {
            //  SyndEntry entry = (SyndEntry) o;
            //System.out.println(entry.getTitle());
            //  System.out.println(entry.getDescription().getValue());
            // System.out.println(entry.getLink());
            //  SimpleDateFormat parser = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            // Date date = parser.parse(String.valueOf(entry.getPublishedDate()));
            // System.out.println(date);
           // }
        } catch (IOException e /*  FeedException e */) {
            e.printStackTrace();
        }
    }
}

