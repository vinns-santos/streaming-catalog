package tech.ada.pw2.streaming.titles.repository.filter;

public class TitleFilter {

    private String title;
    private String type;
    private String mainGenre;
    private Integer releaseYear;
    private Integer runtime;

    public TitleFilter(String title, String type, String mainGenre, Integer releaseYear, Integer runtime) {
        this.title = title;
        this.type = type;
        this.mainGenre = mainGenre;
        this.releaseYear = releaseYear;
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMainGenre() {
        return mainGenre;
    }

    public void setMainGenre(String mainGenre) {
        this.mainGenre = mainGenre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }
}
