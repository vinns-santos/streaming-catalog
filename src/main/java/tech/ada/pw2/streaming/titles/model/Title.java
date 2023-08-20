package tech.ada.pw2.streaming.titles.model;

import com.google.gson.Gson;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TITULOS")
public class Title{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "type")
    private String type;
    @Column(name = "main_genre")
    private String mainGenre;
    @Column(name = "release_year")
    private Integer releaseYear;
    @Column(name = "runtime")
    private Integer runtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Title() {

    }

    public Title(Long id, String title, String type, String mainGenre, Integer releaseYear, Integer runtime) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.mainGenre = mainGenre;
        this.releaseYear = releaseYear;
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Title title1 = (Title) o;

        if (getId() != null ? !getId().equals(title1.getId()) : title1.getId() != null) return false;
        if (getTitle() != null ? !getTitle().equals(title1.getTitle()) : title1.getTitle() != null) return false;
        if (getType() != null ? !getType().equals(title1.getType()) : title1.getType() != null) return false;
        if (getMainGenre() != null ? !getMainGenre().equals(title1.getMainGenre()) : title1.getMainGenre() != null)
            return false;
        if (getReleaseYear() != null ? !getReleaseYear().equals(title1.getReleaseYear()) : title1.getReleaseYear() != null)
            return false;
        return getRuntime() != null ? getRuntime().equals(title1.getRuntime()) : title1.getRuntime() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getMainGenre() != null ? getMainGenre().hashCode() : 0);
        result = 31 * result + (getReleaseYear() != null ? getReleaseYear().hashCode() : 0);
        result = 31 * result + (getRuntime() != null ? getRuntime().hashCode() : 0);
        return result;
    }
}
