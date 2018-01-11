import DataAccesLayer.AfleveringRepository;
import DataAccesLayer.SerieRepository;
import DataAccesLayer.SqlConnection;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.javafx.fxml.expression.Expression.add;

public class UserInterface implements Runnable {

    public JFrame frame;
    public JPanel panelSouth, panelWest, overview1, overview2, overview3, overview4, overview5, overview6;
    public JTextArea overview1TextArea;
    public JTable overview1Table;
    public String[] columnNamesTable1 = {
            "Serie",
            "Genre"};
    public JComboBox overview1ComboBox;

    public UserInterface() {
    }

    @Override
    public void run() {
        frame = new JFrame("Netflix Statistix");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        container.setLayout(new BorderLayout());

        //Styling of south panel
        panelSouth = new JPanel();
        panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS));
        panelSouth.add(new JLabel("Netflix Statistix | Informatica 2018 23IVT1C1 " +
                "Joost (2132350) Jake (Studentnummer hier) Fenna (Studentnummer hier)"));
        add(panelSouth, BorderLayout.SOUTH);

        //Styling of western panel
        panelWest = new JPanel();
        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
        JButton overview1Button = new JButton("Overzicht 1");
        JButton overview2Button = new JButton("Overzicht 2");
        JButton overview3Button = new JButton("Overzicht 3");
        JButton overview4Button = new JButton("Overzicht 4");
        JButton overview5Button = new JButton("Overzicht 5");
        JButton overview6Button = new JButton("Overzicht 6");
        overview1Button.addActionListener(new overviewButtonListener(1, container));
        overview2Button.addActionListener(new overviewButtonListener(2, container));
        overview3Button.addActionListener(new overviewButtonListener(3, container));
        overview4Button.addActionListener(new overviewButtonListener(4, container));
        overview5Button.addActionListener(new overviewButtonListener(5, container));
        overview6Button.addActionListener(new overviewButtonListener(6, container));
        panelWest.add(overview1Button);
        panelWest.add(overview2Button);
        panelWest.add(overview3Button);
        panelWest.add(overview4Button);
        panelWest.add(overview5Button);
        panelWest.add(overview6Button);

        //Styling of overview 1
        overview1 = new JPanel();
        overview1.setLayout(new BoxLayout(overview1, BoxLayout.Y_AXIS));
        overview1.setBackground(Color.lightGray);
        JPanel field = new JPanel();
        field.setLayout(new BoxLayout(field, BoxLayout.X_AXIS));
        field.setBackground(Color.lightGray);
        JLabel serieLabel = new JLabel( "Selecteer Serie:");
        field.add(serieLabel);
        String[] options = { "Sherlock", "Breaking Bad", "Fargo" };
        overview1ComboBox = new JComboBox(options);
        overview1ComboBox.addActionListener(new Overview1ActionListener());
        field.add(overview1ComboBox);
        overview1.add(field, BorderLayout.NORTH);
        overview1TextArea = new JTextArea();
        overview1TextArea.setBackground(Color.lightGray);
        overview1.add(overview1TextArea, BorderLayout.SOUTH);

        Object[][] data = {
                {"sdfsdf", "Smigfdgdfth"},
                {"Jsdfohn", "Dofdgdfe"},
                {"Josdfse", "Browdfdfn"}
        };
        overview1Table = new JTable(data, columnNamesTable1);
        overview1.add(overview1Table);

        //Styling of overview 2
        overview2 = new JPanel();
        overview2.setLayout(new BoxLayout(overview2, BoxLayout.Y_AXIS));
        overview2.setBackground(Color.lightGray);
        overview2.add(new JLabel("Dit is overzicht 2"));

        //Styling of overview 3
        overview3 = new JPanel();
        overview3.setLayout(new BoxLayout(overview3, BoxLayout.Y_AXIS));
        overview3.setBackground(Color.lightGray);
        overview3.add(new JLabel("Dit is overzicht 3"));

        //Styling of overview 4
        overview4 = new JPanel();
        overview4.setLayout(new BoxLayout(overview4, BoxLayout.Y_AXIS));
        overview4.setBackground(Color.lightGray);
        overview4.add(new JLabel("Dit is overzicht 4"));

        //Styling of overview 5
        overview5 = new JPanel();
        overview5.setLayout(new BoxLayout(overview5, BoxLayout.Y_AXIS));
        overview5.setBackground(Color.lightGray);
        overview5.add(new JLabel("Accounts with only 1 profile: "));

        //Styling of overview 6
        overview6 = new JPanel();
        overview6.setLayout(new BoxLayout(overview6, BoxLayout.Y_AXIS));
        overview6.setBackground(Color.lightGray);
        overview6.add(new JLabel("Dit is overzicht 6"));


        //Adds all the panels. This is what it looks like after starting the application.
        //If a button is pressed only the "Center" panel will change.
        container.add(panelSouth, BorderLayout.SOUTH);
        container.add(panelWest, BorderLayout.WEST);
        container.add(overview1, BorderLayout.CENTER);

    }

    class Overview1ActionListener implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            SqlConnection connection = new SqlConnection();
            String hostName = "netflix.database.windows.net";
            String dbName = "NetflixStatistics";
            String user = "jakefennajoost";
            String password = "avansDB!2";
            String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
            connection.connectDatabase(url);

            AfleveringRepository repo = new AfleveringRepository(connection);
            System.out.println(repo.getAfleveringenX(overview1ComboBox.getSelectedItem().toString()));



            Object[][] data = {
                    {"test", "Change"},
                    {"Value1", "Value1"},
                    {"Value2", "Value2"},
                    {"SQL Query result", "in this table"},
            };

            overview1TextArea.setText("" + repo.getAfleveringenX(overview1ComboBox.getSelectedItem().toString()));
            overview1.remove(overview1Table);
            overview1Table = new JTable(data, columnNamesTable1);
            overview1.add(overview1Table);
            overview1Table.revalidate();
            overview1Table.repaint();

        }
    }

    public JFrame getFrame() {
        return frame;
    }

    public class overviewButtonListener implements ActionListener
    {
        private int buttonNumber;
        private Container container;

        public overviewButtonListener(int buttonNumber, Container container){
            this.buttonNumber = buttonNumber;
            this.container = container;
        }

        public void actionPerformed(ActionEvent e){
            removeCurrentCenterPanel();
            switch (buttonNumber) {
                case 1:
                    System.out.println("knompie 1");
                    container.add(overview1);
                    break;
                case 2:
                    System.out.println("knompie 2");
                    container.add(overview2);
                    break;
                case 3:
                    System.out.println("knompie 3");
                    container.add(overview3);
                    break;
                case 4:
                    System.out.println("knompie 4");
                    container.add(overview4);
                    break;
                case 5:
                    System.out.println("knompie 5");
                    container.add(overview5);
                    break;
                case 6:
                    System.out.println("knompie 6");
                    container.add(overview6);
                    break;
            }
            container.revalidate();
            container.repaint();
        }

        public void removeCurrentCenterPanel(){
            container.remove(overview1);
            container.remove(overview2);
            container.remove(overview3);
            container.remove(overview4);
            container.remove(overview5);
            container.remove(overview6);
        }
    }
}