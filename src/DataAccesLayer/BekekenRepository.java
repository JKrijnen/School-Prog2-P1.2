package DataAccesLayer;


    import Domain.Bekeken;

import java.sql.*;
import java.util.ArrayList;

    public class BekekenRepository{
        private SqlConnection connection = null;

        public BekekenRepository(SqlConnection sqlConnection) {
            this.connection = sqlConnection;
        }
        public ArrayList<Bekeken> getBekeken(){
            ResultSet set = connection.executeSql("SELECT * FROM Profile");

            ArrayList<Bekeken> bekekens = new ArrayList<>();
            try {
                while (set.next()) {
                    bekekens.add(new Bekeken(
                            set.getInt("Abonneenummer"),
                            set.getString("Profielnaam"),
                            set.getInt("Gezien"),
                            set.getInt("Percentage")));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return bekekens;
        }
    }

