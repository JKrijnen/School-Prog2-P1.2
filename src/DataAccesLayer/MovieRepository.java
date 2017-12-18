package DataAccesLayer;

import Domain.Movie;

import java.sql.*;
import java.util.ArrayList;

public class MovieRepository {

    private SqlConnection connection = null;

    public MovieRepository(SqlConnection sqlConnection){
        this.connection = sqlConnection;

    }

    public ArrayList<Movie> getMovies() {
        ResultSet set = connection.executeSql("SELECT * FROM Film");

      ArrayList <Movie> movies = new ArrayList<>();
      try {
          while(set.next()) {
              movies.add(new Movie(
                      set.getInt("Id"),
                      set.getString("Titel"),
                      set.getString("Leeftijdsindicatie"),
                      set.getString("Taal"),
                      set.getString("Tijdsduur"),
                      set.getString("Genre")));
          }
      } catch (Exception e) {
              System.out.println(e);
          }
        return movies;
    }
}
