package DatabaseHandler;

import authors.authors;
import com.sun.syndication.feed.synd.SyndEntry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {
    private Connection connection;
    private final ArrayList<authors> currentAuthors;

    public DBHandler(ArrayList<authors> authors) {
        this.currentAuthors = authors;
        try {
            String user = "root";
            String password = "darfghjjok89er";
            String settings = "?serverTimezone=UTC&useSSL=false";
            String host = "jdbc:mysql://localhost:3306/";
            String url = host + "SimpleNewsFormat" + settings;
            this.connection = DriverManager.getConnection(url, user, password);
        } catch(Exception error) {
            System.out.println("Connection failed: " + error);
        }
    }


    private ResultSet GetLastElement(String name) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = String.format("SELECT * FROM news WHERE  time = (SELECT MAX(time) FROM news WHERE author = '%s');", name);
        //System.out.println(query);
        return stmt.executeQuery(query);
    }


    private void InsertInDatabase(SyndEntry current, String name) throws SQLException {
        Statement stmt = connection.createStatement();
        current.setTitle(current.getTitle().replace("'","\\'"));
        current.setTitle(current.getTitle().replace("\"","\\\""));
        String tempDescriptionFirst = current.getDescription().getValue().replace("'","\\'");
        tempDescriptionFirst = tempDescriptionFirst.replace("\"","\\\"");
        String query = String.format("INSERT INTO news VALUES('%s','%s','%s','%s','%s',%d);",
                name, current.getTitle(), tempDescriptionFirst,
                current.getPublishedDate(), current.getLink(),
                current.getPublishedDate().getTime());
        //System.out.println(query);
        stmt.executeUpdate(query);
    }


    public  void InsertArticle() throws SQLException {
        for( Object classAuthor : currentAuthors) {
            authors current = (authors)classAuthor;
            ResultSet rs = GetLastElement(current.GetName());
            List<String> links = new ArrayList<>();
            List<Long> times = new ArrayList<>();
            while (rs.next()) {
                links.add(rs.getString("link"));
                times.add(rs.getLong("time"));
            }
            for(Object objectEntry : current.getEntries()) {
                SyndEntry currentEntry = (SyndEntry)objectEntry;
                if(times.size() > 0 && currentEntry.getPublishedDate().getTime() > times.get(0)) {
                    try {
                        InsertInDatabase(currentEntry, current.GetName());
                    } catch (Exception e) {
                        System.out.println("Something do wrong:" + e);
                    }
                    //System.out.println("1");
                } else if(times.size() > 0 && currentEntry.getPublishedDate().getTime() == times.get(0)) {
                    boolean check = true;
                    for(Object o : links) {
                        String currentLink = (String)o;
                        if(currentEntry.getLink().equals(currentLink)) {
                            check = false;
                        }
                    }
                    if(check) {
                        try {
                            InsertInDatabase(currentEntry, current.GetName());
                        } catch (Exception e) {
                            System.out.println("Something do wrong:" + e);
                        }
                        //System.out.println("2");
                    }
                } else if(times.size() == 0) {
                    try {
                        InsertInDatabase(currentEntry, current.GetName());
                    } catch (Exception e) {
                        System.out.println("Something do wrong:" + e);
                    }
                    //System.out.println("3");
                }
            }
        }
    }

}

