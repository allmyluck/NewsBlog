package authors;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class authors {
    final private  String name;
    //final private URL url;
    private final List<Object> entries;

    public authors(String name, URL url) throws IOException, FeedException {
        this.name = name;
        //this.url = url;
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed;
        feed = input.build(new XmlReader(url));
        this.entries = feed.getEntries();
    }


    public List<Object> getEntries() {
        return entries;
    }

    public String GetName() {
        return name;
    }
/*
    public URL GetUrl() {
        return url;
    }
*/
}
