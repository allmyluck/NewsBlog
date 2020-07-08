package DatabaseHandler;

import authors.authors;
import com.sun.syndication.feed.synd.SyndEntry;

import java.sql.*;
import java.util.ArrayList;

public class DBHandler {
    private Connection connection;
   // private Statement stmt;
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
          //  this.stmt = connection.createStatement();
        } catch(Exception error) {
            System.out.println("Connection failed: " + error);
        }
    }


    // author -> entires
    // проблемы с кодировкой
    // нет проверки пока
    public  void InsertArticle() throws SQLException {
        for( Object classAuthor : currentAuthors) {
            authors current = (authors)classAuthor;
            ResultSet rs = GetLastElement(current.GetName());
            for(Object objectEntry : current.getEntries()) {
                SyndEntry currentEntry = (SyndEntry)objectEntry;
                InsertInDatabase(currentEntry, current.GetName());
                // проверка и добавление
                //if(currentEntry.getPublishedDate().getTime() > rs.getLong("time") &&
                //currentEntry.getLink() != rs.getString("link")) {
                 //   InsertInDatabase(currentEntry, current.GetName());
               // }
            }
        }
    }

    private ResultSet GetLastElement(String name) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = String.format("SELECT * FROM news WHERE time = (SELECT MAX(time) FROM news WHERE author != NULL AND author = '%s');", name);
        //System.out.println(query);
        return stmt.executeQuery(query);
    }

    private void InsertInDatabase(SyndEntry current, String name) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = String.format("INSERT INTO news VALUES('%s','%s','%s','%s','%s',%d);",
                name, current.getTitle(), current.getDescription().getValue(),
                current.getPublishedDate(), current.getLink(),
                current.getPublishedDate().getTime());
        //System.out.println(query);
        stmt.executeUpdate(query);
    }
}

