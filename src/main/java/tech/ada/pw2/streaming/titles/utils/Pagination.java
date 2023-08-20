package tech.ada.pw2.streaming.titles.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Objects;

public class Pagination {
    public static Pageable getPageable(Integer pageNumber, Integer size, String orderField, String direction) {
        return PageRequest.of(pageNumber, size, getSort(orderField, direction));
    }

    private static Sort getSort(String orderField, String direction) {
        if (Objects.nonNull(orderField) && Objects.nonNull(direction)) {
            return Sort.by(Sort.Direction.fromString(direction), orderField);
        }
        return Sort.unsorted();
    }
}
