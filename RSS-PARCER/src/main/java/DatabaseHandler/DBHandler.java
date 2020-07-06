package DatabaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBHandler {
    private Connection connection;

    /*
    public DatabaseHandler(String database, String user, String password) {
        this.url = host + database + settings;
        this.user = user;
        this.password = password;
    }

    public void ChangeInformation(String database, String user, String password) {
        this.url = host + database + settings;
        this.user = user;
        this.password = password;
    }
    */
    public void GetConnect() {
        connection = null;
        try {
            String user = "root";
            String password = "darfghjjok89er";
            String settings = "?useUnicode=true&serverTimezone=UTC&useSSL=false";
            String host = "jdbc:mysql://localhost:3306/";
            String url = host + "News" + settings;
            connection = DriverManager.getConnection(url, user, password);
        } catch(Exception error) {
            System.out.println("Connection failed: " + error);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement GetStatement() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
        } catch (Exception error) {
            System.out.println("Failed: " + error);
        }
        return stmt;
    }

}

