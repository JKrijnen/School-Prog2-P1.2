package Domain;

public class Aflevering {
    private int id;
    private String show;
    private String season;
    private String title;
    private String length;

    public Aflevering(int id, String show, String season, String title, String length) {
        this.id = id;
        this.show = show;
        this.season = season;
        this.title = title;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return String
                .format("\n%s;%s",
                        season, title);
    }
}



