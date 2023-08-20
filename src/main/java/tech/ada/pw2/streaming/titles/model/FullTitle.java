package tech.ada.pw2.streaming.titles.model;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import tech.ada.pw2.streaming.titles.model.enums.AgeCertificationEnum;
import tech.ada.pw2.streaming.titles.model.enums.CountryEnum;
import tech.ada.pw2.streaming.titles.model.enums.GenreEnum;
import tech.ada.pw2.streaming.titles.model.enums.TypeEnum;


public record FullTitle(String id, String title, TypeEnum type, Integer release_year
        , AgeCertificationEnum age_certification, Integer runtime, List<GenreEnum> genres
        , List<CountryEnum> production_countries, Optional<Byte> seasons, String imdb_id, Optional<Double> imdb_score
        , Optional<Integer> imdb_votes, Optional<Double> tmdb_popularity, Optional<Double> tmdb_score)
    implements Comparable<FullTitle>
{

    @Override
    public String toString() {
        return "FullTitle{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", release_year=" + release_year +
                ", age_certification=" + age_certification +
                ", runtime=" + runtime +
                ", genres=" + genres +
                ", production_countries=" + production_countries +
                ", seasons=" + seasons +
                ", imdb_id='" + imdb_id + '\'' +
                ", imdb_score=" + imdb_score +
                ", imdb_votes=" + imdb_votes +
                ", tmdb_popularity=" + tmdb_popularity +
                ", tmdb_score=" + tmdb_score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullTitle anotherFullTitle = (FullTitle) o;
        return Objects.equals(id, anotherFullTitle.id) && Objects.equals(title, anotherFullTitle.title)
                && type == anotherFullTitle.type && Objects.equals(release_year, anotherFullTitle.release_year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, type, release_year);
    }

    @Override
    public int compareTo(FullTitle anotherFullTitle) {
        //action rules
        if (this.genres.contains(GenreEnum.ACTION) && !anotherFullTitle.genres.contains(GenreEnum.ACTION))
            return -1;
        else if (!this.genres.contains(GenreEnum.ACTION) && anotherFullTitle.genres.contains(GenreEnum.ACTION))
            return 1;

        return this.id.compareTo(anotherFullTitle.id);
    }
}
