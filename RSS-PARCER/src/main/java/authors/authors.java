package authors;

import java.net.URL;

public class authors {
    final private  String name;
    final private URL url;

    public authors(String name, URL url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public URL getUrl() {
        return url;
    }

}
