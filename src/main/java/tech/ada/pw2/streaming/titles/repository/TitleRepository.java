package tech.ada.pw2.streaming.titles.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.pw2.streaming.titles.dto.TitleDTO;
import tech.ada.pw2.streaming.titles.model.Title;
import tech.ada.pw2.streaming.titles.repository.filter.TitleFilter;
import tech.ada.pw2.streaming.titles.repository.spec.TitleSpecification;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {
    Page<Title> findAll(Specification<Title> byFilter, Pageable pageable);
}
