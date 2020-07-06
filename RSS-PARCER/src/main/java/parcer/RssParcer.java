package parcer;

import authors.authors;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RssParcer {
    private final ArrayList<authors> currentAuthors;

    public RssParcer(ArrayList<authors> authors) {
        this.currentAuthors = authors;
    }

    public List<List<Object>> Parsing() throws IOException, FeedException {
        List<List<Object>> entries = new ArrayList<>();
        int i = 0;
        for (Object o : currentAuthors) {
            entries.add(new ArrayList<>());
            authors current = (authors)o;
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(current.getUrl()));
            entries.get(i).addAll(feed.getEntries());
            i++;
        }
        return  entries;
    }
}
