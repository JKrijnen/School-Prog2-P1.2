import DataAccesLayer.MovieRepository;
import DataAccesLayer.SqlConnection;

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
    }
}