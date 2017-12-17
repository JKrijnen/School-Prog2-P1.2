import DataAccesLayer.MovieRepository;
import DataAccesLayer.SqlConnection;

import java.sql.*;
public class Main {
    public static void main(String[] args) {
        SqlConnection connection = new SqlConnection();
        connection.connectDatabase("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistics;integratedSecurity=true;");

        MovieRepository repo = new MovieRepository(connection);

        System.out.println(repo.getMovies());
    }
}