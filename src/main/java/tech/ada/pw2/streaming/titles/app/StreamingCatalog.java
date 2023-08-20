package tech.ada.pw2.streaming.titles.app;

import org.springframework.stereotype.Service;
import tech.ada.pw2.streaming.titles.utils.DataReader;

@Service
public class StreamingCatalog {
    private final DataReader reader;

    public StreamingCatalog(DataReader reader){
        this.reader = reader;
//        1 Full database
//        2 Only 10 records
        reader.loadCatalogDatabase(1);
    }

}
