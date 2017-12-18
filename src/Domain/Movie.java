package Domain;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private int id;
    private String title;
    private String ageIndication;
    private String language;
    private String length;
    private String category;

    public Movie (int id, String title, String ageIndication, String language, String length, String category){
        this.id = id;
        this.title = title;
        this.ageIndication = ageIndication;
        this.language = language;
        this.length = length;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAgeIndication() {
        return ageIndication;
    }

    public void setAgeIndication(String ageIndication) {
        this.ageIndication = ageIndication;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String
                .format("Movie [id=%s, Titel=%s, Leeftijdsindicatie=%s, Taal=%s, Tijdsduur=%s, Genre=&s], \n",
                        id, title, ageIndication, language, length, category);
    }
}
