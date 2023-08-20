package tech.ada.pw2.streaming.titles.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.ada.pw2.streaming.titles.dto.TitleDTO;
import tech.ada.pw2.streaming.titles.dto.parser.TitleDTOParser;
import tech.ada.pw2.streaming.titles.exception.DataNotFoundException;
import tech.ada.pw2.streaming.titles.repository.TitleRepository;
import tech.ada.pw2.streaming.titles.repository.filter.TitleFilter;
import tech.ada.pw2.streaming.titles.repository.spec.TitleSpecification;

import static tech.ada.pw2.streaming.titles.utils.Pagination.getPageable;

@Service
public class TitleService {
    private final TitleRepository titleRepository;

    public TitleService(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    public Page<TitleDTO> getTitles(Integer pageNumber, Integer size, String orderField, String direction
            , String title, String type, String mainGenre, Integer releaseYear, Integer runtime) {
        Pageable pageable = getPageable(pageNumber, size, orderField, direction);
        TitleFilter filter = new TitleFilter(title, type, mainGenre, releaseYear, runtime);
        TitleSpecification specification = new TitleSpecification(filter);
        return titleRepository.findAll(specification.findByFilter(), pageable)
                .map(TitleDTOParser::parse);
    }

    public TitleDTO getTitle(Long id) {
        return TitleDTOParser.parse(titleRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(
                        String.format("Título não encontrado com id: %s", id))));
    }
}
