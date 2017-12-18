
import java.sql.*;

/**
 * Dit is een voorbeeld Java toepassing waarin je verbinding maakt met een SQLServer database.
 */
import DataAccesLayer.MovieRepository;
import DataAccesLayer.SqlConnection;

import javax.swing.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        SqlConnection connection = new SqlConnection();
        String hostName = "netflix.database.windows.net";
        String dbName = "NetflixStatistics";
        String user = "jakefennajoost";
        String password = "avansDB!2";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        connection.connectDatabase(url);

        MovieRepository repo = new MovieRepository(connection);
        System.out.println(repo.getMovies());

        JFrame frame = new JFrame("Netflix Statistix");
        frame.setContentPane(new GUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}