package tech.ada.pw2.streaming.titles.utils;

import tech.ada.pw2.streaming.titles.model.FullTitle;

import java.util.List;

public interface DataReader {
    List<FullTitle> loadCatalog(int option);

    void loadCatalogDatabase(int option);
}
