import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


import DataAccesLayer.SqlConnection;
import Domain.Movie;
import DataAccesLayer.MovieRepository;
import TableModel.*;
import com.sun.prism.shader.Solid_ImagePattern_Loader;

public class GUI {
    private JButton Btn_Msg;
    protected JPanel panel1;
    private JTable table1;
    private JButton Btn_view1;
    private JButton Btn_view2;
    private JButton Btn_view3;
    private JButton Btn_view4;
    private JButton Btn_view5;
    private JButton Btn_view6;
    private JPanel Panel_Overzicht;
    private JButton Btn_test;
    private JPanel Panel_Test;
    private JPanel Panel_View1;
    private JPanel Panel_Content;
    private JPanel Panel_View2;
    private JPanel Panel_View3;
    private JPanel Panel_View4;
    private JPanel Panel_View5;
    private JPanel Panel_View6;
    private JButton Btn_View4Calculate;
    private JLabel Lbl_MoviePlaceholder;

    //Call this function to empty the content panel. After you called this you can add new content to the content panel (view 1 - 6).
    public void RemovePanelContent(){
        Panel_Content.removeAll();
        Panel_Content.repaint();
        Panel_Content.revalidate();
    }


    //Test button on test view to retrieve all movies from database and show in table.
    public GUI() {
        Btn_Msg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Movie> movies = null;

                SqlConnection connection = new SqlConnection();
                String hostName = "netflix.database.windows.net";
                String dbName = "NetflixStatistics";
                String user = "jakefennajoost";
                String password = "avansDB!2";
                String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
                connection.connectDatabase(url);

                MovieRepository repo = new MovieRepository(connection);

                movies = repo.getMovies();

                MovieTableModel model = new MovieTableModel(movies);
                System.out.println(model);
                table1.setModel(model);
            }
        });


        //The seven buttons on the left side that switch panels actions:
        Btn_view1.addActionListener(e -> {
            RemovePanelContent();
            Panel_Content.add(Panel_View1);
        });
        Btn_view2.addActionListener(e -> {
            RemovePanelContent();
            Panel_Content.add(Panel_View2);
        });
        Btn_view3.addActionListener(e -> {
            RemovePanelContent();
            Panel_Content.add(Panel_View3);
        });
        Btn_view4.addActionListener(e -> {
            RemovePanelContent();
            Panel_Content.add(Panel_View4);
        });
        Btn_view5.addActionListener(e -> {
            RemovePanelContent();
            Panel_Content.add(Panel_View5);
        });
        Btn_view6.addActionListener(e -> {
            RemovePanelContent();
            Panel_Content.add(Panel_View6);
        });
        Btn_test.addActionListener(e -> {
            RemovePanelContent();
            Panel_Content.add(Panel_Test);
        });

        //Button from view 4 to calculate movie with longest length and is for people under the age of 16.
        Btn_View4Calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lbl_MoviePlaceholder.setText("Test. Dit is de functie uit de GUI.java klasse. Moet berekenen wat het resultaat is en hier tonen in plaats van deze tekst.");
            }
        });
    }
}
