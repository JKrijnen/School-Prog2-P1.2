package DataAccesLayer;

import Domain.Aflevering;

import java.sql.*;
import java.util.ArrayList;

public class AfleveringRepository{
    private SqlConnection connection = null;

    public AfleveringRepository(SqlConnection sqlConnection) {
        this.connection = sqlConnection;
    }
    public ArrayList<Aflevering> getAfleveringen(){
        ResultSet set = connection.executeSql("SELECT * FROM Aflevering");

        ArrayList<Aflevering> afleveringen = new ArrayList<>();
        try {
            while (set.next()) {
                afleveringen.add(new Aflevering(
                        set.getInt("Id"),
                        set.getString("Serie"),
                        set.getString("Seizoen"),
                        set.getString("Titel"),
                        set.getString("Tijdsduur")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return afleveringen;
    }
}