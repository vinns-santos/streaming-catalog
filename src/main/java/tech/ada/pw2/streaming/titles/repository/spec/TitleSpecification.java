package tech.ada.pw2.streaming.titles.repository.spec;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import tech.ada.pw2.streaming.titles.model.Title;
import tech.ada.pw2.streaming.titles.repository.filter.TitleFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TitleSpecification {

    private final TitleFilter titleFilter;

    public TitleSpecification(TitleFilter titleFilter) {
        this.titleFilter = titleFilter;
    }

    public Specification<Title> findByFilter() {
        return (Root<Title> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(titleFilter.getTitle())) {
                predicates.add(criteriaBuilder.like(root.get("title"), "%" + titleFilter.getTitle() + "%"));
            }

            if (Objects.nonNull(titleFilter.getType())) {
                predicates.add(criteriaBuilder.like(root.get("type"), "%" + titleFilter.getType() + "%"));
            }

            if (Objects.nonNull(titleFilter.getMainGenre())) {
                predicates.add(criteriaBuilder.like(root.get("mainGenre"), "%" + titleFilter.getMainGenre() + "%"));
            }

            if (Objects.nonNull(titleFilter.getReleaseYear())) {
                predicates.add(criteriaBuilder.equal(root.get("releaseYear"), titleFilter.getReleaseYear()));
            }

            if (Objects.nonNull(titleFilter.getRuntime())) {
                predicates.add(criteriaBuilder.equal(root.get("runtime"), titleFilter.getRuntime()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

