package TableModel;

import Domain.Movie;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class MovieTableModel extends AbstractTableModel {

    private static final int ID_COL = 0;
    private static final int Title_COL = 1;
    private static final int Age_COL = 2;
    private static final int Language_COL = 3;
    private static final int Length_COL = 4;
    private static final int Category_COL = 5;

    private String[] columnNames = { "ID", "Titel", "Leeftijdsindicatie", "Taal", "Tijdsduur", "Genre"};
    private List<Movie> movies;

    public MovieTableModel (List<Movie> theMovies){
        movies = theMovies;
    }

    @Override
    public int getColumnCount(){
        return columnNames.length;
    }

    @Override
    public int getRowCount(){
        return movies.size();
    }

    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col){

        Movie tempMovie = movies.get(row);

        switch (col) {
            case ID_COL:
                return tempMovie.getId();
            case Title_COL:
                return tempMovie.getTitle();
            case Age_COL:
                return tempMovie.getAgeIndication();
            case Language_COL:
                return tempMovie.getLanguage();
            case Length_COL:
                return tempMovie.getLength();
            case Category_COL:
                return tempMovie.getCategory();
            default:
                return tempMovie.getTitle();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
