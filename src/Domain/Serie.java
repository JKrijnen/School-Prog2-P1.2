package Domain;

public class Serie {
    private String serie;
    private String season;
    private String ageIndication;
    private String language;
    private String genre;
    private String looksLike;

    public Serie(String serie, String season, String ageIndication, String language, String genre, String looksLike) {
        this.serie = serie;
        this.season = season;
        this.ageIndication = ageIndication;
        this.language = language;
        this.genre = genre;
        this.looksLike = looksLike;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLooksLike() {
        return looksLike;
    }

    public void setLooksLike(String looksLike) {
        this.looksLike = looksLike;
    }
}
