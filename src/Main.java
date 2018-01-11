import DataAccesLayer.AfleveringRepository;
import DataAccesLayer.MovieRepository;
import DataAccesLayer.SerieRepository;
import DataAccesLayer.SqlConnection;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.JComboBox;


public class Main extends JFrame{

    public static void main(String[] args) {

        SqlConnection connection = new SqlConnection();
        String hostName = "netflix.database.windows.net";
        String dbName = "NetflixStatistics";
        String user = "jakefennajoost";
        String password = "avansDB!2";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        connection.connectDatabase(url);

        //MovieRepository repo = new MovieRepository(connection);
        //System.out.println(repo.getMovies());

        //SerieRepository repo2 = new SerieRepository(connection);
        //System.out.println(repo2.getSerieX("Breaking bad"));

        //AfleveringRepository repo3 = new AfleveringRepository(connection);
        //System.out.println(repo3.getAfleveringenX("Breaking bad"));

        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);

        //THIS IS OLD GUI THAT WE'RE NOT ALLOWED TO USE.
        //JFrame frame = new JFrame("Netflix Statistix");
        //frame.setContentPane(new GUI().panel1);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        //frame.setVisible(true);
    }
}