package parcer;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

public class RssParcer {

    public List Parsing(HttpURLConnection  httpURL) throws IOException, FeedException {
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(httpURL));
        List entries = feed.getEntries();
        /// create item and change data;
        return  entries;
    }


    //public String GetDataTime() {

    //}
}
