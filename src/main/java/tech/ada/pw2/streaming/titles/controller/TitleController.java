package tech.ada.pw2.streaming.titles.controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.pw2.streaming.titles.dto.TitleDTO;
import tech.ada.pw2.streaming.titles.service.TitleService;


@RestController
@RequestMapping("/titles")
public class TitleController {
    private final TitleService titleService;

    public TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping
    public ResponseEntity<Page<TitleDTO>> getTitles(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0")
            @Min(value = 0, message = "Valor da página deve ser maior que 0") Integer  pageNumber,
            @RequestParam(value = "size", required = false, defaultValue = "10")
            @Min(value = 0, message = "Valor do numero de registros deve ser maior que 0") Integer size,
            @RequestParam(value = "orderField", required = false, defaultValue = "id") String orderField,
            @RequestParam(value = "direction", required = false, defaultValue = "ASC")
            @Size(min = 3, message = "Os campos de ordenação devem ser 'ASC' ou 'DESC' independente de case") String direction,
            @RequestHeader(value = "title", required = false) String title,
            @RequestHeader(value = "type", required = false) String type,
            @RequestHeader(value = "mainGenre", required = false) String mainGenre,
            @RequestHeader(value = "releaseYear", required = false) Integer releaseYear,
            @RequestHeader(value = "runtime", required = false) Integer runtime){
        return ResponseEntity.ok(titleService.getTitles(pageNumber, size, orderField, direction, title, type, mainGenre, releaseYear, runtime));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TitleDTO> getTitle(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(titleService.getTitle(id));
    }
}
