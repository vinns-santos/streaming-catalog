package tech.ada.pw2.streaming.titles.dto.parser;

import tech.ada.pw2.streaming.titles.dto.TitleDTO;
import tech.ada.pw2.streaming.titles.model.Title;

public class TitleDTOParser {
    public static TitleDTO parse(Title title){
        TitleDTO titleDTO = new TitleDTO();
        titleDTO.setId(title.getId().intValue());
        titleDTO.setTitle(title.getTitle());
        titleDTO.setType(title.getType());
        titleDTO.setMainGenre(title.getMainGenre());
        titleDTO.setReleaseYear(title.getReleaseYear());
        titleDTO.setRuntime(title.getRuntime());

        return titleDTO;
    }
}
