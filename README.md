1)RSS файлы(XML) -> обкачка(защита от сохранения дублей уже обкаченных новостей).
Скачка файлов(RSS потоков с переименованием):

   1)wget --limit-rate=100k -P ~/practice/files/ https://lenta.ru/rss/news ; mv ~/practice/files/news ~/practice/files/news_lenta

   2)wget --limit-rate=100k -P ~/practice/files/ https://meduza.io/rss/news ; mv ~/practice/files/news ~/practice/files/news_meduza

вызов скрипта:sh /home/nikita/practice/scripts/downoload.sh


/*
https://lenta.ru/rss/news

https://meduza.io/rss/news
*/


2) Парсинг(XML), сохраняете из разных источников в один формат в БД (видимо столбцы title, description, author, date и т.д.).

3) Пишите приложение на Spring, который подключается к БД и уже отоборажает красиво данные.(Веб- отображение)



Создал Бд:
"CREATE TABLE authors(id INT NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, PRIMARY KEY(id));";
"CREATE TABLE news(id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, idAuthor INT NOT NULL, title TEXT, description TEXT, pubDate varchar(255) NOT NULL, link TEXT, FOREIGN KEY (idAuthor)  REFERENCES authors(id));";
//////////////////////////////// pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.company</groupId>
    <artifactId>RSS-PARCER</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.release>7</maven.compiler.release>
    </properties>
    <dependencies>
        <dependency>
            <groupId>rome</groupId>
            <artifactId>rome</artifactId>
            <version>1.0RC2</version>
        </dependency>
    </dependencies>

</project>







/////////////////////////////////
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] argc) {
        try {
            URL url = new URL("https://meduza.io/rss/news");
            HttpURLConnection  httpURL = (HttpURLConnection) url.openConnection();
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(httpURL));
            List entries = feed.getEntries();
            Iterator it = entries.iterator();
            while(it.hasNext()) {
                SyndEntry entry = (SyndEntry) it.next();
                System.out.println(entry.getTitle());
                System.out.println(entry.getDescription().getValue());
                System.out.println(entry.getLink());
                System.out.println(entry.getPublishedDate());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FeedException e) {
            e.printStackTrace();
        }
    }
}
